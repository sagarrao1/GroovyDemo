package com.groovy.unittest

import static org.junit.Assert.*
import org.junit.Test
import groovy.mock.interceptor.*


class BankAccountTests extends GroovyTestCase{

	private account = new BankAccount(10)
	
	def void setUp() {
		println "setup"
		account = new BankAccount(10)
	}

	def void tearDown(){
		println "teardown"
		account = null
	}

	@Test
	public void testCanDepositMoney() {
		account.deposit(5)
		assert 15 ==  account.balance		
	}

	@Test
	public void testCanWithdrawMoney() {
		account.withdrawl(6)
		assert 4 ==  account.balance
	}

	@Test
	public void testCannotWithdrawMoreMoney() {
		shouldFail(InsufficiantFundsException) {
			account.withdrawl(15)
		}
	}
	
	@Test
	public void testCalculateInrstRate() {
		
		// Mocking InterestRateService 
		def service=  new MockFor(InterestRateService)		
		service.demand.getInterestRate {
			return 0.10
		}
		service.use { 
			account.calculateInterestRate()
			
	//		result = balance +( balance *rate)
	//		11 = 10 + (10 * 0.10)
	//		11 = 10 + 1
			
			assert 11 == account.balance
		 }
	}

}
