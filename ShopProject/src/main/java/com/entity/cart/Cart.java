package com.entity.cart;

import java.util.HashMap;
import java.util.Map;

import com.database.Data;

public class Cart {
	private Map<Long, CartItem> cartItems;
	
	public Cart() {
		this.cartItems = new HashMap<>();
	}

	public Map<Long, CartItem> getAll() {
		return cartItems;
	}
	
	public void addProduct(long id) {
		cartItems.merge(id, new CartItem(Data.getOne(id), 1),
				(val, newVal) -> new CartItem(Data.getOne(id), val.getCount() + 1));
	}

	public double getTotalPrice() {
		double res = 0.0;
		for (CartItem cartItem : cartItems.values()) {
			res += cartItem.getProduct().getPrice() * cartItem.getCount();
		}
		return res;
	}
}
