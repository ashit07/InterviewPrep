package arrays;

public class SearchElementInSortedAndRotatedArray {

  public static int searchElementInRotatedArray(int[] arr, int n, int element) {
    int pivotIndex = findPivotSimple(arr, n);
    if (element > arr[0]) {
      return ArrayUtilityFunctions.binarySearch(arr, 0, pivotIndex, element);
    }
    return ArrayUtilityFunctions.binarySearch(arr, pivotIndex + 1, n - 1, element);
  }

  //Find pivot index such that the element next to it is smaller than it. It would be the larget element in array
  private static int findPivotSimple(int[] arr, int n) {
    int pivotIndex = -1;
    for (int i = 0; i < n; i++) {
      if (arr[i] > arr[i + 1]) {
        pivotIndex = i;
        break;
      }
    }
    return pivotIndex;
  }

  private static int findPivotMiddleApproach(int[] arr, int n) {
    return findPivotMiddleApproach(arr, 0, arr.length - 1);
  }

  private static int findPivotMiddleApproach(int[] arr, int low, int high) {
    if (high < low) {
      return -1;
    }
    if (high == low) {
      return 1;
    }
    int mid = (high + low) / 2;
    if (mid < high && arr[mid] > arr[mid + 1]) {
      return mid;
    }
    if (mid > low && arr[mid] < arr[mid - 1]) {
      return mid - 1;
    }
    if (arr[low] >= arr[mid]) {
      return findPivotMiddleApproach(arr, low, mid - 1);
    }
    return findPivotMiddleApproach(arr, mid + 1, high);

  }

  public static void main(String[] args) {
    int[] rightRotatedArr = {8, 9, 10, 1, 2, 3, 4, 5, 6, 7};
    System.out.println(searchElementInRotatedArray(rightRotatedArr, rightRotatedArr.length, 2));

    int[] leftRotatedArr = {4, 5, 6, 7, 8, 9, 10, 1, 2, 3};
    System.out.println(searchElementInRotatedArray(leftRotatedArr, leftRotatedArr.length, 2));
  }
}
