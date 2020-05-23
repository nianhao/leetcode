import java.util.Scanner;

public class huawei2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String s = in.nextLine();
            String[] cmdS = s.split(" ");
            String cmd = cmdS[0];
            String[] splitS = cmdS[1].split("],");
            boolean flag = true;
            for (int i = 0; i < splitS.length; i++) {
                String cmdT = splitS[i].substring(0,splitS[i].indexOf('['));
                if(!cmdT.equals(cmd)) continue;
                String params;
                int a;
                if((a=splitS[i].indexOf(']'))>0)
                 params= splitS[i].substring(splitS[i].indexOf('[')+1,a);
                else
                    params= splitS[i].substring(splitS[i].indexOf('[')+1);
                try {
                    String[] key_value = params.split(",");
                    String addr[] = key_value[0].split("=");
                    String mask[] = key_value[1].split("=");
                    String val[] = key_value[2].split("=");
                    if(addr[0].equals("addr")&&mask[0].equals("mask")&&val[0].equals("val")){
                        System.out.println(addr[1]+" "+mask[1]+" "+val[1]);
                        flag=false;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    continue;
                }
            }
            if(flag) System.out.println("FAIL");
        }
    }
}
//read read[addr=0x17,mask=0xff,val=0x7],read_his[addr=0xff,mask=0xff,val=0x1],read[addr=0xf0,mask=0xff,val=0x80]
