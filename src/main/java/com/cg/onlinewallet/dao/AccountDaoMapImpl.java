package com.cg.onlinewallet.dao;

import java.util.HashMap;
import java.util.Map;

import java.time.LocalDateTime;
import com.cg.onlinewallet.bean.WalletAccount;
import com.cg.onlinewallet.bean.WalletTransaction;
import com.cg.onlinewallet.exception.AccountException;
import com.cg.onlinewallet.exception.AccountExceptionDescription;
import com.eaio.uuid.UUID;

public class AccountDaoMapImpl implements AccountDao {

	WalletAccount walletAccount;
	
	Map<Integer,WalletAccount> accounts = new HashMap();
	
	@Override
	public boolean createWalletAccount(WalletAccount account) throws AccountException {
		
		accounts.put(account.getAccountId(),account);
		
		System.out.println("Account created with Account Number :"+account.getAccountId());
		return true;
		
	}

	@Override
	public boolean depositAccount(WalletAccount account, double amount) throws AccountException {
		boolean isDeposited=false;
				
		if(amount > 0) {
			account.setBalance(account.getBalance() + amount);
			String transactionId= new UUID().toString().toString();
			LocalDateTime localDateTime = LocalDateTime.now();
			WalletTransaction walletTransaction = new WalletTransaction(transactionId, "Amount deposited successfully", localDateTime, amount, account.getBalance());
			account.addTransaction(walletTransaction);
			accounts.put(account.getAccountId(), account);
			System.out.println("transactionId : "+account.getList().get(account.getList().size()-1).getTransactionId() +" and date:"+account.getList().get(account.getList().size()-1).getDateOfTransaction().toString());
		}
		return isDeposited;
	}

	@Override
	public double showBalance(WalletAccount account) throws AccountException {
		double amount =account.getBalance();
		
			return amount;
		
	}
	
	@Override
	public boolean transferAmount(WalletAccount fromAccount, WalletAccount toAccount, double amount) throws AccountException {
		
		boolean isValid=false;
		if(accounts.get(fromAccount.getAccountId()) != null){
			try{
			     isValid =withdrawAmount(fromAccount, amount);
			}catch(AccountException e){
				throw new AccountException(AccountExceptionDescription.transferAmountException);
			}
			 if(isValid && accounts.get(toAccount.getAccountId()) != null ){
				 depositAccount(toAccount, amount);
			 } else {
				 depositAccount(fromAccount, amount);
				 isValid = false;
				 throw new AccountException(AccountExceptionDescription.invalidAccount);
			}
		}else{
			throw new AccountException(AccountExceptionDescription.invalidAccount);
		}
		
		return isValid;
		
	} 

	@Override
	public boolean withdrawAmount(WalletAccount account, double amount) throws AccountException {
		boolean isValidAmount =false;
		if(amount !=0 && account.getBalance() > amount ) {
			
			account.setBalance(account.getBalance()- amount);
			isValidAmount= true;
			String transactionId= new UUID().toString().toString();
			LocalDateTime localDateTime = LocalDateTime.now();
			WalletTransaction walletTransaction = new WalletTransaction(transactionId, "Amount withdrawn successfully", localDateTime, amount, account.getBalance());
			account.addTransaction(walletTransaction);
			accounts.put(account.getAccountId(), account);
		} else {
			throw new AccountException(AccountExceptionDescription.inSufficientFundsException);
		}
		return isValidAmount;
	}


}
