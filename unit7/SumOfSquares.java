class SumOfSquares{
  public static void main(String[] args){
    double[] n1 = {1, 2, 3, 4};
    double[] n2 = {9, 2, 0};
    double[] n3 = {6, 2};

    test(n1, 30);
    test(n2, 85);
    test(n3, 40);
  }

  public static double sum(double[] nums){
    double result = 0;
    for (double n: nums){
      result += n*n;
    }
    return result;
  }

  public static void test(double[] nums, double expected){
    System.out.println("numbers: ");
    for(double n: nums){
      System.out.print(n + " ");
    }
    System.out.println();
    System.out.println("expected: " + expected + " result: " + sum(nums));
    if(sum(nums) == expected){
      System.out.println(":)");
    }else{
      System.out.println(":(");
    }
    System.out.println();
  }
}
