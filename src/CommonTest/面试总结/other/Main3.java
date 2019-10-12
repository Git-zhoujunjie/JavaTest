package CommonTest.面试总结.other;

import org.junit.Test;

import java.util.*;

public class Main3 {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while(in.hasNext()) {
//            long n = in.nextLong();
//            long k = in.nextLong();
//            int yu = 1000000007;
//
//            long s1 = n-1;
//            long s2 = n-2;
//
//            double result = s1*Math.pow(s2,k-2);
//            System.out.println(((long)result)%yu);
//        }


        Stack<Integer> stack = new Stack<>();
        stack.push((int)'c');
        int n = 5;
        int[] a = {3,1,2,5,4};
        int j=0;
        for(int i=1;i<=5;i++){
            stack.push(i);
            while(!stack.isEmpty() && stack.peek()==a[j]){
                stack.pop();
                j++;
            }
        }
        if(stack.isEmpty()) System.out.println(true);
        else System.out.println(false);
    }

    public int calculate(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();
        boolean calflag = false; //表示当前是否进行计算
        char[] c = s.toCharArray();
        int num = 0;
        final int state_start = 0;
        final int state_num = 1;
        final int state_op = 2;
        int state = state_start;
        for(int i=0;i<c.length;i++){
            if(c[i]==' ') continue;
            //有穷状态自动机
            switch (state){
                case state_start:
                    if(c[i]>='0' && c[i]<='9') state = state_num;
                    else state = state_op;
                    i--;
                    break;
                case state_num:
                    if(c[i]>='0' && c[i]<='9'){
                        num = num*10 + c[i]-'0';
                    }else{
                        nums.push(num);
                        if(calflag)
                            update(nums,ops);
                        i--;
                        num=0;
                        state=state_op;
                    }
                    break;
                case state_op:
                    if(c[i] == '+' || c[i] == '-'){
                        calflag=true;
                        ops.push(c[i]);
                    }
                    if(c[i] == '('){
                        calflag = false;
                        //state = state_num;
                    }
                    if(c[i] == ')') update(nums,ops);
                    if(c[i]>='0' && c[i]<='9') {
                        state = state_num;
                        i--;
                    }
                    break;
            }
        }
        if(num!=0) {
            nums.push(num);
            update(nums,ops);
        }
        if(num == 0 && nums.isEmpty()) return 0;
        return nums.pop();
    }

    public void update(Stack<Integer> nums,Stack<Character> ops){
        if(nums.size()<=1) return;
        int num1 = nums.pop();
        int num2 = nums.pop();
        char op = ops.pop();
        if(op == '+') nums.push(num2+num1);
        if(op == '-') nums.push(num2-num1);
    }

    @Test
    public void testCal(){
        String s = "2-4-(8+2-6+(8+4-(1)+8-10))";
        System.out.println(calculate(s));
    }

    PriorityQueue<Integer> qmax = new PriorityQueue<>((n1,n2) -> n2-n1);
    PriorityQueue<Integer> qmin = new PriorityQueue<>();
    @Test
    public void testQ(){
        addNum(6);
        addNum(10);
        addNum(2);
    }

    public void addNum(int num) {

        //优先向小根堆添加元素
        if(qmax.size()==qmin.size()){
            if(qmax.isEmpty() && qmin.isEmpty()) qmin.offer(num);
            else if(num>=qmin.peek()) qmin.offer(num);
            else qmax.offer(num);
        }
        if(qmax.size()-qmin.size()==1){
            if(num>=qmax.peek()) qmin.offer(num);
            else{
                qmin.offer(qmax.poll());
                qmax.offer(num);
            }
        }
        if(qmin.size()-qmax.size()==1){
            if(num<=qmin.peek()) qmax.offer(num);
            else{
                qmax.offer(qmin.poll());
                qmin.offer(num);
            }
        }
    }
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null) return null;
        if(m==n) return head;
        ListNode first = new ListNode(0);
        first.next = head;
        ListNode pre = first;
        ListNode pro = first;
        while(m-- > 1) pre = pre.next;
        while(n-- > -1)
            pro = pro.next;
        ListNode p = pre.next;
        pre.next = pro;
        while(p!=pro){
            ListNode q = p.next;
            p.next = pre.next;
            pre.next = p;
            p = q;
        }
        return first.next;
    }
    @Test
    public void testNode(){
        ListNode head = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3= new ListNode(3);
        ListNode head4 = new ListNode(4);
        ListNode head5 = new ListNode(5);

        head.next=head2;
        head2.next=head3;
        head3.next=head4;
        head4.next=head5;
        head5.next=null;

        ListNode node = reverseBetween(head,2,4);
        while(node!=null){
            System.out.println(node.val);
            node = node.next;
        }
        List list = new ArrayList();
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        //res.add(cur);
        Arrays.sort(nums);
        generate(0,nums,cur,res);
        return res;
        // 位运算法
//        int setNum = 1 << nums.length; //表示子集的个数
//
//        for(int i=0;i<setNum;i++){
//            List<Integer> cur = new ArrayList<>();
//            //每一个i表示一组特定的子集
//            for(int j=0;j<nums.length;j++){
//                if((i & (1<<j)) != 0){
//                    cur.add(nums[j]);
//                }
//            }
//            res.add(cur);
//        }
//        return res;
    }

    public void generate(int t,int[] nums,List<Integer> cur,List<List<Integer>> res){ //t表示层数
//        if(t>=nums.length){
//            return;
//        }
//        cur.add(nums[t]);
//        res.add(new ArrayList(cur));
//        generate(t+1,nums,cur,res);
//        cur.remove(cur.size()-1);
//        generate(t+1,nums,cur,res);
        res.add(new ArrayList(cur));
        for (int i = t; i < nums.length; i++) {
            //和上个数字相等就跳过
            if (i > t && nums[i] == nums[i - 1]) {
                continue;
            }
            cur.add(nums[i]);

            generate(t+1,nums,cur,res);
            cur.remove(cur.size() - 1);
        }

    }

    @Test
    public void testG(){
        int[] nums = {1,1,3};
        List<List<Integer>> res = subsets(nums);
        System.out.println(res);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //回溯法
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        dfs(0,candidates,target,0,new ArrayList<>(),res);
        return res;
    }

    void dfs(int t,int[] nums,int target,int pre,List<Integer> cur,List<List<Integer>> res){
        if(pre==target) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for(int i=t;i<nums.length && pre<target;i++){
            if(i>t && nums[i] == nums[i-1]) continue;
            cur.add(nums[i]);
            pre+=nums[i];
            dfs(i+1,nums,target,pre,cur,res);
            pre-=nums[i];
            cur.remove(cur.size()-1);
        }

    }

    @Test
    public void testcom(){
        int[] a = {10,1,2,7,6,1,5};
        System.out.println(combinationSum2(a,8));
    }

    @Test
    public void testIterator(){
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<10;i++) list.add(i);
        for(Iterator<Integer> it = list.iterator();it.hasNext();){
            int temp = it.next();
            System.out.print(temp);
            if(temp%2==0)
                it.remove();
        }
        System.out.println();
        System.out.println(list);

//        List<String> aList = new ArrayList<String>();
//        for (int i = 0; i < 5; i++) {
//            aList.add("a" + i);
//        }
//        System.out.println(aList);
//        for (Iterator<String> iter = aList.iterator(); iter.hasNext();) {
//            String temp = iter.next();
//            System.out.print(temp + "\t");
//            if (temp.endsWith("3")) {// 删除3结尾的字符串
//                iter.remove();
//            }
//        }
//        System.out.println();
//        System.out.println(aList);
    }
}
