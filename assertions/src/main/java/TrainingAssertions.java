import google.GoogleResultsPage;
import org.assertj.core.api.Assertions;
import scrum.ScrumTrainersPage;

public class TrainingAssertions extends Assertions {

    public static GoogleResultsPageAssertions assertThat(GoogleResultsPage actual) { return new GoogleResultsPageAssertions(actual); }

    public static ScrumTrainersPageAssertions assertThat(ScrumTrainersPage actual) { return new ScrumTrainersPageAssertions(actual); }
}
