package com.seho.rule.engine.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.seho.rule.engine.IRule;
import com.seho.rule.engine.bean.Order;
import com.seho.rule.engine.bean.Type;

public class PhysicalProductRule implements IRule<Order, Order> {
	
	private final Logger logger = LoggerFactory.getLogger(PhysicalProductRule.class);

	@Override
	public boolean matches(Order order) {
		return order.getProduct().getType().getTypeName().equals(Type.TypeName.PHYSICAL.toString());
	}

	@Override
	public Order process(Order order) {
		logger.info("******** Processing \"{}\" ********", order.getProduct().getName());
		logger.info("******** Generated a packing slip for shipping.");
		logger.info("******** Generate a commission payment to the agent.");	
		order.setStatus(Order.Status.PROCESSED.toString());
		logger.info("******** Done ******** \n");
		return order;
	}

}
