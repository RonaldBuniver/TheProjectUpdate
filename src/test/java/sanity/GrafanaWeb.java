package sanity;


import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;

import javax.swing.text.Utilities;

@Listeners(utilities.Listeners.class)
public class GrafanaWeb extends CommonOps {

    @Test(description = "Test01-Verify Header")
    @Description("This Test login and verifies the main header")
    public void Test01_verifyHeader() {
        WebFlows.login(getData("UserName"), getData("Password"));
        Verifications.verifyTextInElement(grafanaMain.head_dashboard, "Home Dashboard");
    }

    @Test(description = "Test02-Verify Default Users")
    @Description("This Test verifies the default users")
    public void Test02_verifyDefaultUsers() {
        UIActions.mouseHover(grafanaLeftMenu.btn_server, grafanaServerAdmin.link_users);
        Verifications.numberOfElements(grafanaServerAdminMain.rows, 1);
    }

    @Test(description = "Test03-Verify New Users")
    @Description("This Test verifies a new user has been added")
    public void Test03_verifyNewUsers() {
        UIActions.mouseHover(grafanaLeftMenu.btn_server, grafanaServerAdmin.link_users);
        WebFlows.createNewUser("Ronald", "Ronald3421@gmail.com", "Ronald3421", "12345");
        Verifications.numberOfElements(grafanaServerAdminMain.rows, 2);
    }

    @Test(description = "Test04-Verify User Deletion")
    @Description("This Test verifies the deletion of a user")
    public void Test04_verifyUserDeletion() {
        UIActions.mouseHover(grafanaLeftMenu.btn_server, grafanaServerAdmin.link_users);
        WebFlows.deleteLastUser();
        Verifications.numberOfElements(grafanaServerAdminMain.rows, 1);
    }

    @Test(description = "Test05-Verify Progress Steps")
    @Description("This Test verifies the Progress Steps are displayed (using soft assertion)")
    public void Test05_verifyProgressSteps() {
        Verifications.visibilityOfElements(grafanaMain.list_progressSteps);
    }

    @Test(description = "Test06-Verify Avatar Icon")
    @Description("This Test verifies the Avatar Image (using sikuli tool)")
    public void Test06_verifyAvatarIcon() throws FindFailed {
        Verifications.visualElement("GrafanaAvatar");
////       Screen sc = new Screen();
////        sc.find("D:\\FinalProject\\ImageRepository\\test.png");
   }

    @Test(description = "Test07-Search Users", dataProvider = "data-provider-users",dataProviderClass = utilities.ManageDDT.class)
    @Description("This Test Searched Users in a table using DDT")
    public void Test07_searchUsers(String user,String shouldExist) {
        UIActions.mouseHover(grafanaLeftMenu.btn_server, grafanaServerAdmin.link_users);
        WebFlows.SearchAndVerifyUser(user,shouldExist);

    }




}