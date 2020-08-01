package com.SpringBootDemo;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDemoApplicationTests {
	
		BeverageFactory bevFactory = new BeverageFactory();

	@Test
	public void testForNormalOrder()
	{
		Map<String, Double> costmap= new HashMap<String, Double>();
		costmap.put("chai",5.0);
		costmap.put("milk",1.0);
		costmap.put("Sugar",0.5);
		costmap.put("Soda",0.5);
		costmap.put("mint",0.5);	
		costmap.put("water",0.5);

		String order ="chai,-milk,-water";
	
		assertEquals(4.0d, bevFactory.getOrder(order, costmap));
	}
	

	@Test
	public void testForOrderWithNoExclusion()
	{
		Map<String, Double> costmap= new HashMap<String, Double>();
		costmap.put("chai",5.0);
		costmap.put("milk",1.0);
		costmap.put("Sugar",0.5);
		costmap.put("Soda",0.5);
		costmap.put("mint",0.5);	
		costmap.put("water",0.5);

		String order ="chai";
	
		assertEquals(5.0d, bevFactory.getOrder(order, costmap));
	}
	
	@Test
	public void testForNoOrder()
	{
		Map<String, Double> costmap= new HashMap<String, Double>();
		costmap.put("chai",5.0);
		costmap.put("milk",1.0);
		costmap.put("Sugar",0.5);
		costmap.put("Soda",0.5);
		costmap.put("mint",0.5);	
		costmap.put("water",0.5);

		String order ="";
	
		assertEquals(0.0d, bevFactory.getOrder(order, costmap));
	}
}
