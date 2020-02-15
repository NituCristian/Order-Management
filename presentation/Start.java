package presentation;

public class Start {

	/**
	 * Main class
	 * @param args
	 */
	public static void main(String args[]) {
		MainView mainView = new MainView();
		MainController mainController = new MainController(mainView);
		
		mainView.setVisible(true);
	}
	
}

