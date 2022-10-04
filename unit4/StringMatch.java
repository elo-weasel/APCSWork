class StringMatch{
  public static void main(String args[]){
    testStringMatch("sldjfkls", "sldjfkls", 7);
    testStringMatch("huh", "sldjfkls", 0);
    testStringMatch("blah", "bleh", 1);
  }
  public static int stringMatch(String a, String b) {
    int result = 0;
    if(a.length() < b.length()){
      for(int i = 0; i < a.length() - 1; i++){
        if(a.substring(i, i+2).equals(b.substring(i, i+2))){
          result+=1;
        }
      }
    }else{
      for(int i = 0; i < b.length() - 1; i++){
        if(a.substring(i, i+2).equals(b.substring(i, i+2))){
          result += 1;
        }
      }
    }
    return result;
  }
  public static void testStringMatch(String a, String b, int expected){
    int r = stringMatch(a, b);
    System.out.println("expected: " + expected + " result: " + r);
    if(r == expected){
      System.out.println(":)");
    }else{
      System.out.println(":(");
    }
  }
}
