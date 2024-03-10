package test;

/**
 * @author 花木凋零成兰
 * @date 2024/3/10 10:54
 */
public class test_51 {

    public static void main(String[] args) {
        int n = 4;
        int[][] a = new int[n][n];
        int i = 1;
        int j = 1;
        int k = i+1;
        int l = j+1;
        while (k ++ < n && l++ < n) {

            System.out.println("k = " + k + "  l = " + l);
        }
    }

}
