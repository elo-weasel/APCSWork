class Deals{
  public static void main(String[] args){
    testGoodDeal(20.00, 15.00);
    testGoodDeal(190.00, 42.00);
    testGoodDeal(55.00, 50.00);
  }
  public static boolean goodDeal(double originalPrice, double salePrice){
    return originalPrice*.75>=salePrice;
  }
  public static void testGoodDeal(double o, double s){
    System.out.println(o + ", " + s + ": " + goodDeal(o, s));
  }
}
