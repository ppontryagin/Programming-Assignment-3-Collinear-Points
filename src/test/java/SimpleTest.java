/**
 * Created by Pavel.Pontryagin on 14.03.2015.
 */
public class SimpleTest {
    public static void main(String[] args) {
        String str = "(4096, 20992) -> (5120, 20992) -> (6144, 20992) -> (7168, 20992) -> (8128, 20992)";
        String str2 = "(5120, 20992) -> (6144, 20992) -> (7168, 20992) -> (8128, 20992)";
        System.out.println(str.substring(str.indexOf(" (") + 1));
        System.out.println(str2);
        System.out.println("Hash: " + str.substring(str.indexOf(" (" ) + 1).hashCode());
        System.out.println("Has2: " + str2.hashCode());
    }

}
