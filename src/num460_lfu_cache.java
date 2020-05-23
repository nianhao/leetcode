import java.security.KeyException;
import java.util.HashMap;
import java.util.Objects;
import java.util.TreeMap;
import java.util.TreeSet;

class Node implements Comparable<Node>{
    public int key;
    public int value;
    public int lastTime;
    public int fre;
    public Node(int key,int value,int lastTime){
        this.key=key;
        this.value=value;
        this.lastTime = lastTime;
        this.fre=1;
    }

    @Override
    public int compareTo(Node o) {

        if(this.fre!=o.fre){
            //System.out.println(this.key+"++++fre:"+this.fre);
            //System.out.println(o.key+"+++++fre"+o.fre);
            //System.out.println(Integer.compare(o.fre,this.fre));
            return Integer.compare(this.fre,o.fre);
        }
        //System.out.println(this.key+"---"+this.value);
        //System.out.println(o.key+"----"+o.value);
        //System.out.println(-Integer.compare(this.lastTime,o.lastTime));
        return Integer.compare(this.lastTime,o.lastTime);
    }

    public void setValue(int value,int lastTime) {
        this.value=value;
        this.lastTime=lastTime;
        this.fre++;
    }

    public int getValue(int lastTime) {
        this.lastTime=lastTime;
        this.fre++;
        return value;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return key == node.key;

    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }
}
class LFUCache {
    public int capacity;
    public int time;
    public HashMap<Integer,Node> values;
    public TreeSet<Node> keys;
    public LFUCache(int capacity) {
        time=0;
        this.capacity=capacity;
        values = new HashMap<Integer, Node>();
        keys = new TreeSet<Node>();


    }

    public int get(int key) {
        if(capacity==0) return -1;
        if(values.containsKey(key)){
            Node oldN = values.get(key);
            keys.remove(oldN);
            int ans = oldN.getValue(++time);
            keys.add(oldN);
            return ans;
        }

        else return -1;

    }

    public void put(int key, int value) {
        if(capacity==0) return;
        if(values.containsKey(key)){
            Node oldN = values.get(key);
            keys.remove(oldN);
            oldN.setValue(value,++time);
            keys.add(oldN);

        }else{
            if(values.size()==this.capacity) {
                Node n = values.get(keys.first().key);
                values.remove(n.key);
                keys.remove(n);
            }

            Node s = new Node(key,value,++time);
            values.put(key,s);
            keys.add(s);

        }

    }

}
public class num460_lfu_cache {
    public static void main(String[] args) {
        LFUCache cache = new LFUCache(10);
        int a=0;
        cache.put(10,13);  //null***null
        cache.put(3,17);  //null***null
        cache.put(6,11);  //null***null
        cache.put(10,5);  //null***null
        cache.put(9,10);  //null***null
        a=cache.get(13);  //-1***-1
        cache.put(2,19);  //null***null
        a=cache.get(2);  //19***19
        a=cache.get(3);  //17***17
        cache.put(5,25);  //null***null
        a=cache.get(8);  //-1***-1
        cache.put(9,22);  //null***null
        cache.put(5,5);  //null***null
        cache.put(1,30);  //null***null
        a=cache.get(11);  //-1***-1
        cache.put(9,12);  //null***null
        a=cache.get(7);  //-1***-1
        a=cache.get(5);  //5***5
        a=cache.get(8);  //-1***-1
        a=cache.get(9);  //12***12
        cache.put(4,30);  //null***null
        cache.put(9,3);  //null***null
        a=cache.get(9);  //3***3
        a=cache.get(10);  //5***5
        a=cache.get(10);  //5***5
        cache.put(6,14);  //null***null
        cache.put(3,1);  //null***null
        a=cache.get(3);  //1***1
        cache.put(10,11);  //null***null
        a=cache.get(8);  //-1***-1
        cache.put(2,14);  //null***null
        a=cache.get(1);  //30***30
        a=cache.get(5);  //5***5
        a=cache.get(4);  //30***30
        cache.put(11,4);  //null***null
        cache.put(12,24);  //null***null
        cache.put(5,18);  //null***null
        a=cache.get(13);  //-1***-1
        cache.put(7,23);  //null***null
        a=cache.get(8);  //-1***-1
        a=cache.get(12);  //24***24
        cache.put(3,27);  //null***null
        cache.put(2,12);  //null***null
        a=cache.get(5);  //18***18
        cache.put(2,9);  //null***null
        cache.put(13,4);  //null***null
        cache.put(8,18);  //null***null
        cache.put(1,7);  //null***null
        a=cache.get(6);  //14***14
        cache.put(9,29);  //null***null
        cache.put(8,21);  //null***null
        a=cache.get(5);  //18***18
        cache.put(6,30);  //null***null
        cache.put(1,12);  //null***null
        a=cache.get(10);  //11***11
        cache.put(4,15);  //null***null
        cache.put(7,22);  //null***null
        cache.put(11,26);  //null***null
        cache.put(8,17);  //null***null
        cache.put(9,29);  //null***null
        a=cache.get(5);  //18***18
        cache.put(3,4);  //null***null
        cache.put(11,30);  //null***null
        a=cache.get(12);  //24***-1
        cache.put(4,29);  //null***null
        a=cache.get(3);  //4***4
        a=cache.get(9);  //29***29
        a=cache.get(6);  //30***30
        cache.put(3,4);  //null***null
        a=cache.get(1);  //12***12
        a=cache.get(10);  //11***11
        cache.put(3,29);  //null***null
        cache.put(10,28);  //null***null
        cache.put(1,20);  //null***null
        cache.put(11,13);  //null***null
        a=cache.get(3);  //29***29
        cache.put(3,12);  //null***null
        cache.put(3,8);  //null***null
        cache.put(10,9);  //null***null
        cache.put(3,26);  //null***null
        a=cache.get(8);  //-1***17
        a=cache.get(7);  //-1***-1
        a=cache.get(5);  //18***18
        cache.put(13,17);  //null***null
        cache.put(2,27);  //null***null
        cache.put(11,15);  //null***null
        a=cache.get(12);  //24***-1
        cache.put(9,19);  //null***null
        cache.put(2,15);  //null***null
        cache.put(3,16);  //null***null
        a=cache.get(1);  //20***20
        cache.put(12,17);  //null***null
        cache.put(9,1);  //null***null
        cache.put(6,19);  //null***null
        a=cache.get(4);  //29***29
        a=cache.get(5);  //18***18
        a=cache.get(5);  //18***18
        cache.put(8,1);  //null***null
        cache.put(11,7);  //null***null
        cache.put(5,2);  //null***null
        cache.put(9,28);  //null***null
        a=cache.get(1);  //20***20
        cache.put(2,2);  //null***null
        cache.put(7,4);  //null***null
        cache.put(4,22);  //null***null
        cache.put(7,24);  //null***null
        cache.put(9,26);  //null***null
        cache.put(13,28);  //null***null
        cache.put(11,26);  //null***null

    }

}

