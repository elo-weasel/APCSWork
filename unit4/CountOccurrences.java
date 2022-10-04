class CountOccurrences{
  public static void main(String args[]){
    testCountOccurrences("haha", "ha", 2);
    testCountOccurrences("rawr", "aw", 1);
  }
  public static int countOccurrences(String big, String small){
    int result = 0;
    for(int i = 0; i < big.length()-(small.length()-1); i++){
      if(big.substring(i, i+small.length()).equals(small)){
        result += 1;
      }
    }
    return result;
  }
  public static void testCountOccurrences(String b, String s, int expected){
    System.out.println("expected: " + expected + " result: " + countOccurrences(b,s));
    if(countOccurrences(b,s) == expected){
      System.out.println(":)");
    }else{
      System.out.println(":(");
    }
  }
}
