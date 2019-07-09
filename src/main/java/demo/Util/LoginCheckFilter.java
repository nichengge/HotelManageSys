package demo.Util;

import demo.Model.Customer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoginCheckFilter", urlPatterns = {"/*"})
@Order(FilterRegistrationBean.LOWEST_PRECEDENCE - 2)
public class LoginCheckFilter implements Filter {

    public static int m = 1;

    @Override
    public void init(FilterConfig filterConfig) {
    }


    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();
        Customer loginedCustomer = (Customer) session.getAttribute("LoginedCustomer");
        System.out.println("过滤请求...");
        String requestPath = request.getServletPath();
        if (loginedCustomer != null
                || requestPath.endsWith("Login")
                || requestPath.endsWith("Register") || m == 1) {
            m=0;
            chain.doFilter(req, resp);
        } else {
            System.out.println("1");
            m=1;
            response.setHeader("Refresh", "1; URL=go?url=CustomerLogin");
        }
    }


}
