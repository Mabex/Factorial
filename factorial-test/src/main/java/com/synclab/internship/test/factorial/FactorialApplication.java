package com.synclab.internship.test.factorial;

import com.synclab.internship.test.factorial.utils.ArgsParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync // Switches on Spring’s ability to run @Async methods in a background thread pool.
public class FactorialApplication implements ApplicationRunner {

	private Environment env;
	private ConcurrentRunner concurrentRunner;

	@Autowired
	public FactorialApplication(Environment env, ConcurrentRunner concurrentRunner) {
		this.env = env;
		this.concurrentRunner = concurrentRunner;
	}

	public static void main(String[] args) {
		SpringApplication.run(FactorialApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		if (ArgsParser.check(args)) {

			int requestNumber = ArgsParser.getRequestNumber(args);
			int toFactorial = ArgsParser.getNumberToFactorial(args);

			System.out.println("Warm up with three synchronous calls:");
			for (int i = 0; i < 3; i++) {
				concurrentRunner.factorial(1, toFactorial);
			}

			System.out.println("\nAsynchronous calls:.");
			concurrentRunner.factorial(requestNumber, toFactorial);
		}
	}
}
