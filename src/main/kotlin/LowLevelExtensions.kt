import java.nio.ByteBuffer

fun Int.toByteArray() = numberToByteArray(Int.SIZE_BYTES) { putInt(this@toByteArray) }

fun Long.toByteArray() = numberToByteArray(Long.SIZE_BYTES) { putLong(this@toByteArray) }

@Throws(NumberFormatException::class)
fun ByteArray.toLong(): Long = toNumeric(Long.SIZE_BYTES) { long }

@Throws(NumberFormatException::class)
fun ByteArray.toInt(): Int = toNumeric(Int.SIZE_BYTES) { int }

private inline fun numberToByteArray(size: Int, bufferFun: ByteBuffer.() -> ByteBuffer): ByteArray =
    ByteBuffer.allocate(size).bufferFun().array()

@Throws(NumberFormatException::class)
private inline fun <reified T: Number> ByteArray.toNumeric(size: Int, bufferFun: ByteBuffer.() -> T): T {
    if (this.size != size) throw NumberFormatException("${T::class.java.simpleName} value must contains $size bytes")

    return ByteBuffer.wrap(this).bufferFun()
}