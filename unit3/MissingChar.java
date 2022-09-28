class MissingChar{
  public static void main(String[] args){
    System.out.println(missingChar("scrumptious", 4));
    System.out.println(missingChar("buffalo", 4));
    System.out.println(missingChar("penguin", 3));
  }
  public static String missingChar(String str, int n) {
    return str.substring(0,n) + str.substring(n+1);
  }
}
