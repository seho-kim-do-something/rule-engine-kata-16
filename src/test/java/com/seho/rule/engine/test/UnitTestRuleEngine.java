package com.seho.rule.engine.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.seho.rule.engine.RuleEngine;
import com.seho.rule.engine.bean.Category;
import com.seho.rule.engine.bean.Order;
import com.seho.rule.engine.bean.Product;
import com.seho.rule.engine.bean.Type;
import com.seho.rule.engine.impl.BookRule;
import com.seho.rule.engine.impl.MembershipRule;
import com.seho.rule.engine.impl.MembershipUpgradeRule;
import com.seho.rule.engine.impl.PhysicalProductRule;
import com.seho.rule.engine.impl.VideoRule;

/**
 * Unit test
 */
public class UnitTestRuleEngine {

	private RuleEngine ruleEngine = new RuleEngine();

	@Before
	public void init(){
		ruleEngine.registerRule(new BookRule())
		.registerRule(new MembershipRule())
		.registerRule(new MembershipUpgradeRule())
		.registerRule(new PhysicalProductRule())
		.registerRule(new VideoRule());
	}

	@Test
	public void PhysicalProduct() {
		Type type = new Type();
		type.setTypeName(Type.TypeName.PHYSICAL.toString());
		
		Category category = new Category();
		category.setCategoryName(Category.CategoryName.LAPTOP.toString());

		Product product = new Product();
		product.setName("Laptop 18 inch");
		product.setType(type);
		product.setCategory(category);

		Order order = new Order();
		order.setProduct(product);
		order.setStatus(Order.Status.NON_PROCESSED.toString());

		ruleEngine.applyRule(order);

		assertEquals("PROCESSED", order.getStatus());
	}

	@Test
	public void testBooKProduct() {    	
		Type type = new Type();
		type.setTypeName(Type.TypeName.PHYSICAL.toString());
		
		Category category = new Category();
		category.setCategoryName(Category.CategoryName.BOOK.toString());

		Product product = new Product();
		product.setName("Advanced Java");
		product.setType(type);
		product.setCategory(category);

		Order order = new Order();
		order.setProduct(product);
		order.setStatus(Order.Status.NON_PROCESSED.toString());

		ruleEngine.applyRule(order);

		assertEquals("PROCESSED", order.getStatus());
	}

	@Test
	public void testMembershipProduct() {    	
		Type type = new Type();
		type.setTypeName(Type.TypeName.NON_PHYSICAL.toString());
		Category category = new Category();
		category.setCategoryName(Category.CategoryName.MEMBERSHIP.toString());

		Product product = new Product();
		product.setName("Membership Activation");
		product.setType(type);
		product.setCategory(category);

		Order order = new Order();
		order.setProduct(product);
		order.setStatus(Order.Status.NON_PROCESSED.toString());

		ruleEngine.applyRule(order);

		assertEquals("PROCESSED", order.getStatus());
	}

	@Test
	public void testMembershipUpgradeProduct() {    	
		Type type = new Type();
		type.setTypeName(Type.TypeName.NON_PHYSICAL.toString());
		
		Category category = new Category();
		category.setCategoryName(Category.CategoryName.MEMBERSHIP_UPGRADE.toString());

		Product product = new Product();
		product.setName("Membership Upgrade");
		product.setType(type);
		product.setCategory(category);

		Order order = new Order();
		order.setProduct(product);
		order.setStatus(Order.Status.NON_PROCESSED.toString());

		ruleEngine.applyRule(order);

		assertEquals("PROCESSED", order.getStatus());
	}
	
	@Test
	public void testVideoProduct() {    	
		Type type = new Type();
		type.setTypeName(Type.TypeName.PHYSICAL.toString());
		
		Category category = new Category();
		category.setCategoryName(Category.CategoryName.VIDEO.toString());

		Product product = new Product();
		product.setName("Learning to Ski");
		product.setType(type);
		product.setCategory(category);

		Order order = new Order();
		order.setProduct(product);
		order.setStatus(Order.Status.NON_PROCESSED.toString());

		ruleEngine.applyRule(order);

		assertEquals("PROCESSED", order.getStatus());
	}


	@Test
	public void testNoRuleProduct() {    	
		Type type = new Type();
		type.setTypeName(Type.TypeName.NON_PHYSICAL.toString());
		
		Category category = new Category();
		category.setCategoryName("Coupon");

		Product product = new Product();
		product.setName("Winners online coupon");
		product.setType(type);
		product.setCategory(category);

		Order order = new Order();
		order.setProduct(product);
		order.setStatus(Order.Status.NON_PROCESSED.toString());

		ruleEngine.applyRule(order);

		assertEquals("NON_PROCESSED", order.getStatus());
	}
}
