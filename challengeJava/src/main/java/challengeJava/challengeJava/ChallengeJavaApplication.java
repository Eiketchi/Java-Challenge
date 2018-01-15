package challengeJava.challengeJava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("challengeJava.challengeJava")
public class ChallengeJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChallengeJavaApplication.class, args);
	}
}
