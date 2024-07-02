package com.ust.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

import java.io.File;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ust.endpoints.Endpoints;
import com.ust.payloads.AddPet;
import com.ust.payloads.Update;
import com.ust.utils.ExtendReportListener;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

@Listeners(ExtendReportListener.class)

public class ApiTest {
	Endpoints endpoint;
	Response response;
	
	@BeforeMethod
	public void setup() {
        endpoint = new Endpoints();
        
    }
	
  @Test (priority =1)
  public void verifyFindPetById() {
	  Response response = Endpoints.getPetById(5);
//	  response.then().assertThat().body("name",equalTo("doggie"));
	  response.then().log().all()
      .contentType("application/json").body("name", equalTo("doggie")).
      assertThat()
      .body(JsonSchemaValidator.matchesJsonSchema(new File(System.getProperty("user.dir") + "\\src\\test\\resources\\byidschema.json")));
	  assertEquals(200, response.statusCode()); 
	  
//	  response.then().log().all()
//      .contentType("application/json").body("[0].alpha_two_code", equalTo("GB")).
//      assertThat()
//      .body(JsonSchemaValidator.matchesJsonSchema(new File(System.getProperty("user.dir") + "\\src\\test\\resources\\schema.json")));
//      
  }
  
  @Test(priority = 2)
  public void addNewPet() {
      AddPet.Category category = new AddPet.Category(0, "string");
      AddPet.Tag[] tags = {new AddPet.Tag(0, "string")};
      String[] photoUrls = {"string"};

      AddPet ap = new AddPet(
              9223,
              category,
              "doggie",
              photoUrls,
              tags,
              "available");

      Response response = Endpoints.createNewPet(ap);
      assertEquals(200, response.getStatusCode());
  }
  
  
//  @Test(priority = 2)
//  public void addNewPet() {
//      AddPet.Category category = new AddPet.Category(0, "string");
//      AddPet.Tag[] tags = {new AddPet.Tag(0, "string")};
//      String[] photoUrls = {"string"};
//
//      AddPet ap = new AddPet(
//              9223,
//              category,
//              "doggie",
//              photoUrls,
//              tags,
//              "available");
//
//      Response response = Endpoints.createNewPet(ap);
//
//      // Validate response status code
//      assertEquals(response.getStatusCode(), 200);
//      
//  }

  
  @Test(priority =3)
  public void upateNewPet() {
	  Update up = new Update(
			  9223,
			  0,
			  "string1",
			  "doggie2",
			  "string",
			  0,
			  "string",
			  "available"); 	  
  Response response = Endpoints.updatePet(up);
  response.then().assertThat().statusCode(200);
  }
  
  
  @Test(priority=4)
  public void deletePet() {
	  Response response = Endpoints.deletePet(6);
  response.then().assertThat().statusCode(404);
  }
  
}
