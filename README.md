[![](https://jitpack.io/v/ArtemBotnev/low-level-extensions.svg)](https://jitpack.io/#ArtemBotnev/low-level-extensions)

## Low level extensions
#### Simple Kotlin, Java library for easy work with numeric types converting to bytes array and vice versa.
#### Support for all Number types.
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

Convert byte array to hex string
```kotlin
val bytes = byteArrayOf(-12, 32, 12, 0, 32, -73, 94, 120, -54, 34, 93, -107)
val hexString = value.toHexString()
```
result: f4200c0020b75e78ca225d95  
You can pass ```true``` to function ```toHexString(true)``` for upper case letters.

Convert hex string to byte array
```kotlin
val hexString = "a0f33402"
val bytes = hexString.fromHexStringToByteArray()
```

#### Java example of usage:
Convert integer to byte array
```java
int source = -343;
byte[] bytes = LowLevelExtensionsKt.toByteArray(source);
```
Convert byte array to long
```java
byte[] bytes = { 34, -2, 13, 34, 23, -3, 43, 102 };
long result = LowLevelExtensionsKt.toLong(bytes);
```
Convert byte array to hex string
```java
byte[] byteArray = { -12, 32, 12, 0, 32, -73, 94, 120, -54, 34, 93, -107 };
String hexString = LowLevelExtensionsKt.toHexString(byteArray, false);
```
result: f4200c0020b75e78ca225d95  
You can pass ```true``` to method ```toHexString(byteArray, true)``` for upper case letters.

Convert hex string to byte array
```java
String hexString  = "a0f33402";
byte[] byteArray = LowLevelExtensionsKt.fromHexStringToByteArray(hexString);
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
 implementation 'com.github.ArtemBotnev:low-level-extensions:1.1.1'
}
```
