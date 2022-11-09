package jsonPlaceHolder.stepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import jsonPlaceHolder.jsonPlaceHolderAPI;
import jsonPlaceHolder.response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.Matchers;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class CommentsStepDef {
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

    @And("Validate get list comments json schema")
    public void validateGetListCommentsJsonSchema() {
        File json = new File((jsonPlaceHolderAPI.JSON_SCHEMA+"/getListCommentsSchema.json"));
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
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

    @And("Validate get single comment json schema")
    public void validateGetSingleCommentJsonSchema() {
        File json = new File((jsonPlaceHolderAPI.JSON_SCHEMA+"/getSingleCommentsSchema.json"));
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
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
    @And("Validate get resource comments json schema")
    public void validateGetResourceCommentsJsonSchema() {
        File json = new File((jsonPlaceHolderAPI.JSON_SCHEMA+"/getResourceCommentsSchema.json"));
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Scenario 5
    @Given("Get resource comments with invalid parameter {int}")
    public void getResourceCommentsWithInvalidParameterId(int id) {
        jsonPHAPI.getComments(id);
    }

    //Scenario 6
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
                .body(response.NAME, Matchers.equalTo(name))
                .body(response.EMAIL, Matchers.equalTo(email))
                .body(response.BODY, Matchers.equalTo(body));
    }
    @And("Validate post new comment json schema")
    public void validatePostNewCommentJsonSchema() {
        File json = new File((jsonPlaceHolderAPI.JSON_SCHEMA+"/postNewCommentSchema.json"));
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Scenario 7
    @Given("Post create new comment with valid json without name")
    public void postCreateNewCommentWithValidJsonWithoutName() {
        File json = new File(jsonPlaceHolderAPI.JSON_REQUEST_BODY+"/createCommentwithoutName.json");
        jsonPHAPI.postNewComment(json);
    }

    @Then("Status code should be {int} Bad Request")
    public void statusCodeShouldBeBadRequest(int badRequest) {
        SerenityRest.then().statusCode(badRequest);
    }

    //Scenario 8
    @Given("Post create new comment with valid json without email")
    public void postCreateNewCommentWithValidJsonWithoutEmail() {
        File json = new File(jsonPlaceHolderAPI.JSON_REQUEST_BODY+"/createCommentwithoutEmail.json");
        jsonPHAPI.postNewComment(json);
    }

    //Scenario 9
    @Given("Post create new comment with valid json without body")
    public void postCreateNewCommentWithValidJsonWithoutBody() {
        File json = new File(jsonPlaceHolderAPI.JSON_REQUEST_BODY+"/createCommentwithoutBody.json");
        jsonPHAPI.postNewComment(json);
    }

    //Scenario 10
    @Given("Post create new comment with invalid json")
    public void postCreateNewCommentWithInvalidJson() {
        File json = new File(jsonPlaceHolderAPI.JSON_REQUEST_BODY+"/invalidJsonBody.json");
        jsonPHAPI.postNewComment(json);
    }

    //Scenario 11
    @Given("Put update comment with valid json with id {int}")
    public void putUpdateCommentWithValidJsonWithIdId(int id) {
        File json = new File(jsonPlaceHolderAPI.JSON_REQUEST_BODY+"/updateComment.json");
        jsonPHAPI.putUpdateComment(id,json);
    }

    @When("Send put update comment request")
    public void sendPutUpdateCommentRequest() {
        SerenityRest.when().put(jsonPlaceHolderAPI.COMMENTS_SINGLE);
    }

    @And("Validate put update comment json schema")
    public void validatePutUpdateCommentJsonSchema() {
        File json = new File((jsonPlaceHolderAPI.JSON_SCHEMA+"/putUpdateCommentSchema.json"));
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    //Scenario 12
    @Given("Put update comment with valid json {int} without name")
    public void putUpdateCommentWithValidJsonWithoutName(int id) {
        File json = new File(jsonPlaceHolderAPI.JSON_REQUEST_BODY+"/updateCommentwithoutName.json");
        jsonPHAPI.putUpdateComment(id, json);
    }

    //Scenario 13
    @Given("Put update comment with valid json {int} without email")
    public void putUpdateCommentWithValidJsonWithoutEmail(int id) {
        File json = new File(jsonPlaceHolderAPI.JSON_REQUEST_BODY+"/updateCommentwithoutEmail.json");
        jsonPHAPI.putUpdateComment(id, json);
    }

    //Scenario 14
    @Given("Put update comment with valid json {int} without body")
    public void putUpdateCommentWithValidJsonWithoutBody(int id) {
        File json = new File(jsonPlaceHolderAPI.JSON_REQUEST_BODY+"/updateCommentwithoutBody.json");
        jsonPHAPI.putUpdateComment(id, json);
    }

    //Scenario 15
    @Given("Put update comment with invalid json {int}")
    public void putUpdateCommentWithInvalidJson(int id) {
        File json = new File(jsonPlaceHolderAPI.JSON_REQUEST_BODY+"/invalidJsonBody.json");
        jsonPHAPI.putUpdateComment(id, json);
    }

    //Scenario 16
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

    //Scenario 17
    @Given("Delete single comment page with {int}")
    public void deleteSingleCommentPageWithId(int id) {
        jsonPHAPI.deleteComment(id);
    }

    @When("Send delete single comment request")
    public void sendDeleteSingleCommentRequest() {
        SerenityRest.when().delete(jsonPlaceHolderAPI.COMMENTS_PER_USER_ID);
    }

}

