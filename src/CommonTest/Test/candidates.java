package CommonTest.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class candidates {

    int currSum=0;
    List<Integer> currList = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(0,0,candidates,target);
        return result;
    }

    void dfs(int t,int sum,int[] candidates,int target){
        if(sum>=target){
            if(sum==target) {
                int[] a = new int[currList.size()];
                for(int i=0;i<currList.size();i++)
                    a[i] = currList.get(i);
                Arrays.sort(a);  //排序
                for(int i=0;i<result.size();i++){

                    List ca = new ArrayList();
                    for(int s:result.get(i)){
                        ca.add(s);
                    }
                    //System.out.println(ca);
                    List cb = new ArrayList();
                    for(int s:a){
                        cb.add(s);
                    }

                   // System.out.println(cb);
                    if(ca.size() == cb.size() ){
                        boolean flag = true;
                        for(int k=0;k<ca.size();k++){
                            if(!ca.get(k).equals(cb.get(k))){
                                flag = false;
                                break;
                            }
                        }
                        if(flag) return; //如果有相同的，则直接返回
                    }
                }
                List cc = new ArrayList();
                for(int s:a){
                    cc.add(s);
                }
                result.add(cc);
                //result.add(new arrayListCon(Arrays.asList(a)));
            }
            return;
        }

        for(int i=0;i<candidates.length;i++){
            currSum += candidates[i];
            currList.add(candidates[i]);
            dfs(t+1,currSum,candidates,target);
            currSum -= candidates[i];
            currList.remove(currList.size()-1); //移除最后一个元素
        }
    }

    public static void main(String[] args) {
        candidates test = new candidates();
//        [4,2,7,5,6]
//        16
        int a[] = {4,2,7,5,6};
        int t = 16;
        System.out.println(test.combinationSum(a,t));
    }
}
