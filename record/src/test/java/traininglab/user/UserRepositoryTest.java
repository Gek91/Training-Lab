package traininglab.user;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import traininglab.user.domain.model.User;
import traininglab.user.domain.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@Transactional
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void getUserListService() {

		List<User> users = userRepository.getUserList();

		Assert.assertEquals(3, users.size());
		Assert.assertEquals("1", users.get(0).getId());
		Assert.assertEquals("us1", users.get(0).getFirstname());
		Assert.assertEquals("last1", users.get(0).getLastname());
		Assert.assertTrue(users.stream().map(User::getId).collect(Collectors.toSet()).containsAll(Arrays.asList("1","2","3")));
	}
}
