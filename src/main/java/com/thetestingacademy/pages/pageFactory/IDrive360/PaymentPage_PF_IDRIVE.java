package com.thetestingacademy.pages.pageFactory.IDrive360;

import com.thetestingacademy.base.CommonToAllPage;

import com.thetestingacademy.utils.WaitHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class PaymentPage_PF_IDRIVE extends CommonToAllPage {

    WebDriver driver;

    public PaymentPage_PF_IDRIVE(WebDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ✅ Payment Information Fields
    @FindBy(xpath = "//iframe[contains(@name, 'stripe_checkout_app') or contains(@title,'payment')]")
    WebElement paymentIframe;

    @FindBy(name = "cardnumber")
    WebElement cardNumberInput;

    @FindBy(name = "exp-date")
    WebElement expiryDateInput;

    @FindBy(name = "cvc")
    WebElement cvcInput;

    @FindBy(id = "upgradeaddress")
    WebElement billingAddressInput;

    @FindBy(xpath = "(//select[@id='countryname'])[1]")
    WebElement countryDropdown;

    // ✅ Corrected XPath for State / Province dropdown
    @FindBy(xpath = "(//select[@id='statename'])[1]")
    WebElement stateDropdown;


    @FindBy(xpath = "//input[@id='upgradezipcode']")
    WebElement postalCodeInput;

    // ✅ Pricing Terms Checkbox & Error Message
    @FindBy(xpath = "(//span[@class='id-checkmark'])[3]")
    WebElement agreeTermsCheckbox;


    // ✅ Card Error Message (Displayed after invalid/test card submission)
    @FindBy(xpath = "//div[contains(@class,'error') and contains(text(),'Your card was declined')]")
    WebElement cardErrorMsg;


    // ✅ Upgrade Button
    @FindBy(id = "frm-btn1")
    WebElement upgradeButton;


    // ✅ Methods to interact with elements
    public void fillCardDetails(String card, String expiry, String cvc) {

        WaitHelpers.waitJVM(2000);
        driver.switchTo().frame(paymentIframe);
        enterInput(cardNumberInput, card);
        enterInput(expiryDateInput, expiry);
        enterInput(cvcInput, cvc);
        WaitHelpers.waitJVM(2000);
        driver.switchTo().defaultContent();

    }


    public void enterBillingAddress(String address) {
        enterInput(billingAddressInput, address);
    }

    public void enterPostalCode(String postalCode) {
        enterInput(postalCodeInput, postalCode);
    }

    public void selectCountry(String countryName) {
        Select select = new Select(countryDropdown);
        select.selectByValue(countryName);

//        List<WebElement> allCountry = select.getOptions();
//        for (WebElement c : allCountry) {
//            System.out.println("Country Option: " + c.getText());
//        }

//        // ---- Different ways to select ----
//        // 1️⃣ By visible text
//        countrySelect.selectByVisibleText("United States");
//
//        // 2️⃣ By value (from <option value="CA">)
//        stateSelect.selectByValue("CA");
//
//        // 3️⃣ By index (starting from 0)
//        // stateSelect.selectByIndex(5);

    }


    public void selectState(String stateValue) {

//        wait.until(ExpectedConditions.visibilityOf(stateDropdown));
        Select select = new Select(stateDropdown);
        select.selectByVisibleText(stateValue);


        // ---- Different ways to select ----
//        // 1️⃣ By visible text
//        countrySelect.selectByVisibleText("United States");
//
//        // 2️⃣ By value (from <option value="CA">)
//        stateSelect.selectByValue("CA");
//
//        // 3️⃣ By index (starting from 0)
//        // stateSelect.selectByIndex(5);


    }

    public void agreeToTerms() {
        if (!agreeTermsCheckbox.isSelected()) {
            clickElement(agreeTermsCheckbox);
        }
    }

    public void clickUpgradeButton() {
        clickElement(upgradeButton);
    }


    // ---------- Complete Payment Form ----------

    public void fillPaymentForm(String billingAddress, String country, String state, String postalCode) {
        enterBillingAddress(billingAddress);
        selectCountry(country);
//        selectState(state);
        enterPostalCode(postalCode);
        agreeToTerms();
        clickUpgradeButton();
    }


    // ✅ Method to capture error text
    public String getCardErrorMessage() {
        try {
            wait.until(ExpectedConditions.visibilityOf(cardErrorMsg));
            return getText(cardErrorMsg);
        } catch (Exception e) {
            System.out.println("⚠️ Card error message not found: " + e.getMessage());
            return "";
        }
    }


}
