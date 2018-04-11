package io.narayan.async;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * 
 * @author narayana
 *
 */
@Configuration
@ComponentScan
@EnableScheduling
@PropertySource("app.properties")
public class App {
 
	@Bean
	public static PropertySourcesPlaceholderConfigurer propsConfig() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		new AnnotationConfigApplicationContext(App.class);
	}
	
	@Scheduled(fixedDelayString = "${scheduler.fixedDelay}000")
	public void repeatIt() {
		System.out.println("Good Boy!!");
	}
}
