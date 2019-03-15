import java.util.*;

public class Quick {
  public static void main(String[] args) {
    int[] ary = {5,5,5,5,5,5,5,4};
    //System.out.println("ANSWER(999): " + quickselect(ary, 10));
    System.out.println(quickselect(ary, 0));
    System.out.println(printArr(ary));
  }

  public static int partition (int [] data, int start, int end) {
    Random rand = new Random();
    int pivot = rand.nextInt(end - start + 1);

    swap(data, pivot, start);

    while (start != end) {
      if (data[start + 1] > data[start]) {
        swap(data, start + 1, end);
        end --;
      }
      else {
        swap(data, start, start + 1);
        start ++;
      }
    }
    return start;
  }


  public static int quickselect(int []data, int k){
    int start = 0;
    int end = data.length - 1;

    boolean finished = false;
    while (! finished) {
      int pivot  = partition(data, start, end);
      if (pivot == k) finished = true;
      else if (pivot < k) start = pivot + 1;
      else end = pivot - 1;
    }
    return data[k];
  }

  public static void quicksort(int[] data) {
    sortHelper(data, 0, data.length - 1);
  }


  private static void sortHelper(int[] data, int low, int high) {
    if (low > high) return;
    int pivot = partition(data, low, high);
    sortHelper(data, pivot + 1, high);
    sortHelper(data, low, pivot - 1);
  }

  public static String printArr(int[] arr) {
    String output = "";
    for (int x: arr) {
      output += x + " ";
    }
    return output;
  }

  private static void swap(int[] ary, int idx1, int idx2) {
    int holder = ary[idx1];
    ary[idx1] = ary[idx2];
    ary[idx2] = holder;
  }
}
