import org.junit.Assert;
import org.junit.Test;

public class ExtensionsTest {

    @Test
    public void convertInt() {
        int source = -343;
        byte[] bytes = LowLevelExtensionsKt.toByteArray(source);
        int result = LowLevelExtensionsKt.toInt(bytes);

        Assert.assertEquals(source, result);
    }

    @Test(expected = NumberFormatException.class)
    public void intExceptionTest() {
        byte[] bytes = new byte[] { 34, -2, 13 };
        LowLevelExtensionsKt.toInt(bytes);
    }

    @Test
    public void convertLong() {
        long source = 3492L;
        byte[] bytes = LowLevelExtensionsKt.toByteArray(source);
        long result = LowLevelExtensionsKt.toLong(bytes);

        Assert.assertEquals(source, result);
    }

    @Test(expected = NumberFormatException.class)
    public void longExceptionTest() {
        byte[] bytes = new byte[] { 34, -2, 13, 34, 23, -3, 43, 102 };
        LowLevelExtensionsKt.toLong(bytes);
    }
}
