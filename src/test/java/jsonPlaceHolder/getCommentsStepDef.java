package jsonPlaceHolder;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import static org.hamcrest.CoreMatchers.equalTo;

public class getCommentsStepDef {
    @Steps
    jsonPlaceHolderAPI jsonPHAPI;

    //Scenario 1
    @Given("Get list comments without parameter")
    public void getListCommentsWithoutParameter() {
        SerenityRest.given().get(jsonPlaceHolderAPI.COMMENTS_LIST);
    }

    @When("Send Get list comments request")
    public void sendGetListCommentsRequest() {
        SerenityRest.when().get(jsonPlaceHolderAPI.COMMENTS_LIST);
    }

    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int OK) {
        SerenityRest.then().statusCode(OK);
    }

    @And("Response body page should be {int}")
    public void responseBodyPageShouldBe(int postId) {
        SerenityRest.then().body("postId[0]",equalTo(postId));
    }

    //Scenario 2
    @Given("Get single comment with parameter {int}")
    public void getSingleCommentWithParameterId(int id) {
        jsonPHAPI.getComments(id);
    }

    @When("Send get single comment request")
    public void sendGetSingleCommentRequest() {
        SerenityRest.when().get(jsonPlaceHolderAPI.COMMENTS_SINGLE);
    }

    @And("Response body page should be postId and id {int}")
    public void responseBodyPageShouldBePostIdAndIDPostId(int postId) {
        SerenityRest.then().body(response.POSTID,equalTo(postId));
    }

    //Scenario 3
    @Given("Get single comment with invalid parameter {int}")
    public void getSingleCommentWithInvalidParameterId(int id) {
        jsonPHAPI.getComments(id);
    }

    @Then("Status code should be {int} Not Found")
    public void statusCodeShouldBeNotFound(int notFound) {
        SerenityRest.then().statusCode(notFound);
    }

    //Scenario 4
    @Given("Get resource comments with parameter {int}")
    public void getResourceCommentsWithParameterPostId(int id) {
        jsonPHAPI.getComments(id);
    }

    @When("Send get resource comments request")
    public void sendGetResourceCommentsRequest() {
        SerenityRest.when().get(jsonPlaceHolderAPI.COMMENTS_PER_USER_ID);
    }
    @And("Response body page should be postId {int}")
    public void responseBodyPageShouldBePostId(int postId) {
        SerenityRest.then().body("postId[0]",equalTo(postId));
    }

    //Scenario 5
    @Given("Get resource comments with invalid parameter {int}")
    public void getResourceCommentsWithInvalidParameterId(int id) {
        jsonPHAPI.getComments(id);
    }

}
