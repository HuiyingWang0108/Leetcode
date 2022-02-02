/*121, 0, 565  true, -121, 54 false*/
public class PalindromeNumber {

  public boolean isPalindrome(int x) {
    int res = 0;
    int temp = x;
    int pop;
    while (x > 0) {
      pop = x % 10;
      x = x / 10;
      if (res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && pop > 7) {
        break;
      }
      res = res * 10 + pop;
    }
    if (res == temp || temp == 0) {
      return true;
    } else {
      return false;
    }
  }

  public static void main(String args[]) {
    int a = 0;
    PalindromeNumber ob = new PalindromeNumber();
    boolean isPalindrome = ob.isPalindrome(a);
    System.out.println(a + " isPalindrome " + isPalindrome);
  }
}