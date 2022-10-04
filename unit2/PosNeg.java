class PosNeg{
  public static void main(String[] args){
    testPosNeg(-2, -3, true, true);
    testPosNeg(2, -1, true, false);
    testPosNeg(0, -4, false, true);
    testPosNeg(9, 5, false, false);
  }

  public static boolean posNeg(int a, int b, boolean negative) {
  if (negative == true){
    return a < 0 && b < 0;
    }else{
      if(a<b){
        return a<0 && b>=0;
      }else{
        return a>=0 && b<0;
      }
    }
  }

  public static void testPosNeg(int n1, int n2, boolean neg, boolean expected){
    System.out.println("expected: " + expected + " result: " + posNeg(n1, n2, neg));
    if(posNeg(n1, n2, neg) == expected){
      System.out.println(":)");
    }else{
      System.out.println(":(");
    }
  }
}
