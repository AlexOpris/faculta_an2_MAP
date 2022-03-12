import java.io.Serializable;

public class Cake implements Serializable {
	
	private String name;
	private float weight;
	private float price;
	private int candles;
	
	public Cake(String name, float weight, float price, int candles) {
		
		this.name=name;
		this.weight=weight;
		this.price=price;
		this.candles=candles;
	}
	
	

	public Cake() {
			
			this.name="";
			this.weight=0;
			this.price=0;
			this.candles=0;
		}
		
	public void set_name(String name) {
		this.name=name;
	}
	
	public String get_name() {
		return this.name;
	}
	
	public void set_weight(float weight) {
		this.weight=weight;
	}
	
	public float get_weight() {
		return this.weight;
	}
	
	public void set_price(float price) {
		this.price=price;
	}
	
	public float get_price() {
		return this.price;
	}
	
	public void set_candles(int candles) {
		this.candles=candles;
	}
	
	public int get_candles() {
		return this.candles;
	}
	
	public String to_string() {
		String s="Cake: ";
		s=s+this.name;
		s=s+" has ";
		s=s+this.weight;
		s=s+" kg, ";
		s=s+" the price: ";
		s=s+this.price;
		s=s+" and "+this.candles+" candles.";
				
		return s;
	}
	
}
