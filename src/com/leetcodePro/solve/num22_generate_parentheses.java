import java.util.ArrayList;
import java.util.List;

public class num22_generate_parentheses {

    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        char[] par = new char[2*n];
        getAll(par,0,2*n,ans);
        return ans;
    }
    public static void getAll(char[] par,int pos,int len,List<String> ans){
        if(pos==len){
            if(vaild(par)){
                ans.add(new String(par));
            }
            return;
        }
        par[pos]='(';
        getAll(par,pos+1,len,ans);
        par[pos]=')';
        getAll(par,pos+1,len,ans);
    }
    public static boolean vaild(char[] par){
        int count =0;
        for(int i=0;i<par.length;i++){
            if(count<0) break;
            if(par[i]=='(') count++;
            if(par[i]==')') count--;
        }
        if(count==0) return true;
        return false;
    }

    public static void main(String[] args) {
        List<String> ans = generateParenthesis(10);
        for (String s: ans) {
            System.out.println(s);

        }
    }

}
