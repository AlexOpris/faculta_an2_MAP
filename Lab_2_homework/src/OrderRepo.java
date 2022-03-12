import java.util.ArrayList;

public interface OrderRepo {
	
	ArrayList<CakeOrder> get_all();
	void add_order(CakeOrder cake_order);
	void cancel_order(CakeOrder cake_order);
	CakeOrder get_most_expensive();
	CakeOrder get_oldest();
	CakeOrder get_most_cakes_nr();

}
