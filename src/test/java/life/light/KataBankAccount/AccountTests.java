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
		assertThat(account.balance()).isEqualTo(0);

	}

}
