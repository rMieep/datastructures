public class FenwickTree implements PrefixSumArray {

    private final int[] fenwickArray;

    public FenwickTree(int[] array) {
        this.fenwickArray = new int[array.length + 1];
        buildTree(array);
    }

    private void buildTree(int[] array) {
        for(int i = 1; i < this.fenwickArray.length; i++) {
            int responsibility = calculateResponsibility(i);
            int sum = 0;
            for(int j = i; j > i - responsibility; j--) {
                sum += array[j - 1];
            }
            this.fenwickArray[i] = sum;
        }
    }

    private int calculateResponsibility(int number) {
        return (int) Math.pow(2, calculateLSB(number));
    }

    private int calculateLSB(int number) {
        int b = number - 1;
        int c = number | b;
        return (int)(Math.log(c ^ b) / Math.log(2));
    }

    @Override
    public int rangeQuery(int from, int to) {
        return calculatePrefixSum(to + 1) - calculatePrefixSum(from);
    }

    private int calculatePrefixSum(int index) {
        int sum = 0;

        while(index > 0) {
            sum += this.fenwickArray[index];
            index -= calculateResponsibility(index);
        }

        return sum;
    }

    @Override
    public void updatePoint(int index, int oldValue, int newValue) {
        int difference = newValue - oldValue;
        index = index + 1;

        while(index < this.fenwickArray.length) {
            this.fenwickArray[index] += difference;
            index += calculateResponsibility(index);
        }
    }
}
