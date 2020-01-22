package life.light.KataBankAccount;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class AccountTests {

	private Transaction withdrawal5 = new Withdrawal(LocalDate.now(),5);
	private Transaction withdrawal10 = new Withdrawal(LocalDate.of(2020,1,2),10);
	private Transaction deposit10 = new Deposit(LocalDate.of(2020,1,1),10);
	private Transaction deposit50 = new Deposit(LocalDate.of(2020,1,1),50);

	private final static String LINE_SEPARATOR = System.getProperty("line.separator");

	@Test
	void Should_balanceReturn0_When_noTransaction() {
		// Give
		Account account = new Account();
		// When
		// Then
		assertThat(account.getBalance()).isEqualTo(0);
	}

	@Test
	void Should_balanceReturn1_When_firstDeposit1() {
		// Give
		Account account = new Account();
		Transaction deposit = new Deposit(LocalDate.now(),1);
		// When
		account.deposit(deposit);
		// Then
		assertThat(account.getBalance()).isEqualTo(1);
	}

	@Test
	void Should_balanceReturn10_When_deposit15AndWithdrawal5() {
		// Give
		Account account = new Account();
		Transaction deposit = new Deposit(LocalDate.now(),15);
		// When
		account.deposit(deposit);
		account.withdrawal(withdrawal5);
		// Then
		assertThat(account.getBalance()).isEqualTo(10);
	}

	@Test
	void Should_balanceReturn_When_someWithdrawal() {
		// Give
		Account account = new Account();
		Transaction deposit = new Deposit(LocalDate.now(),15);
		Transaction withdrawal2 = new Withdrawal(LocalDate.now(),2);
		// When
		account.deposit(deposit);
		account.withdrawal(withdrawal5);
		account.withdrawal(withdrawal2);
		// Then
		assertThat(account.getBalance()).isEqualTo(8);
	}

	@Test
	void Should_returnHistoryOfOneOperation_When_deposit(){
		 // Give
		Account account = new Account();
		// When
		account.deposit(deposit10);
		// Then
		assertThat(account.history()).isEqualTo("Deposit | 2020-01-01 | 10 | 10" + LINE_SEPARATOR);
	}

	@Test
	void Should_returnHistoryOfSomeOperationDeposit_When_someDeposit(){
		// Give
		Account account = new Account();
		Transaction deposit20 = new Deposit(LocalDate.of(2020,1,2),20);
		// When
		account.deposit(deposit10);
		account.deposit(deposit20);
		// Then
		assertThat(account.history()).isEqualTo("Deposit | 2020-01-01 | 10 | 10" + LINE_SEPARATOR +
												"Deposit | 2020-01-02 | 20 | 30" + LINE_SEPARATOR);
	}

	@Test
	void Should_returnHistoryOfOperationWithWithdrawal_When_oneDepositAndOneWithdrawal(){
		// Give
		Account account = new Account();
		// When
		account.deposit(deposit50);
		account.withdrawal(withdrawal10);
		// Then
		assertThat(account.history()).isEqualTo("Deposit | 2020-01-01 | 50 | 50" + LINE_SEPARATOR+
												"Withdrawal | 2020-01-02 | 10 | 40" + LINE_SEPARATOR);
	}

	@Test
	void Should_returnHistoryOfOperationWithWithdrawal_When_oneDepositAndSomeWithdrawal(){
		// Give
		Account account = new Account();
		Transaction withdrawal5 = new Withdrawal(LocalDate.of(2020,1,3),5);

		// When
		account.deposit(deposit50);
		account.withdrawal(withdrawal10);
		account.withdrawal(withdrawal5);

		// Then
		assertThat(account.history()).isEqualTo("Deposit | 2020-01-01 | 50 | 50" + LINE_SEPARATOR
											+ "Withdrawal | 2020-01-02 | 10 | 40" + LINE_SEPARATOR
											+ "Withdrawal | 2020-01-03 | 5 | 35" + LINE_SEPARATOR);
	}

}
