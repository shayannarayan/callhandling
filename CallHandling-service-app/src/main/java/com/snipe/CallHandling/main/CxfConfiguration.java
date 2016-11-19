package com.snipe.CallHandling.main;

import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
/**
 * Purpose:
 * 
 * created date:
 * 
 * Modified date:
 * @author Laxmikanth
 *
 */
@Configuration
@ImportResource("classpath:config/CallHandling-servlet.xml")
public class CxfConfiguration {
	/**
	 * 
	 * @return
	 */
	@Bean
    public ServletRegistrationBean cxfServlet() {
        ServletRegistrationBean servlet = new ServletRegistrationBean(new CXFServlet(), "/services/*");
        servlet.setLoadOnStartup(1);
        return servlet;
    }

}
