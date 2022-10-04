class Deals{
  public static void main(String[] args){
    testGoodDeal(20.00, 15.00, true);
    testGoodDeal(190.00, 42.00, true);
    testGoodDeal(55.00, 50.00, false);
  }
  public static boolean goodDeal(double originalPrice, double salePrice){
    return originalPrice*.75>=salePrice;
  }
  public static void testGoodDeal(double o, double s, boolean expected){
    System.out.println("expected: " + expected + " result: " + goodDeal(o, s));
    if(goodDeal(o, s) == expected){
      System.out.println(":)");
    }else{
      System.out.println(":(");
    }
  }
}
