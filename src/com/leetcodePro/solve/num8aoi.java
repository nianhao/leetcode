public class num8aoi {
    public static int myAtoi(String str) {
        StringBuilder res = new StringBuilder("");
        StringBuilder str2 = new StringBuilder("");
        int n = str.length();
        int len=0;
        char c ;
        boolean flag = false;
        boolean lzero = false;
        for(int i=0;i<n;i++){
            c = str.charAt(i);
            if(flag==false&&c==' ') continue;
            if(flag==false&&c!=' '){
                flag=true;
                str2.append(c);
                len++;
                continue;
            }
            str2.append(c);
            len++;
        }
        //str = str.trim();
        flag=false;
        for(int i=0;i<len;i++){
            c = str2.charAt(i);
            if(c=='+'){
                if(flag==false)
                {
                    flag = true;
                    continue;
                }
                break;

            }
            if(c=='-'){
                if(flag==false){
                    flag=true;
                    res.append(c);
                    continue;
                }
                break;
            }else if('0'<=c&&c<='9'){
                res.append(c);
                flag=true;
                continue;
            }else{
                break;
                //if(c==' ') continue;
            }
        }
        if(res.length()==0) return 0;
        if(res.length()==1){
            c = res.charAt(0);
            if(c=='-'||c=='+') return 0;
        }
        try
        {
            return Integer.parseInt(res.toString());
        }catch (Exception e){
            if(res.charAt(0)=='-')
                return Integer.MIN_VALUE;
            else return Integer.MAX_VALUE;
        }
    }
    public static int myAtoi2(String str) {
        StringBuilder res = new StringBuilder("");
        StringBuilder str2 = new StringBuilder("");
        int n = str.length();
        int len=0;
        char c ;
        boolean flag = false;
        boolean lzero = false;
        for(int i=0;i<n;i++){
            c = str.charAt(i);
            if(c==' '&&len==0) continue;
            if(c=='+'||c=='-'){
                if(len==0){
                    res.append(c);
                    len++;
                    continue;
                }
                break;
            }
            if(c>='0'&&c<='9'){
                res.append(c);
                len++;
                continue;
            }
            break;

        }

        if(len==0) return 0;
        if(len==1){
            c = res.charAt(0);
            if(c=='-'||c=='+') return 0;
        }
        try
        {
            return Integer.parseInt(res.toString());
        }catch (Exception e){
            if(res.charAt(0)=='-')
                return Integer.MIN_VALUE;
            else return Integer.MAX_VALUE;
        }
    }
    public static int myAtoi3(String str) {
        StringBuilder res = new StringBuilder("");
        StringBuilder str2 = new StringBuilder("");
        int n = str.length();
        int len = 0;
        int ans = 0;
        long tmp = 0;
        char c;
        boolean flag = false;
        boolean lzero = false;
        for (int i = 0; i < n; i++) {
            c = str.charAt(i);
            if (c == ' ' && len == 0) continue;
            if (c == '+' || c == '-') {
                if (len == 0) {
                    if (c == '-') lzero = true;
                    res.append(c);
                    len++;
                    continue;
                }
                break;
            }
            if (c >= '0' && c <= '9') {
                res.append(c);
                len++;
                int a = lzero ? (-(c - '0')) : (c - '0');
                tmp = tmp * 10 + a;
                if(tmp>Integer.MAX_VALUE) return Integer.MAX_VALUE;
                if(tmp<Integer.MIN_VALUE) return Integer.MIN_VALUE;
                ans = (int)tmp;
                continue;
            }
            break;

        }
        return ans;


    }
    public static void main(String[] args) {
        System.out.println(myAtoi3("  0000000000012345678"));
        System.out.println(myAtoi3("-2147483647"));
    }
}
