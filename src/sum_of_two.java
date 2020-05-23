import java.util.HashMap;

public class sum_of_two {
    class Solution {
        int [] two_num(int [] nums,int target){
            HashMap<Integer, Integer> num_indx = new HashMap<Integer, Integer>();
            int [] ans = new int [2];
            for(int i=0;i<nums.length;i++){
                int another = target - nums[i];
                if(num_indx.containsKey(another)){
                    ans[0] = i;
                    ans[1] = num_indx.get(another);
                    return ans;
                }
                num_indx.put(nums[i],i);
            }
            return ans;
        }
    }
}
