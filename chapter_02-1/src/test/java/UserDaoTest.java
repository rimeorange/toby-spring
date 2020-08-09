import org.junit.Test;
import org.springframework.context.ApplicationContext;

import org.springframework.context.support.GenericXmlApplicationContext;
import springbook.user.dao.UserDao;
import springbook.user.domain.User;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.sql.SQLException;

public class UserDaoTest {
    @Test
    public void addAndGet() throws SQLException {
        ApplicationContext context =
                new GenericXmlApplicationContext("applicationContext.xml");

        UserDao dao = context.getBean("userDao", UserDao.class);
        User user = new User();
        user.setId("krazy");
        user.setName("심원보");
        user.setPassword("spring01");

        dao.add(user);
        User user2 = dao.get(user.getId());

        assertThat(user2.getName(), is(user.getName()));
        assertThat(user2.getPassword(), is(user.getPassword()));

    }
}
