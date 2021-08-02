package br.imd.rest;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import br.imd.rest.expections.RestRequestException;

public class ClientService {
	private final Scanner scanner;
	private int groupIndex;
	private String user;

	public ClientService() {
		this.scanner = new Scanner(System.in);
	}

	public void publishMessage(int index, String userName, String message) throws RestRequestException {

		String uri = "http://localhost:8080/grupo/publish/" + index;
		Map<String, String> headerParams = new HashMap<String, String>();

		headerParams.put("accept", "application/json");
		headerParams.put("content-type", "text/plain");

		String json = "{\"userName\": \"" + userName + "\", \"message\": \"" + message + "\"}";
		String response = HttpUtils.httpPostRequest(uri, headerParams, json, 200);
	}

	public void enterGroup(int index, String userName) throws RestRequestException {

		String uri = "http://localhost:8080/grupo/enter/" + index;
		Map<String, String> headerParams = new HashMap<String, String>();

		headerParams.put("accept", "application/json");
		headerParams.put("content-type", "text/plain");

		String response = HttpUtils.httpPostRequest(uri, headerParams, userName, 200);
	}

	public void createGroup(String name) throws RestRequestException {

		String uri = "http://localhost:8080/grupo/create/";
		Map<String, String> headerParams = new HashMap<String, String>();

		headerParams.put("accept", "application/json");
		headerParams.put("content-type", "text/plain");

		String response = HttpUtils.httpPostRequest(uri, headerParams, name, 200);

		JSONObject jsonObject = new JSONObject(response);
		System.out.println("Grupo \"" + jsonObject.get("name") + "\" criado com sucesso!");
	}

	public void listGroups() throws RestRequestException {

		String uri = "http://localhost:8080/grupo/";
		Map<String, String> headerParams = new HashMap<String, String>();

		headerParams.put("accept", "application/json");

		String response = HttpUtils.httpGetRequest(uri, headerParams);

		JSONArray json = new JSONArray(response);
		for(int i = 0; i < json.length(); i++) {
			JSONObject jsonObject = new JSONObject(json.get(i).toString());
			System.out.println("Index " + i + " Group " + jsonObject.get("name"));
		}
		System.out.println();
	}

	public void listMessages() throws RestRequestException {

		String uri = "http://localhost:8080/grupo/" + this.groupIndex + "/messages";
		Map<String, String> headerParams = new HashMap<String, String>();

		headerParams.put("accept", "application/json");

		String response = HttpUtils.httpGetRequest(uri, headerParams);

		JSONArray json = new JSONArray(response);
		for(int i = 0; i < json.length(); i++) {
			JSONObject jsonObject = new JSONObject(json.get(i).toString());
			System.out.println(jsonObject.get("user") + ": " + jsonObject.get("message"));
			System.out.println();
		}
	}

	private void listGroupOptions() throws RestRequestException {
		int option;

		label:
		while(true) {
			this.groupMenu();
			option = this.scanner.nextInt();
			this.scanner.nextLine();

			switch (option) {
				case 1:
					System.out.println("Insert message:");
					String message = this.scanner.nextLine();
					this.publishMessage(this.groupIndex, this.user, message);
				case 2:
					this.listMessages();
					break;
				case 0:
					this.groupIndex = -1;
					break label;
				default:
					System.out.println("This option is invalid.");
					break;
			}
		}
	}

	private void mainMenu()
	{
		System.out.println("\nPress 1 to create a group");
		System.out.println("Press 2 to enter in group");
		System.out.println("Press 0 to exit Concord");
	}

	private void groupMenu()
	{
		System.out.println("\nPress 1 to publish a message");
		System.out.println("Press 2 to print group messages");
		System.out.println("Press 0 to exit the group");
	}

	private void addToGroup() throws RestRequestException {
		System.out.println("Insert name of group: ");
		this.createGroup(this.scanner.nextLine());
	}

	public void execute() throws RestRequestException {
		System.out.println("Inser your name: ");
		this.user = this.scanner.nextLine();

		int option;

		label:
		while(true) {
			this.mainMenu();

			option = this.scanner.nextInt();
			this.scanner.nextLine();

			switch (option) {
				case 1:
					this.addToGroup();
					break;
				case 2:
					this.listGroups();

					System.out.println("Insert index of group");
					this.groupIndex = this.scanner.nextInt();

					if(this.groupIndex == -1) {
						break;
					}

					this.scanner.nextLine();
					this.listGroupOptions();
					break;
				case 0:
					break label;
				default:
					System.out.println("This option is invalid.");
					break;
			}
		}
	}

}
