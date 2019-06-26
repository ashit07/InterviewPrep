package algorithms.dp;

public class FibonacciDP {
  static long[] fibCache = new long[300];

  public static long fibonacciWithoutDP(long val) {
    if (val <= 1) {
      return 1;
    }
    return fibonacciWithoutDP(val - 1) + fibonacciWithoutDP(val - 2);
  }

  /**
   * Top down   Approach for Fibonacci
   * @param val
   * @return
   */
  public static long fibonacciWithDP(long val) {
    if (val <= 1) {
      fibCache[(int) val] = 1;
    }
    if (fibCache[(int) val] == 0) {
      fibCache[(int) val] = fibonacciWithDP(val - 1) + fibonacciWithDP(val - 2);
    }
    return fibCache[(int) val];
  }

  /**
   * Bottom Up Approach for Fibonacci
   * @param val
   * @return
   */
  public static long fibonacciWithDPBottomUp(long val) {
    long[] result = new long[(int) val + 1];
    result[0] = 1;
    result[1] = 1;
    for (int i = 2; i < val + 1; i++) {
      result[i] = (long) result[i - 1] + (long) result[i - 2];
    }
    return result[(int) val];
  }

  public static void main(String[] args) {
    //long val = FibonacciDP.fibonacciWithoutDP(80);
    //System.out.println(val);


    //  long val2 = FibonacciDP.fibonacciWithDP(200);
    // System.out.println(val2);

    long val3 = FibonacciDP.fibonacciWithDP(200);
    System.out.println(val3);

    long val4 = FibonacciDP.fibonacciWithDPBottomUp(200);
    System.out.println(val4);
  }
}
