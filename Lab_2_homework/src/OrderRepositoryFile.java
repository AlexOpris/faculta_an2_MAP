import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class OrderRepositoryFile extends OrderRepository {
	
	private String file_name;
	
	public OrderRepositoryFile(String name) {
		this.file_name=name;
		readFromFile();
	}
	
	public void readFromFile(){
		DataInputStream input = null;
		
		try {
			input = new DataInputStream(new FileInputStream(file_name));
			while(true) {
				String name=input.readUTF();
				float weight = input.readFloat();
				float price = input.readFloat();
				int candles = input.readInt();
				String phone = input.readUTF();
				int nr_cakes = input.readInt();
				
				order_list.add(new CakeOrder(name, weight, price, candles, phone, nr_cakes));
			}
			
		}
		catch(EOFException e) {}
		
		catch(FileNotFoundException e) {
			System.err.println("Reading error"+e);
		}
		
		catch(IOException e) {
			System.err.println("Reading error "+e);
		}
		
		finally {
			if(input!=null)
				try {input.close();
				}catch (IOException e) {
					System.err.println("Closing file error "+e);
				}
		}	
	}
	
	public void printInFile() {
		DataOutputStream output=null;
		
		try {
			output=new DataOutputStream(new FileOutputStream(file_name));
			for(CakeOrder cake_order: order_list) {
				output.writeUTF(cake_order.get_name());
				output.writeFloat(cake_order.get_weight());
				output.writeFloat(cake_order.get_price());
				output.writeInt(cake_order.get_candles());
				output.writeUTF(cake_order.get_phone_nr());
				output.writeInt(cake_order.get_cakes_nr());
				
			}
		}catch(FileNotFoundException e) {
			System.err.println("Writing error "+e);
		}
		catch (IOException e) {
			System.err.println("Writing error "+e);
		}
		finally {
			if(output!=null)
				try {
					output.close();
				}catch(IOException e) {
					System.err.println("Writing error "+e);
				}
		}
		
	}
	
    @Override
    public void add_order(CakeOrder obj) {
        try {
            super.add_order(obj);
            printInFile();
        } catch (RuntimeException e) {
        	System.err.println("Writing error "+e);
        }
    }
    
    @Override
    public void cancel_order(CakeOrder obj) {
        try {
            super.cancel_order(obj);
            printInFile();
        } catch (RuntimeException e) {
        	System.err.println("Writing error "+e);
        }
    }

}
