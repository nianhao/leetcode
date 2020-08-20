import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class num5 {
    public static String solve(String s ){
        int n = s.length();
        StringBuilder str = new StringBuilder(s);
        StringBuilder addStr = new StringBuilder(2*n+5);
        addStr.append('#');
        for(int i=0;i<n;i++){
            addStr.append(s.charAt(i));
            addStr.append('#');
        }
        //System.out.println(addStr);
        int max = 1;
        int maxL = 0;
        int maxR = 0;
        int maxC = -1;
        int len = addStr.length();
        for(int i =0;i<len;i++){
            for(int pl =i-1,pr=i+1;pl>-1&&pr<len;pl--,pr++){
                if(addStr.charAt(pl)==addStr.charAt(pr)){
                    if(max<(pr-pl+1)){
                        max = pr-pl+1;
                        maxL=pl;
                        maxR=pr;
                        maxC=i;
                    }
                    continue;
                }
                break;
            }
        }

        StringBuilder res1 = new StringBuilder(addStr.substring(maxL,maxR+1));
        StringBuilder res = new StringBuilder();
        for(int i=0;i<res1.length();i++){
            if(i%2!=0) res.append(res1.charAt(i));
        }
        s=res.toString();
        return s;
    }
    public static String solve2(String s){
        int n = s.length();
        StringBuilder str = new StringBuilder(s);
        StringBuilder addStr = new StringBuilder(2*n+5);
        addStr.append("$#");
        for(int i=0;i<n;i++){
            addStr.append(s.charAt(i));
            addStr.append('#');
        }
        addStr.append('%');
        int len = addStr.length();
        int[] p = new int[len];
        int id=0,mx=0;
        for(int i =1;i<len-1;i++){
            if(i<mx) p[i] = Math.min(p[2*id-i],mx-i);
            else p[i]=1;
            while (addStr.charAt(i-p[i])==addStr.charAt(i+p[i])) p[i]++;
            if(i+p[i]>mx){
                mx=i+p[i];
                id=i;
            }
        }
        int maxInd=-1;
        int maxNum = -1;
        for(int i=0;i<len;i++){
            if(p[i]>maxNum){
                maxInd=i;
                maxNum=p[i];
            }
        }
        String res1 = addStr.substring(maxInd-maxNum+1,maxInd+maxNum);
        StringBuilder res = new StringBuilder();
        for(int i=1;i<res1.length();i++)
            if(i%2==1) res.append(res1.charAt(i));
        return res.toString();
    }
    public static void main(String[] args) {
        System.out.println(solve2("bcbadafefsdfffffffffffffd"));
    }
}
