package presentation;


import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.*;


public class MainView extends JFrame{

	private JButton client = new JButton("Client table");
	private JButton product = new JButton("Product table");
	private JButton order = new JButton("Order table");

	public MainView() {
	
		client.setPreferredSize(new Dimension(500, 50));
		product.setPreferredSize(new Dimension(500, 50));
		order.setPreferredSize(new Dimension(500, 50));
		
		JPanel panel1 = new JPanel();   
		JPanel panel2 = new JPanel();   
		JPanel panel3 = new JPanel();  
	
		panel1.add(client);
		panel2.add(product);
		panel3.add(order);
		
		JPanel p = new JPanel();  
		p.add(panel1);   
		p.add(panel2); 
		p.add(panel3);
	
	
		p.setLayout(new BoxLayout(p, BoxLayout. Y_AXIS ));  
		this.setContentPane(p);
		
		this.pack();               
		this.setTitle("Main");  
		  
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void addClientListener(ActionListener listener) {
		client.addActionListener(listener);
	}
	
	public void addProductListener(ActionListener listener) {
		product.addActionListener(listener);
	}
	
	public void addOrderListener(ActionListener listener) {
		order.addActionListener(listener);
	}

}
