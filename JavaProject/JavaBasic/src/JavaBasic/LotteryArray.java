package JavaBasic;

/**
 * User crow7
 * Date 2021/8/8.
 */
public class LotteryArray {
    public static void main(String[] args) {
        final int NMAX = 10;

        int[][] cdds = new int[NMAX + 1][];
        for (int n = 0; n <= NMAX; ++n) {
            cdds[n] = new int[n + 1];
        }
        for (int n = 0; n < cdds.length; n++) {
            for (int k = 0; k < cdds[n].length; k++) {
                int lotteryOdds = 1;
                for (int i = 1; i <= k; i++) {
                    lotteryOdds = lotteryOdds * (n - 1 + 1) / i;

                }
                cdds[n][k] = lotteryOdds;
            }
        }
        for (int[] row : cdds) {
            for (int cdd : row) {
                System.out.printf("%4d", cdd);
            }
            System.out.println();
        }
    }

}
