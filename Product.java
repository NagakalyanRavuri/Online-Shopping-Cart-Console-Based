package onlineShoppingCart;

public abstract class Product {
	protected double productPrice;
	private String productName;
	private Long productId;
	
	
	public Product(double productPrice, String productName, Long productId) {
		super();
		this.productPrice = productPrice;
		this.productName = productName;
		this.productId = productId;
	}
	
	public Product() {
		super();
	}
	
	
	public abstract double getProductPrice();
	public String getProductName() {
		return productName;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
}
