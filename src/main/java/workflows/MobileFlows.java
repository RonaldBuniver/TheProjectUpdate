package workflows;

import extensions.MobileActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class MobileFlows extends CommonOps {

   @Step("Business Flow: Fill Form and Calculate Mortgage")
    public static void calculateMortgage(String amount, String term, String rate){
        MobileActions.updateText(martgageMain.txt_amount,amount);
        MobileActions.updateText(martgageMain.txt_term,term);
        MobileActions.updateText(martgageMain.txt_rate,rate);
        MobileActions.tap(martgageMain.btn_Calculate);
    }



}
