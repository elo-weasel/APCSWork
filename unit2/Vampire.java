class Vampire{
  public static void main(String[] args){
    testIsVampire(5, true, true);
    testIsVampire(20, true, false);
    testIsVampire(15, false, true);
    testIsVampire(3, false, false);
  }
  public static boolean isVampire(float hour, boolean awake){
    if (awake == true){
      return hour < 6 || hour > 22;
    }else{
      return hour >= 6 && hour <= 22;
    }
  }
  public static void testIsVampire(float h, boolean a, boolean expected){
    System.out.println("expected: " + expected + " result: " + isVampire(h, a));
    if(isVampire(h, a) == expected){
      System.out.println(":)");
    }else{
      System.out.println(":(");
    }
  }
}
