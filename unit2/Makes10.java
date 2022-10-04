class Makes10{
  public static void main (String[] args){
    testMakes10(4, 5, false);
    testMakes10(2, 10, true);
    testMakes10(7, 3, true);
  }
  public static boolean makes10(int a, int b) {
    return a+b == 10 || a==10 || b==10;
  }
  public static void testMakes10(int num1, int num2, boolean expected){
    System.out.println("expected: " + expected + " result: " + makes10(num1, num2));
    if(makes10(num1, num2) == expected){
      System.out.println(":)");
    }else{
      System.out.println(":(");
    }
  }
}
