# Reproduce Kotlin Native Regression

Reproducer for: https://github.com/quarkusio/quarkus/issues/44472

Native tests fail:

```shell script
./mvnw clean install -Dnative -Dquarkus.native.container-build=true
```

stacktrace:
```
java.lang.RuntimeException: kotlin.reflect.jvm.internal.KotlinReflectionInternalError: Unresolved class: class kotlin.collections.EmptyList (kind = CLASS)
        at org.jboss.resteasy.reactive.server.core.ServerSerialisers.invokeWriter(ServerSerialisers.java:256)
        at org.jboss.resteasy.reactive.server.core.ServerSerialisers.invokeWriter(ServerSerialisers.java:186)
        at org.jboss.resteasy.reactive.server.core.serialization.FixedEntityWriter.write(FixedEntityWriter.java:28)
        at org.jboss.resteasy.reactive.server.handlers.ResponseWriterHandler.handle(ResponseWriterHandler.java:34)
        at io.quarkus.resteasy.reactive.server.runtime.QuarkusResteasyReactiveRequestContext.invokeHandler(QuarkusResteasyReactiveRequestContext.java:147)
        at org.jboss.resteasy.reactive.common.core.AbstractResteasyReactiveContext.run(AbstractResteasyReactiveContext.java:147)
        at io.quarkus.vertx.core.runtime.VertxCoreRecorder$14.runWith(VertxCoreRecorder.java:627)
        at org.jboss.threads.EnhancedQueueExecutor$Task.doRunWith(EnhancedQueueExecutor.java:2675)
        at org.jboss.threads.EnhancedQueueExecutor$Task.run(EnhancedQueueExecutor.java:2654)
        at org.jboss.threads.EnhancedQueueExecutor.runThreadBody(EnhancedQueueExecutor.java:1627)
        at org.jboss.threads.EnhancedQueueExecutor$ThreadBody.run(EnhancedQueueExecutor.java:1594)
        at org.jboss.threads.DelegatingRunnable.run(DelegatingRunnable.java:11)
        at org.jboss.threads.ThreadLocalResettingRunnable.run(ThreadLocalResettingRunnable.java:11)
        at io.netty.util.concurrent.FastThreadLocalRunnable.run(FastThreadLocalRunnable.java:30)
        at java.base@21.0.5/java.lang.Thread.runWith(Thread.java:1596)
        at java.base@21.0.5/java.lang.Thread.run(Thread.java:1583)
        at org.graalvm.nativeimage.builder/com.oracle.svm.core.thread.PlatformThreads.threadStartRoutine(PlatformThreads.java:896)
        at org.graalvm.nativeimage.builder/com.oracle.svm.core.thread.PlatformThreads.threadStartRoutine(PlatformThreads.java:872)
Caused by: kotlin.reflect.jvm.internal.KotlinReflectionInternalError: Unresolved class: class kotlin.collections.EmptyList (kind = CLASS)
        at kotlin.reflect.jvm.internal.KClassImpl.createSyntheticClassOrFail(KClassImpl.kt:339)
        at kotlin.reflect.jvm.internal.KClassImpl.access$createSyntheticClassOrFail(KClassImpl.kt:49)
        at kotlin.reflect.jvm.internal.KClassImpl$Data.descriptor_delegate$lambda$0(KClassImpl.kt:67)
        at kotlin.reflect.jvm.internal.KClassImpl$Data.accessor$KClassImpl$Data$lambda0(KClassImpl.kt)
        at kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$0.invoke(Unknown Source)
        at kotlin.reflect.jvm.internal.ReflectProperties$LazySoftVal.invoke(ReflectProperties.java:70)
        at kotlin.reflect.jvm.internal.ReflectProperties$Val.getValue(ReflectProperties.java:32)
        at kotlin.reflect.jvm.internal.KClassImpl$Data.getDescriptor(KClassImpl.kt:53)
        at kotlin.reflect.jvm.internal.KClassImpl.getDescriptor(KClassImpl.kt:193)
        at kotlin.reflect.jvm.internal.KClassImpl.getMemberScope$kotlin_reflection(KClassImpl.kt:202)
        at kotlin.reflect.jvm.internal.KClassImpl$Data.declaredNonStaticMembers_delegate$lambda$22(KClassImpl.kt:173)
        at kotlin.reflect.jvm.internal.KClassImpl$Data.accessor$KClassImpl$Data$lambda10(KClassImpl.kt)
        at kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$10.invoke(Unknown Source)
        at kotlin.reflect.jvm.internal.ReflectProperties$LazySoftVal.invoke(ReflectProperties.java:70)
        at kotlin.reflect.jvm.internal.ReflectProperties$Val.getValue(ReflectProperties.java:32)
        at kotlin.reflect.jvm.internal.KClassImpl$Data.getDeclaredNonStaticMembers(KClassImpl.kt:173)
        at kotlin.reflect.jvm.internal.KClassImpl$Data.allNonStaticMembers_delegate$lambda$26(KClassImpl.kt:182)
        at kotlin.reflect.jvm.internal.KClassImpl$Data.accessor$KClassImpl$Data$lambda14(KClassImpl.kt)
        at kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$14.invoke(Unknown Source)
        at kotlin.reflect.jvm.internal.ReflectProperties$LazySoftVal.invoke(ReflectProperties.java:70)
        at kotlin.reflect.jvm.internal.ReflectProperties$Val.getValue(ReflectProperties.java:32)
        at kotlin.reflect.jvm.internal.KClassImpl$Data.getAllNonStaticMembers(KClassImpl.kt:182)
        at kotlin.reflect.full.KClasses.getMemberProperties(KClasses.kt:148)
        at com.fasterxml.jackson.module.kotlin.KotlinNamesAnnotationIntrospector.findDefaultCreator(KotlinNamesAnnotationIntrospector.kt:99)
        at com.fasterxml.jackson.databind.introspect.AnnotationIntrospectorPair.findDefaultCreator(AnnotationIntrospectorPair.java:746)
        at com.fasterxml.jackson.databind.introspect.AnnotationIntrospectorPair.findDefaultCreator(AnnotationIntrospectorPair.java:746)
        at com.fasterxml.jackson.databind.introspect.POJOPropertiesCollector._addCreators(POJOPropertiesCollector.java:666)
        at com.fasterxml.jackson.databind.introspect.POJOPropertiesCollector.collectAll(POJOPropertiesCollector.java:451)
        at com.fasterxml.jackson.databind.introspect.POJOPropertiesCollector.getJsonValueAccessor(POJOPropertiesCollector.java:269)
        at com.fasterxml.jackson.databind.introspect.BasicBeanDescription.findJsonValueAccessor(BasicBeanDescription.java:248)
        at com.fasterxml.jackson.databind.ser.BasicSerializerFactory.findSerializerByAnnotations(BasicSerializerFactory.java:393)
        at com.fasterxml.jackson.databind.ser.BasicSerializerFactory.buildCollectionSerializer(BasicSerializerFactory.java:712)
        at com.fasterxml.jackson.databind.ser.BasicSerializerFactory.buildContainerSerializer(BasicSerializerFactory.java:654)
        at com.fasterxml.jackson.databind.ser.BeanSerializerFactory._createSerializer2(BeanSerializerFactory.java:205)
        at com.fasterxml.jackson.databind.ser.BeanSerializerFactory.createSerializer(BeanSerializerFactory.java:174)
        at com.fasterxml.jackson.databind.SerializerProvider._createUntypedSerializer(SerializerProvider.java:1523)
        at com.fasterxml.jackson.databind.SerializerProvider._createAndCacheUntypedSerializer(SerializerProvider.java:1491)
        at com.fasterxml.jackson.databind.SerializerProvider.findPrimaryPropertySerializer(SerializerProvider.java:709)
        at com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap.findAndAddPrimarySerializer(PropertySerializerMap.java:72)
        at com.fasterxml.jackson.databind.ser.BeanPropertyWriter._findAndAddDynamic(BeanPropertyWriter.java:899)
        at com.fasterxml.jackson.databind.ser.BeanPropertyWriter.serializeAsField(BeanPropertyWriter.java:710)
        at com.fasterxml.jackson.databind.ser.std.BeanSerializerBase.serializeFields(BeanSerializerBase.java:770)
        at com.fasterxml.jackson.databind.ser.BeanSerializer.serialize(BeanSerializer.java:184)
        at com.fasterxml.jackson.databind.ser.DefaultSerializerProvider._serialize(DefaultSerializerProvider.java:502)
        at com.fasterxml.jackson.databind.ser.DefaultSerializerProvider.serializeValue(DefaultSerializerProvider.java:341)
        at com.fasterxml.jackson.databind.ObjectWriter$Prefetch.serialize(ObjectWriter.java:1583)
        at com.fasterxml.jackson.databind.ObjectWriter._writeValueAndClose(ObjectWriter.java:1285)
        at com.fasterxml.jackson.databind.ObjectWriter.writeValue(ObjectWriter.java:1098)
        at io.quarkus.resteasy.reactive.jackson.runtime.serialisers.BasicServerJacksonMessageBodyWriter.writeResponse(BasicServerJacksonMessageBodyWriter.java:72)
        at org.jboss.resteasy.reactive.server.core.ServerSerialisers.invokeWriter(ServerSerialisers.java:218)
        ... 17 more
```

After downgrading to Quarkus 3.15.1 in `pom.xml`, the tests pass.

```<quarkus.platform.version>3.15.1</quarkus.platform.version>```
