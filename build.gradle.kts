// Top-level build file where you can add configuration options common to all sub-projects/modules.

plugins {
    // Applying the plugins to subprojects/modules
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.googleServices) apply false
}

