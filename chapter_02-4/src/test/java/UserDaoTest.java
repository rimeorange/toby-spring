import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import springbook.user.dao.UserDao;
import springbook.user.domain.User;

import java.sql.SQLException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class UserDaoTest {
    @Test
    public void addAndGet() throws SQLException{
        ApplicationContext context =
                new GenericXmlApplicationContext("applicationContext.xml");

        UserDao dao = context.getBean("userDao", UserDao.class);
        User user1 = new User("rime1", "심원보", "spring01");
        User user2 = new User("rime2", "심원보", "spring02");

        dao.deleteAll();
        assertThat(dao.getCount(), is(0));

        dao.add(user1);
        dao.add(user2);
        assertThat(dao.getCount(), is(2));

        User userget1 = dao.get(user1.getId());
        assertThat(userget1.getName(), is(user1.getName()));
        assertThat(userget1.getPassword(), is(user1.getPassword()));

        User userget2 = dao.get(user2.getId());
        assertThat(userget2.getName(), is(user2.getName()));
        assertThat(userget2.getPassword(), is(user2.getPassword()));
    }

}
