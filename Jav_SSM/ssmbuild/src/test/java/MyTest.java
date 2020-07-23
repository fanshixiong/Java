import com.frans.pojo.Books;
import com.frans.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {

    /**
     *测试思路：
     * 1. Bean不存在
     *    1.1. 查看Bean是否注入成功
     *    1.2. 看是否能够查询出结果。
     *    都可以，那么底层没问题，可能是spring出了问题， 整合的时候没有调用到service层的bean
     *       1. applicationContext.xml 没有注入bean
     *       2. web.xml中没有绑定spring总的配置文件
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
