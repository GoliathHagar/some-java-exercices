/**
 * @author : goliathhagar
 * @CreatedBy : IntelliJ IDEA
 * @ProjectName : VisualNuts
 * @created : 1/5/23, Thursday, 4:36 PM
 **/
public class VisualNutsExer1 {
    static int MIN = 1,
            MAX = 100;

    static String VISUAL = "Visual",
            NUTS = "Nuts";


    String algorithm1(int number){
        int rest3 = number % 3;
        int rest5 = number % 5;
        String restContent = "";

        if (rest3 == 0 && rest5 == 0) {
            restContent = VISUAL + " " + NUTS;
        } else if (rest3 == 0) {
            restContent = VISUAL;
        } else if (rest5 == 0) {
          restContent = NUTS;
        } else {
           restContent = "" + number;
        }

        return restContent;
    }

     void exercice1(int begin, int end) {
        for (int num = begin; num <= end; num++) {
            System.out.println(algorithm1(num));
        }
    }

    public static void main(String[] args) {

        new VisualNutsExer1().exercice1(MIN, MAX);

    }
}
