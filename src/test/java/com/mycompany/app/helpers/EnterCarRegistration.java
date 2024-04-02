package com.mycompany.app.helpers;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class EnterCarRegistration {

    public static Performable carReg(String carRegistrationNo){
        return Task.where("{0} enter car registration in the search field "+carRegistrationNo,
                Enter.theValue(carRegistrationNo)
                .into(EnterARegPage.ENTER_A_REG_FIELD));

    }

    public static Performable getStarted(){
        return Task.where("{0} click on the get started button ",
                Click.on(EnterARegPage.GET_STARTED));
    }
}
