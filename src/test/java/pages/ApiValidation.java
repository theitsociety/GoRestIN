package pages;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import utulities.ConfigurationReader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class ApiValidation {
	public Response response;

	private String updateBody(String name, String gender, String email, String status) {
		String body = "";
		try {
			body = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir") + File.separator + "src/test/resources/data/userDetails.json")));
			body = body.replaceAll("replaceName", name);
			body = body.replaceAll("replaceEmail", email);
			body = body.replaceAll("replaceGender", gender);
			body = body.replaceAll("replaceStatus", status);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return body;
	}

	public Response postMethod(String name, String gender, String email, String status) {
		String requestBody = updateBody(name, gender, email, status);
		Response response = given()
				.headers("Authorization", "Bearer 7c1158095623c6486eae51ffd8f901971ac32060fe9dde5f0c94c14404817c0d",
						"Content-Type", "application/json", "Accept", ContentType.JSON)
				.body(requestBody)
				.post();
		return response;
	}

	public Response putMethod(String name, String gender, String email, String status) {
		String requestBody = updateBody(name, gender, email, status);
		Response response = given()
				.headers("Authorization", "Bearer 7c1158095623c6486eae51ffd8f901971ac32060fe9dde5f0c94c14404817c0d",
						"Content-Type", "application/json", "Accept", ContentType.JSON)
				.body(requestBody)
				.put();

		return response;
	}


	private String updatePostBody(String postBody, String title) {
		String body = "";
		try {
			body = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir") + File.separator + "src/test/resources/data/postCreate.json")));
			body = body.replaceAll("replaceBody", postBody);
			body = body.replaceAll("replaceTitle", title);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return body;
	}

	public Response postMethodCreate(String body, String title) {
		String requestBody = updatePostBody(body, title);
		Response response = given()
				.headers("Authorization", "Bearer 7c1158095623c6486eae51ffd8f901971ac32060fe9dde5f0c94c14404817c0d",
						"Content-Type", "application/json", "Accept", ContentType.JSON)
				.body(requestBody)
				.post();

		return response;
	}

	public String updatePostBody(String comment, String name, String email) {
		String body = "";
		try {
			body = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir") + File.separator + "src/test/resources/data/createComment.json")));
			body = body.replaceAll("replaceBody", comment);
			body = body.replaceAll("replaceName", name);
			body = body.replaceAll("replaceEmail", email);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return body;
	}
	public Response postMethodComment(String comment, String name, String email) {
		String requestBody = updatePostBody(comment, name,email);
		Response response = given()
				.headers("Authorization", "Bearer 7c1158095623c6486eae51ffd8f901971ac32060fe9dde5f0c94c14404817c0d",
						"Content-Type", "application/json", "Accept", ContentType.JSON)
				.body(requestBody)
				.post();

		return response;
	}

	public Response deleteMethod() {
		Response response=given()
				.headers("Authorization","Bearer "+ ConfigurationReader.getProperty("bearerToken"),
						"Content-Type", "application/json", "Accept", ContentType.JSON)
				.delete();
		return response;
	}
}
