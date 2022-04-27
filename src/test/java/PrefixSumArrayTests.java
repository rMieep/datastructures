import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public abstract class PrefixSumArrayTests {

    protected final int[] array = new int[]{1, 2, 3, 4, 5, 6};

    protected abstract PrefixSumArray createInstance();

    @Test
    public void testPrefixSumArrayRangeQuery() {
        PrefixSumArray ds = createInstance();
        Assertions.assertEquals(14, ds.rangeQuery(1, 4));
    }

    @Test
    public abstract void testPrefixSumArrayUpdateValue() throws NoSuchFieldException, IllegalAccessException;
}
