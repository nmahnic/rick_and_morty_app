plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("de.mannodermaus.android-junit5") version "1.9.3.0"
}

android {
    namespace = "com.nicomahnic.data"
    compileSdk = 34

    defaultConfig {
        minSdk = 28

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")

        buildConfigField("String", "BASE_URL_RICK_Y_MORTY", "\"https://rickandmortyapi.com/api/\"")
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

    buildFeatures {
        buildConfig = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    implementation(project(":domain"))

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.7.2")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    val koinVersion = "3.5.0"
    implementation("io.insert-koin:koin-core:$koinVersion")

    val retrofitVersion = "2.9.0"
    implementation("com.squareup.retrofit2:converter-moshi:$retrofitVersion")
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    val loggingInterceptorVersion = "4.9.3"
    implementation("com.squareup.okhttp3:logging-interceptor:$loggingInterceptorVersion")

    val pagingVersion = "3.2.1"
    implementation ("androidx.paging:paging-runtime-ktx:$pagingVersion")

    testImplementation ("org.junit.jupiter:junit-jupiter-api:5.9.2")
    testRuntimeOnly ("org.junit.jupiter:junit-jupiter-engine:5.9.2")
    testImplementation("org.mockito:mockito-junit-jupiter:5.3.1")
    testImplementation("org.mockito.kotlin:mockito-kotlin:4.0.0")
}