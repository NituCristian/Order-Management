package presentation;


import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.*;


public class OrderView extends JFrame{

	private JTextField giveProductId = new JTextField(50);
	private JTextField giveClientId = new JTextField(50);
	private JTextField giveOrderQuantity = new JTextField(50);
	
	private JButton add = new JButton("Add Order");
	private JButton show = new JButton("Show Orders");	
	private JButton main = new JButton("Back to main panel");
	
	public OrderView() {
		JPanel panel1 = new JPanel();   
		JPanel panel2 = new JPanel();   
		JPanel panel3 = new JPanel();   
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();

		panel1.add(new JLabel("Product id"));
		panel1.add(giveProductId);
		
		panel2.add(new JLabel("Client id"));
		panel2.add(giveClientId);
		
		panel3.add(new JLabel("Order quantity"));
		panel3.add(giveOrderQuantity);

		panel4.add(add);
		panel4.add(show);
		
		panel5.add(main);
		
		JPanel p = new JPanel();  
		p.add(panel1);   
		p.add(panel2); 
		p.add(panel3);
		p.add(panel4);
		p.add(panel5);
		
		p.setLayout(new BoxLayout(p, BoxLayout. Y_AXIS ));  
		this.setContentPane(p);
		
		this.pack();               
		this.setTitle("Orders");  
		  
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void addOrderInsertListener(ActionListener listener) {
		add.addActionListener(listener);
	}
	
	public void addShowOrdersListener(ActionListener listener) {
		show.addActionListener(listener);
	}
	
	
	public JTextField getGiveProductId() {
		return giveProductId;
	}

	public void setGiveProductId(JTextField giveProductId) {
		this.giveProductId = giveProductId;
	}

	public JTextField getGiveClientId() {
		return giveClientId;
	}

	public void setGiveClientId(JTextField giveClientId) {
		this.giveClientId = giveClientId;
	}

	public JTextField getGiveOrderQuantity() {
		return giveOrderQuantity;
	}

	public void setGiveOrderQuantity(JTextField giveOrderQuantity) {
		this.giveOrderQuantity = giveOrderQuantity;
	}
	
	public void addMainPanelListener(ActionListener listener) {
		main.addActionListener(listener);
	}

}
