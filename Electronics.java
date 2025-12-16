package onlineShoppingCart;

public class Electronics extends Product{
	private double warrantyPrice;
	
	public Electronics(double productPrice,String productName,Long productId,double warrantyPrice) {
		super(productPrice,productName,productId);
		
		this.warrantyPrice = warrantyPrice;
	}

	public Electronics() {
		super();
		// TODO Auto-generated constructor stub
	}


	public double getWarrantyPrice() {
		return warrantyPrice;
	}

	public void setWarrantyPrice(double warrantyPrice) {
		this.warrantyPrice = warrantyPrice;
	}

	@Override
	public double getProductPrice() {
		return warrantyPrice + productPrice;
	}
	
	
}
