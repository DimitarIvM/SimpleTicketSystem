package bg.softuni.stssoftuniproject.config;

import bg.softuni.stssoftuniproject.web.interceptor.LoggedAdminInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig  implements WebMvcConfigurer {

    private final LoggedAdminInterceptor loggedAdminInterceptor;

    @Autowired
    public InterceptorConfig(LoggedAdminInterceptor loggedAdminInterceptor) {
        this.loggedAdminInterceptor = loggedAdminInterceptor;
    }


    @Override
    public void  addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor( loggedAdminInterceptor);
    }
}
