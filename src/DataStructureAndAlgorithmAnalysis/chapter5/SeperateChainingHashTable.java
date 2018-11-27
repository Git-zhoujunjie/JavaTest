package DataStructureAndAlgorithmAnalysis.chapter5;

import java.util.LinkedList;
import java.util.List;

public class SeperateChainingHashTable<AnyType> {
    public SeperateChainingHashTable(){
        this(DEFAULT_TABLE_SIZE);
    }
    public SeperateChainingHashTable(int size){
        theLists = new LinkedList[nextPrime(size)];
        for(int i = 0;i<theLists.length;i++)
            theLists[i] = new LinkedList<>();
    }

    public void insert(AnyType x){
        List<AnyType> whichList = theLists[myHash(x)];
        if(!whichList.contains(x)){
            whichList.add(x);
            if(++currentSize>theLists.length)
                rehash();
        }
    }
    public void remove(AnyType x){
        List<AnyType> whichList = theLists[myHash(x)];
        if(whichList.contains(x)){
            whichList.remove(x);
            currentSize--;
        }
    }
    public boolean contains(AnyType x){
        List<AnyType> whichList = theLists[myHash(x)];
        return whichList.contains(x);
    }
    public void makeEmpty(){
        for(int i= 0;i<theLists.length;i++)
            theLists[i].clear();
        currentSize = 0;
    }

    private static final int DEFAULT_TABLE_SIZE = 101;

    private List<AnyType>[] theLists;
    private int currentSize;

    private void rehash(){

    }
    private int myHash(AnyType x){
        int hashVal = x.hashCode();
        hashVal %= theLists.length;
        if(hashVal<0)
            hashVal += theLists.length;
        return hashVal;
    }

    private static int nextPrime(int n){ //求大于n的下一个素数
        while(true){
            if(isPrime(n)) break;
            n++;
        }
        return n;
    }
    private static boolean isPrime(int n){
        int k = (int)(Math.sqrt(n)+0.5);
        for(int i = 2;i<=k;i++){
            if(n%k == 0)
                return false;
        }
        return true;
    }
}
