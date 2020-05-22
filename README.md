[![](https://jitpack.io/v/ArtemBotnev/low-level-extensions.svg)](https://jitpack.io/#ArtemBotnev/low-level-extensions)

## Low level extensions
#### Simple Kotlin, Java library for easy work with numeric types converting to bytes array and vice versa.
#### Kotlin example of usage:
Convert integer to byte array
```kotlin
val source = -343
val bytes = source.toByteArray()
```
Convert byte array to short
```kotlin
val bytes = byteArrayOf(-18, 41)
val result: Short = bytes.toShort()
```
#### Java example of usage:
Convert integer to byte array
```java
int source = -343;
byte[] bytes = LowLevelExtensionsKt.toByteArray(source);
```
Convert byte array to long
```java
byte[] bytes = new byte[] { 34, -2, 13, 34, 23, -3, 43, 102 };
long result = LowLevelExtensionsKt.toLong(bytes);
```
#### To use this, add dependensies to your project:
Jitpack repository to your root build.gradle at the end of repositories
```groovy
allprojects {
 repositories {
  ...
  maven { url 'https://jitpack.io' }
  }
 }
```
and to module level build.gradle
```groovy
dependencies {
 implementation 'com.github.ArtemBotnev:low-level-extensions:0.2.0'
}
```
