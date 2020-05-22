import java.nio.ByteBuffer

/**
 * Converts short variable to byte array
 * @return 2 byte array representing a short variable
 */
fun Short.toByteArray() = numberToByteArray(Short.SIZE_BYTES) { putShort(this@toByteArray) }

/**
 * Converts integer variable to byte array
 * @return 4 byte array representing a integer variable
 */
fun Int.toByteArray() = numberToByteArray(Int.SIZE_BYTES) { putInt(this@toByteArray) }

/**
 * Converts long variable to byte array
 * @return 8 byte array representing a long variable
 */
fun Long.toByteArray() = numberToByteArray(Long.SIZE_BYTES) { putLong(this@toByteArray) }

/**
 * Converts byte array to short variable
 * @return short variable result
 * @throws NumberFormatException in case of byte array size not equals 2
 */
@Throws(NumberFormatException::class)
fun ByteArray.toShort(): Short = toNumeric(Short.SIZE_BYTES) { short }

/**
 * Converts byte array to integer variable
 * @return integer variable result
 * @throws NumberFormatException in case of byte array size not equals 4
 */
@Throws(NumberFormatException::class)
fun ByteArray.toInt(): Int = toNumeric(Int.SIZE_BYTES) { int }

/**
 * Converts byte array to long variable
 * @return long variable result
 * @throws NumberFormatException in case of byte array size not equals 8
 */
@Throws(NumberFormatException::class)
fun ByteArray.toLong(): Long = toNumeric(Long.SIZE_BYTES) { long }

private inline fun numberToByteArray(size: Int, bufferFun: ByteBuffer.() -> ByteBuffer): ByteArray =
    ByteBuffer.allocate(size).bufferFun().array()

@Throws(NumberFormatException::class)
private inline fun <reified T: Number> ByteArray.toNumeric(size: Int, bufferFun: ByteBuffer.() -> T): T {
    if (this.size != size) throw NumberFormatException("${T::class.java.simpleName} value must contains $size bytes")

    return ByteBuffer.wrap(this).bufferFun()
}