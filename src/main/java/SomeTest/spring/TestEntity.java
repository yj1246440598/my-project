package SomeTest.spring;

import SomeTest.aop.AopUser;
import SomeTest.aop.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class TestEntity {
    @Override
    public String toString() {
        return "TestEntity{" +
                "speC1='" + speC1 + '\'' +
                ", speC2='" + speC2 + '\'' +
                ", aopUser=" + aopUser +
                ", list=" + list +
                ", array=" + Arrays.toString(array) +
                ", set=" + set +
                ", map=" + map +
                ", properties=" + properties +
                ", empty='" + empty + '\'' +
                ", nullValue='" + nullValue + '\'' +
                '}';
    }

    private String speC1;
    private String speC2;
    private AopUser aopUser;
    private List<String> list;
    private String[] array;
    private Set<String> set;
    private Map<String,String> map ;
    private Properties properties;
    private String empty;
    private String nullValue="init value";

    public String getSpeC1() {
        return speC1;
    }

    public void setSpeC1(String speC1) {
        this.speC1 = speC1;
    }

    public String getSpeC2() {
        return speC2;
    }

    public void setSpeC2(String speC2) {
        this.speC2 = speC2;
    }

    public AopUser getAopUser() {
        return aopUser;
    }

    public void setAopUser(AopUser aopUser) {
        this.aopUser = aopUser;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public String[] getArray() {
        return array;
    }

    public void setArray(String[] array) {
        this.array = array;
    }

    public Set<String> getSet() {
        return set;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public String getEmpty() {
        return empty;
    }

    public void setEmpty(String empty) {
        this.empty = empty;
    }

    public String getNullValue() {
        return nullValue;
    }

    public void setNullValue(String nullValue) {
        this.nullValue = nullValue;
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:EntityApplicationContext.xml");
        TestEntity entity = (TestEntity) context.getBean("testEntity");
        System.out.println(entity);
    }
}
