package com.Flipkart.objectrpository;
 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Flipkart.resources.CommonActions;

public class MobilePage extends CommonActions{

	public MobilePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="q")
	private WebElement search;
	
	public WebElement getSearch() {
		return search;
	}
	
	@FindBy(xpath="//button[@class='_2KpZ6l _2doB4z']")
	private WebElement login;
	
	public WebElement getLogin() {
		return login;
	}

	@FindBy(xpath="//button[text()='BUY NOW']")
	private WebElement buy;
	
	public WebElement getBuy() {
		return buy;
	}
	
	@FindBy(xpath="(//div[@class='_4rR01T'])[3]")
	private WebElement pickProduct;
	
	public WebElement getPickProduct() {
		return pickProduct;
	}
	
	@FindBy(xpath="//div[text()='You might be interested in']")
	private WebElement scrollTo;

	public WebElement getScrollTo() {
		return scrollTo;
	}
	
	
}
