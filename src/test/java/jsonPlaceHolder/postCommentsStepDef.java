package jsonPlaceHolder;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class postCommentsStepDef {
    @Steps
    jsonPlaceHolderAPI jsonPHAPI;

    //Scenario 1
    @Given("Post create comment with valid json")
    public void postCreateCommentWithValidJson() {
        File json = new File(jsonPlaceHolderAPI.JSON_REQUEST_BODY+"/createComment.json");
        jsonPHAPI.postNewComment(json);
    }

    @When("Send post user comments request")
    public void sendPostUserCommentsRequest() {
        SerenityRest.when().post(jsonPlaceHolderAPI.COMMENTS_LIST);
    }

    @Then("Status code should be {int} Created")
    public void statusCodeShouldBeCreated(int created) {
        SerenityRest.then().statusCode(created);
    }

    @And("Response body page should contain name {string}, email {string} and body {string}")
    public void responseBodyPageShouldContainNameEmailAndBody(String name, String email, String body) {
        SerenityRest.then()
                .body(response.NAME,equalTo(name))
                .body(response.EMAIL,equalTo(email))
                .body(response.BODY,equalTo(body));
    }

    //Scenario 2
    @Given("Post create new comment with valid json without name")
    public void postCreateNewCommentWithValidJsonWithoutName() {
        File json = new File(jsonPlaceHolderAPI.JSON_REQUEST_BODY+"/createCommentwithoutName.json");
        jsonPHAPI.postNewComment(json);
    }

    @Then("Status code should be {int} Bad Request")
    public void statusCodeShouldBeBadRequest(int badRequest) {
        SerenityRest.then().statusCode(badRequest);
    }

    //Scenario 3
    @Given("Post create new comment with valid json without email")
    public void postCreateNewCommentWithValidJsonWithoutEmail() {
        File json = new File(jsonPlaceHolderAPI.JSON_REQUEST_BODY+"/createCommentwithoutEmail.json");
        jsonPHAPI.postNewComment(json);
    }

    //Scenario 4
    @Given("Post create new comment with valid json without body")
    public void postCreateNewCommentWithValidJsonWithoutBody() {
        File json = new File(jsonPlaceHolderAPI.JSON_REQUEST_BODY+"/createCommentwithoutBody.json");
        jsonPHAPI.postNewComment(json);
    }

    //Scenario 5
    @Given("Post create new comment with invalid json")
    public void postCreateNewCommentWithInvalidJson() {
        File json = new File(jsonPlaceHolderAPI.JSON_REQUEST_BODY+"/invalidJsonBody.json");
        jsonPHAPI.postNewComment(json);
    }
}
