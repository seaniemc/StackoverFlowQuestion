package todoapp.controllers;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@Configuration
public class ResourceController extends WebMvcConfigurerAdapter{
   @Override
      public void addViewControllers(ViewControllerRegistry registry) {
	   registry.addViewController("/").setViewName("app/views/index.html");
       registry.addViewController("/api/todos").setViewName("app/views/todo.html");
       registry.addViewController("static/views/register").setViewName("app/views/register.html");
       registry.addViewController("static/views/login").setViewName("app/views/login.html");
      }
}