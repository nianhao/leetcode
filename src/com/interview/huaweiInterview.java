package com.interview;

public class huaweiInterview {
    public String longestS(String s){
        StringBuffer sTmp = new StringBuffer("&");
        char[] sChar = s.toCharArray();
        for(int i=0;i<s.length();i++){
            sTmp.append(sChar[i]);
            sTmp.append('&');
        }
        int indM = -1;
        int lenM = 0;
        int lM=0;
        int rM=0;
        for(int i=1;i<sTmp.length()-1;i++){
            int ind = i;
            int l = ind -1;
            int r = ind+1;
            while(l>=0&&r<sTmp.length()){
                if(sTmp.charAt(l)==sTmp.charAt(r)){
                    if((r-l)>lenM){
                        lenM=r-l;lM=l;rM=r;
                    }
                    l--;r++;
                }else{
                    break;
                }
            }
        }
       // System.out.println(indM);
        StringBuffer ans = new StringBuffer();
        for(int i=lM;i<rM;i++){
            if(sTmp.charAt(i)!='&') ans.append(sTmp.charAt(i));
        }
        return  ans.toString();


    }

    public static void main(String[] args) {
        huaweiInterview t = new huaweiInterview();
        System.out.println(t.longestS("aa"));
        System.out.println(t.longestS("aca"));
        System.out.println(t.longestS("accaeffffcffff"));
    }


}
