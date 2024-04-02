package com.mycompany.app.helpers;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class WhatIsMyCar extends PageObject {

    public static Target MAKE_AND_MODEL = Target.the("Make and Model").locatedBy("//h1[contains(@class,'VehicleMakeTitle')]");

    public static Target MAKE_SPEC = Target.the("SPEC").locatedBy("//p[contains(@class,'VehicleSubTitle')][1]");

    public static Target MAKE_DETAILS = Target.the("Details").locatedBy("//p[contains(@class,'VehicleSubTitle')][2]");

}
