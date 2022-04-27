public class FenwickTree implements PrefixSumArray {

    private final int[] fenwickArray;

    public FenwickTree(int[] array) {
        if(array == null) {
            throw new IllegalArgumentException("array=null");
        }

        if(array.length == 0) {
            throw new IllegalArgumentException("array.length=0");
        }

        this.fenwickArray = new int[array.length + 1];
        buildTree(array);
    }

    @Override
    public int rangeQuery(int from, int to) {
        if(from > to) {
            throw new IllegalArgumentException(String.format("from=%s, to=%s", from, to));
        }
        return calculatePrefixSum(to + 1) - calculatePrefixSum(from);
    }

    @Override
    public void updatePoint(int index, int value) {
        if(index < 0 || index > this.fenwickArray.length - 2) {
            throw new IllegalArgumentException(String.format(
                    "index=%s, array.length=%s", index, this.fenwickArray.length - 1));
        }

        int difference = value - rangeQuery(index, index);
        index = index + 1;

        while(index < this.fenwickArray.length) {
            this.fenwickArray[index] += difference;
            index += calculateLSB(index);
        }
    }

    private void buildTree(int[] array) {
        int n = fenwickArray.length;
        for (int i = 1; i < n; i++) {
            this.fenwickArray[i] += array[i - 1];
            int parent = i + calculateLSB(i);

            if(parent < n) {
                this.fenwickArray[parent] += this.fenwickArray[i];
            }
        }
    }

    private int calculatePrefixSum(int index) {
        int sum = 0;

        while(index > 0) {
            sum += this.fenwickArray[index];
            index -= calculateLSB(index);
        }

        return sum;
    }

    private int calculateLSB(int number) {
        return number & -number;
    }
}
