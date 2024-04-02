package com.mycompany.app.helpers;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.util.List;


public class WriteToVariable implements Task {


    private final String value;
    private final List<String> arrayList;


    public WriteToVariable(String value, List<String> arrayList) {
        this.value = value;
        this.arrayList = arrayList;
    }

    public static WriteToVariable write(String value,List<String> arrayList) {
        return new WriteToVariable(value, arrayList);
    }

    @Override
    public <T extends Actor> void performAs(T t) {

        arrayList.add(value);
    }

    // Getter method for retrieving the variable value
    public List<String> getVariableValue() {
        return arrayList;
    }
}
