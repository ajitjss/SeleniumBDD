package stepDef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.cucumber.datatable.DataTable;

import java.util.List;
import java.util.Map;

public class dataTableStepDefs {

    @Given("^user navigated to website$")
    public void user_navigated_to_website() throws Throwable {
        System.out.println("User Navigated to Website");
    }

    @Then("^Enter userid and password$")
    public void enter_userid_and_password(DataTable arg1) throws Throwable {
       /* List<Map<String, String>> cred = arg1.asMaps(String.class, String.class);
        System.out.println(cred.get(0).get("Name"));
        System.out.println(cred.get(0).get("SurName"));
        System.out.println(cred.get(1).get("Name"));
        System.out.println(cred.get(1).get("SurName"));
        System.out.println(cred.get(2).get("Name"));
        System.out.println(cred.get(2).get("SurName"));
        System.out.println(cred.get(3).get("Name"));
        System.out.println(cred.get(3).get("SurName"));*/
     /*  List<List<String>> cred = arg1.raw();
        System.out.println(cred.get(0).get(0));
        System.out.println(cred.get(0).get(1));
        System.out.println(cred.get(2).get(0));
        System.out.println(cred.get(2).get(1));
        Map<String, String> credData = arg1.asMap(String.class, String.class);

*/

    }

    @Then("^User successfully login into Application$")
    public void user_successfully_login_into_Application() throws Throwable {

    }

}



