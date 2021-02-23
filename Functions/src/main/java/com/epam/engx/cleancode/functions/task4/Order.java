package com.epam.engx.cleancode.functions.task4;

import com.epam.engx.cleancode.functions.task4.thirdpartyjar.Product;

import java.util.Iterator;
import java.util.List;

public class Order {

    private List<Product> products;

    public Double getPriceOfAvailableProducts() {

        
        removeUnAvailableProducts();
        

        return orderPriceOfProducts();
    }
    
    private Double orderPriceOfProducts() {
    	
    	return(products.stream().map(product -> product.getProductPrice()).reduce((double) 0,(sum,price) -> sum + price));
    	
		/*
		 * double orderPrice = 0.0; for (Product product : products) orderPrice +=
		 * product.getProductPrice(); return orderPrice;
		 */
    }
    
    
    private void removeUnAvailableProducts() {
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (!product.isAvailable())
                iterator.remove();
        }
    }


    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }
}
