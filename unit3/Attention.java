class Attention{
  public static void main(String[] args){
    testAttention("Hey you!", true);
    testAttention("Hey you!...nevermind", true);
    testAttention("Hey!", false);
  }
  public static boolean attention(String str){
    if(str.length()>6){
      return str.substring(0, 8).equals("Hey you!");
    }else{
      return false;
    }
  }
  public static void testAttention(String str, boolean expected){
    System.out.println("expected: " + expected + " result: " + attention(str));
    if(attention(str) == expected){
      System.out.println(":)");
    }else{
      System.out.println(":(");
    }
  }
}
