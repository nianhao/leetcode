import java.util.ArrayList;
import java.util.List;

public class num22_generate_parentheses2 {

    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder par = new StringBuilder();
        getAll(par,0,0,n,ans);
        return ans;
    }
    public static void getAll(StringBuilder par,int left,int right,int len,List<String> ans){
        if(par.length()==2*len){
            ans.add(par.toString());
            return;
        }
        if(left<len){
            par.append('(');
            getAll(par,left+1,right,len,ans);
            par.deleteCharAt(par.length()-1);
        }
        if(right<left){
            par.append(')');
            getAll(par,left,right+1,len,ans);
            par.deleteCharAt(par.length()-1);
        }
    }

    public static void main(String[] args) {
        List<String> ans = generateParenthesis(3);
        for (String s: ans) {
            System.out.println(s);

        }
    }

}
