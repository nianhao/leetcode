public class num14_longest_common_prefix {
    public static String longestCommonPrefix(String[] strs) {

        int strNum = strs.length;
        if(strNum==1) return strs[0];
        int minLen = Integer.MAX_VALUE;
        for(int i=0;i<strs.length;i++)
            minLen=Math.min(minLen,strs[i].length());
        StringBuilder res = new StringBuilder("");
        for(int i=0;i<minLen;i++){
            boolean flag=true;
            char c = strs[0].charAt(i);
            for(int j=1;j<strNum;j++){
                if(strs[j].charAt(i)!=c){
                    flag=false;
                    break;
                }
            }
            if(flag){
                res.append(c);
            }else{
                break;
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }
}
