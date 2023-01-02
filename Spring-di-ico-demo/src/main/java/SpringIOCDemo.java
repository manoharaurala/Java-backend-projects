import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import javax.annotation.Resource;

public class SpringIOCDemo {
    public static void main(String[] args) {
        // its an implementation of BeanFactor
   ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("projectbeans.xml");
        //ApplicationContext context = new ClassPathXmlApplicationContext("projectbeans.xml");

        Engine engine2 = (Engine) context.getBean("engine2");
        System.out.println(engine2);





        Car hexa = (Car) context.getBean("car1");
        hexa.run();
        context.close();
    }
}
