package dhbw.lib;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class SCalendar extends Calendar{

	public SCalendar() {
		// TODO Auto-generated constructor stub
	}

	public SCalendar(TimeZone zone, Locale aLocale) {
		super(zone, aLocale);
		// TODO Auto-generated constructor stub
	}
	
	public static Calendar currentTime(){
		return SCalendar.getInstance();
	}
	
	public String timeString(){
		return this.getTime().toString();
	}

	@Override
	public void add(int field, int amount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void computeFields() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void computeTime() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getGreatestMinimum(int field) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getLeastMaximum(int field) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaximum(int field) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMinimum(int field) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void roll(int field, boolean up) {
		// TODO Auto-generated method stub
		
	}
	
	

}
