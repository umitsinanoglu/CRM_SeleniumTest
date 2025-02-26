# Web Uygulamaları için Selenium Test Çerçevesi

Bu proje, her türlü web uygulaması için otomasyon testlerini içeren örnek bir projedir. Java tabanlı Selenium WebDriver, Cucumber ile BDD (Davranış Odaklı Geliştirme) ve JUnit kullanılarak hazırlanmış bu framework, testlerin yapılandırılabilir, ölçeklenebilir ve sürdürülebilir olmasını amaçlamaktadır.

---

## İçindekiler

- [Amaç](#amaç)
- [Özellikler](#özellikler)
- [Teknolojiler](#teknolojiler)
- [Ön Koşullar](#ön-koşullar)
- [Kurulum ve Başlangıç](#kurulum-ve-başlangıç)
- [Testlerin Çalıştırılması](#testlerin-çalıştırılması)
- [Proje Yapısı](#proje-yapısı)
- [Konfigürasyon](#konfigürasyon)
- [Raporlama](#raporlama)
- [Katkıda Bulunma](#katkıda-bulunma)
- [Lisans](#lisans)
- [İletişim](#iletişim)

---

## Amaç

Projenin temel amacı, Java ile Selenium WebDriver ve Cucumber kullanarak BDD yaklaşımını temel alan otomasyon testleri için sağlam bir iskelet (seed) oluşturmaktır. Bu yapı sayesinde:
- Test senaryoları kolayca yazılabilir ve genişletilebilir.
- Test çalıştırmaları, JUnit entegrasyonu sayesinde standart hale getirilir.
- Proje, her türlü web uygulamasının test otomasyonu için referans bir örnek sunar.

---

## Özellikler

- **Davranış Odaklı Geliştirme (BDD):** Cucumber ile test senaryoları doğal dilde yazılabilir.
- **Selenium WebDriver Entegrasyonu:** Gerçek tarayıcı testleri için Selenium kullanımı.
- **JUnit Entegrasyonu:** Testlerin standart şekilde çalıştırılması ve raporlanması.
- **Maven Tabanlı Yapı:** Proje bağımlılıkları ve derleme işlemleri için Maven kullanımı.
- **Raporlama:** ExtentReports entegrasyonu ile detaylı test raporları oluşturulabilir.
- **Otomatik WebDriver Yönetimi:** WebDriverManager ile tarayıcı sürücüleri otomatik olarak yönetilir.
- **Loglama:** Log4j ile test çalışmaları sırasında detaylı loglama yapılabilir.

---

## Teknolojiler

- **Java 17**
- **Selenium WebDriver 4.28.1**
- **Cucumber (Java & TestNG/JUnit) 7.21.1**
- **JUnit 4 ve JUnit Jupiter (JUnit 5) 5.10.2**
- **Maven**
- **WebDriverManager 5.9.3**
- **ExtentReports 5.1.1 & extentreports-cucumber7-adapter 1.14.0**
- **Log4j (log4j-slf4j2-impl 2.20.0)**

---

## Ön Koşullar

- **Java 17:** Projeyi çalıştırmak için Java 17 yüklü olmalıdır.
- **Maven:** Maven kurulumu gereklidir.
- **Tarayıcı Sürücüleri:** ChromeDriver (Google Chrome) veya GeckoDriver (Mozilla Firefox) gibi ilgili tarayıcı sürücülerinin sistem PATH'inde veya proje konfigürasyonunda bulunması gerekir.

---

## Kurulum ve Başlangıç

1. **Repo'yu Klonlayın:**

   ```bash
   git clone https://github.com/umitsinanoglu/CRM_SeleniumTest.git
   cd CRM_SeleniumTest
