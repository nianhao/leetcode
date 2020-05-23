public class num11 {
    public static int maxArea(int[] height) {
        int n = height.length;
        int ans = 0;

        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++)
            {
                int len = j-i;
                int hei = Math.min(height[i],height[j]);
                ans = Math.max(ans,len*hei);
            }
        }
        return ans;
    }
    public static int maxArea2(int[] height) {
        int n = height.length;
        int ans = 0;
        int l=0,r=n-1;
        while(l<r){
            int hei = Math.min(height[l],height[r]);
            int wid = r-l;
            ans = Math.max(ans,hei*wid);
            if(height[l]>height[r]) r--;
            else l++;
        }
        return ans;
    }
    public static void main(String[] args) {

    }
}
