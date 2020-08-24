package com.leetcode.SwordToOffer;

public class num3 {
    public String replaceSpace(String s) {
        int len = s.length();
        char[] sChar = s.toCharArray();
        StringBuilder res = new StringBuilder();
        for(int i=0;i<len;i++){
            if(sChar[i]==' '){
                res.append("%20");
            }
            else{
                res.append(sChar[i]);
            }
        }
        return  res.toString();
    }
}
