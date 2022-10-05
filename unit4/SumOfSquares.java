class SumOfSquares{
  public static void main(String args[]){
    testSum(4, 30);
    testSum(5, 55);
  }
  public static int sum(int n){
    int result = 0;
    for(int i = 1; i<=n; i++){
      result += i*i;
    }
    return result;
  }
  public static void testSum(int n, int expected){
    System.out.println("sum of: " + n + ", expected: " + expected + " result: " + sum(n));
    if(sum(n) == expected){
      System.out.println(":)");
    }else{
      System.out.println(":(");
    }
  }
}
