package CommonTest.MyHashMap;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @param <K>
 * @param <V>
 */
class Node<K,V>{
    public int hash;
    public K key;
    public V value;
    Node<K,V> next;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

public class MyHashMap<K,V> {

    Map<K,V> m = new TreeMap<>();
    private static final int LENGTH = 16;
    private Node<K,V>[] table = new Node[LENGTH]; //核心数组
    private int size;

    public int size(){
        return size;
    }
    public void put(K key,V value){
        //table要先判断是否需要扩容
        if(size==table.length){
            Node[] newTable = new Node[table.length << 1]; //新长度需要是2的整数幂
            System.arraycopy(table,0,newTable,0,table.length);
            table = newTable;
        }
        Node<K,V> node = new Node(key,value);
        int hash = hash(node.key);
        node.hash = hash;
        boolean flag = false;

        if(table[hash] == null) {
            table[hash] = node;
            size++;
        }else{
            Node temp = table[hash];
            Node pre = temp;
            while(temp!=null){
                if(!temp.key.equals(node.key)) {
                    pre = temp;
                    temp = temp.next;
                    flag = false;
                }else{
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                pre.next = node;
                size++;
            }else temp.value = node.value;
        }

    }
    public Object get(K k){
        int hash = hash(k);
        Node temp = table[hash];
        while(temp!=null){
            if(temp.key.equals(k)){
                return temp.value;
            }
            temp = temp.next;
        }
        return null;
    }
    public void remove(K k){
        int hash = hash(k);
        Node temp = table[hash];
        if(temp == null){
            return;
        }else if(temp.key.equals(k)){
            table[hash] = temp.next;

            size--;
            return;
        }else {
            Node pre = temp;
            while (temp != null) {
                if (temp.key.equals(k)) {
                    pre.next = temp.next;
                    temp.next = null;
                    size--;
                    return;
                } else {
                    pre = temp;
                    temp = temp.next;
                }
            }
        }
    }
    private int hash(K key){
        int hashcode = key.hashCode();
        /*
        hashcode&(LENGTH-1) 等同于 hashcode%table.length
        但位运算效率比取余运算高，不过数组长度必须为2的整数幂！
         */
        return hashcode&(table.length-1);

    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i=0;i<table.length;i++){
            Node temp = table[i];
            while(temp!=null){
                sb.append(temp.key+":"+temp.value+",");
                temp = temp.next;
            }
        }
        sb.setCharAt(sb.lastIndexOf(","),']');
        return sb.toString();
    }

    public static void main(String[] args){
        MyHashMap<Integer,String> test = new MyHashMap<>();
        for(int i=1;i<=17;i++){
            test.put(i,"test"+i);
        }

        System.out.println(test);
        test.put(2,"twotwo");
        System.out.println(test.size());
        System.out.println(test.table.length);
        System.out.println(test.get(17));
        test.remove(3);
        System.out.println(test);
        System.out.println(test.size());

        HashMap map=new HashMap();
        Hashtable table =new Hashtable();
    }
}
