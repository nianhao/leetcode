public class num4_1 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double ans=0.0;
        int nums1_len = nums1.length;
        int nums2_len = nums2.length;
        if(nums1_len==0){
            int [] nums = nums2;
            int lenN = nums2_len;
            if(lenN%2==0){
                ans = (nums[lenN/2]+nums2[lenN/2-1])/2.0;
            }else{
                ans = nums[lenN/2]+0.0;
            }
            return ans;
        }else if (nums2_len==0){
            int [] nums = nums1;
            int lenN = nums1_len;
            if(lenN%2==0){
                ans = (nums[lenN/2]+nums[lenN/2-1])/2.0;
            }else{
                ans = nums[lenN/2]+0.0;
            }
            return ans;
        }
        int [] nums = new int[nums1_len+nums2_len];
        int cur_num1=0,cur_num2=0,cur=0;
        while (true){
            int n1=-1,n2=-1;
            if(cur_num1<nums1_len){
                n1 = nums1[cur_num1];
            }
            if(cur_num2<nums2_len){
                n2 = nums2[cur_num2];
            }
            if(cur_num1<nums1_len&&cur_num2<nums2_len){
                if(n1<=n2){
                    nums[cur++]=nums1[cur_num1++];
                }else{
                    nums[cur++]=nums2[cur_num2++];
                }
                if(cur<(nums1_len+nums2_len)){
                    continue;
                }else{
                    break;
                }
            }
            if(cur_num1<nums1_len){
                nums[cur++]=nums1[cur_num1++];

            }
            if(cur_num2<nums2_len){
                nums[cur++]=nums2[cur_num2++];
            }
            if(cur<(nums1_len+nums2_len)){
                continue;
            }else{
                break;
            }
        }
        int lenN=nums1_len+nums2_len;

        if(lenN%2==0){
            ans = (nums[lenN/2]+nums[lenN/2-1])/2.0;
        }else{
            ans = nums[lenN/2]+0.0;
        }
        return ans;
    }
}
