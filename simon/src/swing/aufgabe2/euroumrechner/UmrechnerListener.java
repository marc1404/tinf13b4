package swing.aufgabe2.euroumrechner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UmrechnerListener implements ActionListener {

	UmrechnerFrame umrechnerFrame;
	Boolean toEuro;




	public UmrechnerListener(UmrechnerFrame umrechnerFrame, Boolean toEuro) {
		super();
		this.umrechnerFrame = umrechnerFrame;
		this.toEuro = toEuro;
	}




	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.umrechnerFrame.doCalculation(this.toEuro);

	}

}
