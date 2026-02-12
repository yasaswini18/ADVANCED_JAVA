package com.test.User;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class UserTest {
	User user = new User(101,
            "Yash",
            "yash@gmail.com",
            "12345",
            "123456789",
            User.Role.ADMIN,
            true,
            "11-02-2026");
	
	@Test
	public void testGetDetails()
	{
		String expected = "User[id=101, name=Yash, email=yash@gmail.com, password=12345, phone=123456789, Role=ADMIN, Active=true, Created At=11-02-2026]"; 		
		assertEquals(expected, user.getDetails());
	}
	
	@Test
	public void nullCheck()
	{
		
		assertNotNull(user);
	}
}
