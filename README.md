# Problem
Unit tests against EncryptedSharedPreferences fail when `isIncludeAndroidResources = true`.

# Steps to Reproduce

Clone this sample.

## Without Including Resources (Passes Correctly)

Run:
```
./gradlew :test:testDebugUnitTest
```

Test passes as expected.

## When Including Resources (Fails Incorrectly)

Uncomment in `/test/build.gradle.kts`
```
//    testOptions.unitTests.apply {
//        isIncludeAndroidResources = true
//    }
```

Run:
```
./gradlew :test:testDebugUnitTest
```

Test fails with the following exception:
```
java.security.KeyStoreException: AndroidKeyStore not found
	at java.base/java.security.KeyStore.getInstance(KeyStore.java:871)
	at androidx.security.crypto.MasterKeys.keyExists(MasterKeys.java:155)
	at androidx.security.crypto.MasterKeys.getOrCreate(MasterKeys.java:99)
	at androidx.security.crypto.MasterKey$Builder$Api23Impl.build(MasterKey.java:380)
	at androidx.security.crypto.MasterKey$Builder.build(MasterKey.java:320)
	at com.jsmolinski.robolectric.encryptedsharedpreferences.storage.LocalStorage.<init>(LocalStorage.kt:13)
	at com.jsmolinski.robolectric.encryptedsharedpreferences.test.LocalStorageTest.<init>(LocalStorageTest.kt:13)
	at java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
	at java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:77)
	at java.base/jdk.internal.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)
	at java.base/java.lang.reflect.Constructor.newInstanceWithCaller(Constructor.java:499)
	at java.base/java.lang.reflect.Constructor.newInstance(Constructor.java:480)
	at org.junit.runners.BlockJUnit4ClassRunner.createTest(BlockJUnit4ClassRunner.java:250)
	at org.robolectric.RobolectricTestRunner$HelperTestRunner.createTest(RobolectricTestRunner.java:475)
	at org.junit.runners.BlockJUnit4ClassRunner.createTest(BlockJUnit4ClassRunner.java:260)
	at org.junit.runners.BlockJUnit4ClassRunner$2.runReflectiveCall(BlockJUnit4ClassRunner.java:309)
	at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
	at org.junit.runners.BlockJUnit4ClassRunner.methodBlock(BlockJUnit4ClassRunner.java:306)
	at org.robolectric.internal.SandboxTestRunner$HelperTestRunner.methodBlock(SandboxTestRunner.java:375)
	at org.robolectric.RobolectricTestRunner$HelperTestRunner.methodBlock(RobolectricTestRunner.java:484)
	at org.robolectric.internal.SandboxTestRunner$2.lambda$evaluate$2(SandboxTestRunner.java:290)
	at org.robolectric.internal.bytecode.Sandbox.lambda$runOnMainThread$0(Sandbox.java:104)
	at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:264)
	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1136)
	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:635)
	at java.base/java.lang.Thread.run(Thread.java:840)
Caused by: java.security.NoSuchAlgorithmException: AndroidKeyStore KeyStore not available
	at java.base/sun.security.jca.GetInstance.getInstance(GetInstance.java:159)
	at java.base/java.security.Security.getImpl(Security.java:676)
	at java.base/java.security.KeyStore.getInstance(KeyStore.java:868)
	... 25 more
```
