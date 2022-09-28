class MixStart{
  public static void main(String[] args){
    System.out.println("hi: " + mixStart("hi"));
    System.out.println("fixing: " + mixStart("fixing"));
    System.out.println("wix: " + mixStart("wix"));
  }
  public static boolean mixStart(String str) {
    if(str.length()>2){
      return str.substring(1,3).equals("ix");
    }else{
      return false;
    }
  }
}
