class Greetings{
  public static void main(String[] args){
    testGreetings("Audrey", "Hello, Audrey, how are you?");
    testGreetings("jam", "Hello, jam, how are you?");
    testGreetings("isdhfoewhophfwebbhksjbdjf :)", "Hello, isdhfoewhophfwebbhksjbdjf :), how are you?");
  }
  public static String greetings(String name){
    return "Hello, " + name + ", how are you?";
  }
  public static void testGreetings(String name, String expected){
    System.out.println("expected: " + expected + " result: " + greetings(name));
    if(greetings(name).equals(expected)){
      System.out.println(":)");
    }else{
      System.out.println(":(");
    }
  }
}
