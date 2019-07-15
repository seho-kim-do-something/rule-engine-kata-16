package com.seho.rule.engine.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.seho.rule.engine.IRule;
import com.seho.rule.engine.bean.Category;
import com.seho.rule.engine.bean.Order;
import com.seho.rule.engine.bean.Type;

public class BookRule implements IRule<Order, Order> {
	
	private final Logger logger = LoggerFactory.getLogger(BookRule.class);

	@Override
	public boolean matches(Order order) {
		return order.getProduct().getType().getTypeName().equals(Type.TypeName.PHYSICAL.toString())
				&& order.getProduct().getCategory().getCategoryName().equals(Category.CategoryName.BOOK.toString());
	}

	@Override
	public Order process(Order order) {
		logger.info("******** Processing \"{}\" ********", order.getProduct().getName());
		logger.info("------> Generated a duplicate packing slip for the royalty department.");
		order.setStatus(Order.Status.PROCESSED.toString());
		logger.info("******** Done ******** \n");
		return order;
	}

}
