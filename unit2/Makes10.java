class Makes10{
  public static void main (String[] args){
    testMakes10(4,5);
    testMakes10(2,10);
    testMakes10(7,3);
  }
  public static boolean makes10(int a, int b) {
    return a+b == 10 || a==10 || b==10;
  }
  public static void testMakes10(int num1, int num2){
    System.out.println(num1 + ", " + num2 + ": " + makes10(num1, num2));
  }
}
