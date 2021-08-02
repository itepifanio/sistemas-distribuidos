package br.imd.rest;

import br.imd.rest.expections.RestRequestException;

public class Client {
	public static void main(String[] args) throws RestRequestException {
		ClientService restClient = new ClientService();
		restClient.execute();
	}
}
