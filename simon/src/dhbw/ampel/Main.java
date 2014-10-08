package dhbw.programmierern.ampel;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		AmpelThread ampelThread = new AmpelThread(new AmpelFrame());
		ampelThread.start();
	}

}
