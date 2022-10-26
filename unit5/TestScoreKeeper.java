class TestScoreKeeper{
  public static void main(String[] args){
    ScoreKeeper s1 = new ScoreKeeper();
    ScoreKeeper s2 = new ScoreKeeper();

    testScoreKeeper(s1);
    testScoreKeeper(s2);
  }

  public static void testScoreKeeper(ScoreKeeper s){
    System.out.println();
    System.out.println("score: " + s.getScore());

    int random = (int)(Math.random()*5);
    for(int i = 0; i<random; i++){
      System.out.println("+100");
      s.scoreNormal();
      System.out.println("new score: " + s.getScore());
    }

    random = (int)(Math.random()*3);
    for(int i = 0; i<random; i++){
      System.out.println("+1000");
      s.scoreBonus();
      System.out.println("new score: " + s.getScore());
    }
  }
}
