package apitests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class simpleGetRequest {
    String hrUrl="http://3.89.104.82:1000/ords/hr/regions";
    @Test
    public void test1(){
        Response response = RestAssured.get(hrUrl);

        //print status code
        System.out.println(response.statusCode());

        //print the json body
        response.prettyPrint();

    }

//    Given accept type is json
//    When user get request to regions endpoint
//    Then response status code must be 200
//    and body is json format
    @Test
    public void test2(){
        Response response=RestAssured.given().accept(ContentType.JSON)
                    .when().get(hrUrl);
        //verify response status code is 200
        Assert.assertEquals(response.statusCode(),200);

        //verify content type is application/json
        System.out.println(response.contentType());
        Assert.assertEquals(response.contentType(),"application/json");

    }
    @Test
    public void test3(){
        RestAssured
                .given().accept(ContentType.JSON)
                .when().get(hrUrl)
                .then().assertThat().statusCode(200)
                .and().contentType("application/json");
    }
    /*
    Given accept type json
    When user sends get request to/regions/2
    Then response status code must be 200
    and response body format
    and response body contains Americans
     */
    @Test
    public void test4(){
        Response response=RestAssured
                .given().accept(ContentType.JSON)
                .when().get(hrUrl+"/2");

        Assert.assertEquals(response.getStatusCode(),200);

        Assert.assertEquals(response.contentType(),"application/json");

        Assert.assertTrue(response.body().asString().contains("Americans"));
    }
}
