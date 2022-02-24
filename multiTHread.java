import java.util.Arrays;

class ThreadA extends Thread {
  int s[];

  ThreadA(int x[]) {
    this.s = x;
  }

  public void run() {
    int sum = 0;
    for (int i = 0; i < s.length; i++) {
      sum = sum + s[i];
    }
    System.out.println("The sum is " + sum);
    try {
      Thread.sleep(2000);
    } catch (Exception e) {
      System.out.println(e);
    }
  }
  
}

class ThreadDemo {
  public static void main(String[] args) {

    int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
    int newArr1[] = Arrays.copyOfRange(arr, 0, 2);
    int newArr2[] = Arrays.copyOfRange(arr, 2, 4);
    int newArr3[] = Arrays.copyOfRange(arr, 4, 6);
    int newArr4[] = Arrays.copyOfRange(arr, 6, 8);
    ThreadA T1 = new ThreadA(newArr1);
    ThreadA T2 = new ThreadA(newArr2);
    ThreadA T3 = new ThreadA(newArr3);
    ThreadA T4 = new ThreadA(newArr4);
    try {
      T1.start();
      T2.start();
      T3.start();
      T4.start();
    } catch (Exception e) {
      System.out.println();
    }

  }
}