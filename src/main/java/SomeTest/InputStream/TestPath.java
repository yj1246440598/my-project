package SomeTest.InputStream;

import com.enjoy.ApplicationMain;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;

public class TestPath {
    public static void main(String[] args) {
        System.out.println("--------------getResource-----------------");
        URL u1 = ApplicationMain.class.getResource("");
        URL u2 = ApplicationMain.class.getResource("a.json");
        URL u3 = ApplicationMain.class.getResource("/");
        URL u4 = ApplicationMain.class.getResource("./a.json");
        URL u5 = ApplicationMain.class.getResource("/a.json");
        System.out.println(u1);
        System.out.println(u2);
        System.out.println(u3);
        System.out.println(u4);
        System.out.println(u5);
        System.out.println("=================================");
        URL u6 = ApplicationMain.class.getClassLoader().getResource("");
        URL u7 = ApplicationMain.class.getClassLoader().getResource("a.json");
        URL u8 = ApplicationMain.class.getClassLoader().getResource("./a.json");
        URL u9 = ApplicationMain.class.getClassLoader().getResource("/");
        System.out.println(u6);
        System.out.println(u7);
        System.out.println(u8);
        System.out.println(u9);
        System.out.println("===================================");
        String absolutePath = new File("").getAbsolutePath();
        String absolutePath1 = new File("a.json").getAbsolutePath();
        String absolutePath2 = new File("./a.json").getAbsolutePath();
        String absolutePath3 = new File("/").getAbsolutePath();
        System.out.println(absolutePath);
        System.out.println(absolutePath1);
        System.out.println(absolutePath2);
        System.out.println(absolutePath3);

        System.out.println("==================================");
        String property = System.getProperty("user.dir");
        System.out.println(property);
        System.out.println("==================================");
        try {
            FileInputStream fileInputStream = new FileInputStream(ApplicationMain.class.getClassLoader().getResource("a.json").getPath());
            if (fileInputStream != null) {
                System.out.println("获取成功1");
            }else {
                System.out.println("获取失败1");
            }
        }catch (Exception e){

        }

        try {
            InputStream fileInputStream = ApplicationMain.class.getClassLoader().getResourceAsStream("a.json");
            if (fileInputStream != null) {
                System.out.println("获取成功");
            }else {
                System.out.println("获取失败");
            }
        }catch (Exception e){

        }
    }
}
