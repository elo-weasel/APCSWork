class TestMagicEightBall{
  public static void main(String[] args){
    MagicEightBall m = new MagicEightBall();
    testMagicEightBall(m, "Will tomorrow be a good day?");
  }

  public static void testMagicEightBall(MagicEightBall m, String question){
    for(int i = 0; i < 1; i++){
      System.out.println(m.ask(question));
    }
  }
}
