import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class num3 {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        int ans = 0;
        Set<Character> win = new HashSet<>();
        int n = s.length();
        while (i < n && j < n) {
            if (win.contains(s.charAt(j))) {
                win.add(s.charAt(j));
                ans = Math.max(ans, j - i);
                j++;
            } else {
                win.remove(s.charAt(i));
                i++;
            }
        }
        return ans;
    }
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        int j=0;
        int ans = 0;
        for(int i=0;i<n;i++){
            if(map.containsKey(s.charAt(i))){
                j = Math.max(map.get(s.charAt(i)),j);
            }
            ans = Math.max(ans,i-j+1);
            map.put(s.charAt(i),i+1);
        }
        return ans;
    }
}
