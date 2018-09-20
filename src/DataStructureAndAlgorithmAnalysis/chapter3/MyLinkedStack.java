package DataStructureAndAlgorithmAnalysis.chapter3;

public class MyLinkedStack<AnyType> {

    private int theSize;
    public Node<AnyType> top;

    private class Node<AnyType> {
        public Node<AnyType> next;

        public AnyType data;

        public Node(AnyType d,Node n){
            data=d;
            next=n;
        }
    }

    public MyLinkedStack(){ clear();}
    private void clear(){
        theSize=0;
        top = new Node<>(null,null);

    }

    public int size(){
        return theSize;
    }
    private void add(AnyType x){
        Node<AnyType> p = new Node<>(x,null);
        p.next=top;
        top=p;
        theSize++;
    }
    public boolean push(AnyType x){
        add(x);
        return true;
    }

    private AnyType remove(){
        AnyType data = top.data;
        top=top.next;
        theSize--;
        return data;
    }
    public AnyType pop(){
        return remove();
    }

    public static void main(String[] args){
        MyLinkedStack ms = new MyLinkedStack();
        ms.push("asdfas");
        ms.push("sfdasd");
        ms.push(123);
        while(ms.size()>0){
            System.out.println(ms.pop());
        }
    }
}
