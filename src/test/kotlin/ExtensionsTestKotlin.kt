import org.junit.Assert
import org.junit.Test

class ExtensionsTestKotlin {

    @Test
    fun convertShort() {
        val source: Short = 2587
        val bytes = source.toByteArray()
        val result = bytes.toShort()

        Assert.assertEquals(source, result)
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

        Assert.assertEquals(source, result)
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

        Assert.assertEquals(source, result)
    }

    @Test(expected = NumberFormatException::class)
    fun longExceptionTest() {
        val bytes = byteArrayOf(34, -2, 13)
        bytes.toLong()
    }
}