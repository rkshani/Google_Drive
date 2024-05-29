plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.googleServices)
}

android {
    namespace = "com.rkshani.drivedemo"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.rkshani.drivedemo"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    configurations {
        all {
            exclude(group = "commons-logging", module = "commons-logging")
            exclude(group = "org.apache.httpcomponents")
        }
    }

    packagingOptions {
        exclude("META-INF/DEPENDENCIES")
        exclude("LICENSE.txt")
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    // for runtime permission
    implementation(libs.dexter)
    // for top side toast, text with animation
//    implementation(libs.load.toast)

    // Google Drive API libs
    // Google auth
    implementation(libs.play.services.auth)
    implementation(libs.google.http.client.gson)
    // Google client API
    implementation("com.google.api-client:google-api-client-android:1.26.0") {
        exclude(group = "org.apache.httpcomponents")
    }
    // Google services API
    implementation("com.google.apis:google-api-services-drive:v3-rev136-1.25.0") {
        exclude(group = "org.apache.httpcomponents")
    }
}
