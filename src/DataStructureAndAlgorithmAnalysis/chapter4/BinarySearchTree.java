package DataStructureAndAlgorithmAnalysis.chapter4;

import java.util.Random;

public class BinarySearchTree<AnyType extends Comparable<? super AnyType>> {
    private class BinaryNode<AnyType> {
        private AnyType element;
        private BinaryNode<AnyType> lc;
        private BinaryNode<AnyType> rc;

        public BinaryNode(AnyType ele) {
            this(ele, null, null);
        }

        public BinaryNode(AnyType ele, BinaryNode<AnyType> l, BinaryNode<AnyType> r) {
            element = ele;
            lc = l;
            rc = r;
        }
    }

    private BinaryNode<AnyType> root;
    public BinarySearchTree(){
        root = null;
    }
    public void makeEmpty(){
        root = null;
    }
    public boolean isEmpty(){
        return root == null;
    }

    //contains
    public boolean contains(AnyType x){
        return contains(x, root);
    }
    private boolean contains(AnyType x,BinaryNode<AnyType> t){
        if(t == null)
            return false;
        int b = x.compareTo(t.element);
        if(b<0) return contains(x, t.lc);
        else if(b>0) return contains(x, t.rc);
        else return true;
    }

    //findMin
    public AnyType findMin(){
        return findMin(root).element;
    }
    private BinaryNode<AnyType> findMin(BinaryNode<AnyType> t){
        if(t == null ) return null;
        else if(t.lc == null) return t;
        else return findMin(t.lc);
    }
    //findMax
    public AnyType findMax(){
        return findMax(root).element;
    }
    private BinaryNode<AnyType> findMax(BinaryNode<AnyType> t){
        if(t != null)
            while(t.rc != null)
                t = t.rc;
        return t;
    }

    //insert
    public void insert(AnyType x){
        root = insert(x, root);
    }
    private BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> t){
        if(t == null) return new BinaryNode<AnyType>(x,null,null);
        int b = x.compareTo(t.element);
        if(b<0) t.lc = insert(x, t.lc);
        else if(b>0) t.rc = insert(x, t.rc);
        else ;

        return t;
    }
    //remove
    public void remove(AnyType x){
        root = remove(x, root);
    }
    private BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> t){
        if(t == null) return t;
        int b = x.compareTo(t.element);
        if(b<0) t.lc = remove(x, t.lc);
        else if(b>0) t.rc = remove(x, t.rc);
        else {
            if(t.lc!=null && t.rc!=null){
                AnyType rm = findMin(t.rc).element;
                t.element = rm;
                t.rc = remove(rm, t.rc);
            }
            else if(t.lc!=null && t.rc == null) t = t.lc;
            else if(t.rc!=null && t.lc == null) t = t.rc;
            else t = null;
        }
        return t;
    }
    //printTree
    public void printTree() {
        if(isEmpty()) System.out.print("Empty Tree!");
        else printTree( root );
    }
    private void printTree(BinaryNode<AnyType> t){
        if(t!=null){
            printTree(t.lc);
            System.out.println(t.element);
            printTree(t.rc);
        }
    }

    public static void main(String[] args){
        BinarySearchTree<Integer> myTree = new BinarySearchTree<>();
        Random random = new Random(60);
        for(int i = 0;i<15;i++){
            myTree.insert(random.nextInt(20));
        }
        myTree.printTree();
    }
}
