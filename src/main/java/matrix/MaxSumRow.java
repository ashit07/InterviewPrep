package matrix;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MaxSumRow {

  public static int calculateMaxSumRow(int[][] matrix) {
    int maxSum = 0;
    int maxRow = 0;
    for (int i = 0; i < matrix.length; i++) {
      int rowsum = 0;
      for (int j = 0; j < matrix[0].length; j++) {
        rowsum += matrix[i][j];
      }
      if (maxSum < rowsum) {
        maxSum = rowsum;
        maxRow = i + 1;
      }
    }
    System.out.println(maxRow);
    return maxSum;
  }

  public static int calculateMaxSumRowMultithreaded(int[][] matrix)
      throws InterruptedException, ExecutionException {
    int maxSum = 0;
    ExecutorService exec = Executors.newFixedThreadPool(matrix.length);

    CountDownLatch latch = new CountDownLatch(matrix.length);
    List<Future<Integer>> tasks = new ArrayList<>(matrix.length);
    for (int i = 0; i < matrix.length; i++) {
      tasks.add(exec.submit(new SumCalculator(matrix[i], latch)));
    }
    latch.await();

    for (Future<Integer> val : tasks) {
      if (maxSum < val.get()) {
        maxSum = val.get();
      }
    }
    return maxSum;

  }

  static class SumCalculator implements Callable {
    private CountDownLatch latch;
    private int[] arr;

    SumCalculator(int[] arr, CountDownLatch latch) {
      this.arr = arr;
      this.latch = latch;
    }

    @Override
    public Object call() throws Exception {
      int sum = 0;
      for (int i = 0; i < arr.length; i++) {
        sum += arr[i];
      }
      latch.countDown();
      return sum;
    }
  }

  public static void main(String[] args) {
    int[][] matrix = {{10, 20, 30, 11}, {5, 11, 26, 31}, {4, 15, 21, 41}, {1, 2, 50, 21}};
    try {
      System.out.println(calculateMaxSumRowMultithreaded(matrix));
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (ExecutionException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
