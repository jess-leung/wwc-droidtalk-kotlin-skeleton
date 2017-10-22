# DroidTalk in Kotlin: Women Who Code August 2017
This git repo contains the skeleton code to get started building out DroidTalk, a messaging app using Kotlin.

# Setup! 
There are many ways to deploy the app. 

You can either use a real physical Android device or use the inbuilt emulator provided by Android Studio. 

**Follow the appropriate instructions to set up (at least) one of the ways to deploy the app.**

## Project common setup 
1. Make sure you have [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) 
2. Install [Android Studio, which includes Android SDK](https://developer.android.com/studio/index.html)
3. If you are using Android Studio 2.x, install the Kotlin plugin in Android studio: Preferences > Plugins > Search for Kotlin.
It may prompt you to search in external repositories, just follow the instructions to install the Kotlin plugin. (The Kotlin plugin comes with
Android Studio 3.x.)
4. Clone this repository 
```
git clone https://github.com/jleu1656/wwc-droidtalk-kotlin-skeleton.git
```

## Setting up the inbuilt Android Studio emulator 
1. Open AVD Manager in Android Studio
2. Select Create Virtual Device > Select a device and click next 
3. Select a system image (make sure it's API 23+) > Next
4. Finish to create your new virtual device  

## Setting up your physical device if you have one with Android 6.0+/API Level 23+ (Marshmellow onwards)
Generally to enable develop options, although this may depend on the model and manufacturer of your phone:
1. Go to your phone settings > About phone 
2. Tap on the Build Number 7 times to enable Developer Options
3. Go back to the main settings > Developer Options
4. Enable USB Debugging

# Running the app 
1. Open the project in Android Studio
2. Android Studio will likely prompt you to install dependencies unless you already have them, proceed to install them 
3. In Android Studio, shift + f10 or click on the green play button to build the app. Select a virtual device.

# Further Reading
Android developer guide: https://developer.android.com/guide/index.html
Material Design: https://material.google.com/ 
