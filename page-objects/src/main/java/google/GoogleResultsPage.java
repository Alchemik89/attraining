package google;

import lombok.Getter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
        getChangeToEnglishLink().click();
        return this;
    }
    public GoogleResultsPage searchInResults(String searchPhrase) {
        getSearchInResultsInput().sendKeys("surface", Keys.ENTER);
        return this;
    }
}
