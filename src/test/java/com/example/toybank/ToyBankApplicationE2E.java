package com.example.toybank;

import com.example.toybank.repository.AccountTransaction;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ToyBankApplicationE2E {

    private static final String DESCRIPTION = "A marvellous thing";

    private static final BigDecimal AMOUNT = new BigDecimal ("342.43");

    private static final LocalDate DATE = LocalDate.now();

    private static final int ACCOUNT_ID = 5 ;

    private int port = 51131;


    private String hostname = "127.0.0.1";


    private RestTemplate restTemplate = new RestTemplate();

    @Test
    public void saveAndRetrieve() {
        String url = String.format("http://%s:%d/transaction/", hostname, port ) ;
        AccountTransaction createdValue = createSourceTransaction();
        HttpEntity<AccountTransaction> httpEntity = new HttpEntity<AccountTransaction>(createdValue);
        AccountTransaction stored = restTemplate.postForObject(url, httpEntity, AccountTransaction.class) ;

        ResponseEntity<AccountTransaction> response = restTemplate.getForEntity(url + stored.getId().toString(), AccountTransaction.class);
        assertEqualTransactionValues(createdValue, response.getBody());

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
