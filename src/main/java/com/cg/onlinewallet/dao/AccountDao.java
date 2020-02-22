package com.cg.onlinewallet.dao;

import com.cg.onlinewallet.bean.WalletAccount;
import com.cg.onlinewallet.exception.AccountException;

public interface AccountDao {
	public int createWalletAccount(WalletAccount account) throws AccountException;

	public int depositAccount(int accoundId, double amount) throws AccountException;
	public double showBalance(int userId2) throws AccountException; 
	public int transferAmount(int accountId1, int accountId2, double amount1) throws AccountException;

}
