package com.cg.onlinewallet;


import static org.junit.Assert.*;

import org.junit.Test;

import com.cg.onlinewallet.bean.WalletAccount;
import com.cg.onlinewallet.bean.WalletAccountType;
import com.cg.onlinewallet.exception.AccountException;
import com.cg.onlinewallet.service.AccountService;
import com.cg.onlinewallet.service.AccountServiceImpl;

public class AccountServiceTest {
	
	
	@Test
	public void checkDepositAmount() throws AccountException {
			
			WalletAccount account= new WalletAccount(123,1000,WalletAccountType.SAVING,null);
			
			AccountService accountService = new AccountServiceImpl();
			
			accountService.createWalletAccount(account);
			accountService.depositAccount(account, 500);

			assertEquals(accountService.showBalance(account),1500.0,0);
	}
	
	@Test
	public void checkTransferAmount() throws AccountException {
			
			WalletAccount fromAccount= new WalletAccount(123,1050,WalletAccountType.SAVING,null);

			WalletAccount toAccount= new WalletAccount(456,5,WalletAccountType.SAVING,null);

			AccountService accountService = new AccountServiceImpl();
			
			accountService.createWalletAccount(fromAccount);
			accountService.createWalletAccount(toAccount);
			accountService.transferAmount(fromAccount,toAccount,200);
			
			System.out.println("Account Balance in toAccount is :" +accountService.showBalance(toAccount));
			assertEquals(accountService.showBalance(toAccount),205.0,0);
	}
	
	@Test
	public void checkTransferAmountWithInvalidFromAcc() throws AccountException {
		try {
			WalletAccount fromAccount= new WalletAccount(123,1050,WalletAccountType.SAVING,null);

			WalletAccount toAccount= new WalletAccount(456,5,WalletAccountType.SAVING,null);
			
			WalletAccount invalidFromAccount= new WalletAccount(100,5000,WalletAccountType.SAVING,null);

			AccountService accountService = new AccountServiceImpl();
			
			accountService.createWalletAccount(fromAccount);
			accountService.createWalletAccount(toAccount);
			
			accountService.transferAmount(invalidFromAccount,toAccount,300);
		}
		catch(Exception e) {
				// TODO Auto-generated catch block
				assertEquals(e.getMessage(),"Account number not found or Invalid account");
				e.printStackTrace();;
		}
			
	}
	
	@Test
	public void checkTransferAmountWithInsuffiecientBalance() {
		try {
			
			WalletAccount fromAccount= new WalletAccount(123,1050,WalletAccountType.SAVING,null);

			WalletAccount toAccount= new WalletAccount(456,5,WalletAccountType.SAVING,null);

			AccountService accountService = new AccountServiceImpl();
			accountService.createWalletAccount(fromAccount);
			accountService.createWalletAccount(toAccount);
			
					accountService.transferAmount(fromAccount,toAccount,2000);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			assertEquals(e.getMessage(),"Requested amount can not be transfer due to low balance");
			e.printStackTrace();;
		}
	}

}
