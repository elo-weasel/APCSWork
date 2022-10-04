class MissingChar{
  public static void main(String[] args){
    testMissingChar("scrumptious", 4, "scruptious");
    testMissingChar("buffalo", 4, "bufflo");
    testMissingChar("penguin", 3, "penuin");
  }
  public static String missingChar(String str, int n) {
    return str.substring(0,n) + str.substring(n+1);
  }
  public static void testMissingChar(String str, int n, String expected){
    System.out.println("expected: " + expected + " result: " + missingChar(str, n));
    if(missingChar(str, n).equals(expected)){
      System.out.println(":)");
    }else{
      System.out.println(":(");
    }
  }
}
