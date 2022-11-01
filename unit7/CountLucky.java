class CountLucky{
  public static void main(String[] args){
    int[] n1 = {3, 7, 14};
    int[] n2 = {17, -7, 0};
    int[] n3 = {230487, 4, 2};

    test(n1, 2);
    test(n2, 2);
    test(n3, 1);
  }

  public static int count(int[] nums){
    int result = 0;
    for (int n: nums){
      if((n%7 == 0 || n%10 == 7 || n%10 == -7) && n != 0){
        result += 1;
      }
    }
    return result;
  }

  public static void test(int[] nums, int expected){
    System.out.println("numbers: ");
    for(int n: nums){
      System.out.print(n + " ");
    }
    System.out.println();
    System.out.println("expected: " + expected + " result: " + count(nums));
    if(count(nums) == expected){
      System.out.println(":)");
    }else{
      System.out.println(":()");
    }
    System.out.println();
  }
}
