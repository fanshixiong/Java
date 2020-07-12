import com.frans.pojo.Address;
import com.frans.pojo.Student;
import com.frans.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Address address = (Address) context.getBean("address");
        System.out.println(address);
        Student student = (Student) context.getBean("student");
        System.out.println(student);

        User user = context.getBean("user", User.class);
        System.out.println(user);
    }
}
