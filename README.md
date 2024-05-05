# 📱 Mondly Android App

## 📖 Description
This Android app 🚀 is built using modern development practices. It fetches a list of items and displays them in a user-friendly interface. Designed with scalability and efficiency in mind, this app incorporates several advanced libraries and tools.

## 🛠️ Libraries Used

- **Kotlin Coroutines** 🌀: Facilitates managing long-running tasks with simplified asynchronous programming, improving the performance and responsiveness of the app.
- **Kotlin Serialization** 📦: Provides a way to convert Kotlin objects into JSON format and vice versa, streamlining the process of data handling over the network.
- **Retrofit** 🌐: A type-safe HTTP client for Android and Java, used for making network requests and handling API calls seamlessly.
- **Coil** 🖼️: An image loading library for Android, which makes it easy to fetch, decode, and display images on the fly.
- **Jetpack Compose** 🎨: A modern toolkit for building native UIs in Android using declarative programming, making the code more concise and intuitive.

## 🚧 Missing Features

Even though the app is fully functional, there are a few areas not covered in this project that could be considered for future development:

- **Dependency Injection Framework**: No frameworks like Hilt or Koin were used, as the project's simplicity didn't justify their implementation.
- **Dimension Resource Files**: Dimensions are not managed in a separate resource file, which could improve maintainability.
- **Testing**: Both unit testing and UI testing are currently absent.
- **Static Analysis Tools**: Tools for linting and proper code analysis were not integrated.
- **Gradle Versions Catalog**: Dependencies are not managed via a Gradle Versions Catalog, which could streamline dependency management and updates.

## 📚 How to Get Started

To get started with this project, clone the repository and open it in your preferred IDE that supports Android development, such as Android Studio. Ensure you have the latest version of the Android SDK installed and configured.

```bash
git clone https://github.com/josegbel/mondly.git
cd mondly
```

Build the project by syncing with Gradle and then run the app on a physical device or emulator.

## 📄 License

Distributed under the MIT License.
