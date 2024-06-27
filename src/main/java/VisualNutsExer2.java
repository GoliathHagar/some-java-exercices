import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author : goliathhagar
 * @CreatedBy : IntelliJ IDEA
 * @ProjectName : VisualNuts
 * @created : 1/6/23, Friday, 4:57 PM
 **/
public class VisualNutsExer2 {
   Set<Country> countries;

    public VisualNutsExer2(Set<Country> countries) {
        this.countries = countries;
    }

    public static class Country{
        private final String countryCode;
        private final Set<String> officialLanguages;

        public Country(String name, Set<String> officialLanguages) {
            this.countryCode = name;
            this.officialLanguages = officialLanguages;
        }

        public String getCountryCode() {
            return countryCode;
        }

        public Set<String> getOfficialLanguages() {
            return officialLanguages;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof VisualNutsExer2.Country country)) return false;
            return getCountryCode().equals(country.getCountryCode());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getCountryCode());
        }
    }

    /**
     *
     * @return int Number of countries
     */
    int getTotalCountry(){
        return countries.size();
    }

    /**
     *
     * @return String Country code
     */
    public String getGermanSpeakCountryWithMostLanguages(){
        String contryCode = "";


       /* Optional<Map.Entry<String, Integer>> country = countries.stream()
                .filter(ctr -> ctr.getOfficialLanguages().contains("de"))
                .map(ctr -> Map.entry(ctr.getCountryCode(), ctr.getOfficialLanguages().size()))
                .max(Map.Entry.comparingByValue());*/

        Optional<Map.Entry<String, Integer>> country = getCountryOfficialLanguagesQuantity("de")
                .max(Map.Entry.comparingByValue());

        if(country.isPresent())
            contryCode = country.get().getKey();

        return contryCode;
    }

    /**
     *
     * @return int Total Languages
     */
    public int getAllOfficialLAnguagues(){ //Set may be usefull
        Set<String> languages = countries.stream()
                .flatMap(country -> country.getOfficialLanguages().stream())
                .collect(Collectors.toSet());

        return languages.size();
    }

    /**
     *
     * @return String Country Code
     */
    public String getCountryHighestNumberOfficialLanguages(){
        String contryCode = "";

        /*Optional<Map.Entry<String, Integer>> country = countries.stream()
                .map(ctr -> Map.entry(ctr.getCountryCode(), ctr.getOfficialLanguages().size()))
                .max(Map.Entry.comparingByValue());*/
        Optional<Map.Entry<String, Integer>> country = getCountryOfficialLanguagesQuantity("")
                .max(Map.Entry.comparingByValue());

        if(country.isPresent())
            contryCode = country.get().getKey();

        return contryCode;
    }

    private Stream<Map.Entry<String, Integer>> getCountryOfficialLanguagesQuantity(String countryCode ){
        return countries.stream()
                .filter(ctr -> ctr.getOfficialLanguages().contains(countryCode) || countryCode.isEmpty())
                .map(ctr -> Map.entry(ctr.getCountryCode(), ctr.getOfficialLanguages().size()));
    }

    /**
     *
     * @return String Language Code
     */
    public String getMostCommonLanguage(){
        String language = "";
        Optional<Map.Entry<String, Long>> languages = countries.stream()
                .flatMap(country -> country.getOfficialLanguages().stream())
                .collect(Collectors.groupingBy(ctr -> ctr,Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue());

        if(languages.isPresent())
            language = languages.get().getKey();

        return language;
    }

    public static void main(String[] args) {

        HashSet<Country> dataSource = new HashSet<>();//external api/datasource

        VisualNutsExer2 exer2 = new VisualNutsExer2(dataSource);

        System.out.println("Total Country: " + exer2.getTotalCountry());
        System.out.println("Most German Speaking  Country: " + exer2.getGermanSpeakCountryWithMostLanguages());
        System.out.println("Total Official Languages: " + exer2.getMostCommonLanguage());
        System.out.println("Highest Number Of Official Language Country: " + exer2.getCountryHighestNumberOfficialLanguages());
        System.out.println("Most Common Official Languages: " + exer2.getMostCommonLanguage());


    }
}
