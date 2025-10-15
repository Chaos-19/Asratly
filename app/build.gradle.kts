
plugins {
    id("com.android.application")
        
    id("kotlin-android")
    id("org.jetbrains.kotlin.plugin.compose")
 
    id("com.google.dagger.hilt.android")
    kotlin("kapt")
  
}

android {
    namespace = "com.chaos.asratly"
    compileSdk = 36
    
    
    defaultConfig {
        applicationId = "com.chaos.asratly"
        minSdk = 21
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
        
        vectorDrawables { 
            useSupportLibrary = true
        }
        
    }
    
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    
    buildFeatures {
        
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.11"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    compilerOptions {
        jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.fromTarget("17"))
    }
}

dependencies {

    implementation(platform("androidx.compose:compose-bom:2025.06.01"))

    debugImplementation("androidx.compose.ui:ui-test-manifest")
    implementation("androidx.core:core-ktx:1.17.0")
    debugImplementation("androidx.compose.ui:ui-tooling")
    implementation("androidx.compose.ui:ui")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.9.2")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.activity:activity-compose:1.10.1")
    implementation("androidx.compose.ui:ui-graphics")
    
    implementation("androidx.compose.material:material-icons-extended")
    
    // --- AndroidX + Lifecycle ---
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.9.2")
    // --- Compose ViewModel & LiveData ---
    implementation("androidx.compose.runtime:runtime-livedata:1.9.3")
    

    // --- Kotlin Coroutines ---
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.9.0")
    
    // --- Dependency Injection (Hilt) ---
    implementation("com.google.dagger:hilt-android:2.51.1")
    kapt("com.google.dagger:hilt-android-compiler:2.51.1")
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")
    
    // --- Room (Local Database) ---
    implementation("androidx.room:room-runtime:2.7.0")
    implementation("androidx.room:room-ktx:2.7.0")
    kapt("androidx.room:room-compiler:2.7.0")
    
    // --- Navigation ---
    implementation("androidx.navigation:navigation-compose:2.8.3")
    
    // --- Coil for image loading ---
    implementation("io.coil-kt:coil-compose:2.6.0")
    
    // --- Optional: Logging ---
    implementation("com.jakewharton.timber:timber:5.0.1")
}