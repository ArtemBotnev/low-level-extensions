import org.junit.Assert.*
import org.junit.Test

class ExtensionsTestKotlin {

    @Test
    fun convertShort() {
        val source: Short = 2587
        val bytes = source.toByteArray()
        val result = bytes.toShort()

        assertEquals(source, result)
    }

    @Test(expected = NumberFormatException::class)
    fun shortExceptionTest() {
        val bytes = byteArrayOf(-18)
        bytes.toShort()
    }

    @Test
    fun convertInt() {
        val source = -343
        val bytes = source.toByteArray()
        val result = bytes.toInt()

        assertEquals(source, result)
    }

    @Test(expected = NumberFormatException::class)
    fun intExceptionTest() {
        val bytes = byteArrayOf(34, -2, 13, 59, 47)
        bytes.toInt()
    }

    @Test
    fun convertLong() {
        val source = 3492L
        val bytes = source.toByteArray()
        val result = bytes.toLong()

        assertEquals(source, result)
    }

    @Test(expected = NumberFormatException::class)
    fun longExceptionTest() {
        val bytes = byteArrayOf(34, -2, 13)
        bytes.toLong()
    }

    @Test
    fun convertFloat() {
        val source = 5124.0753f
        val bytes = source.toByteArray()
        val result = bytes.toFloat()

        assertEquals(source, result)
    }

    @Test(expected = NumberFormatException::class)
    fun floatExceptionTest() {
        byteArrayOf(-12, 32, 12).toFloat()
    }

    @Test
    fun convertDouble() {
        val source = 15.07530689
        val bytes = source.toByteArray()
        val result = bytes.toDouble()

        assertEquals(source, result, 0.000000001)
    }

    @Test(expected = NumberFormatException::class)
    fun doubleExceptionTest() {
        byteArrayOf(-12, 32, 12, 0, 32, -73, 94, 120, -54).toDouble()
    }
}