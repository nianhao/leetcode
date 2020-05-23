import java.util.WeakHashMap;

/**
 * 整数转罗马数字
 */


public class num12 {
    public static String getOne(int num,int e){

        String ans = null;
        switch (num){
            case 0: ans= "";
                    break;
            case 1: ans= "I";break;
            case 2: ans= "II";break;
            case 3: ans= "III";break;
            case 4: ans= "IV";break;
            case 5: ans= "V";break;
            case 6: ans= "VI";break;
            case 7: ans= "VII";break;
            case 8: ans= "VIII";break;
            case 9: ans= "IX";break;
        }

        if(e==0) return ans;
        if(e==1) {
            ans=ans.replace('X','C');
            ans=ans.replace('V','L');
            ans=ans.replace('I','X');
            return ans;
        }
        if(e==2){
            ans=ans.replace('X','M');
            ans=ans.replace('V','D');
            ans=ans.replace('I','C');
            return ans;
        }
        ans = ans.replace('I','M');

        return ans;
    }
    /**
     * 整数转罗马数字
     * @param num
     * @return
     */
    public static String intToRoman(int num) {
        if(num<10) return getOne(num,0);
        int x = num/10;
        int e = 0;
        int tmp=1;
        while (x>0){
            tmp*=10;
            x/=10;
            e++;
        }
        StringBuilder ans = new StringBuilder("");
        while (num>0){
            int n = num/tmp;
            num%=tmp;
            tmp/=10;
            ans.append(getOne(n,e--));
        }
        return ans.toString();
    }

    /**
     *
     * @param num
     * @return
     */
    public static String intToRoman2(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int ind =0;
        StringBuilder ans = new StringBuilder("");
        while (ind<13){
            while (num>=nums[ind]){

                ans.append(romans[ind]);
                num-=nums[ind];
            }
            ind++;

        }
        return ans.toString();
    }
    public static void main(String[] args) {
        System.out.println(intToRoman2(1994));
    }
}
