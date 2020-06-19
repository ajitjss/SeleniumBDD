package APITest;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import cucumber.api.java.eo.Se;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class BasicCRUDTest001 {
    public static String BASE_URL = "https://api.stripe.com";
    public static String EMAIL = "ajit091@gmail.com";
    public static String SECRET_KEY = "sk_test_2g6FLGf1pqC5QawYRqtGU9ia";
    RequestSpecification httpRequest = null;

    @BeforeMethod
    public void beforeTest() {
        RestAssured.baseURI = BASE_URL;
        httpRequest = RestAssured.given().auth().oauth2(SECRET_KEY);
    }

    @Test
    public void validateCustomers() {
        Response response = httpRequest.request(Method.GET, "/v1/customers");
        Assert.assertEquals(200, response.getStatusCode());
        System.out.println(response.getStatusLine());
        JsonParser parse = new JsonParser();
        JsonObject json = parse.parse(response.getBody().asString()).getAsJsonObject();
        //  System.out.println("printing json"+json.toString());
        int customerSize = json.getAsJsonArray("data").size();
        Assert.assertEquals(3, customerSize);
    }


     @Test
    public void createCustomers() {
        JsonParser parse = new JsonParser();
        JsonObject json = parse.parse(httpRequest.request(Method.GET, "/v1/customers").getBody().asString()).getAsJsonObject();
        Response response = httpRequest.request(Method.POST, "/v1/customers");
        Assert.assertEquals(200, response.getStatusCode());
        System.out.println(response.getStatusLine());
        //    JsonParser parse1 = new JsonParser();
        JsonObject json1 = parse.parse(response.getBody().asString()).getAsJsonObject();
        //  System.out.println("printing json"+json.toString());
        int customerSize = json.getAsJsonArray("data").size();
        Assert.assertEquals(3, customerSize);
    }

    @Test
    public void deleteCustomer() {
        String id = httpRequest.request(Method.GET, "/v1/customers").getBody().asString();
        JsonParser parse = new JsonParser();
        JsonObject json = parse.parse(id).getAsJsonObject();
        System.out.println("response as string: " + json.get("data"));
        JsonArray arr = json.get("data").getAsJsonArray();
        JsonObject json1 = arr.get(0).getAsJsonObject();
        System.out.println("data: " + json1.get("id"));
        String id1 = json1.get("id").getAsString();
        Response response = RestAssured.given().auth().oauth2(SECRET_KEY).request(Method.DELETE, "v1/cusomers/id" + id1);
        System.out.println("Status Code for Delete: "+response.statusCode());
    }

    @Test
    public void ListOfCustomers(){
        Response response = httpRequest.request(Method.GET, "v1/customers");
        Assert.assertEquals(200, response.statusCode());
        JsonParser parse = new JsonParser();
        JsonObject json = parse.parse(response.getBody().asString()).getAsJsonObject();
        JsonArray arr = json.getAsJsonArray("data");
        HashMap<Integer, Map<String, String>> customer = new HashMap<Integer, Map<String, String>>();
        for( int i=0;i<arr.size();i++){
            JsonObject j1 = arr.get(i).getAsJsonObject();
            HashMap<String, String>customerData = new HashMap<String, String>();
            customerData.put("id",j1.get("id").getAsString());
            customerData.put("email",j1.get("email").getAsString());
         customer.put(i, customerData);
        }
        System.out.println("Custmer Data "+customer);
        // use of Iterator
        Set<Integer> keys = customer.keySet();
        Iterator<Integer> itr = keys.iterator();
        while(itr.hasNext()){
            Integer num = itr.next();
            System.out.println("id: "+customer.get(num).get("id"));
            System.out.println("email: "+customer.get(num).get("email"));
        }

    }

}
