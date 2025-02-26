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

2. **Bağımlılıkları Yükleyin:**

   Maven kullanarak proje bağımlılıklarını yüklemek için:

   ```bash
   mvn clean install
   ```

   Bu işlem, proje derlemesi ve testler için gerekli tüm bağımlılıkları indirip yapılandıracaktır.

---

## Testlerin Çalıştırılması

Testleri çalıştırmak için terminalden proje dizininde aşağıdaki komutu kullanabilirsiniz:

```bash
mvn test
```

Bu komut, Maven Surefire Plugin aracılığıyla tanımlı tüm test sınıflarını çalıştıracaktır. Test senaryoları, Cucumber feature dosyaları ile tanımlı olup, JUnit veya TestNG entegrasyonu sayesinde çalıştırılır.

---

## Proje Yapısı

Proje, standart Maven dizin yapısını kullanmaktadır:

```
WebUygulamalarıSeleniumTest/
├── .idea/                 # IntelliJ IDEA proje ayarları
├── src/
│   └── test/
│       ├── java/          # Java tabanlı test kodları, Cucumber adımlarının ve test koşucularının bulunduğu dizin
│       └── resources/     # Cucumber feature dosyaları ve diğer test kaynakları
├── .gitignore             # Git tarafından izlenmeyecek dosya ve klasörler
├── pom.xml                # Maven proje konfigürasyon dosyası
└── README.md              # Bu dosya
```

---

## Konfigürasyon

- **pom.xml:** Projede kullanılan kütüphane ve plugin versiyonları, Java sürümü, test frameworkleri gibi temel ayarlar burada yapılandırılmıştır.
- **WebDriver Yönetimi:** `WebDriverManager` kütüphanesi sayesinde, tarayıcı sürücüleri otomatik olarak indirip yapılandırılır.
- **Loglama:** Log4j entegrasyonu ile test çalışmaları sırasında detaylı loglar alınabilir. Log ayarları için proje içindeki konfigürasyon dosyalarını (örneğin, `log4j2.xml` gibi) inceleyebilirsiniz.

---

## Raporlama

Projede ExtentReports kullanılarak test raporları oluşturulabilmektedir. Test çalışması sonrası, ExtentReports adapter sayesinde detaylı HTML raporları elde edebilirsiniz. Rapor dosyalarının konumunu ve raporlama detaylarını, test koşucu konfigürasyon dosyalarından veya ExtentReports adapter dokümantasyonundan öğrenebilirsiniz.

---

## Katkıda Bulunma

Projeye katkıda bulunmak isterseniz, lütfen aşağıdaki adımları takip edin:

1. **Fork:** Projeyi GitHub üzerinde fork'layın.
2. **Branch Oluşturun:** Yeni bir özellik veya hata düzeltmesi için yeni bir branch oluşturun.
3. **Değişiklik Yapın:** İlgili değişiklikleri yapın ve commit edin.
4. **Pull Request Gönderin:** Değişikliklerinizi ana projeye entegre etmek üzere bir pull request oluşturun.

Her türlü öneri, iyileştirme ve hata bildirimi için katkılarınız memnuniyetle karşılanacaktır.

---

## Lisans

Bu projeye ait özel bir lisans bilgisi bulunmamaktadır. Projeyi kullanmadan veya dağıtmadan önce lisans konusunu netleştirmeniz önerilir. Kendi ihtiyaçlarınıza göre bir lisans ekleyebilirsiniz.

---

## İletişim

Herhangi bir soru veya geri bildirim için [umitsinanoglu](https://github.com/umitsinanoglu) GitHub profilinden ulaşabilirsiniz.

---

> **Not:** Projede yer alan versiyon numaraları ve bağımlılık sürümleri, `pom.xml` dosyasında tanımlı olan güncel değerlerdir. Gerekli durumlarda bu değerleri güncelleyerek en son sürümlerle çalışmayı tercih edebilirsiniz.
```
