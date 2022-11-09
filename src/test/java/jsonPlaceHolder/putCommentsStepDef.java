package jsonPlaceHolder;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

public class putCommentsStepDef {
    @Steps
    jsonPlaceHolderAPI jsonPHAPI;

    //Scenario 1
    @Given("Put update comment with valid json with id {int}")
    public void putUpdateCommentWithValidJsonWithIdId(int id) {
        File json = new File(jsonPHAPI.JSON_REQUEST_BODY+"/updateComment.json");
        jsonPHAPI.putUpdateComment(id,json);
    }

    @When("Send put update comment request")
    public void sendPutUpdateCommentRequest() {
        SerenityRest.when().put(jsonPHAPI.COMMENTS_SINGLE);
    }

    //Scenario 2
    @Given("Put update comment with valid json {int} without name")
    public void putUpdateCommentWithValidJsonWithoutName(int id) {
        File json = new File(jsonPlaceHolderAPI.JSON_REQUEST_BODY+"/updateCommentwithoutName.json");
        jsonPHAPI.putUpdateComment(id, json);
    }

    //Scenario 3
    @Given("Put update comment with valid json {int} without email")
    public void putUpdateCommentWithValidJsonWithoutEmail(int id) {
        File json = new File(jsonPlaceHolderAPI.JSON_REQUEST_BODY+"/updateCommentwithoutEmail.json");
        jsonPHAPI.putUpdateComment(id, json);
    }

    //Scenario 4
    @Given("Put update comment with valid json {int} without body")
    public void putUpdateCommentWithValidJsonWithoutBody(int id) {
        File json = new File(jsonPlaceHolderAPI.JSON_REQUEST_BODY+"/updateCommentwithoutBody.json");
        jsonPHAPI.putUpdateComment(id, json);
    }

    //Scenario 5
    @Given("Put update comment with invalid json {int}")
    public void putUpdateCommentWithInvalidJson(int id) {
        File json = new File(jsonPlaceHolderAPI.JSON_REQUEST_BODY+"/invalidJsonBody.json");
        jsonPHAPI.putUpdateComment(id, json);
    }
}
