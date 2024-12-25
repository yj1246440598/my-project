//package com.enjoy;
//
//import com.enjoy.entity.Users;
//import com.enjoy.mapper.UserMapper;
//import org.apache.shiro.authc.AuthenticationException;
//import org.apache.shiro.authc.AuthenticationInfo;
//import org.apache.shiro.authc.AuthenticationToken;
//import org.apache.shiro.authc.SimpleAuthenticationInfo;
//import org.apache.shiro.authc.UnknownAccountException;
//import org.apache.shiro.authc.UsernamePasswordToken;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.springframework.beans.factory.annotation.Autowired;
//
//public class MyRealm extends AuthorizingRealm {
//
//    @Autowired
//    private UserMapper userMapper;
//
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
//        String name = token.getUsername();
//        Users user = userMapper.selectByName(name);
//        if (user == null){
//            throw  new UnknownAccountException("账户不存在");
//        }
//        return new SimpleAuthenticationInfo(user,user.getPassword(),"myRealm");
//    }
//
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        return null;
//    }
//
//}
