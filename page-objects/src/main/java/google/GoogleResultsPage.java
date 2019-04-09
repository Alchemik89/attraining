package google;

import lombok.Getter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static webdriver.LocalDriverManager.getDriver;

public class GoogleResultsPage {

    @Getter
    @FindBy(xpath = "//a[text() = 'Change to English']")
    private WebElement changeToEnglishLink;

    @Getter
    @FindBy(id = "nqsbq")
    private WebElement searchInResultsInput;

    @Getter
    @FindBy(xpath = "//input[@title = 'Search']")
    private WebElement searchInput;

    @Getter
    @FindBy(xpath = "//cite[1]")
    private WebElement firstSearchResultUrl;

    public GoogleResultsPage changeLanguageToEnglish() {
        (new WebDriverWait(getDriver(), 30)).until(ExpectedConditions.visibilityOf(getChangeToEnglishLink()));
        getChangeToEnglishLink().click();
        return this;
    }
    public GoogleResultsPage searchInResults(String searchPhrase) {
        getSearchInResultsInput().sendKeys(searchPhrase, Keys.ENTER);
        return this;
    }
}
