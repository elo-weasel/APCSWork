class BackAround{
  public static void main(String[] args){
    testBackAround("jam", "mjamm");
    testBackAround("jelly", "yjellyy");
    testBackAround("snocker", "rsnockerr");
  }
  public static String backAround(String str) {
    return str.substring(str.length()-1, str.length()) + str + str.substring(str.length()-1, str.length());
  }
  public static void testBackAround(String str, String expected){
    System.out.println("expected: " + expected + " result: " + backAround(str));
    if(backAround(str).equals(expected)){
      System.out.println(":)");
    }else{
      System.out.println(":(");
    }
  }
}
