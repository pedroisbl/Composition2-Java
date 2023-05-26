package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Enter cliente data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (dd/MM/yyyy}):");
		Date birth = sdf.parse(sc.next());

		Client client = new Client(name, email, birth);

		System.out.println("Enter order data:");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());

		Order order = new Order(birth, status, client);

		System.out.print("\nHow many items to this order? ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.printf("Enter #%d item data:", i);
			sc.nextLine();
			System.out.print("\nProduct name: ");
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			double price = sc.nextDouble();

			Product product = new Product(productName, price);

			System.out.print("Quantity: ");
			int quantity = sc.nextInt();

			OrderItem orderItem = new OrderItem(quantity, price, product);

			order.addItem(orderItem);
		}
		System.out.println();
		System.out.println(order);
		

		sc.close();
	}

}
