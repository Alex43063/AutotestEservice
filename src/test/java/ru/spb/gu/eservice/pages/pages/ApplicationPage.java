package ru.spb.gu.eservice.pages.pages;

import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApplicationPage {
    public WebDriver driver;
    public WebDriverWait wait;

    public ApplicationPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    @FindBy(xpath = "//*[@id=\"uo-user-chosenApplication\"]/div/div[3]/div[2]/a") /* Edit Xpath*/
        private WebElement buttonGoBack;

    @FindBy(xpath = "//*[@id=\"uo-user-applications-drafts-table\"]/tbody/tr[1]/td[1]/a") /* Edit Xpath*/
        private WebElement buttonNumbertFirstApplicationInList;

    @FindBy(xpath = "//*[@id=\"menu-office-applications\"]/div/ul/li[2]/a")
        private WebElement linkDraftApplication;

    /* Form to Filter by DraftApplication*/
    @FindBy(id = "uo-dr-filter-fileName")
            private WebElement nameOfDraftApplication;
    @FindBy(xpath = "//*[@id=\"uo-user-applications-accordion\"]/form/fieldset/div[1]/div[2]/span/span[1]/span")
            private WebElement inputSelectServiseName;
    @FindBy (id = "uo-dr-filter-dateStart")
            private WebElement inputDateStart;
    @FindBy (id="uo-dr-filter-dateEnd")
            private WebElement inputDateEnd;
    @FindBy (id = "uo-dr-filter-clear-all")
            private WebElement buttonClearAllFilter;

    /*Fill form create and send application */
    /*1st step test service */
    @FindBy(xpath = "//select[@class='select2-hidden-accessible']")
            private WebElement selectorProvisionService;
    @FindBy(xpath="//*[@id=\"content\"]/div/fieldset/div/div[1]/div/span[1]/span[1]/span/span[2]/b")
            private WebElement buttonDropList;
    @FindBy(xpath = "/html/body/span/span/span[1]/input")
            private WebElement selectInput;
    @FindBy(xpath = "//*[@id=\"content\"]/div/fieldset/div/div[2]/div/label[1]/input")
            private WebElement checkboxNewTicket;
    @FindBy (xpath = "//*[@id=\"content\"]/div/fieldset/div/div[2]/div/label[2]/input")
    private WebElement checkboxCancellationTicket;

    By controlClickCheckBox = By.xpath("//*[@id=\"content\"]/div/fieldset/div/div[2]/div/label[1]");

    public void fillFirstStepCreateApplication() throws  InterruptedException {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(divPreloader));
        buttonDropList.click();
        selectInput.sendKeys("Выдача разрешения");
        selectInput.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(divPreloader));
        wait.until(ExpectedConditions.elementToBeClickable(controlClickCheckBox));
        checkboxNewTicket.click(); /*Требуется выдача охотничьего билета*/
        //checkboxCancellationTicket.click(); /*Требуется аннулирование охотничьего билета*/
        buttonNext.click();
    }

    /*2nd step test service*/

    By contolOpenSecondStep = By.id("content-header");

    public void fillSecondStepCreateApplication(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(contolOpenSecondStep));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(divPreloader));
        buttonNext.click();
    }

    /*3rd step test service*/
    @FindBy (xpath = "//*[@id=\"content\"]/div/fieldset/div[2]/div/div[1]/div[2]/div[4]/label/i")
            private WebElement checkboxPassportFromSpb;
    @FindBy (xpath = "//*[@id=\"content\"]/div/fieldset/div[2]/div/div[1]/div[2]/div[6]/span[1]/span[1]/span/span[2]/b")
            private WebElement buttonDropListOVD;
    @FindBy (xpath = "/html/body/span/span/span[1]/input")
            private WebElement inputOVD;

    By contolOpenThirdStep = By.id("content-header");
    By waitOpenLiOVD = By.xpath("//li[contains(text(), 'ТП №68 отдела УФМС России по Санкт-Петербургу и Ленинградской обл. в Приморском р-не гор.Санкт-Петербурга')]");

    public void fillThirdStepCreateApplication() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(contolOpenThirdStep));
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

    /*4th step test service*/

    By contolOpenFourthStep = By.id("content-header");

    public void fillFourthStepCreateApplication() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(contolOpenFourthStep));
        buttonNext.click();
    }

    /*5th step test service*/
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


    By contolOpenFifthStep = By.id("content-header");
    By waitOpenLiAddress = By. xpath("//li[contains(text(), 'Санкт-Петербург г, Савушкина ул')]");

    public void fillFifthStepCreateApplication() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(contolOpenFifthStep));
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
    /*6th step test service*/
    @FindBy(xpath = "//*[@id=\"content\"]/div/fieldset/div/div[1]/div/span[1]/span[1]/span/span[2]/b")
            private WebElement buttonDropListKnowMinRule;
    @FindBy(xpath = "//*[@id=\"content\"]/div/fieldset/div/div[3]/div[1]/div/span[1]/span[1]/span/span[2]/b")
            private WebElement buttonDropListTypeTicket;
    @FindBy(xpath = "/html/body/span/span/span[1]/input")
            private WebElement inputKnowMinRule;
    @FindBy(xpath = "/html/body/span/span/span[1]/input")
            private WebElement inputTypeTicket;
    @FindBy(xpath = "//*[@id=\"content\"]/div/fieldset/div/div[2]/div/div/div/input")
            private WebElement inputMarkAuto;

    By contolOpenSixthStep = By.id("content-header");
    By waitOpenLiMinRules = By.xpath("//li[contains(text(), 'ознакомлен')]");
    By waitOpenLiTypeTicket = By.xpath("//li[contains(text(), 'Новый охотничий билет')]");

    public void fillSixthStepCreateApplication() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(contolOpenSixthStep));
        buttonDropListKnowMinRule.click();
        inputKnowMinRule.sendKeys("ознакомлен");
        wait.until(ExpectedConditions.visibilityOfElementLocated(waitOpenLiMinRules));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(divPreloader));
        inputKnowMinRule.sendKeys(Keys.ENTER);
        inputMarkAuto.sendKeys("BMW");
        buttonDropListTypeTicket.click();
        inputTypeTicket.sendKeys("Новый охотничий билет");
        wait.until(ExpectedConditions.visibilityOfElementLocated(waitOpenLiTypeTicket));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(divPreloader));
        inputTypeTicket.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(divPreloader));/* Сделать для него отдельную процедуру*/
        buttonNext.click();
    }

    /*7th step test service*/
    @FindBy(xpath = "//*[@id=\"content\"]/div/fieldset/div/div[2]/div/div[3]/span[2]")
            private WebElement buttonAddDocument;
    @FindBy(xpath = "//input[@class=\"file-input-hide\"]")
            private WebElement inputFileDocument;
    @FindBy(xpath = "//button[contains(text(), 'Сохранить')]")
            private WebElement buttonSaveDocument;

    By controlOpenSeventhStep = By.id("content-header");
    By controlOpenModalWindow = By.xpath("//div[@class=\"modal-dialog modal-content\"]");
    By controlFileContainer = By.xpath("//tbody[@class=\"file-container\"]");


    public void fillSeventhStepCreateApplication() throws  InterruptedException {
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//*[@id=\"dynamic-menu\"]/div/div[7]/div/div/span")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(controlOpenSeventhStep));
        buttonAddDocument.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(controlOpenModalWindow));
        inputFileDocument.sendKeys("C:\\Users\\davydov\\IdeaProjects\\EservicePortal\\src\\test\\assert\\files\\passport.jpg");
        wait.until(ExpectedConditions.visibilityOfElementLocated(controlFileContainer));
        buttonSaveDocument.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(divPreloader));
        buttonNext.click();
    }

    /*8th step test service*/
    @FindBy (xpath = "//span[contains(text(), 'Достоверность сообщенных сведений подтверждаю.')]")
            private WebElement checkboxCorrectData;
    @FindBy (xpath = "//a[contains(text(), 'Подать заявление')]")
            private WebElement buttonSendApplication;

    By controlOpenEighthStep = By.id("content-header");

    public void fillEighthStepCreateApplication() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(controlOpenEighthStep));
        checkboxCorrectData.click();
        buttonSendApplication.click();
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





    By divApplication = By.id("uo-item-el");
    By divPreloader = By.id("preloader-div");
    By hDraftAppl = By.xpath("//h4[contains(text(), 'Черновики заявлений')]");
    By divApplicationForm = By.id("authorize_table");


    public void controlOpenPageApplication(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(divApplication));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(divPreloader));
    }
    public void goBackToListApplication(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"uo-user-chosenApplication\"]/div/div[3]/div[2]/a")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(divPreloader));
        Actions builder = new Actions(driver);
        builder.doubleClick(buttonGoBack).build().perform();
    }

    public void openDraftApplicationList(){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(divPreloader));
        linkDraftApplication.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(hDraftAppl));
    }

    public void openDraftApplication(){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(divPreloader));
        buttonNumbertFirstApplicationInList.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(divApplicationForm));
    }

    public void fillFilter (){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(divPreloader));
        inputDateStart.sendKeys("12072019");
        inputDateEnd.sendKeys("09082019");
        inputDateEnd.sendKeys(Keys.ENTER);
    }

}
