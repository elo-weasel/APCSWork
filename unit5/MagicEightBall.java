public class MagicEightBall{
  private final String response1;
  private final String response2;
  private final String response3;
  private final String response4;
  private final String response5;
  private final String response6;
  private int random;

  public MagicEightBall(){
    response1 = "Yes";
    response2 = "No";
    response3 = "The stars say yes";
    response4 = "Possibly";
    response5 = "Don't plan on it";
    response6 = "It seems to be so";
    random = (int)(Math.random()*6);
  }

  public String ask(String s){
    if (random == 1){
      return response1;
    }else if(random == 2){
      return response2;
    }else if(random == 3){
      return response3;
    }else if(random == 4){
      return response4;
    }else if(random == 5){
      return response5;
    }else{
      return response6;
    }
  }
}
