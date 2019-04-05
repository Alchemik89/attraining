package scrum;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static webdriver.LocalDriverManager.getDriver;

public class ScrumTrainersPage {

    @Getter
    @FindBy(id = "edit-country")
    private WebElement countrySelect;

    @Getter
    @FindBy(xpath = "//input[@value = 'All Courses']")
    private WebElement trainingInput;

    @Getter
    @FindBy(xpath = "//input[contains(@id, 'edit-submit-trainers')]")
    private WebElement applyFilterButton;

    @Getter
    @FindBy(xpath = "//article[@class = 'trainer-grid-item']")
    private List<WebElement> allTrainers;

    @Getter
    @FindBy(xpath = "//p[contains(text(), 'Teaches')]/span")
    private List<WebElement> allTeaches;

    @Getter
    @FindBy(xpath = "//p[contains(text(), 'Private Courses')]/span")
    private List<WebElement> allPrivateCouches;

    public ScrumTrainersPage selectCountry(String countryName) {
        (new Select(getCountrySelect())).selectByVisibleText(countryName);
        return this;
    }

    public ScrumTrainersPage typeTraining(String trainingName) {
        getTrainingInput().sendKeys(trainingName);
        return this;
    }

    public ScrumTrainersPage apply() {
        getApplyFilterButton().click();
        (new WebDriverWait(getDriver(), 10))
                .until(ExpectedConditions
                        .invisibilityOf(getDriver().findElement(By.xpath("//div[@class = 'ajax-progress ajax-progress-fullscreen']"))));
        return this;
    }
}
