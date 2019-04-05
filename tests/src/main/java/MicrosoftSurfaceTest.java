import google.GoogleComPage;
import google.GoogleResultsPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import static webdriver.LocalDriverManager.getDriver;

public class MicrosoftSurfaceTest extends BaseTest {

    @Test(description = "Search in google.com for 'Microsoft'")
    public void searchInGoogleForMicrosoftTest() {
        getDriver().get("http://www.google.com");
        final GoogleResultsPage googleResultsPage = PageFactory.initElements(getDriver(), GoogleComPage.class)
                .search("Microsoft")
                .changeLanguageToEnglish()
                .searchInResults("surface");

        TrainingAssertions.assertThat(googleResultsPage)
                .hasValueInSearchInput("surface site:microsoft.com")
                .hasFirstUrlInResults("https://www.microsoft.com/en-us/surface");
    }
}
