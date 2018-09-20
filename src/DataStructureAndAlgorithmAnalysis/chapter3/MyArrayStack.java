package DataStructureAndAlgorithmAnalysis.chapter3;

public class MyArrayStack<AnyType> {
    private static final int DEFAULT_CAPACITY = 10;

    private int theSize;
    private AnyType[] theItems;
    private int topOfStack;

    public void clear(){
        theSize = 0;
        topOfStack=-1;
    }
    public MyArrayStack(){
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

    public void push(AnyType x){
        add(++topOfStack,x);
    }

    public AnyType remove(int idx){
        AnyType removeItem = theItems[idx];
        for(int i=idx+1;i<size();i++)
            theItems[idx]=theItems[i];

        theSize--;
        return removeItem;
    }
    public AnyType pop(){
        return remove(topOfStack--);
    }

    public static void main(String[] args){
        MyArrayStack ms = new MyArrayStack();
        ms.push("asdfas");
        ms.push("sfdasd");
        ms.push(123);
        while(ms.size()>0){
            System.out.println(ms.pop());
        }
    }

}
