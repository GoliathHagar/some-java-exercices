import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : goliathhagar
 * @CreatedBy : IntelliJ IDEA
 * @ProjectName : VisualNuts
 * @mailto : thejuniormonteiro@outlook.com
 * @created : 1/5/23, Thursday, 4:37 PM
 **/

class VisualNutsExer1Test {

    @Test
    void algorithm1GivenMultiple3Test() {
        int given = 3;
        String expect = "Visual";
        //when
        Assertions.assertEquals(new VisualNutsExer1().algorithm1(given), expect);

    }

    @Test
    void algorithm1GivenMultiple5Test() {
        int given = 5;
        String expect = "Nuts";
        //when
        Assertions.assertEquals(new VisualNutsExer1().algorithm1(given), expect);

    }

    @Test
    void algorithm1GivenMultiple3and5Test() {
        int given = 15;
        String expect = "Visual Nuts";
        //when
        Assertions.assertEquals(new VisualNutsExer1().algorithm1(given), expect);

    }

    /*@ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 15, Integer.MAX_VALUE})
    void algorithm1ParameterizedTest(int candidate){
        Assertions.assertEquals(new VisualNutsExer1().algorithm1(candidate), "Nuts");
    }*/
}