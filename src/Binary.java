public class Binary {
    private static int counterLeft = 0;
    private static int counterRight = 0;
    private static int counterInterpolation = 0;

    public static void main(String[] args) {
        int[] a = new int[100];
        int x = 0;

        System.out.println(binarySearchLeft(a, x, 0, a.length - 1));
        System.out.println(binarySearchRight(a, x, 0, a.length - 1));
        System.out.println("Anzahl Durchläufe L: " + counterLeft);
        System.out.println("Anzahl Durchläufe R: " + counterRight);

        int[] b = {0, 1000, 1001, 1002, 1003, 1004, 1005};
        int x2 = 1002;
        System.out.println("\n" + interpolationSearch(b, x2));
        System.out.println("Anzahl Durchläufe Interpolation: " + counterInterpolation);
    }

    private static int binarySearchLeft(int[] a, int x, int l, int r) {
        counterLeft++;
        int m = (r + l) / 2;
        if (m == 0)
            return 0;
        if (a[m] == x && a[m - 1] != x)
            return m;
        if (a[m] < x)
            return binarySearchLeft(a, x, m + 1, r);
        return binarySearchLeft(a, x, l, m - 1);
    }

    private static int binarySearchRight(int[] a, int x, int l, int r) {
        counterRight++;
        int m = (r + l) / 2;
        if (m == a.length - 1)
            return a.length - 1;
        if (a[m] == x && a[m + 1] != x)
            return m;
        if (a[m] > x)
            return binarySearchRight(a, x, l, m - 1);
        return binarySearchRight(a, x, m + 1, r);
    }

    private static int interpolationSearch(int[] a, int x) {
        int l = 0;
        int r = a.length - 1;
        while (l <= r) {
            counterInterpolation++;
            int d1 = x - a[l];
            int d2 = a[r] - x;
            int m = 0;
            if(d1 + d2 != 0)
                m = (d1 * r + d2 * l) / (d1 + d2);
            if (a[m] == x)
                return m;
            if (a[m] > x)
                r = m - 1;
            else l = m + 1;
        }
        return -1;
    }
}