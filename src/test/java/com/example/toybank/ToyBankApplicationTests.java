package com.example.toybank;

import com.example.toybank.repository.AccountTransaction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class ToyBankApplicationTests {

    private static final String DESCRIPTION = "A purchase";
    private static final BigDecimal AMOUNT = new BigDecimal ("23.43");
    private static final LocalDate  DATE = LocalDate.now();
    private static final int ACCOUNT_ID = 1 ;

    @Autowired
    AccountTransactionController controller ;

    @Test
    void contextLoads() {
    }


    @Test
    void shouldSaveTransaction()  {
        AccountTransaction sourceTransaction = createSourceTransaction();

        AccountTransaction created = controller.createTransaction(sourceTransaction) ;
        assertNotNull(created) ;

        assertEqualTransactionValues(sourceTransaction, created);
    }

    @Test
    void shouldRetrieveTransaction()  {
        AccountTransaction sourceTransaction = createSourceTransaction();

        AccountTransaction created = controller.createTransaction(sourceTransaction) ;

        int transactionId = created.getId();
        AccountTransaction retrieved = controller.findTransaction(transactionId).getBody() ;

        assertEqualTransactionValues(sourceTransaction, retrieved);
    }

    private AccountTransaction createSourceTransaction() {
        AccountTransaction sourceTransaction = new AccountTransaction() ;
        sourceTransaction.setDescription(DESCRIPTION);
        sourceTransaction.setAmount(AMOUNT);
        sourceTransaction.setDate(DATE) ;
        sourceTransaction.setAccountId(ACCOUNT_ID);
        
        return sourceTransaction;
    }

    private void assertEqualTransactionValues(AccountTransaction sourceTransaction, AccountTransaction created) {
        assertEquals(sourceTransaction.getAmount(), created.getAmount());
        assertEquals(sourceTransaction.getDescription(), created.getDescription());
        assertEquals(sourceTransaction.getDate(), created.getDate());
        assertEquals(sourceTransaction.getAccountId(), created.getAccountId());
    }
}
