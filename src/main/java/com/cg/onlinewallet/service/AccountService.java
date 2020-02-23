package com.cg.onlinewallet.service;

import java.util.UUID;

import com.cg.onlinewallet.dao.AccountDaoMapImpl;
import com.cg.onlinewallet.bean.WalletAccount;
import com.cg.onlinewallet.bean.WalletTransaction;
import com.cg.onlinewallet.exception.AccountException;

public class AccountService {

	
	
	/*UUID uuid = UUID.randomUUID();
    String randomUUIDString = uuid.toString();
    WalletTransaction walletTransaction = new WalletTransaction();*/
    
    WalletAccount walletAccount = new WalletAccount();
	
	AccountDaoMapImpl accountDao= new AccountDaoMapImpl();
	public void validateAndCreateWalletAccount(WalletAccount account) throws AccountException
	{
		accountDao.createWalletAccount(account);
	}

	public void validateAndDepositAccount(int accountId, double amount) throws AccountException{
		if(amount >0){
			WalletAccount account = accountDao.getAccounts().get(accountId);
			if(account != null){
				account.setBalance(account.getBalance()+amount);
			}
			else 
				throw new AccountException("Account not found with given account number"); 
			
		} else {
			throw new AccountException("deposit amount can not be zero or a negative value"); 
		}
	}
	public double validateAndShowBalance(int accountId) throws AccountException{
		WalletAccount account = accountDao.getAccounts().get(accountId);
		if(account != null)
			return account.getBalance();
		else 
			throw new AccountException("Account not found with given account number"); 
	}
	public void validateAndTransferAmount(int fromAccountId, int toAccountId, double amount) throws AccountException{
		WalletAccount fromAcctWallet = accountDao.getAccounts().get(fromAccountId);
		if( fromAcctWallet == null)
		    throw new AccountException("Invalid sender account or account number not found"); 
		WalletAccount toAcctWallet = accountDao.getAccounts().get(toAccountId);
		if(toAcctWallet == null)
			throw new AccountException("Invalid receiver account or account number not found"); 
		
		if(fromAcctWallet.getBalance() >= amount ){
			accountDao.transferAmount(fromAccountId, toAccountId, amount);
		}
		else
			throw new AccountException("Insuffiecient balance"); 
		
	}
	
}
