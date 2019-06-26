package hackerrank;

public class Shopkeeper {

  public static int price(int arr[]) {
    int price = 0;
    boolean priceUpdated = false;
    for (int i = 0; i < arr.length; i++) {
      priceUpdated = false;
      if (i == arr.length - 1) {
        price = price + arr[i];
        System.out.println(price);
        break;
      }
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[i] > arr[j]) {
          price = price + arr[i] - arr[j];
          priceUpdated = true;
          break;
        }
      }
      if (!priceUpdated) {
        price = price + arr[i];
      }
      System.out.println(price);
    }

    return price;

  }

  public static void main(String[] args) {
    int arr[] = {5, 1, 3, 8, 6, 2};
    System.out.println(price(arr));

  }

}
