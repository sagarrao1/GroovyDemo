package com.groovy.unittest;

class BankAccount {
	private balance
	
	BankAccount(initialBalance) {
		balance = initialBalance;
	}

	def void deposit(amount) {
		balance += amount;
	}

	def void withdrawl(amount) {
		if (amount > balance) {
			throw new InsufficiantFundsException(" Insufficiant balance: " + amount);
//			throw new Exception()
		}

		balance -= amount;
	}
	
	def void calculateInterestRate() {
		def service = new InterestRateService()
		def rate =service.getInterestRate()
//		def rate=0.10
		
		def totalInterest= balance*rate
		
		deposit(totalInterest)
	}
	
}
