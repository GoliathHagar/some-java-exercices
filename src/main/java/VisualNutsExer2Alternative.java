import java.util.*;
import java.util.stream.Collectors;

/**
 * @author : goliathhagar
 * @CreatedBy : IntelliJ IDEA
 * @ProjectName : VisualNuts
 * @created : 1/5/23, Thursday, 6:06 PM
 **/
public class VisualNutsExer2Alternative {
    public VisualNutsExer2Alternative(Map<String, List<String>> countries) {
        this.countries = countries;
    }

    Map<String, List<String>> countries;
    /*public class Country{
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
            if (!(o instanceof Country country)) return false;
            return getCountryCode().equals(country.getCountryCode());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getCountryCode());
        }
    }
*/
   /* void loadCountryData(){//load from json source
        countries = new HashMap<>();

        countries.put("US", List.of("en"));
        countries.put("BE", List.of("nl","fr","de"));
        countries.put("NL", List.of("nl","fy"));
        countries.put("DE", List.of("de"));
        countries.put("ES", List.of("es"));

    }*/

    int totalCountry(){
        return countries.size();
    }

    /**
     *
     * @return String Country code
     */
    String germanSpeakCountryWithMostLanguages(){
        String contryCode = "";

        Optional<Map.Entry<String, Integer>> country = countries.entrySet().stream()
                .filter(ctr -> ctr.getValue().contains("de"))
                .map(ctr -> Map.entry(ctr.getKey(), ctr.getValue().size()))
                .max(Map.Entry.comparingByValue());

        if(country.isPresent())
            contryCode = country.get().getKey();

        return contryCode;
    }

    int allOfficialLAnguagues(){ //hashset may be usefull
        Set<String> languages = countries.entrySet().stream()
                .flatMap(country -> country.getValue().stream())
                .collect(Collectors.toSet());

        return languages.size();
    }

    String countryHighestNumberOfficialLanguages(){
        String contryCode = "";

        Optional<Map.Entry<String, Integer>> country = countries.entrySet().stream()
                .map(ctr -> Map.entry(ctr.getKey(), ctr.getValue().size()))
                .max(Map.Entry.comparingByValue());

        if(country.isPresent())
            contryCode = country.get().getKey();

        return contryCode;
    }

    String mostCommonLanguage(){
        String language = "";

        Optional<Map.Entry<String, Long>> languages = countries.entrySet().stream()
                .flatMap(country -> country.getValue().stream())
                .collect(Collectors.groupingBy(ctr -> ctr,Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue());

        if(languages.isPresent())
            language = languages.get().getKey();

        return language;
    }

    public static void main(String[] args) {
        VisualNutsExer2Alternative exer2 = new VisualNutsExer2Alternative(Map.of());


        System.out.println("Total Country: " + exer2.totalCountry());
        System.out.println("Most German Speaking  Country: " + exer2.germanSpeakCountryWithMostLanguages());
        System.out.println("Total Official Languages: " + exer2.allOfficialLAnguagues());
        System.out.println("Highest Number Of Official Language Country: " + exer2.countryHighestNumberOfficialLanguages());
        System.out.println("Most Common Official Languages: " + exer2.mostCommonLanguage());


    }
}
