import java.util.Arrays;
import java.util.Random;

class Helpers {
    static void swap(int[] arr, int i, int j) {
        arr[i] = (arr[i] + arr[j]) - (arr[j] = arr[i]);
    }

    // average value
    static double ave(int arr[]) {
        return Arrays.stream(arr).sum() / arr.length;
    }

    static int min(int arr[]) {
        return Arrays.stream(arr).min().getAsInt();

    }

    static int max(int arr[]) {
        return Arrays.stream(arr).max().getAsInt();
    }
}

class BubbleSort {
    static void sort(int arr[]) {
        sort(arr, arr.length);
    }

    static void sort(int arr[], int end) {
        if (end == 1)
            return;

        for (int i = 0; i < end - 1; i++)
            if (arr[i] > arr[i + 1])
                Helpers.swap(arr, i, i + 1);

        sort(arr, end - 1);
    }

}

class InsertionSort {
    static void sort(int arr[]) {
        sort(arr, arr.length);
    }

    static void sort(int arr[], int end) {
        if (end <= 1)
            return;

        sort(arr, end - 1);

        int last = arr[end - 1];
        int j = end - 2;

        while (j >= 0 && arr[j] > last) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = last;
    }

}

class QuickSort extends Helpers {

    static void sort(int arr[]) {
        sort(arr, 0, arr.length - 1);
    }

    static void sort(int[] arr, int startIdx, int endIdx) {

        int idx = partition(arr, startIdx, endIdx);

        if (startIdx < idx - 1)
            sort(arr, startIdx, idx - 1);

        if (endIdx > idx)
            sort(arr, idx, endIdx);

    }

    static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];

        while (left <= right) {
            while (arr[left] < pivot) {
                left++;
            }
            while (arr[right] > pivot) {
                right--;
            }
            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        return left;
    }
}

class Main extends Helpers {

    public static void main(String[] args) {
        // declarations
        Random random = new Random();
        long NOE = 15; // number of elements to sort
        int MINV = 10; // minimal value of element
        int MAXV = 100000; // maximal value of element
        // filling up arr by random values
        int arr[] = random.ints(NOE, MINV, MAXV).toArray();
        // print array before sort
        System.out.println(Arrays.toString(arr));
        // starting time measurement
        long start = System.nanoTime();
        // sorting algorithm to mesure
        BubbleSort.sort(arr);
        // ending time measurement
        long end = System.nanoTime();
        // print array after sort
        System.out.println(Arrays.toString(arr));
        long cpuTime = end - start;

        System.out.println("CPU time is : " + cpuTime);
    }
}
