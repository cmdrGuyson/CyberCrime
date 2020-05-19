package Controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class UserFilter implements Filter {

    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest http_request = (HttpServletRequest) request;

        if (http_request.getSession().getAttribute("typeOfUser") != null) {
            String type = (String) http_request.getSession().getAttribute("typeOfUser");

            if (!type.equals("user")) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("util/access-denied.jsp");
                dispatcher.forward(request, response);
            }else{
                chain.doFilter(request, response);
            }
            
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("util/access-denied.jsp");
            dispatcher.forward(request, response);
        }

    }
    
}
