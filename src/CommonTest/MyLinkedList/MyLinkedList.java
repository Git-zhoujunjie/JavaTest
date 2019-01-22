package CommonTest.MyLinkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试LinkedList
 * 1.添加add(T e)方法，重写toString（）
 * 2.添加get(int i)方法，添加remove()
 * 3.添加add(int i,T e)方法
 * @param <T>
 */

class Node<T>{
    public Node<T> previous;
    public Node<T> next;
    public T element;

    public Node(T element) {
        this.element = element;
    }
}

public class MyLinkedList<T> {
//    LinkedList linkedList = new LinkedList();
    public Node<T> first;
    public Node<T> last;
    public int size = 0;

    Map m = new HashMap();
    public void add(T e){
        Node node = new Node(e);
        if(first == null){
            first = node;
            last = node;
        }else{
            node.previous = last;
            last.next = node;
            last = node;
        }
        size++;
    }
    public void add(int index,T e){
        Node temp = getNode(index);
        Node node = new Node(e);
        if(temp == first){
            node.next = temp;
            temp.previous = node;
        }else {
            node.next = temp;
            node.previous = temp.previous;
            temp.previous.next = node;
            temp.previous = node;
        }
    }
    public T get(int index){

        return getNode(index).element;
    }
    public void remove(int index){
        Node<T> temp = getNode(index);
        if(index == 0){
            first = temp.next;
            temp.next.previous = null;
            temp.next = null;

        }else {
            temp.previous.next = temp.next;
            temp.next.previous = temp.previous;
        }
        size--;
    }

    private Node<T> getNode(int index){
        checkIndex(index);
        Node<T> temp ;
        if(index <= (size<<1)) {  //size<<1 相当于size/2
            temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        }else{
            temp = last;
            for(int i=size-1;i>size-index-1;i--){
                temp = temp.previous;
            }
        }
        return temp;
    }
    private void checkIndex(int index){
        if(index<0 || index>=size){
            throw new RuntimeException("索引异常！"+index );
        }
    }
    public String toString(){
        Node temp = first;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while(temp != null){
            sb.append(temp.element + ",");
            temp = temp.next;
        }
        sb.setCharAt(sb.lastIndexOf(","),']');

        return sb.toString();
    }

    public static void main(String[] args){
        MyLinkedList<String> test = new MyLinkedList<>();
        test.add("aa");
        test.add("bb");
        test.add("cc");
        test.add("dd");
        test.add("ee");
        System.out.println(test);
        System.out.println(test.get(3));
        test.remove(0);
        System.out.println(test);
        test.add(2,"老周");
        System.out.println(test);
    }
}
