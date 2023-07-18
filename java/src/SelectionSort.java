public class SelectionSort {
    public static void main(String[] args) {
        var array = new int[]{22, 1, 3, 99, 8};
        for (int i = 0; i < (array.length - 1); i++) {
            var smallestIndex = findSmallest(array, i);
            var buf = array[i];
            array[i] = array[smallestIndex];
            array[smallestIndex] = buf;
        }
        for (var elem : array) {
            System.out.println(elem);
        }
    }

    public static int findSmallest(int[] array, int startingIndex) {
        var smallest = startingIndex;
        for (int i = startingIndex; i < array.length; i++) {
            if (array[i] < array[smallest]) {
                smallest = i;
            }
        }
        return smallest;
    }
}
