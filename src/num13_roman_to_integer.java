import java.util.HashMap;

public class num13_roman_to_integer {
    public static  int romanToInt(String s) {
        HashMap<Character,Integer> r2i = new HashMap();
        r2i.put('I',1);
        r2i.put('V',5);
        r2i.put('X',10);
        r2i.put('L',50);
        r2i.put('C',100);
        r2i.put('D',500);
        r2i.put('M',1000);
        int n=r2i.get(s.charAt(s.length()-1));
        for(int i=s.length()-2;i>=0;i--){
            if(r2i.get(s.charAt(i))>=r2i.get(s.charAt(i+1))){
                n+=r2i.get(s.charAt(i));
            }else{
                n-=r2i.get(s.charAt(i));
            }
        }
        return n;



    }
    public static  int romanToInt2(String s) {
        int cur=0;
        int pre = 0;
        int ans = 0;
        int n = s.length();
        for(int i=n-1;i>=0;i--){
            char c = s.charAt(i);
            switch (c){
                case 'I':
                    cur = 1;
                    break;
                case 'V':
                    cur = 5;
                    break;
                case 'X':
                    cur = 10;
                    break;
                case 'L':
                    cur = 50;
                    break;
                case 'C':
                    cur = 100;
                    break;
                case 'D':
                    cur = 500;
                    break;
                case 'M':
                    cur = 1000;
                    break;
            }
            if(i==(n-1)){
                pre = cur;
                ans += cur;
            }else{
                if(cur<pre){
                    ans-=cur;
                }else{
                    ans+=cur;
                }
                pre=cur;
            }
        }
        return ans;



    }

    public static void main(String[] args) {
        System.out.println(romanToInt2("MCMXCIV"));
    }
}
