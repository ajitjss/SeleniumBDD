package JSON_POJO;

import java.util.List;

public class User {
    private  String name;
    private int age;
    private List<String> message;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<String> getMessage() {
        return message;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }
}
