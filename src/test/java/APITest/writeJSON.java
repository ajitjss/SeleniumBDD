package APITest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;

public class writeJSON {
public static void main(String [] args) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    JsonNode root = mapper.readTree(new File("Tree.JSON"));
    ((ObjectNode)root).remove("id");
    ((ObjectNode)root).put("empCode", "a31311");
    ((ObjectNode)root).put("salary", "500");
    ((ObjectNode)root).withArray("month").add(250);
    ((ObjectNode)root).withArray("month").add(350);
    ((ObjectNode)root).withArray("month").add(450).add(850);
    ((ObjectNode)root).withArray("month").add(550);
    ((ObjectNode)root).withArray("month").add(750);
    ((ObjectNode)root).withArray("month").add(250);
    ((ObjectNode)root).putArray("homeTown").add("Ballia").add("Mau");
    ((ObjectNode)root).putArray("homeTown").removeAll();
    ((ObjectNode)root).withArray("withArray").add("withArray1").add("WithArray2");
    ((ObjectNode)root).putArray("putArray").add("putArray").add("PutArray2");

    System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(root));

}
}