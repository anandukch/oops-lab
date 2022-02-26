import java.util.Arrays;
import java.util.Scanner;

class ThreadA extends Thread {
  int s[];
  int sum = 0;

  ThreadA(int x[]) {
    this.s = x;
    this.start();
  }

  public void run() {

    for (int i = 0; i < s.length; i++) {
      this.sum = this.sum + s[i];
    }
    System.out.println("The sum is " + this.sum);
    // try {
    // Thread.sleep(2000);
    // } catch (Exception e) {
    // System.out.println(e);
    // }
  }

  public int sum() {
    return this.sum;
  }

}

class ThreadDemo {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the array size");
    int n = sc.nextInt();
    int arr[] = new int[n];
    System.out.println("Enter the array elements");
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    float a = (n * 3) / 4;
    int b = (int) a;
    int newArr1[] = Arrays.copyOfRange(arr, 0, arr.length / 4);
    int newArr2[] = Arrays.copyOfRange(arr, arr.length / 4, arr.length / 2);
    int newArr3[] = Arrays.copyOfRange(arr, arr.length / 2, b);
    int newArr4[] = Arrays.copyOfRange(arr, b, arr.length);

    ThreadA T1 = new ThreadA(newArr1);
    ThreadA T2 = new ThreadA(newArr2);
    ThreadA T3 = new ThreadA(newArr3);
    ThreadA T4 = new ThreadA(newArr4);
    int s1, s2, s3, s4;
    try {
      T1.join();
      T2.join();
      T3.join();
      T4.join();

    } catch (Exception e) {
      System.out.println();
    }
    s1 = T1.sum();
    s2 = T2.sum();
    s3 = T3.sum();

    s4 = T4.sum();
    System.out.println("The sum of the array is " + (s1 + s2 + s3 + s4));

  }
}