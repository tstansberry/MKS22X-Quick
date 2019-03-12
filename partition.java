import java.util.Random;

public class partition {
  public static void main(String[] args) {
    int[] ary = {999,999,999,4,1,0,3,2,999,999,999};
    partition(ary, 0, ary.length - 1);
    System.out.println(printArr(ary));
  }

  public static int partition (int [] data, int start, int end) {
    Random rand = new Random();
    int pivot = rand.nextInt(data.length);

    swap(data, pivot, 0);
    System.out.println("Pivot: " + data[0]);

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
