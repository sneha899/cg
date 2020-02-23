package com.cg.onlinewallet.dao;

import com.cg.onlinewallet.bean.WalletAccount;
import com.cg.onlinewallet.exception.AccountException;

public interface AccountDao {
	public int createWalletAccount(WalletAccount account) throws AccountException;

	public int depositAccount(int accoundId, double amount) throws AccountException;
	public double showBalance(int accountId) throws AccountException; 
	public void withdrawAmount(int accountId, double amount);
	public void transferAmount(int fromAccountId, int toAccountId2, double amount) throws AccountException;

}
