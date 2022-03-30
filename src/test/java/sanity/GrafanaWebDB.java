package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;


@Listeners(utilities.Listeners.class)
public class GrafanaWebDB extends CommonOps {
    @Test(description = "Test01-Login To Grafana with Credentials")
    @Description("This Test login with Credentials and verifies the main header")
    public void Test01_loginDBandVerifyHeader() {
        WebFlows.loginDB();
        Verifications.verifyTextInElement(grafanaMain.head_dashboard, "Home Dashboard");
    }



}
