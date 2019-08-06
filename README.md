# kt

## Config kotlin use gradle plugin in vscode

```shell
# 1. 初始化
gradle init --type kotlin-application

# 2. 选择使用groovy或kotlin作为DSL
Select build script DSL:
  1: groovy
  2: kotlin
Enter selection (default: kotlin) [1..2] 

# 3. 设置项目名字
Project name (default: kt): 

# 4. 设置包名
Source package (default: kt): com.kt.learn

# 5. 运行程序
gradle run
```

配置成功后，自动在生成gradle配置文件：

setting.grale.kts:
```kotlin
rootProject.name = "kt"
```

build.gradle.kts:
```kotlin
/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Kotlin application project to get you started.
 */

plugins {
    // Apply the Kotlin JVM plugin to add support for Kotlin on the JVM
    id("org.jetbrains.kotlin.jvm").version("1.3.10")

    // Apply the application to add support for building a CLI application
    application
}

repositories {
    // Use jcenter for resolving your dependencies.
    // You can declare any Maven/Ivy/file repository here.
    jcenter()
}

dependencies {
    // Use the Kotlin JDK 8 standard library
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // Use the Kotlin test library
    testImplementation("org.jetbrains.kotlin:kotlin-test")

    // Use the Kotlin JUnit integration
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
}

application {
    // Define the main class for the application
    mainClassName = "com.kt.learn.AppKt"
}
```

> 其中： ` mainClassName = "com.kt.learn.AppKt"` 是程序的入口函数