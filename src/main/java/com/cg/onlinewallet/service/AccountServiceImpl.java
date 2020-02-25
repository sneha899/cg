package com.cg.onlinewallet.service;

import com.cg.onlinewallet.bean.WalletAccount;
import com.cg.onlinewallet.dao.AccountDao;
import com.cg.onlinewallet.dao.AccountDaoMapImpl;
import com.cg.onlinewallet.exception.AccountException;

public class AccountServiceImpl implements AccountService {
	
	AccountDao accountDao = new AccountDaoMapImpl();
	 
    WalletAccount walletAccount = new WalletAccount();
	
    @Override
	public boolean createWalletAccount(WalletAccount account) throws AccountException
	{
    	return accountDao.createWalletAccount(account);
	}

    @Override
	public boolean depositAccount(WalletAccount account, double amount) throws AccountException{
		boolean isDeposited=false;
    	if(amount != 0 || amount > 0){
			accountDao.depositAccount(account, amount);
			isDeposited =true;
    	}
			else
				throw new AccountException("deposit amount can not be zero or a negative value");
		return isDeposited;
			
			
	}
    
    @Override
	public double showBalance(WalletAccount account) throws AccountException{
		
			return accountDao.showBalance(account);
	}
	
	@Override
	public boolean transferAmount(WalletAccount fromAccount, WalletAccount toAccount, double amount) throws AccountException{
		return accountDao.transferAmount(fromAccount, toAccount, amount);
		
	}


}
