import com.suhao.atcrowdfunding.bean.User;
import com.suhao.atcrowdfunding.manager.service.UserService;
import com.suhao.atcrowdfunding.util.MD5Util;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author suhao
 * @create_date 2020-05-26 0:46
 */

public class Test01 {
    public static void main(String[] args) {
        ApplicationContext ioc=new ClassPathXmlApplicationContext("spring/spring*.xml");
        UserService userService=ioc.getBean(UserService.class);
        for (int i=0;i<=100;i++){
            User user=new User();
            user.setLoginacct("test"+i);
            user.setUserpswd(MD5Util.digest("123"));
            user.setUsername("test"+i);
            user.setEmail("test"+i+"@suhao.com");
            user.setCreatetime("2020-05-26 00:55:00");

            userService.saveUser(user);
        }
    }
}
