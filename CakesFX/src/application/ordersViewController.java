package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class ordersViewController implements Initializable {
	
	private OrderRepository cakeRepo;
	private List<CakeOrder> order_list;
	
	@FXML private TextField nameText;
	@FXML private TextField weightText;
	@FXML private TextField candlesText;
	@FXML private TextField phoneText;
	@FXML private TextField cakenrText;
	@FXML private TextField priceText;
	@FXML private Button enterBtn;
	@FXML private Button showBtn;
	@FXML private Button clearBtn;
	
	public ordersViewController(){
		
		this.cakeRepo=new OrderRepository();
		this.order_list=FXCollections.observableArrayList();
	}
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		for(CakeOrder elem: cakeRepo.get_all()){
			order_list.add(elem);
		}
	}
	
	@FXML
	public void enterOrder(ActionEvent e) {
    	String name = nameText.getText();

    	
    	String w = weightText.getText();
    	float weight=Float.parseFloat(w);
    	
    	String p = priceText.getText();
    	float price=Float.parseFloat(p);
    	
    	String c = candlesText.getText();
    	int candles=Integer.parseInt(c);
    	
    	String phone = phoneText.getText();

    	
    	String cakes = priceText.getText();
    	int cakes_nr=Integer.parseInt(cakes);
    	
    	CakeOrder cakeOrd = new CakeOrder(name, weight, price, candles, phone, cakes_nr);
    	
    	cakeRepo.add_order(cakeOrd);
    	this.order_list.add(cakeOrd);
    	
    	this.clearFields(e);
    		    	
	}
	
	@FXML
	public void clearFields(ActionEvent e) throws IOException {
		nameText.setText("");
		weightText.setText("");
		priceText.setText("");
		candlesText.setText("");
		cakenrText.setText("");
		phoneText.setText("");
	}
	
	@FXML
	public void showExistingOrders(ActionEvent e) throws IOException{
		
		System.out.println(this.cakeRepo.get_all().toString());
		
	}


}
