package arrays;

public class ArrayUtilityFunctions {

  public static void displayArray(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i]);
      System.out.print(", ");
    }
    System.out.println("");
  }

  public static void reverseArray(int[] arr, int start, int end) {
    while (start < end) {
      int temp = arr[start];
      arr[start] = arr[end];
      arr[end] = temp;
      start++;
      end--;
    }
  }

  public static int binarySearch(int[] arr, int low, int high, int key) {
    if (low > high) {
      return -1;
    }
    int mid = (low + high) / 2;
    if (arr[mid] == key) {
      return mid;
    }
    if (key > arr[mid]) {
      return binarySearch(arr, mid + 1, high, key);
    }
    return binarySearch(arr, low, mid - 1, key);
  }
}
