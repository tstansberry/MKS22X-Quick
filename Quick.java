import java.util.*;

public class Quick {
  public static void main(String[]args){
  System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
  int[]MAX_LIST = {1000000000,500,10};
  for(int MAX : MAX_LIST){
    for(int size = 31250; size < 2000001; size*=2){
      long qtime=0;
      long btime=0;
      //average of 5 sorts.
      for(int trial = 0 ; trial <=5; trial++){
        int []data1 = new int[size];
        int []data2 = new int[size];
        for(int i = 0; i < data1.length; i++){
          data1[i] = (int)(Math.random()*MAX);
          data2[i] = data1[i];
        }
        long t1,t2;
        t1 = System.currentTimeMillis();
        Quick.quicksort(data2);
        t2 = System.currentTimeMillis();
        qtime += t2 - t1;
        t1 = System.currentTimeMillis();
        Arrays.sort(data1);
        t2 = System.currentTimeMillis();
        btime+= t2 - t1;
        if(!Arrays.equals(data1,data2)){
          System.out.println("FAIL TO SORT!");
          System.exit(0);
        }
      }
      System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
    }
    System.out.println();
  }
}

  public static int partition (int [] data, int start, int end) {
    int pivot = start + (int)(Math.random() * (end - start + 1));

    swap(data, pivot, start);
    pivot = start;
    int high = end;

    while (start < high) {
      if (data[start] > data[pivot]) {
        swap(data, start, high);
        high --;
      }
      else if (data[high] < data[pivot]) {
        swap(data, start, high);
        start++;
      }
      else {
        start ++;
        high --;
      }
    }
    int output = pivot;
    for (int x = pivot + 1; x <= end; x ++) {
      if (data[x] < data[pivot]) output = x;
      if (data[x] > data[pivot]) x = end + 1;
    }
    swap(data, pivot, output);
    return output;
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
    if (data.length >= 0) sortHelper(data, 0, data.length - 1);
    sortHelper(data,0,0);
  }


  private static void sortHelper(int[] data, int low, int high) {
    if (low >= high) return;
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
