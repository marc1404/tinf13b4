package probeklausur;

public class ZooTier {

	private String name;
	private String art;
	private String futter;
	
	public ZooTier(String art, String name, String futter){
		this.art = art;
		this.name = name;
		this.futter = futter;
	}
	
	public void fuettern(String futter){
		if(futter.equals(this.futter)){
			System.out.println(name + " (" + art + ") frisst " + futter);
		}else{
			System.out.println(name + " (" + art + ") verschmäht " + futter);
		}
	}
	
	public String getName(){
		return name;
	}
	
	public String getArt(){
		return art;
	}
	
	@Override
	public String toString(){
		return name + " (" + art + ")";
	}
	
}
