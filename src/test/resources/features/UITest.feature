Feature: Hepsiburada UI test automation case

  @UITest
  Scenario: Hepsiburada UI Test
    Given User navigates to "hepsiburada_url"
    When User on "Üye Giriş" page login with "username" and "password"
    And User on "Hepsiburada" page searches for "Kitap"
    And User on "Kitap" page adds the second book of the page
    And User on "Kitap" page goes "Sepetim" page
    And User on "Sepetim" page clicks "Alışverişi tamamla"
    And User on "Teslimat Bilgileri" page navigates "Devam et"
    And User on "Ödeme Bilgileri" page clicks on the following by order
      | click01 | Anında Havale  |
      | click02 | Ziraat Bankası |
      | click03 | Devam et       |
    Then User should on "Sipariş Özeti" page
    And Ödeme Bilgileri page selected bank should be same with on Sipariş Özeti page bank