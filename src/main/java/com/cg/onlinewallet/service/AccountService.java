package com.cg.onlinewallet.service;


import com.cg.onlinewallet.dao.AccountDaoMapImpl;
import com.cg.onlinewallet.bean.WalletAccount;
import com.cg.onlinewallet.exception.AccountException;

public interface AccountService {

    WalletAccount walletAccount = new WalletAccount();
	
	AccountDaoMapImpl accountDao= new AccountDaoMapImpl();
	public boolean createWalletAccount(WalletAccount account) throws AccountException;
	
	public boolean depositAccount(WalletAccount account, double amount) throws AccountException;
	public boolean transferAmount(WalletAccount fromAccount, WalletAccount toAccount, double amount) throws AccountException;

	public double showBalance(WalletAccount account) throws AccountException;
		
}
