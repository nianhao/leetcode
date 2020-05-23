import java.util.LinkedList;
import java.util.Queue;

public class ji_qi_ren_de_yun_dong_fan_wei_lcof {


    public static int movingCount(int m, int n, int k) {
        int[] dx=new int[] {-1,1,0,0};
        int[] dy = new int[]{0,0,-1,1};
        boolean[][] vis = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        vis[0][0]=true;
        int ans = 1;
        while (!q.isEmpty()){
            int[] nowN = q.poll();
            for(int i=0;i<4;i++){

                int nextX = nowN[0]+dx[i];
                int nextY = nowN[1]+dy[i];
                //boolean flag = canMove(nextX,nextY,k);
                if(nextX>=0&&nextX<m &&nextY>=0&&nextY<n&&!vis[nextX][nextY]&&canMove(nextX,nextY,k)){
                    ans++;
                    vis[nextX][nextY]=true;
                    q.offer(new int[]{nextX,nextY});
                }


            }
        }
        return ans;

    }

    private static boolean canMove(int nextX, int nextY,int k) {
        int sum=0;
        while (nextX>0){
            sum+=nextX%10;
            nextX/=10;
        }
        while (nextY>0){
            sum+=nextY%10;
            nextY/=10;
        }
        return sum<=k ? true:false;

    }
    public static int movingCount2(int m, int n, int k){
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(canMove(i,j,k)) ans++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(movingCount(2,3,1));
    }
}
