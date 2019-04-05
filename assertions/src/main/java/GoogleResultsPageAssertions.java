import google.GoogleResultsPage;
import org.assertj.core.api.AbstractObjectAssert;

public class GoogleResultsPageAssertions extends AbstractObjectAssert<GoogleResultsPageAssertions, GoogleResultsPage> {

    protected GoogleResultsPageAssertions(GoogleResultsPage actual) {
        super(actual, GoogleResultsPageAssertions.class);
    }

    public GoogleResultsPageAssertions hasValueInSearchInput(String value) {
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
