import org.junit.Before;
import org.junit.Test;

import com.goglezon.jadmin.model.User;
import com.goglezon.jadmin.service.UserService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Yuwenqi on 2015/10/7.
 */
public class ServiceTest {

    private UserService userService;

    @Before
    public void init() throws Exception {

        ApplicationContext aCtx = null;
       try {
            aCtx = new FileSystemXmlApplicationContext("classpath:spring-config.xml");
            userService = (UserService) aCtx.getBean("userService");
        } catch (BeansException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void get(){
        User user=new User();
        user.setUserId(1);
        user=userService.get(user);
        System.out.println(user);
    }

    @Test
    public void getUsersByGroup(){
        List<User> list=userService.getUsersByGroup(1);
        System.out.println(list);
    }

    @Test
    public void delete(){
        User user=new User();
        user.setUserId(266);
        boolean ret=userService.delete("admin",user );
        System.out.println(ret);
    }

    @Test
    public void update(){
        User user=new User();
        user.setUserId(1);
        user.setEmail("yuwenqi@goglezon.com");
        user.setShowQuicknote(-1);
        boolean ret=userService.update("admin",user);
        System.out.println(ret);
    }

    @Test
    public void modifyUsersGroup(){
        Map map=new HashMap();
        map.put("userGroup",2);

       List list=new ArrayList();
        list.add(278);
        list.add(280);
        list.add(284);
        map.put("userIds",list);
        boolean ret=userService.modifyUsersGroup("admin", map);
        System.out.println(ret);
    }
    @Test
    public void testDubbo(){

    }
}
