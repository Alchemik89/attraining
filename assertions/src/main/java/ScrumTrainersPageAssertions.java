import org.assertj.core.api.AbstractObjectAssert;
import scrum.ScrumTrainersPage;

public class ScrumTrainersPageAssertions extends AbstractObjectAssert<ScrumTrainersPageAssertions, ScrumTrainersPage> {

    ScrumTrainersPageAssertions(ScrumTrainersPage actual) {
        super(actual, ScrumTrainersPageAssertions.class);
    }

    public ScrumTrainersPageAssertions hasNumberOfResults(int resultsSize) {
        TrainingAssertions.assertThat(actual.getAllTrainers().size())
                .isEqualTo(resultsSize);
        return this;
    }

    public ScrumTrainersPageAssertions allTrainersHasCourse(String course) {
        final boolean match = actual.getAllTrainers().stream()
                .allMatch(trainings -> trainings.getText().contains(course));
        TrainingAssertions.assertThat(match)
                .overridingErrorMessage("Not all trainers have course: " + course)
                .isTrue();
        return this;
    }

    public ScrumTrainersPageAssertions allTrainersHavePrivateCourses() {
        final boolean match = actual.getAllPrivateCouches().stream()
                .allMatch(privateCourses -> privateCourses.getText().equals("Yes"));
        TrainingAssertions.assertThat(match)
                .overridingErrorMessage("Not all trainers have private courses")
                .isTrue();
        return this;
    }
}
