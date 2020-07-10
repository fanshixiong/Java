import com.frans.services.UserServiceImp;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        UserServiceImp userServiceImp = (UserServiceImp) context.getBean("userServiceImpl");

        userServiceImp.getUser();

    }

}



