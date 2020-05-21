import org.junit.Assert
import org.junit.Test

class ExtensionsTestKotlin {

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

    @Test
    fun convertInt() {
        val source = -343
        val bytes = source.toByteArray()
        val result = bytes.toInt()

        Assert.assertEquals(source.toLong(), result.toLong())
    }

    @Test(expected = NumberFormatException::class)
    fun intExceptionTest() {
        val bytes = byteArrayOf(34, -2, 13, 59, 47)
        bytes.toInt()
    }
}