import java.util.*;

class ZName{
  public static void main(String[] args){
    ArrayList<String> s1 = new ArrayList<String>();
    s1.add("Zzzz");
    s1.add("zoo");
    s1.add("ooze");
    ArrayList<String> s2 = new ArrayList<String>();
    s2.add("buzz");
    s2.add("sizzle");
    ArrayList<String> s3 = new ArrayList<String>();
    s3.add("zip");
    s3.add("zap");

    test(s1, 7);
    test(s2, 0);
    test(s3, 6);
  }

  public static int zs(ArrayList<String> strs){
    int result = 0;
    for (String s: strs){
      if(s.substring(0,1).equals("z") || s.substring(0,1).equals("Z")){
        result += s.length();
      }
    }
    return result;
  }

  public static void test(ArrayList<String> strs, int expected){
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
