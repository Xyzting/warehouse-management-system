# WMS Mobile App

Aplikasi Android **Warehouse Management System** untuk operator gudang.

**Tugas**: Pemrograman Mobile — Pertemuan 11
**Universitas Teknologi Bandung** — Teknik Informatika

## Tim

| Nama | NIM |
|------|-----|
| M. Hafizul Hadi | 24552011218 |
| Nazka Yasir Alman Paluthi | 24552011087 |
| Reyhan Fathir Alamsyah | 24552011032 |
| Radhitias Salman Syam | 24552011112 |

## Studi Kasus

Aplikasi mobile WMS yang nyambung ke project **OOAD** (studi kasus sama). Lihat use case diagram di folder pertemuan yang sama: `../01_use_case_diagram.drawio`.

### Fitur Utama (sesuai Use Case Diagram OOAD)

| Modul | Fitur |
|-------|-------|
| User Management | Login, Logout, View Profile |
| Master Data | View Item Catalog, Search Item |
| Inbound | Create Goods Receipt, Scan Barcode |
| Outbound | Create Goods Issue |
| Inventory | View Stock, View Stock Movement |
| Reporting | Generate Stock Report |

## Tech Stack

- **Bahasa**: Kotlin 1.9
- **Min SDK**: 26 (Android 8.0 Oreo)
- **Target SDK**: 34 (Android 14)
- **UI**: XML Layouts + Material Components 3
- **Build**: Gradle 8.2 + Android Gradle Plugin 8.2
- **Architecture**: View Binding + sederhana (MVC). Bisa di-upgrade ke MVVM nanti.

## Cara Build & Run

### Prasyarat
1. **Android Studio Hedgehog** (2023.1.1) atau lebih baru — [Download](https://developer.android.com/studio)
2. **JDK 17** (sudah include di Android Studio)

### Steps
1. Clone repo:
   ```bash
   git clone https://github.com/<username>/wms-mobile-app.git
   ```
2. Buka Android Studio → **File → Open** → pilih folder `wms-mobile-app`
3. Tunggu **Gradle sync** (3-10 menit pertama kali — download dependencies)
4. Klik tombol Run hijau (▶) atau tekan **Shift+F10**
5. Pilih emulator atau device fisik

### Login Demo

| Username | Password | Role |
|----------|----------|------|
| `operator` | `123` | Operator |
| `supervisor` | `123` | Supervisor |
| `admin` | `123` | Admin |

## Struktur Folder

```
wms-mobile-app/
├── app/
│   ├── src/main/
│   │   ├── AndroidManifest.xml
│   │   ├── java/com/wms/mobile/
│   │   │   ├── MainActivity.kt              ← Login screen
│   │   │   ├── DashboardActivity.kt         ← Main menu
│   │   │   └── data/model/                  ← Data classes (sesuai OOAD)
│   │   │       ├── User.kt                  ← User, Role
│   │   │       ├── Item.kt                  ← Item, Category, Supplier
│   │   │       ├── Stock.kt                 ← Stock, Location, StockMovement
│   │   │       └── TransactionDocument.kt   ← GoodsReceipt, GoodsIssue, dll
│   │   └── res/
│   │       ├── layout/                      ← UI XML
│   │       ├── values/                      ← strings, colors, themes
│   │       ├── drawable/                    ← icons
│   │       └── mipmap-anydpi-v26/           ← launcher icon
│   ├── build.gradle.kts                     ← Module config
│   └── proguard-rules.pro
├── gradle/
│   └── libs.versions.toml                   ← Dependency versions
├── build.gradle.kts                         ← Root config
├── settings.gradle.kts
├── gradle.properties
├── README.md (file ini)
└── .gitignore
```

## TODO — Fitur Belum Diimplementasi

Skeleton ini baru handle Login + Dashboard. Tinggal diisi:

- [ ] **ItemListActivity** — RecyclerView untuk View Item Catalog + Search
- [ ] **GoodsReceiptActivity** — Form Create Goods Receipt + Scan Barcode (CameraX/ML Kit)
- [ ] **GoodsIssueActivity** — Form Create Goods Issue
- [ ] **StockListActivity** — RecyclerView untuk View Stock
- [ ] **StockMovementActivity** — RecyclerView untuk View Stock Movement (history)
- [ ] **ReportActivity** — Generate Stock Report
- [ ] **ProfileActivity** — View Profile + Logout button
- [ ] **Repository layer** — abstraksi data access (mock dulu, nanti ke API/Room)
- [ ] **Database lokal** — Room atau SharedPreferences buat persist data
- [ ] **API integration** (opsional) — kalau ada backend nyata

## Catatan

- File `local.properties` (berisi SDK path lokal) **tidak di-commit** karena beda di tiap mesin. Android Studio bikin otomatis pas pertama kali Open project.
- Folder `build/`, `.idea/`, `*.iml` adalah generated files yang **tidak di-commit** (sudah di-set di `.gitignore`).
- Pas pertama clone, gradle wrapper akan re-download dependencies (perlu internet stabil).
- Kalau gradle sync error karena versi mismatch — di Android Studio: **File → Sync Project with Gradle Files** atau **File → Invalidate Caches & Restart**.

## Lisensi

Tugas akademik. Internal kelompok.
