package br.com.alura.mvc.mudi;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import br.com.alura.mvc.mudi.interceptor.InterceptadorAcesso;

@Configuration
public class WebConfig implements WebMvcConfigurer{

	@Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        registry.addInterceptor(new InterceptadorAcesso()).addPathPatterns("/**");
    }
}
