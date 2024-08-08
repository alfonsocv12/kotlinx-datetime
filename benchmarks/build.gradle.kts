import org.jetbrains.kotlin.gradle.tasks.KotlinCompilationTask

plugins {
    with(libs.plugins) {
        alias(kotlin.jvm)
        alias(jmh)
    }
}

sourceSets {
    dependencies {
        implementation(project(":kotlinx-datetime"))
        implementation(libs.jmh)
    }
}

// publish benchmarks to the repository root for easier `java -jar benchmarks.jar`
tasks.named<Jar>("jmhJar") {
    archiveBaseName = "benchmarks"
    archiveClassifier = null
    archiveVersion.convention(null as String?)
    archiveVersion = null
    destinationDirectory = file("$rootDir")
}

// compile all Kotlin code from the module during full-repository builds
tasks.named("assemble") {
    tasks.withType<KotlinCompilationTask<*>>().forEach { compileKotlinTask ->
        dependsOn(compileKotlinTask)
    }
}
