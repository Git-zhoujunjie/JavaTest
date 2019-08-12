package CommonTest.Test;

import java.util.*;

public class edit111 {

    public int countChanges(String[] dic, int n, String s, String t) {
        Map<String, List<String>> graph = new HashMap<>();
        Set<String> dicSet = new HashSet<>(Arrays.asList(dic));
        for (String s1 : dic) {
            List<String> adj = getAdj(s1, dicSet);
            graph.put(s1, adj);
        }
        Queue<String> queue = new ArrayDeque<>();
        Map<String, Integer> vistied = new HashMap<>();
        vistied.put(s, 0);
        queue.add(s);
        while (!queue.isEmpty()) {
            String te = queue.poll();
            if (te.equals(t)) return vistied.get(t);
            for (String s1 : graph.get(te)) {
                if (null == vistied.get(s1)) {
                    vistied.put(s1, vistied.get(te) + 1);
                    queue.add(s1);
                }

            }
        }
        return -1;
    }

    private List<String> getAdj(String s1, Set<String> dicSet) {
        List<String> rst = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < s1.length(); j++) {
                StringBuilder builder = new StringBuilder(s1);
                builder.setCharAt(j, (char) ('a' + i));
                if (dicSet.contains(builder.toString()) && !builder.toString().equals(s1)) rst.add(builder.toString());
            }
        }
        return rst;
    }
}


