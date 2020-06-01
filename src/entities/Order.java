package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entitiesEnum.OrderStatus;

public class Order {

	private String moment;
	private OrderStatus status;
	
	private Client client;
		
	private List<OrderItem> items = new ArrayList<>();

	public Order(String status, Client client) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date thisMoment = new Date();
		this.moment = sdf.format(thisMoment);
		this.status = OrderStatus.valueOf(status);
		this.client = client;
	}

	public OrderStatus getStatus() {
		return status;
	}
	
	public void addItem(OrderItem item) {
		items.add(item);
	}
	
	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	
	public Double total() {
		double soma = 0.0;
		for (OrderItem x : items) {
			soma += x.subTotal();
		}
		return soma;
	}

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: ");
		sb.append(moment + "\n");
		
		sb.append("Order status: ");
		sb.append(status + "\n");
		
		sb.append("Client: ");
		sb.append(client + "\n");
		
		for (OrderItem x : items) {
			sb.append(x + "\n");
		}
		
		sb.append("Total price: $");
		sb.append(String.format("%.2f", total()));
				
		return sb.toString();
	}
	
	
}
