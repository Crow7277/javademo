package JavaBasic_05_Method;

/**
 * User crow7
 * Date 2021/9/3.
 */
public class ArraysUtil {
    /**
     * 升序排列一个int数组
     *
     * @param x 要排序的int数组
     */
    public static void sortASC(int[] x) {
        for (int i = 0; i < x.length - 1; i++) {
            for (int j = 0; j < x.length - i - 1; j++) {
                if (x[j] > x[j + 1]) {
                    int temp = x[j];
                    x[j] = x[j + 1];
                    x[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 升序排列一个double数组
     *
     * @param x 要排序的double数组
     */
    public static void sortASC(double[] x) {
        for (int i = 0; i < x.length - 1; i++) {
            for (int j = 0; j < x.length - i - 1; j++) {
                if (x[j] > x[j + 1]) {
                    double temp = x[j];
                    x[j] = x[j + 1];
                    x[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 升序排列一个byte数组
     *
     * @param x 要排序的byte数组
     */
    public static void sortASC(byte[] x) {
        for (int i = 0; i < x.length - 1; i++) {
            for (int j = 0; j < x.length - i - 1; j++) {
                if (x[j] > x[j + 1]) {
                    byte temp = x[j];
                    x[j] = x[j + 1];
                    x[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 升序排列一个short数组
     *
     * @param x 要排序的short数组
     */
    public static void sortASC(short[] x) {
        for (int i = 0; i < x.length - 1; i++) {
            for (int j = 0; j < x.length - i - 1; j++) {
                if (x[j] > x[j + 1]) {
                    short temp = x[j];
                    x[j] = x[j + 1];
                    x[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 升序排列一个long数组
     *
     * @param x 要排序的long数组
     */
    public static void sortASC(long[] x) {
        for (int i = 0; i < x.length - 1; i++) {
            for (int j = 0; j < x.length - i - 1; j++) {
                if (x[j] > x[j + 1]) {
                    long temp = x[j];
                    x[j] = x[j + 1];
                    x[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 升序排列一个float数组
     *
     * @param x 要排序的float数组
     */
    public static void sortASC(float[] x) {
        for (int i = 0; i < x.length - 1; i++) {
            for (int j = 0; j < x.length - i - 1; j++) {
                if (x[j] > x[j + 1]) {
                    float temp = x[j];
                    x[j] = x[j + 1];
                    x[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 升序排列一个int数组
     *
     * @param x 要排序的int数组
     */
    public static void sortDESC(int[] x) {
        for (int i = 0; i < x.length - 1; i++) {
            for (int j = 0; j < x.length - i - 1; j++) {
                if (x[j] < x[j + 1]) {
                    int temp = x[j];
                    x[j] = x[j + 1];
                    x[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 降序排列一个double数组
     *
     * @param x 要排序的double数组
     */
    public static void sortDESC(double[] x) {
        for (int i = 0; i < x.length - 1; i++) {
            for (int j = 0; j < x.length - i - 1; j++) {
                if (x[j] < x[j + 1]) {
                    double temp = x[j];
                    x[j] = x[j + 1];
                    x[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 降序排列一个byte数组
     *
     * @param x 要排序的byte数组
     */
    public static void sortDESC(byte[] x) {
        for (int i = 0; i < x.length - 1; i++) {
            for (int j = 0; j < x.length - i - 1; j++) {
                if (x[j] < x[j + 1]) {
                    byte temp = x[j];
                    x[j] = x[j + 1];
                    x[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 降序排列一个short数组
     *
     * @param x 要排序的short数组
     */
    public static void sorDESC(short[] x) {
        for (int i = 0; i < x.length - 1; i++) {
            for (int j = 0; j < x.length - i - 1; j++) {
                if (x[j] < x[j + 1]) {
                    short temp = x[j];
                    x[j] = x[j + 1];
                    x[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 降序排列一个long数组
     *
     * @param x 要排序的long数组
     */
    public static void sortDESC(long[] x) {
        for (int i = 0; i < x.length - 1; i++) {
            for (int j = 0; j < x.length - i - 1; j++) {
                if (x[j] < x[j + 1]) {
                    long temp = x[j];
                    x[j] = x[j + 1];
                    x[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 降序排列一个float数组
     *
     * @param x 要排序的float数组
     */
    public static void sortDESC(float[] x) {
        for (int i = 0; i < x.length - 1; i++) {
            for (int j = 0; j < x.length - i - 1; j++) {
                if (x[j] < x[j + 1]) {
                    float temp = x[j];
                    x[j] = x[j + 1];
                    x[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 判断给定数组中是否包含指定元素
     *
     * @param arr 给定数组
     * @param b   指定元素
     * @return 如果包含返回索引，如果不包含返回-1
     */
    public static int indexOf(byte[] arr, byte b) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == b) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 判断给定数组中是否包含指定元素
     *
     * @param arr 给定数组
     * @param b   指定元素
     * @return 如果包含返回索引，如果不包含返回-1
     */
    public static int indexOf(short[] arr, short b) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == b) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 判断给定数组中是否包含指定元素
     *
     * @param arr 给定数组
     * @param b   指定元素
     * @return 如果包含返回索引，如果不包含返回-1
     */
    public static int indexOf(double[] arr, double b) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == b) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 判断给定数组中是否包含指定元素
     *
     * @param arr 给定数组
     * @param b   指定元素
     * @return 如果包含返回索引，如果不包含返回-1
     */
    public static int indexOf(long[] arr, long b) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == b) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 判断给定数组中是否包含指定元素
     *
     * @param arr 给定数组
     * @param b   指定元素
     * @return 如果包含返回索引，如果不包含返回-1
     */
    public static int indexOf(float[] arr, float b) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == b) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 判断给定数组中是否包含指定元素
     *
     * @param arr 给定数组
     * @param b   指定元素
     * @return 如果包含返回索引，如果不包含返回-1
     */
    public static int indexOf(int[] arr, int b) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == b) {
                return i;
            }
        }
        return -1;
    }
    /**
     * 判断给定数组中是否包含指定元素
     *
     * @param arr 给定数组
     * @param b   指定元素
     * @return 如果包含返回索引，如果不包含返回-1
     */
    public static int indexOf(boolean[] arr, boolean b) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == b) {
                return i;
            }
        }
        return -1;
    }

    // 判断是否包含指定元素

    /**
     * 判断是否包含元素
     *
     * @param arr 给定数组
     * @param b   指定的元素
     * @return 包含返回true，不包含返回false
     */
    public static boolean isContain(int arr[], int b) {
        int index = indexOf(arr, b);
        return index >= 0 ? true : false;
    }
    // 判断给定数组包含指定元素出现多少次

    /**
     * 判断给定数组包含指定元素出现了多少次
     *
     * @param arr 给定数组
     * @param b   指定元素
     * @return 返回出现次数
     */
    public static int containTimes(int[] arr, int b) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == b) {
                count++;
            }
        }
        return count;
    }
    //判断给定数组是否包含且仅包含一次给定元素

    /**
     * 判断给定数组是否包含且仅包含一次给定元素
     *
     * @param arr 给定数组
     * @param b   给定元素
     * @return 如果包含一次返回true，否则false
     */
    public static boolean isOne(int[] arr, int b) {
        int i = containTimes(arr, b);
        return i == 1 ? true : false;
    }
}

