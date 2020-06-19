package APITest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.json.Json;

import java.io.File;
import java.io.IOException;

public class TreeModelReader {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(new File("Tree.JSON"));
        System.out.println("node value: "+ node.get("id").asText());
        JsonNode root =node.get("name");
        System.out.println(root.asText());
        if(root.isArray()){
            for(JsonNode jsNode: root){
                System.out.println("Value: "+jsNode.asText());
            }
        }
        JsonNode firstName= root.get("first");
        System.out.println("firstName: "+firstName);
        JsonNode lastName= root.get("last");
        System.out.println("Testing it's object"+ lastName.isObject());
        System.out.println("Testing it's Longs"+ lastName.isLong());
        System.out.println("Last Name: "+lastName);
        JsonNode contact = node.get("contact");
        if(contact.isArray()){
            for(JsonNode jsContact: contact){
                System.out.println("contact Value : "+ jsContact.get("type"));
                System.out.println("Contact value: "+jsContact.get("ref") );
            }
        }
    }

}
