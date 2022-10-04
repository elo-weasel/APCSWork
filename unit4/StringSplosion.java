class StringSplosion{
  public static void main(String[] args){
    testStringSplosion("hi", "hhi");
    testStringSplosion("string", "sststrstristrinstring");
    testStringSplosion("test", "ttetestest");
  }
  public static String stringSplosion(String str) {
    String result = "";
    for(int i = 0; i < str.length() + 1; i++){
      result += str.substring(0, i);
    }
    return result;
  }
  public static void testStringSplosion(String s, String expected){
    String r = stringSplosion(s);
    System.out.println("expected: " + expected + " result: " + r);
    if(r.equals(expected)){
      System.out.println(":)");
    }else{
      System.out.println(":(");
    }
  }
}
