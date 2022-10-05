class Reverse{
  public static void main(String args[]){
    testReverse("wow","wow");
    testReverse("shoes", "seohs");
  }
  public static String reverse(String s){
    String result = "";
    for(int i = s.length()-1; i >= 0; i--){
      result += s.substring(i, i+1);
    }
    return result;
  }
  public static void testReverse(String s, String expected){
    System.out.println("original: " + s + ", expected: " + expected + " result: " + reverse(s));
    if(reverse(s).equals(expected)){
      System.out.println(":)");
    }else{
      System.out.println(":(");
    }
  }
}
