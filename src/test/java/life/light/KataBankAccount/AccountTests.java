package life.light.KataBankAccount;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AccountTests {

	@Test
	void Shouls_balanceReturn0_When_noTransaction() {

		// Give
		Account account = new Account();

		// When

		//Then
		assertThat(account.getBalance()).isEqualTo(0);

	}

	@Test
	void Should_balanceReturn1_When_firstDeposit1() {

		// Give
		Account account = new Account();

		// When
		account.deposit(1);

		//Then
		assertThat(account.getBalance()).isEqualTo(1);

	}


	@Test
	void Should_returnBalance_When_someDeposit() {

		// Give
		Account account = new Account();

		// When
		account.deposit(1);
		account.deposit(3);
		account.deposit(6);

		//Then
		assertThat(account.getBalance()).isEqualTo(10);

	}

}
