package application;

public class CakeOrder extends Cake {
	
	private String phone_nr;
	private int cakes_nr;
	
	public CakeOrder(String name, float weight, float price, int candles, String phone_nr, int cakes_nr){
		
		super(name, weight, price, candles);
		this.phone_nr=phone_nr;
		this.cakes_nr=cakes_nr;
	}
	
	public void set_phone_nr(String phone_nr) {
		this.phone_nr=phone_nr;
	}
	
	public String get_phone_nr() {
		return this.phone_nr;
	}
	
	public void set_cakes_nr(int nr) {
		this.cakes_nr=nr;
	}

	public int get_cakes_nr() {
		return this.cakes_nr;
	}
	
	@Override
	public String to_string() {
		String s="";
		s=s+this.get_name();
		s=s+" has ";
		s=s+this.get_weight();
		s=s+" kg, ";
		s=s+" the price: ";
		s=s+this.get_price();
		s=s+" and "+this.get_candles()+" candles, phone number: "+this.phone_nr+" "+this.cakes_nr+" cakes.";		
		
		return s;
	}
	
	
}
