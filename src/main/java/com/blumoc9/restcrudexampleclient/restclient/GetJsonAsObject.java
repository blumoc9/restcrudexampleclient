package com.blumoc9.restcrudexampleclient.restclient;

import javax.ws.rs.core.MediaType;

import com.blumoc9.restcrudexampleclient.model.Employee;
import com.blumoc9.restcrudexampleclient.staticValue.AbstractHarcodeUrl;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;


/**
 * 
 * @author fcolmenarez
 *
 */
public class GetJsonAsObject {
	
	 public static void main(String[] args) {
		 
	      ClientConfig clientConfig = new DefaultClientConfig();
	 
	      // Create Client based on Config
	      Client client = Client.create(clientConfig);
	 
	      WebResource webResource = client.resource(AbstractHarcodeUrl.URL_WEB_SERVICES_01);
	 
	      
	      try {
	    	  Builder builder = webResource.accept(MediaType.APPLICATION_JSON).header("content-type", MediaType.APPLICATION_JSON);
		      ClientResponse response = builder.get(ClientResponse.class);
	    	  // Status 200 is successful.
		      if (response.getStatus() != 200) {
		          System.out.println("Failed with HTTP Error code: " + response.getStatus());
		          String error= response.getEntity(String.class);
		          System.out.println("Error: "+error);
		          return;
		      }
		 
		      System.out.println("Output from Server .... \n");
		 
		      Employee employee = (Employee) response.getEntity(Employee.class);
		 
		      System.out.println("Emp No .... " + employee.getEmpNo());
		      System.out.println("Emp Name .... " + employee.getEmpName());
		      System.out.println("Position .... " + employee.getPosition());
			
		  } catch (Exception e) {
				System.out.println("response error");
		  }finally{
			  
		  }
	      
	      
	 
	  }
	

}
