class Vampire{
  public static void main(String[] args){
    testIsVampire(5, true);
    testIsVampire(20, true);
    testIsVampire(15, false);
    testIsVampire(3, false);
  }
  public static boolean isVampire(float hour, boolean awake){
    if (awake == true){
      return hour < 6 || hour > 22;
    }else{
      return hour >= 6 && hour <= 22;
    }
  }
  public static void testIsVampire(float h, boolean a){
    System.out.println(h + ", " + a + ": " + isVampire(h, a));
  }
}
