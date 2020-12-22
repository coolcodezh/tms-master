package vip.coolcode;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vip.coolcode.account.service.AccountService;

@SpringBootTest
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */

    @Autowired
    AccountService accountService;

}
