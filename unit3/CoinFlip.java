class CoinFlip{
  public static void main(String[] args){
    for(int i = 0; i < 10; i++){
      System.out.println(flip());
    }
  }
  public static String flip(){
    double r = Math.random();
    if(r>0.5){
      return "Heads";
    }else{
      return "Tails";
    }
  }
}
