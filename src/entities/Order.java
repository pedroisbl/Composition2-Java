package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");
	
	private Date moment;
	private OrderStatus status;
	private Client client;
	private List<OrderItem> items = new ArrayList<>();
	
	public Order() {
	}
	
	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}


	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getCliente() {
		return client;
	}

	public void setCliente(Client cliente) {
		this.client = cliente;
	}

	public List<OrderItem> getItem() {
		return items;
	}

	public void setItem(List<OrderItem> item) {
		this.items = item;
	}
	
	public void addItem(OrderItem item) {
		items.add(item);
	}
	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	public double total() {
		double sum = 0;
		for (OrderItem item : items) {
			sum += item.subTotal();
		}
		return sum;
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ORDER SUMARY:\n");
		sb.append("Order moment - ");
		sb.append(sdf.format(moment)+"\n");
		sb.append("Order status - ");
		sb.append(status + "\n");
		sb.append("Client - ");
		sb.append(client);
		sb.append("\nOrder items:\n");
		for (OrderItem item : items) {
			sb.append(item + "\n");
		}
		sb.append("Total price: $");
		sb.append(String.format("%.2f", total()));
		return sb.toString();
		
	}
	/* ORDER SUMMARY:
Order moment: 20/04/2018 11:25:09
Order status: PROCESSING
Client: Alex Green (15/03/1985) - alex@gmail.com*/
}
