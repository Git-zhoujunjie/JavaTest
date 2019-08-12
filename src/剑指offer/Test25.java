package 剑指offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
 * 另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 *
 * 思路：在原链表的节点后新增一个节点，处理新增节点的随机指针，然后拆分即可得到新链表
 */
public class Test25 {
    public RandomListNode Clone(RandomListNode pHead){
        if(pHead==null) return null;
        //1、在原链表每个节点后新增一个节点
        RandomListNode p = pHead;
        RandomListNode q = p.next;
        while(p!=null){
            RandomListNode node = new RandomListNode(p.label);
            p.next = node;
            node.next = q;
            p=q;
            q=q.next;
        }
        //2、再次遍历，处理新增节点的random指针
        p = pHead;
        while(p!=null){
            p.next.random = p.random==null?null:p.random.next;
            p = p.next.next;
        }
        //3、分割链表，形成新旧两个链表
        p = pHead;
        q=p.next;
        RandomListNode root = p.next;
        while(p!=null){
            p.next = q.next;
            p = p.next;
            q.next = p.next;
        }

        return root;
    }
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
