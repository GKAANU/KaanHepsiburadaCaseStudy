Feature: Hepsiburada UI test automation case

  @UITest
  Scenario: "Anında Havale" sayfasındaki seçilen banka ile "Sipariş Özet" sayfasındaki bankanın eşleşmesi
    Given User navigates to "hepsiburada_url"
    When User on "Üye Giriş" page login with "username" and "password"
    And User on "Hepsiburada" page searches for "Kitap"
    And User on "Kitap" page adds the second book of the page
    And User on "Kitap" page goes "Sepetim" page
    And User on "Sepetim" page clicks "Alışverişi tamamla"
    And User on "Teslimat Bilgileri" page picks exist "a" address
    And User on "Teslimat Bilgileri" page clicks "Devam et"
    And User on "Ödeme Bilgileri" page clicks on the following by order
      | click01  | Anında Havale      |
      | click02  | Ziraat Bankası |
      | click03 | Devam et     |
    Then User on "Sipariş Özeti" page
    And Verify on Ödeme Bilgileri page picked bank same on Sipariş Özeti page bank