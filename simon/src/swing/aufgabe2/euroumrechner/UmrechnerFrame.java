package swing.aufgabe2.euroumrechner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class UmrechnerFrame extends dhbw.lib.SimonsFrame{

	private JTextField inputMoney;
	private JButton btnToDollar;
	private JButton btnToEuro;
	private JButton btnCancel;
	
	
	
	private static final double EXCHANGE_RATE = 1.95583;
	
	public UmrechnerFrame() {
		super();
		
		this.prepareGui();
		
		this.buildForm();
	
		
		this.deliverGui(false);
		
	}
	
	private void buildForm(){
		final UmrechnerFrame frame = this;
		this.inputMoney = new JTextField();
		this.btnToDollar = new JButton("Zu Dollar");
		this.btnToEuro = new JButton("Zu Euro");
		this.btnCancel = new JButton("Abbrechen");
				
		this.addToGui(new JLabel("Input"));
		this.addToGui(this.inputMoney);
		
		JPanel buttonsPanel = this.addPanel(1, 3);
		
		buttonsPanel.add(this.btnToEuro);
		buttonsPanel.add(this.btnToDollar);
		buttonsPanel.add(this.btnCancel);
		
		this.btnToEuro.addActionListener(new UmrechnerListener(this, true));
		this.btnToDollar.addActionListener(new UmrechnerListener(this, false));
		
		this.btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				
			}
		});
		
		
		/**
		 * MENU BAR
		 */
		JMenuBar menuBar = this.createMenuBar();
		JMenu convertMenu = new JMenu("Konvertieren");
		
		JMenuItem itemToEuro = new JMenuItem("Zu Euro");		
		JMenuItem itemToDollar = new JMenuItem("Zu Dollar");
		
		itemToDollar.addActionListener(new UmrechnerListener(this, false));
		itemToEuro.addActionListener(new UmrechnerListener(this, true));
		
		convertMenu.add(itemToDollar);
		convertMenu.add(itemToEuro);
		
		menuBar.add(convertMenu);
		
		/**
		 * Radio Group
		 */
		
		final JRadioButton radioToEuro = new JRadioButton("Zu Euro");
		JRadioButton radioToDollar = new JRadioButton("Zu Dollar");
		ButtonGroup btnRadios = new ButtonGroup();
		btnRadios.add(radioToEuro);
		btnRadios.add(radioToDollar);
		
		
		JPanel radioPanel = this.addPanel(1, 3);
		radioPanel.add(radioToEuro);
		radioPanel.add(radioToDollar);
		
		JButton radioButton = new JButton("Konvertieren");
		radioPanel.add(radioButton);
		radioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Boolean toEuro = radioToEuro.isSelected();
				frame.doCalculation(toEuro);
				
			}
		});
		
	}
	
	public void doCalculation(Boolean toEuro){
		
		String moneyString = this.inputMoney.getText();
		moneyString = moneyString.replace("$", "");
		moneyString = moneyString.replace("€", "");
		
		Double moneyDouble = Double.parseDouble(moneyString);
		
		Double moneyResult = null;
		String unitString = null;
		
		
		if(toEuro){
			unitString = "€";
			moneyResult = moneyDouble / EXCHANGE_RATE;
		}
		else{
			unitString = "$";
			moneyResult = moneyDouble * EXCHANGE_RATE;
		}
		
		this.inputMoney.setText(moneyResult.toString() +  unitString);
		
		
		
		
	}

	
	
	
}
