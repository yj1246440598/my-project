package SomeTest.spring;

public class ConstorArgTest {

    private  String  name;

    public ConstorArgTest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
