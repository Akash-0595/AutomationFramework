package vtiger.practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractise {

	@Test(dataProvider="getData")
	public void addToCart(String name,int price,String color,int qty,boolean isAvailable) {
		System.out.println("--"+name+"-"+price+"-"+color+"-"+isAvailable);
	}
	
	@DataProvider
	public Object[][] getData(){
		Object[][] data=new Object[2][5];
		data[0][0]= "Iphone";
		data[0][1]=55000;
		data[0][2]="black";
		data[0][3]=1;
        data[0][4]=true;
        
        data[1][0]= "hp";
		data[1][1]=45000;
		data[1][2]="silver";
		data[1][3]=1;
        data[1][4]=true;
        
        return data;
	}
}


