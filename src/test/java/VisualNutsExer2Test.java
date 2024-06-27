import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author : goliathhagar
 * @CreatedBy : IntelliJ IDEA
 * @ProjectName : VisualNuts
 * @created : 1/6/23, Friday, 5:00 PM
 **/
class VisualNutsExer2Test {

    Set<VisualNutsExer2.Country> countries;

    @BeforeEach
    void setup(){
        countries = new HashSet<>();

        countries.add(
                new VisualNutsExer2.Country(
                        "US",new HashSet<String>(List.of("en"))
                )
        );
        countries.add(
                new VisualNutsExer2.Country(
                        "BE",new HashSet<String>(List.of("de","nl","fr"))
                )
        );
        countries.add(
                new VisualNutsExer2.Country(
                        "NL",new HashSet<String>(List.of("nl","fy"))
                )
        );
        countries.add(
                new VisualNutsExer2.Country(
                        "DE",new HashSet<String>(List.of("de"))
                )
        );
        countries.add(
                new VisualNutsExer2.Country(
                        "ES",new HashSet<String>(List.of("es"))
                )
        );
    }

    @Test
    void getTotalCountry() {
        VisualNutsExer2 nutsExer2Version2 = new VisualNutsExer2(countries);

        int total = nutsExer2Version2.getTotalCountry();
        Assertions.assertEquals(5, total );

    }

    @Test
    void getGermanSpeakCountryWithMostLanguages() {
        VisualNutsExer2 nutsExer2Version2 = new VisualNutsExer2(countries);
        String germanSpeak = nutsExer2Version2.getGermanSpeakCountryWithMostLanguages();

        Assertions.assertEquals("BE", germanSpeak);

    }

    @Test
    void getAllOfficialLAnguagues() {
        VisualNutsExer2 nutsExer2Version2 = new VisualNutsExer2(countries);
        int total = nutsExer2Version2.getAllOfficialLAnguagues();

        Assertions.assertEquals(6, total);
    }

    @Test
    void getCountryHighestNumberOfficialLanguages() {
        VisualNutsExer2 nutsExer2Version2 = new VisualNutsExer2(countries);

        String countryCode = nutsExer2Version2.getCountryHighestNumberOfficialLanguages();

        Assertions.assertEquals("BE", countryCode);
    }

    @Test
    void getMostCommonLanguage() {
        VisualNutsExer2 nutsExer2Version2 = new VisualNutsExer2(countries);

        String language = nutsExer2Version2.getMostCommonLanguage();

        Assertions.assertEquals("de", language);
    }
}
