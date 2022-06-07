import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public abstract class PrefixSumMatrixTests {

    protected static final int[][] VALID_MATRIX = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    protected static final int[][] NULL_MATRIX = null;
    protected static final int[][] EMPTY_MATRIX = new int[][]{{}};

    protected abstract PrefixSumMatrix createInstance(int[][] matrix);

    @Test
    public void testConstructionNullArrayThrows() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> createInstance(NULL_MATRIX));
    }

    @Test
    public void testConstructionEmptyArrayThrows() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> createInstance(EMPTY_MATRIX));
    }

    @Test
    public void testPrefixSumArrayRangeQuery() {
        PrefixSumMatrix ds = createInstance(VALID_MATRIX);
        Assertions.assertEquals(21, ds.rangeQuery(new int[]{0, 0}, new int[]{1, 2}));
    }
}
