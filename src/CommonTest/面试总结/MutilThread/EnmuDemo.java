package CommonTest.面试总结;

import lombok.Getter;

public enum EnmuDemo {
    One(1,"齐"),TWO(2,"楚"),Three(3,"燕"),FOUR(4,"韩"),FIVE(5,"赵"),SIX(6,"魏");

    @Getter private Integer key;
    @Getter private String value;

    EnmuDemo(Integer key,String value){
        this.key = key;
        this.value = value;
    }

    public static EnmuDemo getEnmu(Integer i){
        EnmuDemo[] enmuDemos = EnmuDemo.values();
        for(EnmuDemo ele : enmuDemos){
            if(ele.getKey()==i ) return ele;
        }
        return null;
    }
}
