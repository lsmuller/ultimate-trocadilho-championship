package com.utc.repositories;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.utc.UtcApplication;
import com.utc.entities.User;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {UtcApplication.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UserRepositoryTest {

	@Autowired
	private UserRepository repository;

	@Test
	public void createUserShouldPersistData() {
		User user = new User.Builder().withEmail("test@sap.com").withPassword("12345").build();
		repository.save(user);

		User actUser = repository.findByEmail("test@sap.com");

		Assert.assertEquals(user.getEmail(), actUser.getEmail());
		Assert.assertEquals(user.getPassword(), actUser.getPassword());
		Assert.assertNotNull(user.get_id());
	}

}
