package google;

import lombok.Getter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static webdriver.LocalDriverManager.getDriver;

public class GoogleComPage {

    @Getter
    @FindBy(xpath = "//input[@role = 'combobox']")
    private WebElement searchInput;

    public GoogleResultsPage search(String searchPhrase) {
        (new WebDriverWait(getDriver(), 30)).until(ExpectedConditions.visibilityOf(getSearchInput()));
        getSearchInput().sendKeys(searchPhrase, Keys.ENTER);
        return PageFactory.initElements(getDriver(), GoogleResultsPage.class);
    }

}
