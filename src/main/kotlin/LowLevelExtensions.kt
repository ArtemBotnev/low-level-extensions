import java.nio.ByteBuffer

val Float.Companion.SIZE_BYTES: Int
    get() = 4

val Double.Companion.SIZE_BYTES: Int
    get() = 8

/**
 * Converts short variable to byte array
 * @return 2 byte array representing short variable
 */
fun Short.toByteArray() = numberToByteArray(Short.SIZE_BYTES) { putShort(this@toByteArray) }

/**
 * Converts integer variable to byte array
 * @return 4 byte array representing integer variable
 */
fun Int.toByteArray() = numberToByteArray(Int.SIZE_BYTES) { putInt(this@toByteArray) }

/**
 * Converts long variable to byte array
 * @return 8 byte array representing long variable
 */
fun Long.toByteArray() = numberToByteArray(Long.SIZE_BYTES) { putLong(this@toByteArray) }

/**
 * Converts float variable to byte array
 * @return 4 byte array representing float variable
 */
fun Float.toByteArray() = numberToByteArray(Float.SIZE_BYTES) { putFloat(this@toByteArray) }

/**
 * Converts double variable to byte array
 * @return 8 byte array representing double variable
 */
fun Double.toByteArray() = numberToByteArray(Double.SIZE_BYTES) { putDouble(this@toByteArray) }

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

/**
 * Converts byte array to float variable
 * @return float variable result
 * @throws NumberFormatException in case of byte array size not equals 4
 */
@Throws(NumberFormatException::class)
fun ByteArray.toFloat(): Float = toNumeric(Float.SIZE_BYTES) { float }

/**
 * Converts byte array to double variable
 * @return double variable result
 * @throws NumberFormatException in case of byte array size not equals 8
 */
@Throws(NumberFormatException::class)
fun ByteArray.toDouble(): Double = toNumeric(Double.SIZE_BYTES) { double }

private inline fun numberToByteArray(size: Int, bufferFun: ByteBuffer.() -> ByteBuffer): ByteArray =
    ByteBuffer.allocate(size).bufferFun().array()

@Throws(NumberFormatException::class)
private inline fun <reified T: Number> ByteArray.toNumeric(size: Int, bufferFun: ByteBuffer.() -> T): T {
    if (this.size != size) throw NumberFormatException("${T::class.java.simpleName} value must contains $size bytes")

    return ByteBuffer.wrap(this).bufferFun()
}