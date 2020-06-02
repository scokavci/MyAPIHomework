package com.automation.homework;

import com.automation.pojos.hw1Pojo.Person;
import com.automation.utilities.ConfigurationReader;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Homework1_GitHubUINamesAPI {

    @BeforeAll
    public static void setUp(){
        baseURI = ConfigurationReader.getProperty( "CYBERTEK.UINAMES.URI");
    }
    @Test
    @DisplayName("No params test")
    public void noPramTest(){
        when().get().then().
                assertThat().statusCode(200).contentType("application/json; charset=utf-8").
                and().assertThat().
                body("name", notNullValue(),
                        "surname",notNullValue(),
                        "gender",notNullValue(), "region",notNullValue());
    }
    private List<String> genders = new ArrayList<>(Arrays.asList("male","female"));
    @Test
    @DisplayName("Gender test")
    public void genderTest() {
        Collections.shuffle(genders);
        String gender = genders.get(0);
        Response response = given().
                                   queryParam("gender",gender).
                                   when().get();
        response.then().assertThat().
                 statusCode(200).contentType("application/json; charset=utf-8").
                 and().body("gender", is(gender));

    }
    @Test
    @DisplayName("2 params test")
    public void twoParamsTest() {
        Response response = given().
                                 queryParam("region","Germany").
                                 queryParam("gender","female").
                                 when().get();
        response.prettyPeek();
        response.then().assertThat().statusCode(200).contentType("application/json; charset=utf-8").
                body("gender",is("female"), "region",is("Germany"));
    }
    @Test
    @DisplayName("invalid gender test")
    public void invalidGenderTest() {
            given().
                    queryParam("gender", "MALE").
                    when().get().
                    then().statusCode(400).
                    and().statusLine(containsString("Bad Request") ).
                    and().body("error",is("Invalid gender"));
    }

    @Test
    @DisplayName("invalid region test")
    public void invalidRegionTest() {
                      given().
                              queryParam("region", "Dog").
                              when().get().
                              then().statusCode(400).
                              and().statusLine(containsString("Bad Request") ).
                              and().body("error",is("Region or language not found"));
    }

    @Test
    @DisplayName("amount and regions test")
    public void amountAndRegionTest() {
        Response response = given().
                queryParam("region", "Italy").
                queryParam("amount", 296).
                when().get();
        // response.prettyPeek();

        List<Person> people = response.jsonPath().getList("", Person.class);

        Set<String> fullNames = new HashSet<>();

        for (Person person : people) {
               fullNames.add(person.getName()+" "+person.getSurname());
        }

        response.then().statusCode(200).contentType("application/json; charset=utf-8").
        and().body("size()",is(fullNames.size()));
    }

    @Test
    @DisplayName("3 params test")
    public void threeParamsTest() {
        Response response = given().
                queryParam("region", "Italy").
                queryParam("amount", 296).
                queryParam("gender", "female").
                when().get();
        response.prettyPeek();
        response.then().statusCode(200).contentType("application/json; charset=utf-8");
        List<Person> listOfPerson = response.jsonPath().getList("",Person.class);
      boolean result=true;
        for (Person each : listOfPerson) {
              result = each.getRegion().equals("Italy") && each.getGender().equals("female");
        }
        assertTrue(result);
   }

    @Test
    @DisplayName("amount count test")
    public void amountCountTest() {
        Response response = given().
                queryParam("amount", 296).
                when().get();
        List<Person> listPerson = response.jsonPath().getList("",Person.class);
        response.then().statusCode(200).contentType("application/json; charset=utf-8").
                and().body("size()",is(listPerson.size()));
    }
}

