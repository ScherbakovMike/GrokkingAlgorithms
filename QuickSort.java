public class QuickSort {
    
    static int partition(int array[], int start, int end) {
        var pivot = array[end]; // pivot element
        var leftIndex = start;
        var rightIndex = end;
        while (leftIndex < rightIndex) {
            while (leftIndex <= end && array[leftIndex] < pivot) {
                leftIndex++;
            }
            while (rightIndex >= start && array[rightIndex] > pivot) {
                rightIndex--;
            }
            swap(array, leftIndex, rightIndex);
        }
        return leftIndex;
    }

    static void swap(int[] array, int left, int right) {
        int buf = array[left];
        array[left] = array[right];
        array[right] = buf;
    }

    static void quick(int a[], int start, int end)
    {
        if (start < end) {
            int p = partition(a, start, end);
            quick(a, start, p - 1);
            quick(a, p, end);
        }
    }

    static void printArr(int a[], int n) {
        int i;
        for (i = 0; i < n; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int array[] = { 6, 5, 4, 3, 2, 1 };
        printArr(array, array.length);
        quick(array, 0, array.length-1);
        printArr(array, array.length);
    }
}