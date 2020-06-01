import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;

public class Main {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter client data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());
		sc.nextLine();
		
		Client client = new Client(name, email, birthDate);
		
		System.out.println();
		System.out.println("Enter order date: ");
		System.out.print("Status: ");
		String status = sc.nextLine();
		
		Order order = new Order(status, client);
		
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
				
		for(int i=1; i<=n; i++) {
			sc.nextLine();
			System.out.println("Enter #" + i + " item data: ");
			System.out.print("Produtc name: ");
			String productName = sc.nextLine();
			
			System.out.print("Produtc price: ");
			Double productPrice = sc.nextDouble();
			sc.nextLine();
							
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			
			OrderItem orderitem = new OrderItem(quantity, productName, productPrice);
			
			order.addItem(orderitem);
		}
		
		System.out.println();
		System.out.println("ORDER SUMMARY: ");
		System.out.println(order);
		
		sc.close();
	}
}