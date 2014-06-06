package klassen.aufgaben1;

public class Radio {

	private boolean eingeschaltet = false;
	private int lautstaerke = 5;
	private double frequenz = 99.9;
	
	public Radio(){}
	
	public Radio(boolean einaus, int laut, double freq){
		this.eingeschaltet = einaus;
		
		waehleSender(freq);
		
		if(laut < 0){
			laut = 0;
		}else if(laut > 10){
			laut = 10;
		}
		
		this.lautstaerke = laut;
	}
	
	public void lauter(){
		if(eingeschaltet){
			lautstaerke++;
			
			if(lautstaerke > 10){
				lautstaerke = 10;
			}
		}
	}
	
	public void leiser(){
		if(eingeschaltet){
			lautstaerke--;
			
			if(lautstaerke < 0){
				lautstaerke = 0;
			}
		}
	}
	
	public void an(){
		this.eingeschaltet = true;
	}
	
	public void aus(){
		this.eingeschaltet = false;
	}
	
	public void waehleSender(double frequenz){
		if(frequenz < 85 || frequenz > 110){
			frequenz = 99;
		}
		
		this.frequenz = frequenz;
	}
	
	@Override
	public String toString(){
		return String.format("Radio %s: Freq=%s, Laut=%s", (eingeschaltet ? "an" : "aus"), frequenz, lautstaerke);
	}
	
}
