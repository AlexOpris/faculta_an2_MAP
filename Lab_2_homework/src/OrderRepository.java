import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OrderRepository implements OrderRepo {
	
	protected ArrayList<CakeOrder> order_list;
	
	public OrderRepository() {
		
		this.order_list=new ArrayList<CakeOrder>();
		
	}
	
	@Override
	public ArrayList<CakeOrder> get_all() {

		return this.order_list;
	}

	@Override
	public void add_order(CakeOrder cake_order) {
		
		this.order_list.add(cake_order);
	}

	@Override
	public void cancel_order(CakeOrder cake_order) {
		
		this.order_list.remove(cake_order);
		
	}
	
	@Override
	public CakeOrder get_oldest() {
		
		int max_candles=0;
		CakeOrder max_order=null;
		
		for(CakeOrder elem: this.order_list)
		{
			if(elem.get_candles()>max_candles)
			{
				max_order=elem;
				max_candles=elem.get_candles();
			}
		}
		
		return max_order;
	}

	@Override
	public CakeOrder get_most_cakes_nr() {
		
		int max_cakes=0;
		CakeOrder max_order=null;
		
		for(CakeOrder elem: this.order_list)
		{
			if(elem.get_cakes_nr()>max_cakes)
			{
				max_order=elem;
				max_cakes=elem.get_cakes_nr();
			}
		}
		
		return max_order;
	}

	@Override
	public CakeOrder get_most_expensive() {
		
		float max_price=0;
		CakeOrder max_order=null;
		
		for(CakeOrder elem: this.order_list)
		{
			if(elem.get_price()>max_price)
			{
				max_order=elem;
				max_price=elem.get_price();
			}
		}
		
		return max_order;
	}
	
}
