package DataStructureAndAlgorithmAnalysis.chapter4;


public class AvlTree<AnyType extends Comparable<? super AnyType>> {
    private static class AvlNode<AnyType>{
        private AnyType element;
        private AvlNode<AnyType> lc;
        private AvlNode<AnyType> rc;
        private int height;

        //Constructors
        AvlNode(AnyType theElement){
            this(theElement, null, null);
        }
        AvlNode(AnyType e, AvlNode<AnyType> lc, AvlNode<AnyType> rc){
            element = e;
            this.lc = lc;
            this.rc = rc;
            this.height = 0;
        }
    }
    private int height(AvlNode<AnyType> t){
        return t == null ? -1 : t.height;
    }
    private AvlNode<AnyType> root;
    AvlTree(){
        root = null;
    }

    public void insert(AnyType e){
        root = insert(e, root);
    }
    private AvlNode<AnyType> insert(AnyType e, AvlNode<AnyType> t){
        if(t == null) return new AvlNode<AnyType>(e, null, null);
        int compareResult = e.compareTo(t.element);
        if(compareResult < 0){
            t.lc = insert(e, t.lc);
        }
        else if(compareResult > 0){
            t.rc = insert(e, t.rc);
        }
        else ;

        return balance(t);
    }

    private static final int ALLOWED_IMBALANCE = 1;
    private AvlNode<AnyType> balance(AvlNode<AnyType> t){
        if(t == null) return t;
        if(height(t.lc) - height(t.rc) > ALLOWED_IMBALANCE ) {
            if (height(t.lc.lc) >= height(t.lc.rc))
                t = rotateWithLeftChild(t);
            else
                t = doubleWithLeftChild(t);
        }
        else {
            if(height(t.rc) - height(t.lc) >ALLOWED_IMBALANCE){
                if (height(t.rc.rc) >= height(t.rc.lc))
                    t = rotateWithRightChild(t);
                else
                    t = doubleWithRightChild(t);
            }
        }
        t.height = Math.max(height(t.lc), height(t.rc)) + 1;
        return t;
    }

    private AvlNode<AnyType> rotateWithLeftChild(AvlNode<AnyType> k2){
        AvlNode<AnyType> k1 = k2.lc;
        k2.lc = k2.rc;
        k1.rc = k2;
        k2.height = Math.max(height(k2.lc), height(k2.rc)) +1;
        k1.height = Math.max(height(k1.lc), k2.height) +1;
        return k1;
    }
    private AvlNode<AnyType> doubleWithLeftChild(AvlNode<AnyType> k3){
        k3.lc = rotateWithRightChild(k3.lc);
        return rotateWithLeftChild(k3);
    }
    private AvlNode<AnyType> rotateWithRightChild(AvlNode<AnyType> k2){
        AvlNode<AnyType> k1 = k2.rc;
        k2.rc = k2.lc;
        k1.lc = k2;
        k2.height = Math.max(height(k2.lc), height(k2.rc)) +1;
        k1.height = Math.max(height(k1.rc), k2.height) +1;
        return k1;
    }
    private AvlNode<AnyType> doubleWithRightChild(AvlNode<AnyType> k3){
        k3.rc = rotateWithLeftChild(k3.rc);
        return rotateWithRightChild(k3);
    }
    //printTree
    public void printTree() {
        if(root == null) System.out.print("Empty Tree!");
        else printTree( root );
    }
    private void printTree(AvlNode<AnyType> t){
        if(t!=null){
            printTree(t.lc);
            System.out.print(t.element);
            printTree(t.rc);
        }
    }

    public static void main(String[] args){
        AvlTree<Integer> avlTree = new AvlTree<>();
        for(int i = 1 ; i<=8; i++){
            avlTree.insert(i);
            avlTree.printTree();
            System.out.println();
        }
    }
}
