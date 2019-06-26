package arrays;

public class ZerosToEnd {

  static void moveZerosToEnd(int[] arr, int n) {
    int count = 0;
    for (int i = 0; i < n; i++) {
      if (arr[i] != 0) {
        arr[count] = arr[i];
        count++;
      }
    }
    while (count < n) {
      arr[count] = 0;
      count++;
    }
  }

  public static void main(String[] args) {
    int arr[] = {1, 2, 0, 4, 3, 0, 5, 0};
    moveZerosToEnd(arr, arr.length);
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + ", ");
    }

  }
}
