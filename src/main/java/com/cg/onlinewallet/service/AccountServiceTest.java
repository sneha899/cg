package com.cg.onlinewallet;


import static org.junit.Assert.*;

import org.junit.Test;

import com.cg.onlinewallet.bean.WalletAccount;
import com.cg.onlinewallet.bean.WalletAccountType;
import com.cg.onlinewallet.service.AccountService;

public class AccountServiceTest {
	
	
	
	@Test
	public void checkDepositAmount() {
		try {
			
			WalletAccount account= new WalletAccount(123,1000,WalletAccountType.SAVING,null);
			
			AccountService accountService = new AccountService();
			
			accountService.validateAndCreateWalletAccount(account);
			accountService.validateAndCreateWalletAccount(account);
			accountService.validateAndDepositAccount(123, 500);

			assertEquals(accountService.validateAndShowBalance(123),1500.0,0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void checkTransferAmount() {
		try {
			
			WalletAccount fromAccount= new WalletAccount(123,1050,WalletAccountType.SAVING,null);

			WalletAccount toAccount= new WalletAccount(456,5,WalletAccountType.SAVING,null);

			AccountService accountService = new AccountService();
			
			accountService.validateAndCreateWalletAccount(fromAccount);
			accountService.validateAndCreateWalletAccount(toAccount);
			accountService.validateAndTransferAmount(123,456,200);
			

			assertEquals(accountService.validateAndShowBalance(456),205.0,0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void checkTransferAmountWithInvalidFromAcc() {
		try {
			
			WalletAccount fromAccount= new WalletAccount(123,1050,WalletAccountType.SAVING,null);

			WalletAccount toAccount= new WalletAccount(456,5,WalletAccountType.SAVING,null);

			AccountService accountService = new AccountService();
			
			accountService.validateAndCreateWalletAccount(fromAccount);
			accountService.validateAndCreateWalletAccount(toAccount);
			
			accountService.validateAndTransferAmount(100,456,300);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			assertEquals(e.getMessage(),"Invalid sender account or account number not found");
			e.printStackTrace();;
		}
	}
	
	@Test
	public void checkTransferAmountWithInsuffiecientBalance() {
		try {
			
			WalletAccount fromAccount= new WalletAccount(123,1050,WalletAccountType.SAVING,null);

			WalletAccount toAccount= new WalletAccount(456,5,WalletAccountType.SAVING,null);

			AccountService accountService = new AccountService();
			accountService.validateAndCreateWalletAccount(fromAccount);
			accountService.validateAndCreateWalletAccount(toAccount);
			
					accountService.validateAndTransferAmount(123,456,2000);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			assertEquals(e.getMessage(),"Insuffiecient balance");
			e.printStackTrace();;
		}
	}

}
