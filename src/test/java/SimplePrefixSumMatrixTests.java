public class SimplePrefixSumMatrixTests extends PrefixSumMatrixTests {
    @Override
    protected PrefixSumMatrix createInstance(int[][] matrix) {
        return new SimplePrefixSumMatrix(matrix);
    }
}
