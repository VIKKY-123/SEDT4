package com.Vtiger.TC;

public class TC002_FW {

	public static void main(String[] args) throws InterruptedException {
		Basic_Test bt = new Basic_Test();
		bt.openThebrowser();
		
		
		bt.enterUrl();
		
		bt.wait_se();
		
		bt.login_D();
		Thread.sleep(4000);
		bt.Org_Details();
		Thread.sleep(4000);
		bt.verify_Org();
		Thread.sleep(4000);
		bt.sign_Up();
		Thread.sleep(10000);
		bt.close_Browser();
		

	}

}
