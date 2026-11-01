plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.zaki_yasri_3tib"
    compileSdk {
        version = release(37)
    }

    defaultConfig {
        applicationId = "com.example.zaki_yasri_3tib"
        minSdk = 29
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            optimization {
                enable = false
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    // Disini jikalau kita membuat kelas penghubung secara otomatis untuk setiap file xml contohnya
    // activity.login.xml otomatis nanti terbuat kelas ActivityLoginBinding.kt pada file example
    buildFeatures{
        viewBinding = true
    }
}

dependencies {
    implementation("androidx.gridlayout:gridlayout:1.0.0")
    implementation("androidx.viewpager2:viewpager2:1.1.0")
    implementation("com.tbuonomo:dotsindicator:5.1.0")
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.core.ktx)
    implementation(libs.material)
    implementation("com.github.bumptech.glide:glide:4.16.0")
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
}