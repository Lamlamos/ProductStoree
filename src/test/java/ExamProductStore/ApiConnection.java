package ExamProductStore;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class ApiConnection {


    public void apiResponse(String alertTest){
        RestAssured.baseURI = "https://www.demoblaze.com";

        Response response = (Response) given().when().get("https://hls.demoblaze.com/index.m3u8");
        Assert.assertEquals(response.getStatusCode() ,200);

        String responseBody = response.getBody().asString();

        System.out.println("responseBody : \n" + responseBody );

        Assert.assertEquals(responseBody.contains(alertTest) , true);
//        if(responseBody.contains(alertTest)){
//            return true;
//        }else {
//            return false;
//        }

    }
}
