package edu.elon.test;

import static org.junit.Assert.*;

import java.text.NumberFormat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ATMTest {

	private ATM atm;
	
	@Before
	public void setUp(){
	atm = new ATM();
	}
	@After
	public void tearDown(){
	atm = null;
	}
	
	@Test
	public void testATM() {
		assertEquals(atm.getBalance(),0,0);
	}
	
	@Test
	public void testATM2(){
		atm = new ATM(100);
		assertEquals(atm.getBalance(), 100, 0);
	}
	
	@Test
	public void testDeposit() {
		atm.deposit(729);
		assertEquals(atm.getBalance(), 729, 0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testDepositNeg(){
		atm.deposit(-200);
	}
	
	@Test
	public void testGetBalance(){
		atm.deposit(222);
		assertEquals(atm.getBalance(), 222, 0);
	}

	@Test
	public void testToString() {
		double balance = 100;
		atm = new ATM(balance);
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
		String expected = "Amount balance is " + currencyFormat.format(balance);
		String actual = "Amount balance is $100.00";
		assertEquals(actual, expected);
	}
	
	@Test
	public void testWithdraw() {
		atm = new ATM(200);
		assertEquals(atm.withdraw(120), 120, 0);
		assertEquals(atm.getBalance(), 80, 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testWithdrawPoor() {
		atm = new ATM(200);
		atm.withdraw(5000);
	}
	
}
