package ru.spb.gu.eservice.pages.tests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.spb.gu.eservice.pages.EntryPoints;
import ru.spb.gu.eservice.pages.pages.ApplicationPage;
import ru.spb.gu.eservice.pages.pages.ComplaintPage;
import ru.spb.gu.eservice.pages.pages.LoginPage;
import ru.spb.gu.eservice.pages.pages.MainPage;
import sun.applet.Main;
import utils.BaseSettings;

public class LoginTest extends BaseSettings {

    @Test
    public void loginTest() throws InterruptedException{
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        MainPage mainPage = PageFactory.initElements(driver,MainPage.class);
        ApplicationPage applicationPage = PageFactory.initElements(driver, ApplicationPage.class);
        ComplaintPage complaintPage = PageFactory.initElements(driver, ComplaintPage.class);


        loginPage.openLoginPage();
        loginPage.login();
        mainPage.controlOpenMainPage();


        // Next test edit personal data
//        mainPage.openPersonalData();
//        mainPage.editPersonalDate();
//        loginPage.loginOnlyPassword();


        // Next test work with application
        mainPage.openApplication();
        applicationPage.controlOpenPageApplication();
//        applicationPage.goBackToListApplication();


        /*Next test draft*/

//        applicationPage.openDraftApplicationList();
//        //applicationPage.fillFilter();
//        applicationPage.openDraftApplicationList();
//        applicationPage.openDraftApplication();
//        applicationPage.fillFirstStepCreateApplication();
//        applicationPage.fillSecondStepCreateApplication();
//        applicationPage.fillThirdStepCreateApplication();
//        applicationPage.fillFourthStepCreateApplication();
//        applicationPage.fillFifthStepCreateApplication();
//        applicationPage.fillSixthStepCreateApplication();
//        applicationPage.fillSeventhStepCreateApplication();
//        applicationPage.fillEighthStepCreateApplication();

        /* Next test send complaint*/
        complaintPage.openComplaintFormToSend();
        complaintPage.fillFirstStepCreateComplaint();
        complaintPage.fillSecondStepCreateComplaint();
        complaintPage.fillThirdStepCreateComplaint();
        complaintPage.fillFourthStepCreateComplaint();
        complaintPage.fillFifthStepCreateComplaint();

    }

}
