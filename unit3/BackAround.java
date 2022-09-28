class BackAround{
  public static void main(String[] args){
    System.out.println(backAround("jam"));
    System.out.println(backAround("jelly"));
    System.out.println(backAround("snocker"));
  }
  public static String backAround(String str) {
    return str.substring(str.length()-1, str.length()) + str + str.substring(str.length()-1, str.length());
  }
}
