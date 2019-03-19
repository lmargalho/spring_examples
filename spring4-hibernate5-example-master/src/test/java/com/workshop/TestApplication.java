package com.workshop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.workshop.MyApplication;
import com.workshop.config.AppConfiguration;

/**
 * 
 * @author bytesTree
 * @see <a href="http://www.bytestree.com/">BytesTree</a>
 * 
 */
public class TestApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = null;
		try {
			context = new AnnotationConfigApplicationContext(AppConfiguration.class);
			MyApplication application = context.getBean(MyApplication.class);

			//application.performDbTasks();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			context.close();
		}	    
	}
}