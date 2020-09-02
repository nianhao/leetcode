package com.leetcodePro.solve;

import javax.swing.text.html.parser.Entity;
import java.util.*;

class Per implements Comparable{
    public String name;
    public int count;
    Per(String name,int count){
        this.name=name;
        this.count=count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Per per = (Per) o;
        return count == per.count &&
                Objects.equals(name, per.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, count);
    }

    @Override
    public int compareTo(Object q) {
        Per o = (Per) q;
        if(this.count!=o.count){
            return Integer.compare(this.count,o.count);
        }
        return this.name.compareTo(o.name);
    }
}
public class huaWei1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
            while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
                String nameString = in.next();
                try{
                    String[] names = nameString.split(",");
                    HashMap<String ,Integer> count = new HashMap<>();
                    TreeSet<Per> ans = new TreeSet<>();
                    for(String name:names){
                        if(count.containsKey(name)){
                            int tmp = count.get(name);
                            count.put(name,tmp+1);
                        }else{
                            count.put(name,1);
                        }
                    }

                    for(Map.Entry<String,Integer> e : count.entrySet()){
                        Per t = new Per(e.getKey(),e.getValue());
                        ans.add(t);
                    }
                    System.out.println(ans.first().name);

                }catch (Exception e){
                    System.out.println(e);
                    System.out.println("error.0001");
                }
            }
        }

}
