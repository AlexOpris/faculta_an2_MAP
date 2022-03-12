package application;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Controller{
	
	private OrderRepository Repository;
	
	public void add(CakeOrder cake_order) {
		Repository.add_order(cake_order);
	}
	
	public void remove(CakeOrder cake_order) {
		Repository.cancel_order(cake_order);
	}
	
	public CakeOrder get_most_expensive() {
		return Repository.get_most_expensive();
	}
	
	public CakeOrder get_oldest() {
		return Repository.get_oldest();
	}
	
	public CakeOrder get_most_cake_nr() {
		return Repository.get_most_cakes_nr();
	}
	
	public List<CakeOrder> filter_cakes_phone_nr_contains(String s) {
			
		@SuppressWarnings("unchecked")
		var cakes=Repository.get_all()
				.stream()
				.filter(list->list.get_phone_nr().contains(s))
				.collect(Collectors.toList());
		
		return cakes;
	}
	
	public List<CakeOrder> filter_cakes_price_higher(float n) {
		
		@SuppressWarnings("unchecked")
		var cakes=Repository.get_all()
				.stream()
				.filter(list->list.get_price()>n)
				.collect(Collectors.toList());	
		
		return cakes;
	}
	
	public	List<CakeOrder> filter_cakes_name_start_with(String s) {
		
		@SuppressWarnings("unchecked")
		var cakes=Repository.get_all()
				.stream()
				.filter(list->list.get_name().startsWith(s))
				.collect(Collectors.toList());
		
		return cakes;
	}
	

	public List<CakeOrder> filter_cakes_candles_equal_to(int n) {
		
		@SuppressWarnings("unchecked")
		var cakes= Repository.get_all()
				.stream()
				.filter(list->list.get_candles()==n)
				.collect(Collectors.toList());
		
		return cakes;
	}
	
	public List<CakeOrder> filter_cakes_weight_lower(float n){

		@SuppressWarnings("unchecked")
		var cakes=Repository.get_all()
				.stream()
				.filter(list->list.get_weight()<n)
				.collect(Collectors.toList());
		
		return cakes;
		
	}	
}
