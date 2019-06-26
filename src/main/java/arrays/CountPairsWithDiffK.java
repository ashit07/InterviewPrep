package arrays;

// A sorting based Java program to
// count pairs with difference k
import java.util.Arrays;

class CountPairsWithDiffK {

  /*
   * Returns count of pairs with difference k in arr[] of size n.
   */
  static int countPairsWithDiffK(int arr[], int n, int k) {
    int count = 0;
    Arrays.sort(arr); // Sort array elements

    int l = 0;
    int r = 0;
    while (r < n) {
      if (arr[r] - arr[l] == k) {
        count++;
        l++;
        r++;
      } else if (arr[r] - arr[l] > k)
        l++;
      else // arr[r] - arr[l] < sum
        r++;
    }
    return count;
  }

  // Driver program to test above function
  public static void main(String[] args) {
    int arr[] = {1, 1, 2, 2, 3, 3};
    int n = arr.length;
    int k = 1;
    System.out.println("Count of pairs with given diff is " + countPairsWithDiffK(arr, n, k));
  }
}
