public class SimplePrefixSumArray implements PrefixSumArray {

    private final int[] prefixSum;

    public SimplePrefixSumArray(int[] nums) {
        if(nums == null) {
            throw new IllegalArgumentException("array=null");
        }

        if(nums.length == 0) {
            throw new IllegalArgumentException("array.length=0");
        }

        prefixSum = new int[nums.length + 1];

        for(int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
    }

    @Override
    public int rangeQuery(int from, int to) {
        if(from > to) {
            throw new IllegalArgumentException(String.format("from=%s, to=%s", from, to));
        }

        return prefixSum[to + 1] - prefixSum[from];
    }

    @Override
    public void updatePoint(int index, int value) {
        if(index < 0 || index > this.prefixSum.length - 2) {
            throw new IllegalArgumentException(String.format(
                    "index=%s, array.length=%s", index, this.prefixSum.length - 1));
        }

        int diff = value - rangeQuery(index, index);

        for(int i  = index + 1; i < prefixSum.length; i++) {
            prefixSum[i] += diff;
        }
    }
}
