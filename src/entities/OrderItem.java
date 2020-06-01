package entities;

public class OrderItem {
	
	private Integer quantity;
	private Product product;
	
	public OrderItem(Integer quantity, String name, Double price) {
		this.quantity = quantity;
		this.product = new Product(name, price);
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public Double subTotal () {
		return product.getPrice() * quantity;
	}

	@Override
	public String toString() {
		
		StringBuilder sbOrder = new StringBuilder();
		sbOrder.append(product.getName());
		sbOrder.append(", $");
		
		sbOrder.append(String.format("%.2f", product.getPrice()));
		
		sbOrder.append(" Quantity: ");
		sbOrder.append(quantity);
		
		sbOrder.append(", Subtotal: $");
		sbOrder.append(String.format("%.2f", subTotal()));
				
		return sbOrder.toString();
	}
	
	
}
