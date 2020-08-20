import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
class method{
    public int methodId;
    public int methodStack;
    public int[] callMethod;

    public method(int methodId) {
        this.methodId = methodId;
    }
}

public class huawei3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){

            int n = in.nextInt();
            int[] methodCallNum = new int[n];
            HashMap<Integer,method> mapMethod = new HashMap<Integer, method>();
            for(int i=0;i<n;i++){
                methodCallNum[i]=in.nextInt();
                method m = new method(i+1);
                m.callMethod = new int[methodCallNum[i]];
                mapMethod.put(i+1,m);
            }
            in.nextLine();
            for(int i=0;i<n;i++){
                String inS = in.nextLine();
                String [] nums = inS.split(" ");
                if(nums.length==1){
                    System.out.println("NA");
                    return;
                }
                int metodId = Integer.parseInt(nums[0]);
                int metodStack=Integer.parseInt(nums[1]);

                method m = mapMethod.get(metodId);
                m.methodStack=metodStack;
                for(int j=2;j-2<methodCallNum[i];j++){
                    int callMetodId=Integer.parseInt(nums[j]);
                    if(callMetodId==m.methodId) {
                        System.out.println("R");
                        return;
                    }
                    m.callMethod[j-2]=callMetodId;
                }
            }
            int max = -1;
            HashSet<Integer> callM = new HashSet<Integer>();

            for(int methodId: mapMethod.keySet()){
                int sum = 0;
                callM.clear();
                method m = mapMethod.get(methodId);
                callM.add(m.methodId);
                sum+=m.methodStack;
                for(int i=0;i<m.callMethod.length;i++){
                    method call = mapMethod.get(m.callMethod[i]);
                    if(callM.contains(call.methodId)){
                        System.out.println("R");
                        return;
                    }
                    callM.add(call.methodId);
                    sum+=call.methodStack;
                }
                max = Math.max(sum,max);
            }
            System.out.println(max);
        }
    }
}
