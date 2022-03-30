package sanity;


import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ElectronFlows;

@Listeners(utilities.Listeners.class)
public class TodoListElectron extends CommonOps {

    @Test(description = "Test01- Add And Verify New Task")
    @Description("This Test adds a new task and verify it in the list of tasks")
    public void Test01_addAndVerifyNewTask() {
        ElectronFlows.addNewTask("Learn hebrew");
        Verifications.verifyNumber(ElectronFlows.getNumberOfTasks(),1);
    }

    @Test(description = "Test02- Add And Verify New Tasks")
    @Description("This Test adds a new task and verify it in the list of tasks")
    public void Test02_addAndVerifyNewTasks() {
        ElectronFlows.addNewTask("Go out with friends");
        ElectronFlows.addNewTask("Go out with dog");
        ElectronFlows.addNewTask("Go out with cat");
        Verifications.verifyNumber(ElectronFlows.getNumberOfTasks(),3);
    }


}
