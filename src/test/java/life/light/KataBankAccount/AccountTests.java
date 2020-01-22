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
	void Should_balanceReturn10_When_deposit15AndWithdrawal5() {

		// Give
		Account account = new Account();

		// When
		account.deposit(15);
		account.withdrawal(5);

		//Then
		assertThat(account.getBalance()).isEqualTo(10);

	}

	@Test
	void Should_balanceReturn_When_someWithdrawal() {

		// Give
		Account account = new Account();

		// When
		account.deposit(15);
		account.withdrawal(5);
		account.withdrawal(2);

		//Then
		assertThat(account.getBalance()).isEqualTo(8);

	}

	@Test
	void Should_returnHistoryOfOneOperation_When_deposit(){
		 // Give
		Account account = new Account();

		// When
		account.deposit(10);

		// Then
		assertThat(account.history()).isEqualTo("Deposit | 01/01/2020 | 10,00 | 10,00");
	}



}
