package DataStructureAndAlgorithmAnalysis.chapter3;

public class MyLinkedQueue<AnyType> {
    private int theSize;
    private Node<AnyType> beginMaker;
    private Node<AnyType> endMaker;

    private class Node<AnyType> {
        private AnyType data;
        private Node<AnyType> prep;
        private Node<AnyType> next;

        public Node(AnyType d,Node<AnyType> p,Node<AnyType> n){
            data=d;
            prep=p;
            next=n;
        }
    }

    public MyLinkedQueue(){ clear();}
    private void clear(){
        beginMaker = new Node<>(null,null,null);
        endMaker = new Node<>(null,beginMaker,null);
        beginMaker.next = endMaker;

        theSize=0;
    }

    public int size(){return theSize;}

    public void enqueue(AnyType x) {
        Node<AnyType> p = new Node<>(x, beginMaker, beginMaker.next);
        beginMaker.next.prep = p;
        beginMaker.next = p;

        theSize++;
    }

    public AnyType dequeue() {
        //if(size()<=0) throw new IndexOutOfBoundsException();
        AnyType data = endMaker.prep.data;
        endMaker.prep = endMaker.prep.prep;
        endMaker.prep.next = endMaker;

        theSize--;
        return data;
    }

    public static void main(String[] args){
        MyLinkedQueue<String> mq = new MyLinkedQueue();
        mq.enqueue("sfdas");
        mq.enqueue("qrwer");
        mq.enqueue("12352");
        while(mq.size()>0)
            System.out.println(mq.dequeue());
    }
}
