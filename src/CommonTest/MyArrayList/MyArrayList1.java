package CommonTest.MyArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 实现一个简单的ArrayList
 * 1.set和get方法
 * 2.add和remove方法
 * 3.checkIndex方法
 */
public class MyArrayList1<E> {
    private static final int DEFULT_CAPACITY = 10;
    private int size;
    private Object[] elementArray;

    public MyArrayList1(){
        elementArray = new Object[DEFULT_CAPACITY];

        //this.size = DEFUL_CAPACITY;
    }

    public MyArrayList1(int size){
        elementArray = new Object[size];
        //this.size = size;
    }

    public void set(int index,E element){
        checkIndex(index);
        elementArray[index] = element;
    }
    public E get(int i){
        checkIndex(i);
        return (E)elementArray[i];
    }

    public void add(int index,E element){
        if(size<DEFULT_CAPACITY){
            //System.arraycopy(elementArray,);
        }
    }
    public void add(E element){
        //在最后进行添加，若长度超出，需要进行数组扩容
        if(size == DEFULT_CAPACITY){
            Object[] newArray = new Object[size + (size << 1)];
            System.arraycopy(elementArray,0,newArray,0,size);
            elementArray = newArray;
        }
        elementArray[size++] = element;
    }
    public void remove(int index){
        System.arraycopy(elementArray,index+1,elementArray,index,size-index-1);
    }

    public void checkIndex(int index){
        if(index<0 || index >size){
            throw new ArrayIndexOutOfBoundsException("索引不规范"+size);
        }
    }
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("[");
        for(int i=0;i<size;i++){
            str.append(elementArray[i] + ",");
        }
        str.setCharAt(str.lastIndexOf(","),']');

        return str.toString();
    }

    public static void main(String[] args){
        MyArrayList1<String> test = new MyArrayList1<>();
//        test.add("11");
//        test.add("22");
//        test.add("33");
        for(int i=0;i<20;i++){
            test.add("test"+i);
        }
        System.out.println(test);

        test.set(15,"dddd");
        System.out.println(test);
        System.out.println(test.get(14));
    }
}
