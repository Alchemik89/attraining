import google.GoogleResultsPage;
import org.assertj.core.api.AbstractObjectAssert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static webdriver.LocalDriverManager.getDriver;

public class GoogleResultsPageAssertions extends AbstractObjectAssert<GoogleResultsPageAssertions, GoogleResultsPage> {

    GoogleResultsPageAssertions(GoogleResultsPage actual) {
        super(actual, GoogleResultsPageAssertions.class);
    }

    public GoogleResultsPageAssertions hasValueInSearchInput(String value) {
        (new WebDriverWait(getDriver(), 30)).until(ExpectedConditions.visibilityOf(actual.getSearchInput()));
        final String actualValue = actual.getSearchInput().getAttribute("value");
        TrainingAssertions.assertThat(actualValue)
                .isEqualTo(value);
        return this;
    }

    public GoogleResultsPageAssertions hasFirstUrlInResults(String url) {
        TrainingAssertions.assertThat(actual.getFirstSearchResultUrl().getText())
                .isEqualToIgnoringCase(url);
        return this;
    }
}
