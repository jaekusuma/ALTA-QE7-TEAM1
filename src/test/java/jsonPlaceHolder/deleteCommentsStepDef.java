package jsonPlaceHolder;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class deleteCommentsStepDef {
    @Steps
    jsonPlaceHolderAPI jsonPHAPI;

    //Scenario 1
    @Given("Delete list comment with {int}")
    public void deleteListCommentWithId(int id) {
        jsonPHAPI.deleteComment(id);
    }

    @When("Send delete list comment request")
    public void sendDeleteListCommentRequest() {
        SerenityRest.when().delete(jsonPlaceHolderAPI.COMMENTS_SINGLE);
    }

    @Then("Status code should be {int} No Content")
    public void statusCodeShouldBeNoContent(int noContent) {
        SerenityRest.then().statusCode(noContent);
    }

    //Scenario 2
    @Given("Delete single comment page with {int}")
    public void deleteSingleCommentPageWithId(int id) {
        jsonPHAPI.deleteComment(id);
    }

    @When("Send delete single comment request")
    public void sendDeleteSingleCommentRequest() {
        SerenityRest.when().delete(jsonPlaceHolderAPI.COMMENTS_PER_USER_ID);
    }
}
