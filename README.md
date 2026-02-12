# Android Library Custom Alert

![Android](https://img.shields.io/badge/Android-API%2029%2B-brightgreen)
![Gradle](https://img.shields.io/badge/Gradle-8.13-blue)
![Gradle](https://img.shields.io/badge/AppCompat-1.7.1-blue)
![Gradle](https://img.shields.io/badge/ConstraintLayout-2.2.1-blue)
![Gradle](https://img.shields.io/badge/MaterialComponents-1.13.0-blue)
![License](https://img.shields.io/badge/License-MIT-green)

Sebuah library Android yang sederhana dan mudah digunakan untuk menampilkan dialog notifikasi dengan desain yang menarik dan dapat dikustomisasi.

## Tangkapan Layar

<img width="458" height="814" alt="Image" src="https://github.com/user-attachments/assets/2bbc7bdd-5c48-4e3a-a7a8-e16fa3cf0bb7" />

## Fitur

- Dialog alert sederhana dengan satu baris kode
- Kustomisasi penuh untuk card, button, dan gambar
- Builder pattern untuk konfigurasi yang fleksibel
- Mendukung listener saat dialog alert ditutup
- Menampilkan versi aplikasi secara otomatis
- Background transparan dengan efek card

## Persyaratan

- Min SDK: 29 (Android 10.0)
- Compile SDK: 36
- Java: 11

## Installation

Tambahkan library ini ke dalam project Anda:

### Gradle (Kotlin)

```kotlin
dependencies {
    implementation("com.github.Muhammad-Abid24:CustomAlert:1.0.0")
}
```

### Gradle (Groovy)

```groovy
dependencies {
    implementation 'com.github.Muhammad-Abid24:CustomAlert:1.0.0'
}
```

## Cara Penggunaan

### Penggunaan Dasar

```java
// Tampilkan dialog alert dengan pesan default
ShowCustomAlert.show(context);

// Tampilkan dialog alert dengan pesan kustom
ShowCustomAlert.show(context, "Request Gagal, tidak dapat terhubung ke server.\nPeriksa koneksi internet Anda!");
```

### Dengan Listener

```java
ShowCustomAlert.show(context, new ShowCustomAlert.OnDismissListener() {
    @Override
    public void onDismiss() {
        // Aksi saat dialog alert ditutup
    }
});

// Atau dengan pesan kustom
ShowCustomAlert.show(context, "Pesan Anda", new ShowCustomAlert.OnDismissListener() {
    @Override
    public void onDismiss() {
        // Aksi saat dialog alert ditutup
    }
});
```

### Menggunakan Builder (Kustomisasi Penuh)

```java
new ew ShowCustomAlert.Builder(context)
    .setTitle("Judul Alert")
    .setMessage("Pesan kustom Anda")
    .setImageResource(R.drawable.ic_warning)
    .setCardBackgroundColor(R.color.bg_card)
    .setButtonBackgroundColor(R.color.bg_btn)
    .setButtonTextColorResource(R.color.text_btn)
    .setOnDismissListener(() -> {
        // Aksi saat dialog alert ditutup
    })
    .show();
```

### Kustomisasi Gambar

```java
// Menggunakan resource drawable
new ShowCustomAlert.Builder(context)
    .setImageResource(R.drawable.ic_success)
    .show();

// Menggunakan Drawable
Drawable drawable = ContextCompat.getDrawable(context, R.drawable.ic_error);
new ShowCustomAlert.Builder(context)
    .setImageDrawable(drawable)
    .show();
```

## API Reference

### Metode Statis

| Metode | Deskripsi |
|--------|-----------|
| `show(Context)` | Menampilkan dialog alert dengan pesan default |
| `show(Context, String)` | Menampilkan dialog alert dengan pesan kustom |
| `show(Context, OnDismissListener)` | Menampilkan dialog alert dengan listener |
| `show(Context, String, OnDismissListener)` | Menampilkan dialog alert dengan pesan dan listener |

### Builder Methods

| Metode | Deskripsi |
|--------|-----------|
| `setMessage(String)` | Mengatur pesan alert |
| `setTitle(String)` | Mengatur judul alert |
| `setCardBackground(Drawable)` | Mengatur background card dengan Drawable |
| `setCardBackgroundColor(int)` | Mengatur background card dengan resource color |
| `setButtonBackground(Drawable)` | Mengatur background tombol dengan Drawable |
| `setButtonBackgroundColor(int)` | Mengatur background tombol dengan resource color |
| `setButtonTextColor(int)` | Mengatur warna text tombol (Color.INT) |
| `setButtonTextColorResource(int)` | Mengatur warna text tombol dengan resource color |
| `setImageDrawable(Drawable)` | Mengatur gambar dengan Drawable |
| `setImageResource(int)` | Mengatur gambar dengan resource drawable |
| `setOnDismissListener(OnDismissListener)` | Mengatur listener saat dialog alert ditutup |
| `show()` | Menampilkan dialog alert |

## Contoh Lengkap

```java
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Contoh 1: Dialog alert sederhana
        findViewById(R.id.btn_simple).setOnClickListener(v -> {
            ShowCustomAlert.show(this);
        });

        // Contoh 2: Dialog alert dengan pesan kustom
        findViewById(R.id.btn_custom_message).setOnClickListener(v -> {
            ShowCustomAlert.show(this, "Data berhasil disimpan!");
        });

        // Contoh 3: Dialog alert dengan listener
        findViewById(R.id.btn_with_listener).setOnClickListener(v -> {
            ShowCustomAlert.show(this, "Apakah Anda yakin?", new ShowCustomAlert.OnDismissListener() {
                @Override
                public void onDismiss() {
                    finish();
                }
            });
        });

        // Contoh 4: Dialog alert dengan kustomisasi penuh
        findViewById(R.id.btn_full_custom).setOnClickListener(v -> {
            new ShowCustomAlert.Builder(this)
                .setTitle("Success!")
                .setMessage("Data berhasil disimpan ke database.")
                .setImageResource(R.drawable.ic_success)
                .setCardBackgroundColor(R.color.white)
                .setButtonBackgroundColor(R.color.primary)
                .setButtonTextColorResource(R.color.white)
                .setOnDismissListener(new ShowCustomAlert.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        Toast.makeText(MainActivity.this, "Dialog alert ditutup", Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
        });
    }
}
```

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## License

```
MIT License

Copyright (c) 2026 Muhammad Abid

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```

## Author

**Muhammad Abid Misbahuddin**

## Changelog

### Version 1.0.0
- Initial release
- Basic dialog functionality
- Builder pattern for customization
- Support for custom images, colors, and listeners
