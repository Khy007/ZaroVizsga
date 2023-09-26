package hu.pallas.vizsga;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Program {

	public static void main(String[] args) {
		
		Resource resource= new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		
		Stopper stopper = (Stopper)factory.getBean("beallitas");
		stopper.stopperGUI();
        
	}

}
