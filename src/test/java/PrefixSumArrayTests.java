import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public abstract class PrefixSumArrayTests {

    protected static final int[] VALID_ARRAY = new int[]{1, 2, 3, 4, 5, 6};
    protected static final int[] NULL_ARRAY = null;
    protected static final int[] EMPTY_ARRAY = new int[]{};

    protected abstract PrefixSumArray createInstance(int[] array);

    @Test
    public void testConstructionNullArrayThrows() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> createInstance(NULL_ARRAY));
    }

    @Test
    public void testConstructionEmptyArrayThrows() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> createInstance(EMPTY_ARRAY));
    }

    @Test
    public void testPrefixSumArrayRangeQuery() {
        PrefixSumArray ds = createInstance(VALID_ARRAY);
        Assertions.assertEquals(14, ds.rangeQuery(1, 4));
    }

    @Test
    public void testPrefixSumArrayRangeQueryThrows() {
        PrefixSumArray ds = createInstance(VALID_ARRAY);
        Assertions.assertThrows(IllegalArgumentException.class, () -> ds.rangeQuery(2, 1), "from=2, to=1");
    }

    @Test
    public abstract void testPrefixSumArrayUpdateValue() throws NoSuchFieldException, IllegalAccessException;

    @Test
    public void testPrefixSumArrayUpdateValueThrows() {
        PrefixSumArray ds = createInstance(VALID_ARRAY);
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> ds.updatePoint(-1, 5),
                "index=-1, array.length=6"
        );
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> ds.updatePoint(6, 5),
                "index=6, array.length=6"
        );
    }
}
