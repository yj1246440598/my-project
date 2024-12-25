//package com.enjoy.config;
//
//import com.enjoy.MyRealm;
//import com.enjoy.filter.MyLogOutFilter;
//import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
//import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.servlet.Filter;
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//@Configuration
//public class ShiroConfig {
//
//    @Bean
//    public MyRealm myRealm() {
//        MyRealm myRealm = new MyRealm();
//        return myRealm;
//    }
//
//    @Bean
//    public DefaultWebSecurityManager defaultWebSecurityManager(MyRealm myRealm) {
//        DefaultWebSecurityManager defaultSecurityManager = new DefaultWebSecurityManager();
//        defaultSecurityManager.setRealm(myRealm);
//        return defaultSecurityManager;
//    }
//
//    @Bean
//    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager securityManager) {
//        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
//        shiroFilterFactoryBean.setSecurityManager(securityManager);
//
//        Map<String, String> filtermap = new LinkedHashMap<String, String>();
//        filtermap.put("/logout","logout");
////        filtermap.put("/login", "anon");
////        filtermap.put("/**", "authc");
//////        filtermap.put("/user/add","perms[user:add]");
//////        filtermap.put("/user/update","perms[user:update]");
//////        filtermap.put("/classes/findall","perms[classes:findall]");
//////        shiroFilterFactoryBean.setLoginUrl("/main");
////        shiroFilterFactoryBean.setSuccessUrl("/main");
//////        shiroFilterFactoryBean.setUnauthorizedUrl("/noAuth.html");
//        shiroFilterFactoryBean.setFilterChainDefinitionMap(filtermap);
//        Map<String, Filter> filters = new LinkedHashMap<>();
//        filters.put("logout", logOutFilter());
//        shiroFilterFactoryBean.setFilters(filters);
//        return shiroFilterFactoryBean;
//    }
//
//    /**
//     * 退出过滤器
//     */
//    public MyLogOutFilter logOutFilter()
//    {
//        MyLogOutFilter logoutFilter = new MyLogOutFilter();
//        logoutFilter.setLoginUrl("/login");
//        return logoutFilter;
//    }
//
//}
