import java.util.*;

public class ReverseAll{
  public static void main(String args[]){
    ArrayList<String> n1 = new ArrayList<String>();
    n1.add("ksdjf");
    n1.add("hi");
    n1.add("blah");

    ArrayList<String> e1 = new ArrayList<String>();
    e1.add("fjdsk");
    e1.add("ih");
    e1.add("halb");

    testReverseAll(n1, e1);
  }

  public static ArrayList<String> reverseAll(ArrayList<String> strs){
    ArrayList<String> result = new ArrayList<String>();
    for(int i = 0; i < strs.size(); i++){
      result.add(reverse(strs.get(i)));
    }
    return result;
  }

  public static String reverse(String s){
    String result = "";
    for(int i = s.length()-1; i >= 0; i--){
      result += s.substring(i, i+1);
    }
    return result;
  }

  public static void testReverseAll(ArrayList<String> strs, ArrayList<String> expected){
    System.out.println("words: ");
    for(String s: strs){
      System.out.print(s + " ");
    }
    System.out.println();
    System.out.print("expected: ");
    for (String s: expected){
      System.out.print(s + " ");
    }
    System.out.println();
    System.out.print(" result: ");
    for (String s: reverseAll(strs)){
      System.out.print(s + " ");
    }
    System.out.println();
    if(reverseAll(strs).equals(expected)){
      System.out.println(":)");
    }else{
      System.out.println(":(");
    }
    System.out.println();
  }
}
