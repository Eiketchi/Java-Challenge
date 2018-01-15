package challengeJava.challengeJava.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import challengeJava.challengeJava.model.User;

@Service
public class LoginService {

    public boolean validateUser(String email, String password) {
        return searchUser(email,password);
    }
    
    public boolean addUser(String email, String password) {
    	if (searchEmail(email))
    		return false;
    	else
    		return saveUser(email,password);
    }
    

    
    /************************** XML Operations**************************************/
    private static boolean searchUser(String email, String password) { 
	    String filePath = "src/main/resources/users.xml";
	    File xmlFile = new File(filePath);
	    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder dBuilder;
	    try {
	        dBuilder = dbFactory.newDocumentBuilder();
	        Document doc = dBuilder.parse(xmlFile);
	        doc.getDocumentElement().normalize();
	        
	            NodeList nodeList = doc.getElementsByTagName("User");
	            List<User> userList = new ArrayList<User>();
	            for (int i = 0; i < nodeList.getLength(); i++) {
	                userList.add(getEmployee(nodeList.item(i)));
	            }
	            
	            for (User user : userList) 
	            {
	            	if(user.getEmail().equals(email))
	            		if(user.getPassword().equals(password))
	            			return true;
	            }
	            return false;
	    } catch (SAXException | ParserConfigurationException | IOException  e1) {
	        e1.printStackTrace();
	        return false;
	    }
    }
    
    private static boolean searchEmail(String email) { 
	    String filePath = "src/main/resources/users.xml";
	    File xmlFile = new File(filePath);
	    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder dBuilder;
	    try {
	        dBuilder = dbFactory.newDocumentBuilder();
	        Document doc = dBuilder.parse(xmlFile);
	        doc.getDocumentElement().normalize();
	            NodeList nodeList = doc.getElementsByTagName("User");
	            List<User> userList = new ArrayList<User>();
	            for (int i = 0; i < nodeList.getLength(); i++) {
	                userList.add(getEmployee(nodeList.item(i)));
	            }
	            
	            for (User user : userList) 
	            {
	            	if(user.getEmail().equals(email))
	            			return true;
	            }
	            return false;        
	    } catch (SAXException | ParserConfigurationException | IOException e1) {
	        e1.printStackTrace();
	        return false;
	    }
    }
    
    
    private static boolean saveUser(String email, String password) {
    	 String filePath = "src/main/resources/users.xml";
    	    File xmlFile = new File(filePath);
    	    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    	    DocumentBuilder dBuilder;
    	    try {
	    	        dBuilder = dbFactory.newDocumentBuilder();
	    	        Document doc = dBuilder.parse(xmlFile);
	    	        doc.getDocumentElement().normalize();
	    	        
	    	          
	    	   
				  	  Element root = doc.getDocumentElement();
				
				        Collection<User> users = new ArrayList<User>();
				        users.add(new User());
				

				            Element newUser = doc.createElement("User");
				
				            Element mail = doc.createElement("email");
				            mail.appendChild(doc.createTextNode(email));
				            newUser.appendChild(mail);
				
				            Element pw = doc.createElement("password");
				            pw.appendChild(doc.createTextNode(password));
				            newUser.appendChild(pw);
				
				            root.appendChild(newUser);

				        
				        
				        doc.getDocumentElement().normalize();
				        TransformerFactory transformerFactory = TransformerFactory.newInstance();
				        Transformer transformer = transformerFactory.newTransformer();
				        DOMSource source = new DOMSource(doc);
				        StreamResult result = new StreamResult(new File(filePath));
				        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
				        transformer.transform(source, result);
				        return true;
			        
			    } catch (SAXException | ParserConfigurationException | IOException | TransformerException e1) {
			        e1.printStackTrace();
			        return false;
			    }
    
    }
  
  
  
  
  
  
	  private static User getEmployee(Node node) {
	      User user = new User();
	      if (node.getNodeType() == Node.ELEMENT_NODE) {
	          Element element = (Element) node;
	          user.setEmail(getTagValue("email", element));
	          user.setPassword(getTagValue("password", element));
	      }
	
	      return user;
	  }
	
	
	  private static String getTagValue(String tag, Element element) {
	      NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
	      Node node = (Node) nodeList.item(0);
	      return node.getNodeValue();
	  }

    
    
    
    
    
    
    
}