# 🖼 DeepLinkingGalleryApp (Android Deep Linking Demo + Compose + Navigation)

**DeepLinkingGalleryApp** is a small Android demo app that demonstrates **deep linking** in Jetpack Compose. Users can click an image in a “Sender App” and open the Gallery app directly on a **specific image detail screen**.

It’s built with **Kotlin, Jetpack Compose, Navigation, and Clean Architecture principles**.

---

## 📸 Screenshots

| Demo/GİF | 
|--------------|
| <img src="DeepLinkingGalleryApp (online-video-cutter.com).gif" width="700"> |


---

## 📱 Features

- **Deep Linking:** Open a specific image directly using a URL like:  
  `deeplinkinggalleryapp://images/details?id=1`
- **Navigation:** `HomeScreen` → `DetailScreen` using Jetpack Compose Navigation.
- **Animated Transitions:** Smooth `fadeIn` / `fadeOut` / `slide` animations between screens.
- **Sample Data:** Static image list using `sampleImages` utility object.
- **Clean Architecture:** Separation of `presentation`, `navigation`, and `utils`.

---

## 🧩 Tech Stack

| Technology | Purpose |
|------------|---------|
| Kotlin | Core language |
| Jetpack Compose | UI |
| Navigation Compose | Screen navigation |
| Kotlin Coroutines | Asynchronous tasks |
| Clean Architecture | Organized project structure |
| Hilt (optional) | Dependency injection |
| Room (optional) | Offline storage of images (future) |

---

## ⚡ Usage

1. **Install Sender App** → Click button to send deep link.  
2. **Install Gallery App** → Receives deep link and navigates to correct image detail.  
3. **Deep Link Format:**  
   ```text
   deeplinkinggalleryapp://images/details?id={imageId}



