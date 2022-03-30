package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class MainPage {
    @FindBy(how = How.XPATH, using = "//div[@class='text-center dashboard-header']/span")
    public WebElement head_dashboard;

    @FindBy(how = How.XPATH, using = "//div[@class='progress-tracker']//div")
    public List<WebElement> list_progressSteps;





}
