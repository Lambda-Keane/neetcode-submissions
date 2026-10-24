class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        results.add(List.of());
        foo(results, nums);
        return results;
    }
    public void foo(List<List<Integer>> results, int[] nums) {
        for (int num : nums) {
            List<List<Integer>> r =  new ArrayList<>();
            for (var res : results) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(num);
                tmp.addAll(res);
                Collections.sort(tmp);
                r.add(tmp);
            }
            results.addAll(r);
        }
    }
}
