import java.util.Arrays;

/**
 * Created by Pavel.Pontryagin on 14.03.2015.
 */
public class SimpleTest {
    public static void main(String[] args) {

        int[] p = new int[10];
        p[0] = 9;
        p[1] = 8;
        p[2] = 7;
        p[3] = 6;
        p[4] = 5;
        p[5] = 4;
        p[6] = 3;
        p[7] = 2;
        p[8] = 1;
        p[9] = 0;

        Arrays.sort(p, 5, 10);

        for (int i = 0; i < 10; i++) {
            System.out.println(p[i]);
        }

    }
}
