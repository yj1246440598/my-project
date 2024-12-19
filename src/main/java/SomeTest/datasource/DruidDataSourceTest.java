package SomeTest.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;

import javax.naming.NamingException;
import javax.naming.RefAddr;
import javax.naming.Reference;
import java.sql.SQLException;
import java.util.Enumeration;

public class DruidDataSourceTest {
    public static void main(String[] args) throws NamingException {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/security?useSSL=false&serverTimezone=UTC");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("111111");
        druidDataSource.setName("druid-test");
        druidDataSource.setUseUnfairLock(true);

        Reference reference = druidDataSource.getReference();
        Enumeration<RefAddr> all = reference.getAll();
        while (all.hasMoreElements()){
            System.out.println(all.nextElement());
        }
//
//        try {
//            for (int i = 0; i < 5; i++) {
//                DruidPooledConnection connection = druidDataSource.getConnection();
//                DruidPooledConnection connection1 = druidDataSource.getConnection();
//                System.out.println(connection);
//                System.out.println(connection1);
//                if (i % 3 == 0){
//                    connection.close();
//                    connection1.close();
//                }
//            }
//
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }

    }
}
