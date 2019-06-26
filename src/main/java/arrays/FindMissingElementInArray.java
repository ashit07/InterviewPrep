package arrays;

/*   http://www.ardendertat.com/2011/09/27/programming-interview-questions-4-find-missing-element
 *  There is an array of non-negative integers.
 *   A second array is formed by shuffling the elements of the first array and deleting a random element. 
 *   Given these two arrays, find which element is missing in the second array. 
 *   Here is an example input, the first array is shuffled and the number 5 is removed to construct the second array
 *   arr1 = [4,1,0,2,9,6,8,7,5,3]
 *   arr2 = [6,4,7,2,1,0,8,3,9]
 */
public class FindMissingElementInArray {

  /**
   * By performing a very clever trick, we can achieve linear time and constant space complexity without any problems. 
   * Here it is: initialize a variable to 0, then XOR every element in the first and second arrays with that variable. 
   * In the end, the value of the variable is the result, missing element in array2. 
   * 
   * Let’s analyze why this approach works. 
   * What happens when we XOR two numbers? 
   * We should think bitwise, instead of decimal. 
   * XORing a 4-bit number with 1011 would flip the first, third, and fourth bits of the number. 
   * XORing the result again with 1011 would flip those bits back to their original value.
   *  So, if we XOR a number two times with some number nothing will change. 
   *  We can also XOR with multiple numbers and the order would not matter. 
   *  For example, say we XOR the number n1 with n2, then XOR the result with n3, then XOR their result with n2, and then with n3. 
   *  The final result would be the original number n1. 
   *  Because every XOR operation flips some bits and when we XOR with the same number again, we flip those bits back. 
   *  So the order of XOR operations is not important. 
   *  If we XOR a number with some number an odd number of times, there will be no effect.
  
      Above we XOR all the numbers in array1 and array2. 
      All numbers in array2 also appear in array1, but there is an extra number in array1. 
      So the effect of each XOR from array2 is being reset by the corresponding same number in array1 (remember that the order of XOR is not important). 
      But we can’t reset the XOR of the extra number in array1, because it doesn’t appear in array2. 
      So the result is as if we XOR 0 with that extra number, which is the number itself. 
      Since XOR of a number with 0 is the number. 
      Therefore, in the end we get the missing number in array2. 
      The space complexity of this solution is constant O(1) since we only use one extra variable. 
      Time complexity is O(N) because we perform a single pass from the arrays.
   * @param arr1
   * @param arr2
   * @return
   */
  static int findMissingNumberUsingXOROperation(int[] arr1, int[] arr2) {
    int missingElement = 0;
    for (int i = 0; i < arr1.length; i++) {
      missingElement = missingElement ^ arr1[i];
      if (i < arr1.length - 1) {
        missingElement = missingElement ^ arr2[i];
      }
    }
    System.out.println(missingElement);
    return missingElement;
  }

  public static void main(String[] args) {
    int[] arr1 = {4, 1, 0, 2, 9, 6, 8, 7, 5, 3};
    int[] arr2 = {6, 4, 7, 2, 1, 0, 8, 3, 9};
    findMissingNumberUsingXOROperation(arr1, arr2);
  }
}
