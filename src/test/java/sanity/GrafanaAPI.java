package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ApiFlows;

@Listeners(utilities.Listeners.class)
public class GrafanaAPI extends CommonOps {

    @Test(description = "Test  01: Get Team From Grafana")
    @Description("This Test Verify Team Property")
    public void Test01_verifyTeam() {
        Verifications.verifyText(ApiFlows.getTeamProperty("teams[0].name"), "ron");
    }

    @Test(description = "Test  02: Add Team And Verify")
    @Description("This Test adds Team To Grafana and Verify it")
    public void Test02_addTeamAndVerify() {
        ApiFlows.postTeam("RonTeam", "Ron@gmail.com");
        Verifications.verifyText(ApiFlows.getTeamProperty("teams[0].name"), "RonTeam");

    }

    @Test(description = "Test  03: Update Team And Verify")
    @Description("This Test Updates Team in Grafana and Verify it")
    public void Test03_updateTeamAndVerify() {
        String id = ApiFlows.getTeamProperty("teams[0].id");
        ApiFlows.updateTeam("RonTeam01", "Ron@walla.com", id);
        Verifications.verifyText(ApiFlows.getTeamProperty("teams[0].email"), "Ron@walla.com");
    }

    @Test(description = "Test  04: Delete Team And Verify")
    @Description("This Test Deletes Team in Grafana and Verify it")
    public void Test04_deleteTeamAndVerify() {
        String id = ApiFlows.getTeamProperty("teams[0].id");
        ApiFlows.deleteTeam(id);
        Verifications.verifyText(ApiFlows.getTeamProperty("totalCount"), "1");

    }
}