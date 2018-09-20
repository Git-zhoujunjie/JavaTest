package DataStructureAndAlgorithmAnalysis.chapter3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<AnyType> implements Iterable<AnyType>{
    private static final int DEFAULT_CAPACITY = 10;

    private int theSize;
    private AnyType[] theItems;

    public void clear(){
        theSize = 0;

    }
    public MyArrayList(){
        clear();
        ensureCapacity(DEFAULT_CAPACITY);
    }
    public int size(){
        return theSize;
    }
    public boolean isEmpty(){
        return size()==0;
    }
    public void trimToSize(){
        ensureCapacity(size());
    }

    public AnyType get(int idx){
        if(idx<0 || idx>size()) throw new ArrayIndexOutOfBoundsException();
        return theItems[idx];
    }
    public AnyType set(int idx, AnyType newVal){
        if(idx<0 || idx>size()) throw new ArrayIndexOutOfBoundsException();
        AnyType old = theItems[idx];
        theItems[idx]=newVal;
        return old;
    }

    public void ensureCapacity(int newCapacity){
        if(newCapacity < theSize) return;

        AnyType[] old = theItems;
        theItems = (AnyType[]) new Object[newCapacity];
        for(int i=0;i<size();i++)
            theItems[i] = old[i];
    }

    public void add(int idx,AnyType x){
        if(theItems.length==size())
            ensureCapacity(size()*2+1);
        for(int i=size()-1;i>=idx;i--)
            theItems[i+1] = theItems[i];
        theItems[idx]=x;

        theSize++;
    }
    public boolean add(AnyType x){
        add(size(),x);
        return true;
    }

    public AnyType remove(int idx){
        AnyType removeItem = theItems[idx];
        for(int i=idx+1;i<size();i++)
            theItems[idx]=theItems[i];

        theSize--;
        return removeItem;
    }

    private class ArrayListIterator implements Iterator<AnyType>{
        private int current = 0;
        public boolean hasNext(){
            return current<size();
        }

        public AnyType next(){
            if(!hasNext()) throw new NoSuchElementException();
            return theItems[current++];
        }
        public void remove(){
            MyArrayList.this.remove(--current);
        }
    }
    public Iterator<AnyType> iterator(){
        return new ArrayListIterator();
    }

    public static void main(String[] args){
        MyArrayList<String> myarr = new MyArrayList<>();
        myarr.add("123");
        myarr.add("sadfa");
        System.out.println(myarr.size());
        System.out.println(myarr.remove(1));
    }
}
