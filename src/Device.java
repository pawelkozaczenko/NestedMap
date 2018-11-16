import java.util.Date;

public class Device {
	
	private int mf;
	private int type;
	private long date;
	
	public Device(int mf, int type, long date){
		this.mf = mf;
		this.type = type;
		this.date = date;
	}
	
	public int getMf(){
		return mf; 
	}
	
	public int getType(){
		return type;
	}
	
	public long getDate(){
		return date;
	}
	
	public Date getReadableDate() {
		Date result = new Date(date);
		return result;
	}
	
	@Override
	public String toString(){
		//Look at overshadowin local field date :)!!!
		Date date = getReadableDate();
		return String.format("mf: %s, type: %s, date: %s", mf, type, date);
	}
}
