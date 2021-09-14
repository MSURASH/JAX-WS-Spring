import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;

import employeemanagment.services.EmployeeService;
import employeemanagment.services.EmployeeServiceImplService;

public class Main {

	public static void main(String[] args) {
		

		EmployeeService webserivce = new EmployeeServiceImplService().getEmployeeServiceImplPort();
		//Employee employee = webserivce.getEmployeeById("3");
		//System.out.println(employee.getId()+" "+employee.getName());
		//Map requestCtx = ((BindingProvider) webserivce).getRequestContext();
        //requestCtx.put(BindingProvider.USERNAME_PROPERTY, "JDe");
        //requestCtx.put(BindingProvider.PASSWORD_PROPERTY, "jde");
 
        String url = "http://localhost:8080/employeeservice?wsdl";
        //requestCtx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url);
        ((BindingProvider) webserivce).getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "JDE");
        ((BindingProvider) webserivce).getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "jde");
        ((BindingProvider) webserivce).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url);
        ((BindingProvider) webserivce).getRequestContext().put(MessageContext.HTTP_REQUEST_HEADERS, getHeaders());

 
        for (int i = 1; i < 6; i++) {
        	
            System.out.println(webserivce.getEmployeeById(Integer.toString(i)).getName());
        }
		
	}
	
	private static Map<String, List<String>> getHeaders(){
		Map<String, List<String>> headers = new HashMap<>();
		headers.put("CONSUMER_ID", Collections.singletonList("DLA_CON"));
		headers.put("CONTEXT_ID", Collections.singletonList("DLA"));
		headers.put("DP_AUTH_TYPE", Collections.singletonList("authtype_user"));

		return headers;
		
	}

}
