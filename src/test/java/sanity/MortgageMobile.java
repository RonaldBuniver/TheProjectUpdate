package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.MobileFlows;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)
public class MortgageMobile extends CommonOps {

    @Test(description = "Test01-Verify Mortgage")
    @Description("This Test fill in mortgage fields and calculate repayment")
    public void Test01_verifyMortgage() {
        MobileFlows.calculateMortgage("1000","3","4");
        Verifications.verifyTextInElement(martgageMain.txt_repayment, "£30.03");
    }
}
