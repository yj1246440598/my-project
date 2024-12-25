//package com.enjoy.filter;
//
//import org.apache.shiro.subject.Subject;
//import org.apache.shiro.web.filter.authc.LogoutFilter;
//import org.springframework.util.StringUtils;
//
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//
//public class MyLogOutFilter extends LogoutFilter {
//    /**
//     * 退出后重定向的地址
//     */
//    private String loginUrl;
//
//    public String getLoginUrl() {
//        return loginUrl;
//    }
//
//    public void setLoginUrl(String loginUrl) {
//        this.loginUrl = loginUrl;
//    }
//
//    @Override
//    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
//        Subject subject = getSubject(request, response);
//        String redirectUrl = getRedirectUrl(request, response, subject);
//        subject.logout();
//        issueRedirect(request, response, redirectUrl);
//        return false;
//    }
//
//    /**
//     * 退出跳转URL
//     */
//    @Override
//    protected String getRedirectUrl(ServletRequest request, ServletResponse response, Subject subject) {
//        String url = getLoginUrl();
//        if (!StringUtils.isEmpty(url)) {
//            return url;
//        }
//        return super.getRedirectUrl(request, response, subject);
//    }
//}
