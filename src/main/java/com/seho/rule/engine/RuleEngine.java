package com.seho.rule.engine;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.seho.rule.engine.bean.Order;

public class RuleEngine {
	
	private final Logger logger = LoggerFactory.getLogger(RuleEngine.class);
	
	List<IRule<Order, Order>> rules = new ArrayList<>();
	
	// TODO apply multiple rules
	public Order applyRule(Order order) {
		long matchedCount = rules.stream()
				.filter(rule -> rule.matches(order))
				.map(rule -> rule.process(order)).count();		
		if(matchedCount == 0) {
			logger.error("No Matching rule found for order - \"{}\"!\n", order.getProduct().getName());
		}
		return order;
	}
	
	public RuleEngine registerRule(IRule<Order, Order> rule) {
		rules.add(rule);
		return this;
	}

}
