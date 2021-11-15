package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObject.SurveyPage;

public class SurveySteps {
    SurveyPage surveyPage;

    @Given("User go to survey page")
    public void userGotoSurveyPage() {
        surveyPage.open();
    }

    @When("User select {string}")
    public void userChooseTheAnswer(String answer) {
        surveyPage.chooseAnswer(answer);
    }

    @And("User submit the answer")
    public void userSubmitTheAnswer() {
        surveyPage.clickOnNextButton();
    }

    @Then("User should see {string} message")
    public void userShouldSeeMessage(String message) {
        surveyPage.verifyMessage(message);
    }

    @When("User go to previous page")
    public void userGotoPreviousPage() {
        surveyPage.clickOnPrevButton();
    }

    @Then("Button {string} should be clicked")
    public void buttonShouldBeClicked(String answer) {
        surveyPage.verifyButtonStatus(answer);
    }

    @And("Button {string} should not be clicked")
    public void buttonShouldNotBeClicked(String answer) {
        surveyPage.verifyButtonStatus(answer);

    }
}
