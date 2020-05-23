public class Num151reverse_words_in_a_string {
    public static String reverseWords(String s) {
        if(s.length()==0) return s;
        String [] words = s.split(" ");
        StringBuilder ans = new StringBuilder();
        for(int i=words.length-1;i>0;i--){
            if(words[i].length()==0) continue;
            ans.append(words[i]);
            ans.append(" ");
        }
        if(ans.charAt(ans.length())==' '){
            ans.deleteCharAt(ans.length());
        }
        return ans.toString();


    }

    public static void main(String[] args) {
        System.out.println(reverseWords("a"));
    }
}
