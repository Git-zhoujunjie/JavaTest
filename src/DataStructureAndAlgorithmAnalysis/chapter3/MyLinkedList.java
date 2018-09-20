package DataStructureAndAlgorithmAnalysis.chapter3;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<AnyType> implements Iterable<AnyType> {
    private int theSize ;
    private int modCount = 0;
    private Node<AnyType> beginMaker;
    private Node<AnyType> endMaker;
    private static class Node<AnyType>{
        public AnyType data;
        public Node prev;
        public Node next;

        public Node(AnyType a, Node<AnyType> p, Node<AnyType> n){
            data = a;
            prev = p;
            next = n;
        }
    }

    public MyLinkedList() {clear();}

    public void clear(){ doClear();}

    public void doClear(){
        beginMaker = new Node<AnyType>(null,null,null);
        endMaker = new Node<AnyType>(null,beginMaker,null);
        beginMaker.next = endMaker;

        theSize = 0;
        modCount++;
    }

    public int size(){
        return theSize;
    }
    public boolean isEmpty(){
        return size()==0;
    }

    private void addBefore(Node<AnyType> p, AnyType x){
        Node<AnyType> newNode = new Node<AnyType>(x,p.prev,p);
        newNode.prev.next=newNode;
        p.prev = newNode;
        theSize++;
        modCount++;
    }
    private Node<AnyType> getNode(int idx){
        Node<AnyType> p;
        if(idx<0 || idx>size()) throw new IndexOutOfBoundsException();
        if(idx<size()/2){
            p = beginMaker.next;
            for(int i=0;i<idx;i++)
                p = p.next;
        }
        else{
            p = endMaker;
            for(int j = size();j>idx;j--)
                p = p.prev;
        }
        return p;
    }
    public boolean add(AnyType x){
        add(size(),x);
        return true;
    }
    public void add(int idx,AnyType x){
        addBefore(getNode(idx),x);
    }

    public AnyType get(int idx){
        return getNode(idx).data;
    }
    public AnyType set(int idx, AnyType newItem){
        Node<AnyType> p = getNode(idx);
        AnyType old = p.data;
        p.data = newItem;
        return old;
    }

    private AnyType remove(Node<AnyType> p){
        p.next.prev = p.prev;
        p.prev.next = p.next;
        theSize--;
        modCount++;

        return p.data;
    }
    public AnyType remove(int idx){
        return remove(getNode(idx));
    }

    private class LinkedListIterator implements Iterator<AnyType> {
        private Node<AnyType> current = beginMaker.next;
        private int exceptedModCount = modCount;
        private boolean okToRemove = false;

        public boolean hasNext(){
            return current != endMaker;
        }

        public AnyType next(){
            if(exceptedModCount != modCount) throw new ConcurrentModificationException();
            if(!hasNext()) throw new NoSuchElementException();

            AnyType nextItem = current.data;
            current = current.next;
            okToRemove = true;

            return nextItem;
        }

        public void remove(){
            if(exceptedModCount != modCount) throw new ConcurrentModificationException();
            if(!okToRemove) throw new IllegalStateException();

            MyLinkedList.this.remove(current.prev);
            okToRemove = false;
            exceptedModCount++;
        }
    }
    public Iterator<AnyType> iterator(){
        return new LinkedListIterator();
    }

    public static void main(String[] args){
        MyLinkedList<String> myl = new MyLinkedList<String>();
        myl.add("qfdsafda");
        myl.add("wergfwe");
        myl.add("asdfas");
        System.out.println(myl.size());
        for(String s : myl)
            System.out.print(s +", ");
        System.out.println("\n"+myl.get(2));
    }
}
