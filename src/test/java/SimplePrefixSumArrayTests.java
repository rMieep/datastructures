import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

public class SimplePrefixSumArrayTests extends PrefixSumArrayTests {
    @Override
    protected PrefixSumArray createInstance(int[] array) {
        return new SimplePrefixSumArray(array);
    }

    @Test
    @Override
    public void testPrefixSumArrayUpdateValue() throws NoSuchFieldException, IllegalAccessException {
        PrefixSumArray ds = createInstance(PrefixSumArrayTests.VALID_ARRAY);
        ds.updatePoint(4, 7);
        Field privatePrefixSumField = ds.getClass().getDeclaredField("prefixSum");
        privatePrefixSumField.setAccessible(true);
        int[] prefixSum = (int[]) privatePrefixSumField.get(ds);
        Assertions.assertArrayEquals(new int[]{0, 1, 3, 6 , 10, 17, 23}, prefixSum);
    }
}
