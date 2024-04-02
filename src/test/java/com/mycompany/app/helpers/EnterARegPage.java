package com.mycompany.app.helpers;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class EnterARegPage extends PageObject {
    public static Target ENTER_A_REG_FIELD = Target.the("Enter a reg").locatedBy("//input[@data-test-id='vrm']");
    public static Target GET_STARTED = Target.the("Get Started").locatedBy("//button[@type='submit' ]//span[text()='Get started']");
    public static Target BANNER = Target.the("Accept All").locatedBy("//div[@data-test-id='banner-wrapper-with-blocker']");

    public static Target ERROR_MESSAGE = Target.the("Error meesage)").locatedBy("//div[contains(@class,'SubmitErrorAlertContainer')]//span");

}
