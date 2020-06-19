package JSON_POJO;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JacksonAPI {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        User user = JacksonAPI.createUser();
        try {
            mapper.writeValue(new File("C:\\Users\\ajit\\Desktop\\Dholu\\ajeet_"+".txt"), user);
            String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
            System.out.println(jsonString);
        }catch(IOException e){
            e.printStackTrace();
        }

    }

    private static User createUser() {
        User user = new User();
        user.setAge(28);
        user.setName("Ajeet");
        List<String> message = new ArrayList<String>();
        message.add("Hey Jackson User created: Ajeet");
        user.setMessage(message);
        return user;
    }
}
