package spring.security.chapter3.filters;

import java.io.IOException;
import java.util.logging.Logger;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

public class AuthenticationLoggingFilter implements Filter {
    private final Logger loger = Logger.getLogger(AuthenticationLoggingFilter.class.getName());
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
                var req = (HttpServletRequest)request;
                loger.info(() -> "Success auth req...-id :"+req.getHeader("Request-id"));
            chain.doFilter(request, response);

    }

}
