package application;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Properties;

public class OrderRepositoryFile2 extends OrderRepository {
	
	public void readFromFile(){
		
		try {
			Properties properties = new Properties();
			properties.load(new FileInputStream("CakeOrder.properties"));	
			String ordersFileName=properties.getProperty("ordersFile");
			if(ordersFileName==null) {
				ordersFileName="CakesOrders.txt";
				System.err.println("Requests file not found. Using default + ordersFileName");
			}
			OrderRepository order_list=new OrderRepositoryFile(ordersFileName);
		}
		catch(IOException e) {
			System.err.println("Error "+e);
		}
	}
}
