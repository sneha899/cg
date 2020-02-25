package com.cg.onlinewallet.dao;

import com.cg.onlinewallet.bean.WalletAccount;
import com.cg.onlinewallet.exception.AccountException;

public interface AccountDao {
	public boolean createWalletAccount(WalletAccount account) throws AccountException;

	public boolean depositAccount(WalletAccount accound, double amount) throws AccountException;
	public double showBalance(WalletAccount account) throws AccountException; 
	public boolean withdrawAmount(WalletAccount account, double amount) throws AccountException;
	public boolean transferAmount(WalletAccount fromAccount, WalletAccount toAccount, double amount) throws AccountException;
}
