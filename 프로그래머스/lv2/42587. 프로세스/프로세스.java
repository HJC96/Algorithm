import java.util.*;

public class Solution {
    class Pair{
        public int priority;
        public char name ;
        public Pair(int priority, char name){
            this.priority =  priority;
            this.name =  name;
        }
    }

    public int solution(int[] priorities, int location) {
        int answer = 1;
        Queue<Pair> q = new LinkedList<>();
        List<Integer> priors = new ArrayList<>();
        int idx=0;
        for(int i:priorities){
            priors.add(i);
            Pair P = new Pair(i,(char)('A'+idx++));
            q.add(P);
        }
        Collections.sort(priors, (a, b)->{return b.compareTo(a);});
        int priority_idx = 0;
        while(true){
            if(q.peek().priority == priors.get(priority_idx)){
                if(q.peek().name == (char)('A'+ location)) {
                    break;
                }else {
                    q.poll(); answer++; priority_idx++;
                }
            }else{
                Pair tmp = q.poll();
                q.add(tmp);
            }
        }
        return answer;
    }
}