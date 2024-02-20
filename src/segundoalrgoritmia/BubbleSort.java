package segundoalrgoritmia;
-import java.util.Arrays;

public class BubbleSort {

  public static void main(String[] args) {
    int[] array = { 67, 4, 30, 12, 5, 27 };

    System.out.println("ARRAY ORIGINIAL");
    System.out.println(Arrays.toString(array));

    for (int i = 0; i < array.length - 1; i++) {
      for (int j = 0; j < array.length - i - 1; j++) {
        if (array[j] > array[j + 1]) {
          int temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
        }
      }

      System.out.println("PASADA " + (i + 1) + ": " + Arrays.toString(array));
    }

    System.out.println("ARRELGO ORDENADO");
    System.out.println(Arrays.toString(array));
  }
}
