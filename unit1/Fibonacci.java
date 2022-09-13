class Fibonacci{
  public static void main(String[] args){
    int a = 0;
    int b = 1;
    for(int i = 0; i < 30; i++){
      System.out.println(a+b);
      if(i%2  == 0){
        System.out.println(b/a);
        a = a+b;
      }else{
        System.out.println(a/b);
        b = a+b;
      }
    }
  }
}
