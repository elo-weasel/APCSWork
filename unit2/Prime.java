class Prime{
  public static void main(String[] args){
    for(int i = 2; i < 100; i++){
      if(isPrime(i) == true){
        System.out.println(i);
      }
    }
  }
  public static boolean isPrime(int n){
    for(int i = 2; i <= n;){
      if(n%i != 0){
        i++;
      }else if (i == n){
        return true;
      }else{
        return false;
      }
    }
    return true;
  }
}
