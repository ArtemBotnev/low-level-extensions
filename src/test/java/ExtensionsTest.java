import org.junit.Test;

import static org.junit.Assert.*;

public class ExtensionsTest {

    @Test
    public void convertInt() {
        int source = -343;
        byte[] bytes = LowLevelExtensionsKt.fromHexStringToByteArray(source);
        int result = LowLevelExtensionsKt.toInt(bytes);

        assertEquals(source, result);
    }

    @Test(expected = NumberFormatException.class)
    public void intExceptionTest() {
        byte[] bytes = new byte[] { 34, -2, 13 };
        LowLevelExtensionsKt.toInt(bytes);
    }

    @Test
    public void convertLong() {
        long source = 3492L;
        byte[] bytes = LowLevelExtensionsKt.fromHexStringToByteArray(source);
        long result = LowLevelExtensionsKt.toLong(bytes);

        assertEquals(source, result);
    }

    @Test(expected = NumberFormatException.class)
    public void longExceptionTest() {
        byte[] bytes = new byte[] { 34, -2, 13, 34, 43, 102 };
        LowLevelExtensionsKt.toLong(bytes);
    }

    @Test
    public void convertFloat() {
        float source = 5124.0753f;
        byte[] bytes = LowLevelExtensionsKt.fromHexStringToByteArray(source);
        float result = LowLevelExtensionsKt.toFloat(bytes);

        assertEquals(source, result, 0.00001);
    }

    @Test(expected = NumberFormatException.class)
    public void floatExceptionTest() {
        byte[] bytes = new byte[] { -12, 32, 12 };
        LowLevelExtensionsKt.toFloat(bytes);
    }

    @Test
    public void byteArrayHexStringTest() {
        byte[] byteArray = { -12, 32, 12, 0, 32, -73, 94, 120, -54, 34, 93, -107 };
        String hexString = LowLevelExtensionsKt.toHexString(byteArray, false);
        byte[] result = LowLevelExtensionsKt.fromHexStringToByteArray(hexString);

        assertArrayEquals(byteArray, result);
    }
}
