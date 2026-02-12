package spring.security.chapter3.filters;

import java.io.IOException;
import java.net.http.HttpResponse;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpRequest;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Order(1)
public class CustomRequestFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request,
                        ServletResponse response,
                        FilterChain filterChain
                        )throws IOException, ServletException{
        
                            var httpReq = (HttpServletRequest)request;
                            var httpResp =(HttpServletResponse)response;

                            var header = httpReq.getHeader("Request-id");

        if ( header==null || header.isBlank()) {
            httpResp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        filterChain.doFilter(request, response);
    }
    
}
