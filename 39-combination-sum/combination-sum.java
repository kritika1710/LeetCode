class Solution {
    List<List<Integer>> ans= new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        solve(arr,0,0,target,new Stack<Integer>());
        return ans;
    }
    public void solve(int[] arr, int ind,int sum,int target,Stack<Integer> st)
    {
        if(sum>target || ind>=arr.length) return;
        if(sum==target)
        {
            ans.add(new ArrayList<>(st));
            return;
        }
        st.push(arr[ind]);
        solve(arr,ind,sum+arr[ind], target,st);
        st.pop();
        solve(arr,ind+1,sum,target,st);
    }
}