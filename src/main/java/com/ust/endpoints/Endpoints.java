package com.ust.endpoints;

import com.ust.payloads.AddPet;
import com.ust.payloads.Update;
import com.ust.routes.Routes;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Endpoints {
	
	public Endpoints() {
		RestAssured.useRelaxedHTTPSValidation();
	}
	
	//Find Pet By Id
	public static Response getPetById(int id) {
		System.out.println(id);
		
		Response response = RestAssured.given().headers(
				"Content-Type",ContentType.JSON,
				"Accept", ContentType.JSON)
				.baseUri(Routes.base_url)
				.basePath(Routes.get_petbyid)
				.pathParam("petId", id)
				.contentType("application/json")
				.accept(ContentType.JSON)
				.when()
				.get();
		
		return response;		
	}
	
	public static Response createNewPet(AddPet payload) {
		System.out.println(payload);
		
		Response response = RestAssured.given().headers(
				"Content-Type",ContentType.JSON,
				"Accept",ContentType.JSON
				).baseUri(Routes.base_url)
				.basePath(Routes.add_newpet)
				.contentType("application/json")
				.accept(ContentType.JSON)
				.body(payload)
				.when()
				.post();
		
		return response;
		
	}
	
	public static Response updatePet(Update upatepayload) {
		Response response = RestAssured.given().headers(
				"Content-Type",ContentType.JSON,
				"Accept",ContentType.JSON
				).baseUri(Routes.base_url)
				.basePath(Routes.update_pet)
				.contentType("application/json")
				.accept(ContentType.JSON)
				.body(upatepayload)
				.when()
				.put();
		
		return response;
	}
	
	public static Response deletePet(int i) {
		System.out.println(i);
		Response response = RestAssured.given().headers(
				"Content-Type",ContentType.JSON,
				"Accept",ContentType.JSON
				).baseUri(Routes.base_url)
				.basePath(Routes.delete)
				.pathParam("petId", i)
				.contentType("application/json")
				.accept(ContentType.JSON)
				.when()
				.delete();
		
		return response;
	}
	
	
	

}
