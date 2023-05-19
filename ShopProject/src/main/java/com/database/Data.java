package com.database;

import java.util.HashSet;
import java.util.Set;

import com.entity.product.Product;

public class Data {
	private static Set<Product> data = new HashSet<>();
	
	static {
		data.add(new Product(1, "蔡徐坤同款背带裤", 49.9));
		data.add(new Product(2, "蔡徐坤同款篮球", 39.9));
		data.add(new Product(3, "蔡徐坤同款假发", 9.9));
		data.add(new Product(4, "iPhone xv utrl", 9999.9));
		data.add(new Product(5, "ipad", 6889.9));
		data.add(new Product(6, "庄锦铭同款T恤", 59.9));
		data.add(new Product(7, "水杯", 19.9));
		data.add(new Product(8, "肥皂", 9.99));
		data.add(new Product(9, "Type-C充电器", 28.9));
		data.add(new Product(10, "鼠标", 29.9));
	}
	
	public static Set<Product> getAll() {
		return data;
	}
	
	public static Product getOne(long id) {
		for (Product product : data) {
			if (product.getId() == id) {
				return product;
			}
		}
		return null;
	}
}
