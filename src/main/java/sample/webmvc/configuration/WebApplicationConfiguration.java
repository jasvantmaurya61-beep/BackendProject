package sample.webmvc.configuration;

import org.jspecify.annotations.Nullable;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletRegistration;

public class WebApplicationConfiguration implements WebApplicationInitializer {

	@Override
	public void onStartup(@Nullable ServletContext servletContext) {
		
		
		
		AnnotationConfigWebApplicationContext annWebConfig =  new AnnotationConfigWebApplicationContext();
	
	annWebConfig.register(SpringConfiguration.class);
	
	annWebConfig.setServletContext(servletContext);
	ServletRegistration.Dynamic servlet =  servletContext.addServlet("dispatcher", new DispatcherServlet(annWebConfig));
	servlet.setLoadOnStartup(1);
	servlet.addMapping("/");
	
		
	}

}
