class Factorial{
  public static void main(String args[]){
    testFactorial(6, 720);
    testFactorial(7, 5040);
  }
  public static int factorial(int n){
    int result = 1;
    for(int i = 1; i < n+1; i++){
      result *= i;
    }
    return result;
  }
  public static void testFactorial(int n, int expected){
    System.out.println("expected: " + expected + " result: " + factorial(n));
    if(factorial(n) == expected){
      System.out.println(":)");
    }else{
      System.out.println(":(");
    }
  }
}
