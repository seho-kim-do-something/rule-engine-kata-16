package com.seho.rule.engine.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.seho.rule.engine.IRule;
import com.seho.rule.engine.bean.Category;
import com.seho.rule.engine.bean.Order;
import com.seho.rule.engine.bean.Type;

public class VideoRule implements IRule<Order, Order> {

	private final Logger logger = LoggerFactory.getLogger(VideoRule.class);

	@Override
	public boolean matches(Order order) {
		return order.getProduct().getType().getTypeName().equals(Type.TypeName.PHYSICAL.toString())
				&& order.getProduct().getCategory().getCategoryName().equals(Category.CategoryName.VIDEO.toString());
	}

	@Override
	public Order process(Order order) {
		logger.info("******** Processing \"{}\" ********", order.getProduct().getName());
		logger.info("******** Generated a packing slip for shipping.");
		
		if(order.getProduct().getName().equals("Learning to Ski")) {
			logger.info("******** added a free \"First Aid\" video to the packing slip.");
		}
		
		order.setStatus(Order.Status.PROCESSED.toString());
		logger.info("******** Done ******** \n");
		return order;
	}

}
