package onlineShoppingCart;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private List<CartItem> items;
	
	public Cart() {
		items = new ArrayList<>();
	}
	
	public void addItem(Product product,int quantity) {
		
		
		for(int i =0;i<items.size();i++) {
			if(items.get(i).getProduct().equals(product)) {
				items.get(i).setQuantity(items.get(i).getQuantity()+quantity);
				return;
			}
		}
		
		
		
		items.add(new CartItem(product,quantity));
	}
	
	public void removeItem(Long productId) {
		for(int i = 0;i<items.size();i++) {
			if(items.get(i).getProduct().getProductId() == productId) {
				items.remove(i);
				return;
			}
		}
	}
	
	public void updateQuantity(Product product,int quantity) {
		for(int i =0;i<items.size();i++) {
			if(items.get(i).getProduct().getProductId() == product.getProductId()) {
				items.get(i).setQuantity(quantity);
			}
		}
		
		
	}
	
	public double getCartTotal() {
		double total = 0;
		for(int i = 0;i<items.size();i++) {
			total = total + items.get(i).getItemTotal();
		}
		return total;
	}
	
	public void displayCart() {
		if(items.isEmpty()) {
			System.out.println("Cart is Empty");
			return;
		}
		System.out.println("Cart Items: ");
		for(int i =0;i<items.size();i++) {
			System.out.println( items.get(i).getProduct().getProductName()
					+" Quantity: "+items.get(i).getQuantity()
					+" Item total: "+items.get(i).getItemTotal());
		}
		
		System.out.println("Total amount = "+getCartTotal());
	}
	
	

}
