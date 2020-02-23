package com.cg.onlinewallet.dao;

import java.util.HashMap;
import java.util.Map;

import com.cg.onlinewallet.bean.WalletAccount;
import com.cg.onlinewallet.exception.AccountException;

public class AccountDaoMapImpl implements AccountDao {

	WalletAccount walletAccount;
	
	Map<Integer,WalletAccount> accounts = new HashMap();
	
	
	public int createWalletAccount(WalletAccount account) throws AccountException {
		
		accounts.put(account.getAccountId(),account);
		
		System.out.println("Account created with Account Number :"+account.getAccountId());
		return account.getAccountId();
		
	}

	public int depositAccount(int accoundId, double amount) throws AccountException {
		
				accounts.get(accoundId).setBalance(accounts.get(accoundId).getBalance()+amount);
				
		return accoundId;
	}

	public double showBalance(int accountId) throws AccountException {
		
			return accounts.get(accountId).getBalance();
		
	}

	public void transferAmount(int fromAccountId, int toAccountId, double amount) throws AccountException {
		
		withdrawAmount(fromAccountId, amount);
		depositAccount(toAccountId, amount);
		System.out.println("Requested amount transferred successfully");
		
	}

	public void withdrawAmount(int accountId, double amount) {
		accounts.get(accountId).setBalance(accounts.get(accountId).getBalance() - amount);
	}

	public Map<Integer, WalletAccount> getAccounts() {
		return accounts;
	}

}
