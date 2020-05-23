import java.util.ArrayList;
import java.util.Stack;

public class num42_trapping_rain_water {
    public static int trap(int[] height) {

        int len = height.length;
        if (len <= 2) return 0;
        int ans = 0;
        for (int i = 1; i < len - 1; i++) {
            int maxLeft = 0;
            int maxRight = 0;
            for (int j = i - 1; j >= 0; j--) {
                maxLeft = Math.max(maxLeft, height[j]);
            }
            for (int j = i + 1; j < len; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }
            int cur = Math.min(maxLeft, maxRight) - height[i];
            ans += cur > 0 ? cur : 0;
        }
        return ans;
    }

    public static int trap2(int[] height) {

        int len = height.length;
        if (len <= 2) return 0;
        int[] maxLeft = new int[len];
        int[] maxRight = new int[len];
        maxRight[len - 1] = height[len - 1];
        maxLeft[0] = height[0];
        for (int i = 1; i < len; i++)
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
        for (int i = len - 2; i >= 0; i--)
            maxRight[i] = Math.max(maxRight[i + 1], height[i]);
        int ans = 0;
        for (int i = 1; i < len - 1; i++) {
            int cur = Math.min(maxLeft[i], maxRight[i]) - height[i];
            ans += cur;
        }
        return ans;
    }

    public static int trap3(int[] height) {

        int len = height.length;
        if (len <= 2) return 0;

        int ans = 0;
        Stack<Integer> s = new Stack();
        int cur = 0;
        while (cur < len) {
            while (!s.empty() && height[cur] > height[s.peek()]) {
                int top = s.peek();
                s.pop();
                if (s.empty()) break;
                int wid = cur - s.peek() - 1;
                int hei = Math.min(height[cur], height[s.peek()]) - height[top];
                ans += hei * wid;
            }
            s.push(cur++);
        }
        return ans;

    }
}
