import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import scrum.ScrumTrainersPage;

import static webdriver.LocalDriverManager.getDriver;

public class ScrumSiteTest extends BaseTest {

    @Test(description = "Validate PST trainers with private courses")
    public void searchInGoogleForMicrosoftTest() {
        getDriver().get("https://www.scrum.org/find-trainers");
        final ScrumTrainersPage scrumTrainersPage = PageFactory.initElements(getDriver(), ScrumTrainersPage.class)
                .selectCountry("Poland")
                .typeTraining("PST")
                .apply();

        TrainingAssertions.assertThat(scrumTrainersPage)
                .hasNumberOfResults(12)
                .allTrainersHavePrivateCourses()
                .allTrainersHasCourse("PST");
    }
}
