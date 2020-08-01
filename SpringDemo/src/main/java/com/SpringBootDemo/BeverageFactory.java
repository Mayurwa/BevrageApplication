package com.SpringBootDemo;
import java.util.HashMap;
import java.util.Map;

public class BeverageFactory {

	public static void main(String[] args) {

		Map<String , Double> costmap= new HashMap();
		costmap.put("chai",5.0);
		costmap.put("milk",1.0);
		costmap.put("Sugar",0.5);
		costmap.put("Soda",0.5);
		costmap.put("mint",0.5);	
		costmap.put("water",0.5);
		System.out.println("your order costs " + getOrder("chai,-Sugar,-water", costmap));
	}

	public static double getOrder(String order, Map<String, Double> costmap) {
		double cost = 0;
		if(null!=order || !order.isEmpty())
		{
			String orderArr[]=order.split(",");
			if(order.length()==1)
			{
		 cost = (double)costmap.get(orderArr[0]);
			}
			else
			{
			 for(String item:orderArr)
			 {
				 if(item.contains("-"))
				 {
					 item=item.replace("-", " ");
					 double itemCost= (double) costmap.get(item.trim());
					 cost= cost-itemCost;
				 }
				 else
				 {
					 double itemCost= (double) costmap.get(item.trim());
					 cost= cost+itemCost;
				 }
			 }
			}
			
		}else
		{
			System.out.println("Your order is empty");
		}
	
		return cost;
		
		
	}

	

}
