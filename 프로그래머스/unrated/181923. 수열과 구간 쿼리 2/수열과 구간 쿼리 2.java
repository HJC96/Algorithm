class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        int idx=0;
        for(int[] tmp:queries){
            int s = tmp[0];
            int e = tmp[1];
            int k = tmp[2];
            int tmp_ = 9999999;
            for(int i=s;i<=e;i++){
                if(k < arr[i] && arr[i] <tmp_){
                    tmp_ = arr[i];
                }
            }
            if(tmp_ == 9999999)
                answer[idx++] = -1;
            else               
                answer[idx++] = tmp_;
        }
        return answer;
    }
}