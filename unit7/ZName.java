class ZName{
  public static void main(String[] args){
    String[] s1 = {"Zzzz", "zoo", "ooze"};
    String[] s2 = {"buzz", "sizzle"};
    String[] s3 = {"zip", "zap"};

    test(s1, 7);
    test(s2, 0);
    test(s3, 6);
  }

  public static int zs(String[] strs){
    int result = 0;
    for (String s: strs){
      if(s.substring(0,1).equals("z") || s.substring(0,1).equals("Z")){
        result += s.length();
      }
    }
    return result;
  }

  public static void test(String[] strs, int expected){
    System.out.println("words: ");
    for(String s: strs){
      System.out.print(s + " ");
    }
    System.out.println();
    System.out.println("expected: " + expected + " result: " + zs(strs));
    if(zs(strs) == expected){
      System.out.println(":)");
    }else{
      System.out.println(":(");
    }
    System.out.println();
  }
}
