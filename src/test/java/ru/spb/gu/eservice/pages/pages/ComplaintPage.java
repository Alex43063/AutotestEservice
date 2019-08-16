package ru.spb.gu.eservice.pages.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ComplaintPage {
    public WebDriver driver;
    public WebDriverWait wait;

    public ComplaintPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    By divPreloader = By.id("preloader-div");

    @FindBy(xpath = "//*[@id=\"uo-user-chosenApplication\"]/div/div[1]/div[2]/a[3]")
            private WebElement buttonSendComplaint;
    public void openComplaintFormToSend(){
        buttonSendComplaint.click();
    }

    /*1st step complaint*/

    By contolOpenFirstStep = By.id("content-header");

    public void fillFirstStepCreateComplaint(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(contolOpenFirstStep));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(divPreloader));
        buttonNext.click();
    }

    /*2nd step complaint*/
    @FindBy (xpath = "//*[@id=\"content\"]/div/fieldset/div[2]/div/div[1]/div[2]/div[4]/label/i")
    private WebElement checkboxPassportFromSpb;
    @FindBy (xpath = "//*[@id=\"content\"]/div/fieldset/div[2]/div/div[1]/div[2]/div[6]/span[1]/span[1]/span/span[2]/b")
    private WebElement buttonDropListOVD;
    @FindBy (xpath = "/html/body/span/span/span[1]/input")
    private WebElement inputOVD;

    By contolOpenSecondStep = By.id("content-header");
    By waitOpenLiOVD = By.xpath("//li[contains(text(), 'ТП №68 отдела УФМС России по Санкт-Петербургу и Ленинградской обл. в Приморском р-не гор.Санкт-Петербурга')]");

    public void fillSecondStepCreateComplaint() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(contolOpenSecondStep));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(divPreloader));
        checkboxPassportFromSpb.click();
        buttonDropListOVD.click();
        inputOVD.sendKeys("ТП №68 отдела УФМС России по Санкт-Петербургу и Ленинградской обл. в Приморском р-не гор.Санкт-Петербурга");
        wait.until(ExpectedConditions.visibilityOfElementLocated(waitOpenLiOVD));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(divPreloader));
        inputOVD.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(divPreloader));
        buttonNext.click();
    }

    /*3th step complaint*/

    By contolOpenThirdStep = By.id("content-header");

    public void fillThirdStepCreateComplaint() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(contolOpenThirdStep));
        buttonNext.click();
    }

    /*4th step complaint*/
    @FindBy(xpath = "//a[contains(text(), 'Введите адрес')]")
    private WebElement buttonEnterAddress;
    @FindBy(xpath = "//*[@id=\"content\"]/div/fieldset/div[3]/div/div[1]/div[1]/div/span[1]/span[1]/span/span[2]/b")
    private WebElement buttonDropListAddressString;
    @FindBy(xpath = "/html/body/span/span/span[1]/input")
    private WebElement inputAddressString;
    @FindBy(xpath = "//input[@name=\"addressBuilding\"]")
    private WebElement inputNumberOfHouse;
    @FindBy(xpath = "//input[@name=\"addressAppartment\"]")
    private WebElement inputNumberOfFlat;
    @FindBy(xpath = "//input[@name=\"addressIndex\"]")
    private WebElement inputIndex;
    @FindBy(xpath = "//a[contains(text(), 'Сохранить')]")
    private WebElement buttonSaveAddress;


    By contolOpenFourthStep = By.id("content-header");
    By waitOpenLiAddress = By. xpath("//li[contains(text(), 'Санкт-Петербург г, Савушкина ул')]");

    public void fillFourthStepCreateComplaint() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(contolOpenFourthStep));
        buttonEnterAddress.click();
        buttonDropListAddressString.click();
        inputAddressString.sendKeys("Санкт-Петербург г, Савушкина ул");
        wait.until(ExpectedConditions.visibilityOfElementLocated(waitOpenLiAddress));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(divPreloader));
        inputAddressString.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(divPreloader));
        inputNumberOfHouse.sendKeys("36");
        inputNumberOfFlat.sendKeys("22");
        inputIndex.sendKeys("122131");
        buttonSaveAddress.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(divPreloader));
        buttonNext.click();
    }

    /*5th step complaint*/
    @FindBy(xpath = "//*[@id=\"content\"]/div/fieldset/div/div[2]/div[1]/div/span[1]/span[1]/span/span[2]/b")
            private WebElement buttonDropLiTypeViolation;
    @FindBy(xpath = "/html/body/span/span/span[1]/input")
            private WebElement inputTypeViolation;
     @FindBy(xpath = "//*[@id=\"content\"]/div/fieldset/div/div[2]/div[4]/div/span[1]/textarea")
            private WebElement inputSummmaryViolation;

    By contolOpenFifthStep = By.id("content-header");
    By waitOpenLiTypeViolation = By.xpath("//li[contains(text(), 'нарушение срока предоставления услуги')]");

    public void fillFifthStepCreateComplaint(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(contolOpenFifthStep));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(divPreloader));
        buttonDropLiTypeViolation.click();
        inputTypeViolation.sendKeys("нарушение срока предоставления услуги");
        wait.until(ExpectedConditions.visibilityOfElementLocated(waitOpenLiTypeViolation));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(divPreloader));
        inputTypeViolation.sendKeys(Keys.ENTER);
        inputSummmaryViolation.sendKeys("Test_time_end");
        buttonNext.click();
    }

    /*Buttons for all steps*/
    @FindBy (xpath = "//a[contains(text(), 'Далее')]")
    private WebElement buttonNext;
    @FindBy (xpath = "//a[contains(text(), 'Назад')]")
    private WebElement buttonGoBackOneStep;
    @FindBy (xpath = "//a[@class=\"btn btn-default save-template\"]")
    private WebElement buttonSaveAsTemplate;
    @FindBy (xpath = "//a[@class=\"btn btn-default save-draft\"]")
    private WebElement buttonSaveAsDraft;
}
