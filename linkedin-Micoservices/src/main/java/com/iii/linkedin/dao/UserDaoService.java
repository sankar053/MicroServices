package com.iii.linkedin.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import com.iii.linkedin.model.User;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<User>();
	private static int usersCount = 3;
	static {
		users.add(new User(1, "Sankar", new Date()));
		users.add(new User(2, "Rajaguru", new Date()));
		users.add(new User(3, "Sowmiya", new Date()));
	}

	public List<User> findAll() {
		return users;
	}

	public User save(User user) {
		if (user.getId() == null) {
			user.setId(++usersCount);
		}
		users.add(user);
		return (user);
	}

	public User findById(int id) {

		for (User user : users) {
			if (user.getId() == id) {
				return (user);
			}
		}
		return null;

	}

	public User deleteById(@PathVariable int id) {

		Iterator<User> iterattor = users.iterator();
		while (iterattor.hasNext()) {
			User user = iterattor.next();
			if (id == user.getId()) {
				iterattor.remove();
				return (user);
			}
		}

		return (null);

	}

}
