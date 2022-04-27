import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

public class FenwickTreeTests extends PrefixSumArrayTests {
    @Override
    protected PrefixSumArray createInstance(int[] array) {
        return new FenwickTree(array);
    }

    @Test
    @Override
    public void testPrefixSumArrayUpdateValue() throws NoSuchFieldException, IllegalAccessException {
        PrefixSumArray ds = createInstance(PrefixSumArrayTests.VALID_ARRAY);
        ds.updatePoint(4, 7);
        Field privateFenwickArrayField = ds.getClass().getDeclaredField("fenwickArray");
        privateFenwickArrayField.setAccessible(true);
        int[] fenwickArray = (int[]) privateFenwickArrayField.get(ds);
        Assertions.assertArrayEquals(new int[]{0, 1, 3, 3 ,10, 7, 13}, fenwickArray);
    }
}
