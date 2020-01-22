package life.light.KataBankAccount;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AccountTests {

	private Transaction transactionWithdrawal5 = new Transaction(LocalDate.now(),5,TypeTransaction.Withdrawal);
	private Transaction transactionWithdrawal10 = new Transaction(LocalDate.of(2020,1,2),10,TypeTransaction.Withdrawal);
	private Transaction transactionDeposit10 = new Transaction(LocalDate.of(2020,1,1),10,TypeTransaction.Deposit);
	private Transaction transactionDeposit50 = new Transaction(LocalDate.of(2020,1,1),50,TypeTransaction.Deposit);

	private final static String LINE_SEPARATOR = System.getProperty("line.separator");

	@Test
	void Should_balanceReturn0_When_noTransaction() {

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
		Transaction transactionDeposit = new Transaction(LocalDate.now(),1,TypeTransaction.Deposit);

		// When
		account.deposit(transactionDeposit);

		//Then
		assertThat(account.getBalance()).isEqualTo(1);
	}


	@Test
	void Should_balanceReturn10_When_deposit15AndWithdrawal5() {

		// Give
		Account account = new Account();
		Transaction transactionDeposit = new Transaction(LocalDate.now(),15,TypeTransaction.Deposit);

		// When
		account.deposit(transactionDeposit);
		account.withdrawal(transactionWithdrawal5);

		//Then
		assertThat(account.getBalance()).isEqualTo(10);

	}

	@Test
	void Should_balanceReturn_When_someWithdrawal() {

		// Give
		Account account = new Account();
		Transaction transactionDeposit = new Transaction(LocalDate.now(),15,TypeTransaction.Deposit);
		Transaction transactionWithdrawal2 = new Transaction(LocalDate.now(),2,TypeTransaction.Withdrawal);

		// When
		account.deposit(transactionDeposit);
		account.withdrawal(transactionWithdrawal5);
		account.withdrawal(transactionWithdrawal2);

		//Then
		assertThat(account.getBalance()).isEqualTo(8);

	}

	@Test
	void Should_returnHistoryOfOneOperation_When_deposit(){
		 // Give
		Account account = new Account();

		// When
		account.deposit(transactionDeposit10);

		// Then
		assertThat(account.history()).isEqualTo("Deposit | 2020-01-01 | 10 | 10" + LINE_SEPARATOR);
	}

	@Test
	void Should_returnHistoryOfSomeOperationDeposit_When_someDeposit(){
		// Give
		Account account = new Account();
		Transaction transactionDeposit20 = new Transaction(LocalDate.of(2020,1,2),20,TypeTransaction.Deposit);

		// When
		account.deposit(transactionDeposit10);
		account.deposit(transactionDeposit20);

		// Then
		assertThat(account.history()).isEqualTo("Deposit | 2020-01-01 | 10 | 10" + LINE_SEPARATOR +
												"Deposit | 2020-01-02 | 20 | 30" + LINE_SEPARATOR);
	}

	@Test
	void Should_returnHistoryOfOperationWithWithdrawal_When_oneDepositAndOneWithdrawal(){
		// Give
		Account account = new Account();

		// When
		account.deposit(transactionDeposit50);
		account.withdrawal(transactionWithdrawal10);

		// Then
		assertThat(account.history()).isEqualTo("Deposit | 2020-01-01 | 50 | 50" + LINE_SEPARATOR+
												"Withdrawal | 2020-01-02 | 10 | 40" + LINE_SEPARATOR);
	}

	@Test
	void Should_returnHistoryOfOperationWithWithdrawal_When_oneDepositAndSomeWithdrawal(){
		// Give
		Account account = new Account();
		Transaction transactionWithdrawal5 = new Transaction(LocalDate.of(2020,1,3),5,TypeTransaction.Withdrawal);

		// When
		account.deposit(transactionDeposit50);
		account.withdrawal(transactionWithdrawal10);
		account.withdrawal(transactionWithdrawal5);

		// Then
		assertThat(account.history()).isEqualTo("Deposit | 2020-01-01 | 50 | 50" + LINE_SEPARATOR
											+ "Withdrawal | 2020-01-02 | 10 | 40" + LINE_SEPARATOR
											+ "Withdrawal | 2020-01-03 | 5 | 35" + LINE_SEPARATOR);
	}

}
