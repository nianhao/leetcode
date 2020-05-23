public class num9 {
    public static boolean  isPalindrome(int x) {
        if(x<0) return false;
        String ans = String.valueOf(x);
        for(int i=0,j=ans.length()-1;i<=j;i++,j--){
            if(ans.charAt(i)!=ans.charAt(j)) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
}
