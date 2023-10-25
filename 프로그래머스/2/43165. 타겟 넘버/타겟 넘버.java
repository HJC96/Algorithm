class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        DFS(0,target,numbers, 0);
        return answer;
    }
    public void DFS(int cur_int,int target,int[] n, int idx){
        if(idx == n.length){
            if(cur_int == target){ 
                answer++;
            }
            return;
        }
        DFS(cur_int + n[idx],target,n,idx+1);
        DFS(cur_int - n[idx],target,n,idx+1);
    }
}