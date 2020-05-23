import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
class zigC implements Comparable<zigC>{
    public zigC(char c, int row, int col) {
        this.c = c;
        this.row = row;
        this.col = col;
    }

    char c;
    int row;
    int col;

    @Override
    public int compareTo(zigC o) {
        if(this.row!=o.row){
            return Integer.compare(this.row,o.row);

        }else{
            return Integer.compare(this.col,o.col);
        }
    }
}
public class num6_zigzag_conversion {

    public static String convert(String s, int numRows) {
        int len = s.length();
        ArrayList<zigC> zs = new ArrayList<zigC>();
        int row=0;
        int col=0;
        int dir=1;
        for(int i=0;i<len;i++){
            if((row==numRows)){
                dir=-dir;
                row-=2;

            }
            if(row==-1){
                dir=-dir;
                row+=2;
            }
            if(dir==1){
                zigC tmp = new zigC(s.charAt(i),row++, col);
                zs.add(tmp);
            }else{
                zigC tmp = new zigC(s.charAt(i),row--,col++);
                zs.add(tmp);
            }
        }
        StringBuilder res = new StringBuilder(len);
        Collections.sort(zs);
        for (zigC z:zs) {
            //System.out.print(z.c);
            res.append(z);
        }
        return res.toString();

    }
    public static String solve(String s, int numRows){
        int len = s.length();
        if(numRows>len||numRows==1) return s;
        ArrayList<StringBuilder> z = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            z.add(new StringBuilder());
        }
        int dir=-1;
        int row=0;
        for(int i=0;i<len;i++){
            if(row==0||row==numRows-1) dir=-dir;
            z.get(row).append(s.charAt(i));

            row+=dir;
        }
        StringBuilder res = new StringBuilder(len);
        for(StringBuilder ss:z){
            res.append(ss);
        }
        return res.toString();
    }
    public static void main(String[] args) {
        String s = "ab";
        int numRows=1;
        System.out.println(solve(s,numRows));

    }
}
