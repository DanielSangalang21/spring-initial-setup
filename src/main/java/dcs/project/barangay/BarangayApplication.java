package dcs.project.barangay;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import dcs.project.barangay.util.ConfigProperties;

@SpringBootApplication
public class BarangayApplication extends SpringBootServletInitializer{

	@Autowired
	ConfigProperties configProp;

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BarangayApplication.class);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(BarangayApplication.class, args);
	}

	@Bean
	public ResourceBundleMessageSource messageSource() {
		var source = new ResourceBundleMessageSource();
		source.setBasenames("application","messages/message");
		source.setUseCodeAsDefaultMessage(true);
		return source;
	}
	
	@Bean
    public DataSource getDataSource() {
		
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(configProp.getConfigValue("spring.datasource.driverClassName"));
        dataSourceBuilder.url(configProp.getConfigValue("spring.datasource.url"));
        dataSourceBuilder.username(configProp.getConfigValue("spring.datasource.username"));
        dataSourceBuilder.password(configProp.getConfigValue("spring.datasource.password"));
        return dataSourceBuilder.build();
    }
}
