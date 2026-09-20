plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.konklavtracer_v2"
    compileSdk {
        version = release(37)
    }

    defaultConfig {
        applicationId = "com.example.konklavtracer_v2"
        minSdk = 24
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
    buildFeatures {
        compose = true
        viewBinding = true  // Добавь если нужно
    }
}

dependencies {
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    // ===== ДОБАВЬ ЭТИ ЗАВИСИМОСТИ =====

    // Material Design (для TabLayout, NavigationView и др.)
    implementation("com.google.android.material:material:1.11.0")

    // ViewPager2 (для вкладок)
    implementation("androidx.viewpager2:viewpager2:1.0.0")

    // Fragment (для FragmentStateAdapter)
    implementation("androidx.fragment:fragment-ktx:1.6.2")

    // DrawerLayout (часть material, но может понадобиться)
    implementation("androidx.drawerlayout:drawerlayout:1.2.0")

    // ConstraintLayout (если используешь)
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    // RecyclerView (если понадобится для списков)
    implementation("androidx.recyclerview:recyclerview:1.3.2")

    // ===== КОНЕЦ ДОБАВЛЕНИЙ =====

    testImplementation(libs.junit)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
    debugImplementation(libs.androidx.compose.ui.tooling)
}