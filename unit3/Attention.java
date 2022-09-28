class Attention{
  public static void main(String[] args){
    System.out.println("Hey you!: "+attention("Hey you!"));
    System.out.println("Hey you!...nevermind: "+attention("Hey you!...nevermind"));
    System.out.println("Hey!: "+attention("Hey!"));
  }
  public static boolean attention(String str){
    if(str.length()>6){
      return str.substring(0, 8).equals("Hey you!");
    }else{
      return false;
    }
  }
}
