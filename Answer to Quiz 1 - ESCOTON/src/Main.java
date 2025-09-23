public class Main {
    //Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    //Selection Sort
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[n - 1 - i];
            arr[n - 1 - i] = temp;
        }
    }

   //Printing of Sorted Array
    private static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
    //Main Test
    public static void main(String[] args) {
        // Test Bubble Sort
        int[] bubbleArr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original array for Bubble Sort:");
        printArray(bubbleArr);
        bubbleSort(bubbleArr);
        System.out.println("Sorted array (descending) using Bubble Sort:");
        printArray(bubbleArr);

        // Test Selection Sort
        int[] selectionArr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("\nOriginal array for Selection Sort:");
        printArray(selectionArr);
        selectionSort(selectionArr);
        System.out.println("Sorted array (descending) using Selection Sort:");
        printArray(selectionArr);
    }
}