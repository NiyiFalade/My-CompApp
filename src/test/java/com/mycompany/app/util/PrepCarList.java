package com.mycompany.app.util;

public class PrepCarList {

    public String removeItem(String item){
        String item1 = item.replace("|","");
        return item1;
    }

    public String removeItem2(String item) {
        char[] charsToRemove = {'|'};

        StringBuilder m  = new StringBuilder();

        for (char f : item.toCharArray()){
            boolean removeChar = false;
            for (char charToRemove : charsToRemove) {
                if(f == charToRemove){
                    removeChar = true;
                    break;
                }
            }

            if (!removeChar) {
                m.append(f);
            }
        }
        return m.toString();
    }
}
