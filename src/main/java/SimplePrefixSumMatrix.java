public class SimplePrefixSumMatrix implements PrefixSumMatrix {

    private final int[][] prefixSum;

    public SimplePrefixSumMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            throw new IllegalArgumentException(getConstructorExceptionMessage(matrix));
        }

        prefixSum = new int[matrix.length + 1][matrix[0].length + 1];
        prefixSum[1][1] = matrix[0][0];

        for(int i = 2; i < prefixSum.length; i++) {
            prefixSum[i][1] = prefixSum[i - 1][1] + matrix[i - 1][0];
        }

        for(int j = 2; j < prefixSum[0].length; j++) {
            prefixSum[1][j] = prefixSum[1][j - 1] + matrix[0][j - 1];
        }

        for(int i = 2; i < prefixSum.length; i++) {
            for(int j = 2; j < prefixSum[0].length; j++) {
                prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1]
                        - prefixSum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    private String getConstructorExceptionMessage(int[][] matrix) {
        if(matrix == null) {
            return "matrix=null";
        } else if(matrix.length == 0) {
            return "matrix.length=0";
        } else if(matrix[0].length == 0) {
            return "matrix[0].length=0";
        } else {
            return "undefined";
        }
    }

    @Override
    public int rangeQuery(int[] from, int[] to) {
        return prefixSum[to[0] + 1][to[1] + 1] - prefixSum[from[0]][from[1]];
    }
}
