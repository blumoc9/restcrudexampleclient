package com.blumoc9.restcrudexampleclient.restclient;

import com.blumoc9.restcrudexampleclient.model.Employee;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class PostJsonObject {

	public static void main(String[] args) {
		 
        Client client = Client.create();
 
        WebResource webResource = client.resource("http://localhost:8080/RESTfulCRUD/rest/employees");
 
        // This object will be automatically converted into JSON
        Employee newEmp = new Employee("E05", "New Emp1", "Manager");
 
        ClientResponse response = webResource.type("application/json").post(ClientResponse.class, newEmp);
 
        if (response.getStatus() != 200) {
            System.out.println("Failed : HTTP error code : " + response.getStatus());
 
            String error = response.getEntity(String.class);
            System.out.println("Error: " + error);
            return;
        }
 
        System.out.println("Output from Server .... \n");
 
        String output = response.getEntity(String.class);
 
        System.out.println(output);
 
    }
}
