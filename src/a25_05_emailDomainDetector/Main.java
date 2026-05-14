package a25_05_emailDomainDetector;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		List<String> emails = Arrays.asList(
				"anna@gmail.com", "joan@yahoo.com", "pere@gmail.com",
				"maria@outlook.com", "admin@gmail.com", "support@yahoo.com",
				"info@outlook.com", "invalidEmail", "test@GMAIL.com",
				"Anna@gmail.com", "lucia@gmail.com", "novalid@account@mail.com",
				"pere123@another.com", "admin@gmail.com", "support@yahoo.com",
				"invalid@yahoo", "invalid2@gmail"
		);
        EmailDomainDetector emailDomainDetector = new EmailDomainDetector();
        System.out.println(emailDomainDetector.countDomains(emails));

	}
}
