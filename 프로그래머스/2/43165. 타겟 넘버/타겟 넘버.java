class Solution {
    int[] nums;
    int T;
    int ans=0;
    public int solution(int[] numbers, int target) {
        nums = numbers;
        T = target;
        dfs(0, 0);
        return ans;
    }
    
    void dfs(int idx, int sum){
        if(sum == T && nums.length == idx){
            ans++;
            return;
        }
        
        if(idx == nums.length){
            return;
        }
        
        dfs(idx+1, sum+nums[idx]);
        dfs(idx+1, sum-nums[idx]);
    }
    
}