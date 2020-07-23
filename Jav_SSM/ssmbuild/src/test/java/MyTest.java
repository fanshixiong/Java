import com.frans.pojo.Books;
import com.frans.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {

    /**
     *����˼·��
     * 1. Bean������
     *    1.1. �鿴Bean�Ƿ�ע��ɹ�
     *    1.2. ���Ƿ��ܹ���ѯ�������
     *    �����ԣ���ô�ײ�û���⣬������spring�������⣬ ���ϵ�ʱ��û�е��õ�service���bean
     *       1. applicationContext.xml û��ע��bean
     *       2. web.xml��û�а�spring�ܵ������ļ�
     *
     */

    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookServiceImpl = context.getBean("BookServiceImpl", BookService.class);
        List<Books> books = bookServiceImpl.queryAllBook();
        for (Books book : books) {
            System.out.println(book);
        }
    }
}
