package workflows;

import extensions.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import utilities.CommonOps;

public class ElectronFlows extends CommonOps {

    @Step("Add New Task to the List")
    public static void addNewTask(String taskName){
        UIActions.updateText(todoMain.txt_create,taskName);
        UIActions.insertKey(todoMain.txt_create, Keys.RETURN);

    }
    @Step("Count And Return Number Of task in List")
    public static int getNumberOfTasks(){
      return todoMain.list_tasks.size();
    }

    @Step("Empty List Of Tasks ")
    public static void emptyList() {
        for (int i = 0; i < getNumberOfTasks(); i++) {
            UIActions.mouseHover(todoMain.btn_x);
        }
    }
}
