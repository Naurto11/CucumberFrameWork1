package org.step;

import java.io.IOException;

import org.Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.pojo.LoginPojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinationClass extends BaseClass {
	@Given("user has to chrome browser and pass the url")
	public void user_has_to_chrome_browser_and_pass_the_url() throws InterruptedException {

		launchBrowser();
		passUrl("http://192.168.1.111:8085/JMSRS/jmslogin.php");

		maxBrowser();
		Thread.sleep(3000);
	}

	@When("user has to enter the value in testdata{int} and testdata{int} field")
	public void user_has_to_enter_the_value_in_testdata_and_testdata_field(Integer int1, Integer int2)
			throws IOException, InterruptedException {
		LoginPojo login = new LoginPojo();

		String username = "j001";
		String password = "123";

		for (int i = 1; i < 7; i++) {

			toInput(login.getUserId(), excelRead(i, 3));
			toInput(login.getPassword(), excelRead(i, 4));

			String username1 = excelRead(i, 3);

			String password1 = excelRead(i, 4);
			Thread.sleep(1000);

			driver.findElement(By.xpath("//a[text()='Log In']")).click();

			Thread.sleep(1000);

			if (driver.findElement(By.xpath("//button[text()='OK']")).isEnabled()) {

				if ((username.equals(username1)) && (password.equals(password1))) {

					System.out.println("Valid");

					Thread.sleep(1000);

					btnClick(login.getResultBtnClk());
					Thread.sleep(1000);
					btnClick(login.getConBtn());
					Thread.sleep(2000);
					btnClick(login.getCkMasterBtn());
					Thread.sleep(2000);
					btnClick(login.getMarketPage());
					Thread.sleep(2000);
					driver.findElement(By.xpath("//*[@class='fa fa-plus']")).click();
					Thread.sleep(2000);

					Thread.sleep(1000);

					for (int m = 1; m < 6; m++) {
						
						//System.out.println(m);

						toInput(login.getCode(), excelReadGeneral(m, 0));

						toInput(login.getDesc1(), excelReadGeneral(m, 1));

						toInput(login.getDesc2(), excelReadGeneral(m, 2));
						toInput(login.getRemarks1(), excelReadGeneral(m, 3));
						toInput(login.getRemarks2(), excelReadGeneral(m, 4));

					Select s = new Select(driver.findElement(By.xpath("//select[@id='cboDateFormat']")));
//
//						// s.selectByVisibleText("Active");
//
						s.selectByValue("A");
//
//						toInput(login.getStatus(), excelReadGeneral(m, 5));
//
					toInput(login.getSortorder(), excelReadGeneral(m, 6));
//						
						btnClick(login.getSaveAndClse());
						Thread.sleep(1000);
						driver.findElement(By.xpath("//button[text()='OK']")).click();
						
						Thread.sleep(1000);
					
						
						

					}

				}

			}

			else {
				System.out.println("Invalid");
			}
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[text()='OK']")).click();
			

		}

	}

	@When("user has to click the login button")
	public void user_has_to_click_the_login_button() {
	}

	@Then("user has to navigate the error page")
	public void user_has_to_navigate_the_error_page() {
	}
}
