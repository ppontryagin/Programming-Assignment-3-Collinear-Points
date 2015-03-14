/**
 * Created by Pavel.Pontryagin on 14.03.2015.
 */
public class SimpleTest {
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                if (j == 5) {
                    break;
                }
                System.out.println("i: " + i + "; j: " + j);
            }
        }
    }
}
