package bg.softuni.stssoftuniproject.utils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoggedAdminInterceptor implements HandlerInterceptor {


    @Override
   public boolean preHandle (HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.isAuthenticated()) {
            String username = auth.getName();
            System.out.println("Username " + username + " using " + request.getRequestURI());
        }

        return true;
    }
}
