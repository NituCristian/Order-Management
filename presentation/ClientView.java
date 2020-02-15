package presentation;


import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.*;


public class ClientView extends JFrame{

	private JTextField giveClientId = new JTextField(50);
	private JTextField giveClientFirstName = new JTextField(50);
	private JTextField giveClientLastName = new JTextField(50);
	private JTextField giveClientAge = new JTextField(50);
	private JTextField giveClientEmail = new JTextField(50);
	private JTextField giveNoOfClients = new JTextField(50);
	
	private JButton add = new JButton("Add client");
	public JTextField getGiveNoOfClients() {
		return giveNoOfClients;
	}

	public void setGiveNoOfClients(JTextField giveNoOfClients) {
		this.giveNoOfClients = giveNoOfClients;
	}

	private JButton update = new JButton("Update client");
	private JButton delete = new JButton("Delete client");
	private JButton show = new JButton("Show clients");
	private JButton main = new JButton("Back to main panel");
	
	public ClientView() {
		JPanel panel1 = new JPanel();   
		JPanel panel2 = new JPanel();   
		JPanel panel3 = new JPanel();   
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
		JPanel panel6 = new JPanel();
		JPanel panel7 = new JPanel();
		JPanel panel8 = new JPanel();
		
		panel1.add(new JLabel("Client id"));
		panel1.add(getGiveClientId());
		
		panel2.add(new JLabel("First name"));
		panel2.add(giveClientFirstName);
		
		panel3.add(new JLabel("Last name"));
		panel3.add(giveClientLastName);
		
		panel4.add(new JLabel("Age"));
		panel4.add(giveClientAge);
		
		panel5.add(new JLabel("Email"));
		panel5.add(giveClientEmail);
		
		panel6.add(add);
		panel6.add(update);
		panel6.add(delete);
		panel6.add(show);
		
		panel7.add(new JLabel("Number of clients is: "));
		panel7.add(giveNoOfClients);
		
		panel8.add(main);
		
		JPanel p = new JPanel();  
		p.add(panel1);   
		p.add(panel2); 
		p.add(panel3);
		p.add(panel4);
		p.add(panel5);
		p.add(panel6);
		p.add(panel7);
		p.add(panel8);
		
		p.setLayout(new BoxLayout(p, BoxLayout. Y_AXIS ));  
		this.setContentPane(p);
		
		this.pack();               
		this.setTitle("Clients");  
		  
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void addClientInsertListener(ActionListener listener) {
		add.addActionListener(listener);
	}
	
	public JTextField getGiveClientFirstName() {
		return giveClientFirstName;
	}

	public void setGiveClientFirstName(JTextField giveClientFirstName) {
		this.giveClientFirstName = giveClientFirstName;
	}

	public JTextField getGiveClientLastName() {
		return giveClientLastName;
	}

	public void setGiveClientLastName(JTextField giveClientLastName) {
		this.giveClientLastName = giveClientLastName;
	}

	public JTextField getGiveClientAge() {
		return giveClientAge;
	}

	public void setGiveClientAge(JTextField giveClientAge) {
		this.giveClientAge = giveClientAge;
	}

	public JTextField getGiveClientEmail() {
		return giveClientEmail;
	}

	public void setGiveClientEmail(JTextField giveClientEmail) {
		this.giveClientEmail = giveClientEmail;
	}

	public void addClientUpdateListener(ActionListener listener) {
		update.addActionListener(listener);
	}
	
	public void addClientDeleteListener(ActionListener listener) {
		delete.addActionListener(listener);
	}
	
	public void addShowClientsListener(ActionListener listener) {
		show.addActionListener(listener);
	}
	
	public void addMainPanelListener(ActionListener listener) {
		main.addActionListener(listener);
	}

	public JTextField getGiveClientId() {
		return giveClientId;
	}

	public void setGiveClientId(JTextField giveClientId) {
		this.giveClientId = giveClientId;
	}
	
}
