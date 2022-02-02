public class ReverseNumber{
/*overflow*/
//  public static void reverseNumber(){
//    //long value = Integer.MAX_VALUE-1;
//    int value = Integer.MAX_VALUE-1;
//    for(int i = 0; i < 4; i++, value++) {
//      System.out.println(value);
//    }
//  }

//  public static void main(String args[]){
//    ReverseNumber ob = new ReverseNumber();
//    ob.reverseNumber();
//  }

  public int reverse(int x) {
    int res = 0;
    int pop;
    while (x != 0){
      pop = x % 10;
      x = x / 10;
      if(res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && pop > 7) return 0;
      if(res < Integer.MIN_VALUE / 10 || res == Integer.MIN_VALUE / 10 && pop < -8) return 0;
      res = res *10 + pop;
    }
    return res;
  }

  public static void main(String args[]){
    int a = 45670;
    ReverseNumber ob = new ReverseNumber();
    int b = ob.reverse(a);
    System.out.println(a + " reverse number is " + b);
  }
}