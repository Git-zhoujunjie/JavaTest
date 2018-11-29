package LearningAlgorithmInterestingly.chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class meeting implements Comparable<meeting>{
    private static int num=1;
    public final int id = num++;
    int begin;
    int end;

    public meeting(int b,int e){
        this.begin = b;
        this.end = e;
    }

    @Override
    public int compareTo(meeting o) {
        if(this.end > o.end) return 1;
        else if(this.end < o.end) return -1;
        else if(this.begin < o.begin) return 1;
        else return -1;
    }
}
public class 会议安排问题 {
    static List<meeting> createObject(int n) throws IOException {
        List<meeting> meetingsArray = new ArrayList<>();
        System.out.println("请输入每个会议的起始时间和结束时间，用空格隔开：");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < n; i++) {
            String[] strings = bufferedReader.readLine().split(" ");
            meetingsArray.add(new meeting(Integer.parseInt(strings[0]), Integer.parseInt(strings[1])));
        }
        bufferedReader.close();
        Collections.sort(meetingsArray);//按照end排序
        System.out.println("会议按照end递增排序为：");
        for(int i=0;i<meetingsArray.size();i++){
            System.out.println(meetingsArray.get(i).id + " "+ meetingsArray.get(i).begin + " " + meetingsArray.get(i).end);
        }
        return meetingsArray;
    }

    public static void main(String[] args) throws IOException {
        System.out.println("请输入会议数量：");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bufferedReader.readLine());
        List<meeting> meetingList = createObject(count);

        int last = 0;

        for (int i = 0; i < meetingList.size(); i++) {
            if (meetingList.get(i).begin >= last) {
                last = meetingList.get(i).end;
                System.out.println("选取会议的起始时间和结束时间分别为：" + meetingList.get(i).begin + " " + meetingList.get(i).end);
            }
        }
    }
}
