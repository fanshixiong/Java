import com.frans.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext();
        Object address = context.getBean("address");
        System.out.println(address);
//        Student student = (Student) context.getBean("student");
//        System.out.println(student);
    }
}
