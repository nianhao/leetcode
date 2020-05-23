public class num7ReverseInt {
    public static int reverse(int x) {
        if(x==0) return x;
        StringBuilder res=new StringBuilder();
        if(x<0){
            res.append('-');
            x = Math.abs(x);
        }
        while (x>0){
            int a = x%10;
            res.append(a);
            x/=10;
        }

        try{
            return Integer.parseInt(res.toString());
        }catch (Exception e){
            return 0;
        }

    }
    public static int reverse2(int x) {
        int res = 0;
        while (x != 0) {
            int tmp = x % 10;
            int resTmp = res*10+tmp;
            if((resTmp-tmp)/10!=res) return 0;
            res = res * 10 + tmp;
            x /= 10;

        }
        return res;
    }
    public static void main(String[] args) {
        reverse(-125003200);
    }
}
