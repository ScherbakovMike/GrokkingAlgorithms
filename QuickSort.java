import java.util.Arrays;

public class QuickSort {

    static int[] sort(int[] array) {
        if (array.length < 2) {
            return array;
        }
        var pivot = array[0];
        var left = 0;
        var right = array.length - 1;
        var result = new int[array.length];
        for (int i = 1; i < array.length; i++) {
            if (array[i] <= pivot) {
                result[left] = array[i];
                left++;
            } else {
                result[right] = array[i];
                right--;
            }
        }
        return concatArrays(
                sort(Arrays.copyOfRange(result, 0, left)),
                new int[] { pivot },
                sort(Arrays.copyOfRange(result, right + 1, result.length)));
    }

    static int[] concatArrays(int[]... arrays) {
        var length = 0;
        for (int[] array : arrays) {
            length += array.length;
        }
        var result = new int[length];
        var pos = 0;
        for (int[] array : arrays) {
            for (var item : array) {
                result[pos] = item;
                pos++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        var array = new int[] { 10, 5, 2, 3 };
        var result = sort(array);
        for (var item : result) {
            System.out.println(item);
        }
    }
}
