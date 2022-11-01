class SumOfSquares{
  public static void main(String[] args){
    int[] n1 = {1, 2, 3, 4};
    int[] n2 = {9, 2, 0};
    int[] n3 = {6, 2};

    test(n1, 30);
    test(n2, 85);
    test(n3, 40);
  }

  public static int sum(int[] nums){
    int result = 0;
    for (int n: nums){
      result += n*n;
    }
    return result;
  }

  public static void test(int[] nums, int expected){
    System.out.println("numbers: ");
    for(int n: nums){
      System.out.print(n + " ");
    }
    System.out.println();
    System.out.println("expected: " + expected + " result: " + sum(nums));
    if(sum(nums) == expected){
      System.out.println(":)");
    }else{
      System.out.println(":()");
    }
    System.out.println();
  }
}
