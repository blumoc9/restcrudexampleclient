package com.blumoc9.restcrudexampleclient.restclient;

import com.blumoc9.restcrudexampleclient.staticValue.AbstractHarcodeUrl;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * this class allow test connection with the service
 * @author fcolmenarez
 *
 */
public class GetJsonAsString {
	
	private static final String FAILED_TO_CONNECT_TO_SERVICE = "Failed to connect to service";
	private static final String OUTPUT_FROM_SERVER = "Output from Server .... \n";
	private static final String ERROR2 = "Error: ";
	private static final String FAILED_WITH_HTTP_ERROR_CODE = "Failed with HTTP Error code: ";
	private static final String APPLICATION_JSON = "application/json";

	public static void main(String[] args) {
		 
		 try {
		     	 // Create Client
				 Client client = Client.create();
				 WebResource webResource = client.resource(AbstractHarcodeUrl.URL_WEB_SERVICES_01);
				 
			     ClientResponse response = webResource.accept(APPLICATION_JSON).get(ClientResponse.class);
			 
			     // Status 200 is successful.
			     if (response.getStatus() != 200) {
			         System.out.println(FAILED_WITH_HTTP_ERROR_CODE + response.getStatus());
			         String error= response.getEntity(String.class);
			         System.out.println(ERROR2+error);
			         return;
			     }
			 
			     String output = response.getEntity(String.class);
			 
			     System.out.println(OUTPUT_FROM_SERVER);
			     System.out.println(output);
		     
		 } catch (Exception e) {
			// TODO: handle exception
			 System.out.println(FAILED_TO_CONNECT_TO_SERVICE+e.getMessage());
		 }
	     
	 }

	
	
}
