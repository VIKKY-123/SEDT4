package com.erp.Vtiger;

import java.util.Random;

import com.github.javafaker.Faker;

public class JavaUtil {
	/**
	 * This Method is Gonna generate the Random number
	 * @return random number till 1000
	 */
	
	public int generaterandomNumber() {
		
		Random random=new Random();
		return random.nextInt(1000);
	}
	/**
	 * This method gonna Generate the fake firstname
	 * @return  fake first name
	 */
	
	public String fakefirstName() {
		Faker faker=new Faker();
		return faker.name().firstName();
	}
	/**
	 * This method gonna generate the fake lastname
	 * @return lastName
	 */
	
	public String fakelastName() {
		
		Faker faker=new Faker();
		
		return faker.name().lastName();
	}
	/**
	 * This method gonna generate the fake compnay name
	 * @return
	 */
	
	
	public String fakecompanyName() {
		Faker faker=new Faker();
		
		return faker.company().name();
		
	}

}
