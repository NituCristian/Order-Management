package presentation;


import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.*;


public class ProductView extends JFrame{

	private JTextField giveProductId = new JTextField(50);
	private JTextField giveProductName = new JTextField(50);
	private JTextField giveProductPrice = new JTextField(50);
	private JTextField giveProductQuantity = new JTextField(50);
	
	private JButton add = new JButton("Add Product");
	private JButton update = new JButton("Update Product");
	private JButton delete = new JButton("Delete Product");
	private JButton show = new JButton("Show Products");
	private JButton main = new JButton("Back to main panel");
	
	
	public ProductView() {
		JPanel panel1 = new JPanel();   
		JPanel panel2 = new JPanel();   
		JPanel panel3 = new JPanel();   
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
		JPanel panel6 = new JPanel();
		
		
		panel1.add(new JLabel("Product id"));
		panel1.add(getGiveProductId());
		
		panel2.add(new JLabel("Product name"));
		panel2.add(giveProductName);
		
		panel3.add(new JLabel("Quantity"));
		panel3.add(giveProductQuantity);
		
		panel4.add(new JLabel("Price"));
		panel4.add(giveProductPrice);
		
		panel5.add(add);
		panel5.add(update);
		panel5.add(delete);
		panel5.add(show);
		
		panel6.add(main);
		
		JPanel p = new JPanel();  
		p.add(panel1);   
		p.add(panel2); 
		p.add(panel3);
		p.add(panel4);
		p.add(panel5);
		p.add(panel6);
		
		p.setLayout(new BoxLayout(p, BoxLayout. Y_AXIS ));  
		this.setContentPane(p);
		
		this.pack();               
		this.setTitle("Products");  
		  
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public JTextField getGiveProductName() {
		return giveProductName;
	}

	public void setGiveProductName(JTextField giveProductName) {
		this.giveProductName = giveProductName;
	}

	public JTextField getGiveProductQuantity() {
		return giveProductQuantity;
	}

	public void setGiveProductQuantity(JTextField giveProductQuantity) {
		this.giveProductQuantity = giveProductQuantity;
	}

	public JTextField getGiveProductPrice() {
		return giveProductPrice;
	}

	public void setGiveProductPrice(JTextField giveProductPrice) {
		this.giveProductPrice = giveProductPrice;
	}

	public void addProductInsertListener(ActionListener listener) {
		add.addActionListener(listener);
	}
	
	public void addProductUpdateListener(ActionListener listener) {
		update.addActionListener(listener);
	}
	
	public void addProductDeleteListener(ActionListener listener) {
		delete.addActionListener(listener);
	}
	
	public void addShowProductsListener(ActionListener listener) {
		show.addActionListener(listener);
	}
	
	public void addMainPanelListener(ActionListener listener) {
		main.addActionListener(listener);
	}
	

	public JTextField getGiveProductId() {
		return giveProductId;
	}

	public void setGiveProductId(JTextField giveProductId) {
		this.giveProductId = giveProductId;
	} 
	
}
