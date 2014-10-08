package dhbw.programmierern.ampel;

public class AmpelThread extends Thread {

	private AmpelStaten ampelStatus = AmpelStaten.GRUEN;
	private AmpelFrame ampelFrame;
	
	public AmpelThread(AmpelFrame ampelFrame) {
		super();
		this.ampelFrame = ampelFrame;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run(){
		while(!Thread.interrupted()){
			AmpelStaten nextState = ampelStatus.getNext();
			
			try {
				System.out.println("Ampel leuchtet " + nextState.getTitle());
				this.ampelFrame.changeState(nextState);
				this.ampelStatus = nextState;
				Thread.sleep(nextState.getDuration());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	
	
}
