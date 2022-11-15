public class FibonacciSequence{
  public static void main(String args[]){
    int n = 5;
    System.out.println("first " + n + " terms of the fibonacci sequence: ");
    for(int i: fibonacciSequence(n)){
      System.out.println(i);
    }
    n = 10;
    System.out.println("first " + n + " terms of the fibonacci sequence: ");
    for(int i: fibonacciSequence(n)){
      System.out.println(i);
    }
  }

  public static int[] fibonacciSequence(int n){
    int[] result = new int[n];
    int a = 1;
    int b = 1;
    for(int i = 0; i < n; i++){
      if(i%2 == 0){
        result[i] = a;
        a += b;
      }else{
        result[i] = b;
        b += a;
      }
    }
    return result;
  }
}
