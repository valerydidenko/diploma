package diploma.factories;

import diploma.entity.User;
import diploma.enums.RoleEnum;

public final class UserFactory {

	private static User generateSimpleUser() {
		User user = new User();
		user.setLogin("test_login");
		user.setPassword("test_pass");
		user.setUkrName("test_ukr_name");
		user.setUkrSurname("test_ukr_surname");
		user.setEngName("test_eng_name");
		user.setEngSurname("test_eng_surname");
		return user;
	}

	public static User generateUser() {
		User user = generateSimpleUser();
		user.setRole(RoleEnum.USER);
		return user;
	}

	public static User generateAdmin() {
		User user = generateSimpleUser();
		user.setRole(RoleEnum.ADMIN);
		return user;
	}

}