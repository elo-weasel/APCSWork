class MixStart{
  public static void main(String[] args){
    testMixStart("hi", false);
    testMixStart("fixing", true);
    testMixStart("wix", true);
  }
  public static boolean mixStart(String str) {
    if(str.length()>2){
      return str.substring(1,3).equals("ix");
    }else{
      return false;
    }
  }
  public static void testMixStart(String str, boolean expected){
    System.out.println("expected: " + expected + " result: " + mixStart(str));
    if(mixStart(str) == expected){
      System.out.println(":)");
    }else{
      System.out.println(":(");
    }
  }
}
