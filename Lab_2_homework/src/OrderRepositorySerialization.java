

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class OrderRepositorySerialization extends OrderRepository {

	private String file_name;

	public OrderRepositorySerialization(String filename) {
		this.file_name = filename;
		readFromFile();
	}
	
	@SuppressWarnings("unchecked")
	public void readFromFile ()
	{
		
		ObjectInputStream in=null;
		
		try {
			in = new ObjectInputStream(new FileInputStream(file_name));
			order_list=(ArrayList<CakeOrder>)in.readObject();
		}catch(IOException e) {
			System.err.println("Deserilization error "+e);
		}catch (ClassNotFoundException e) {
			System.err.println("Deserialization error "+e);
		}finally{
			if (in!=null)
				try {
					in.close();
				}catch (IOException e) {System.err.println("Eroare "+e); }
		}
		
	}
	
    public void writeToFile()
    {
    	ObjectOutputStream out=null;
		
		try {
			out=new ObjectOutputStream(new FileOutputStream(file_name));
			out.writeObject(order_list);
		}catch (IOException e) {
			System.err.println("Serializatin error "+e);
		}finally {
			if(out!=null)
				try {
					out.close();
				}catch(IOException e) {
					System.err.println("Error "+e);
				}
		}
	 }

    @Override
    public void add_order(CakeOrder obj) {
        try {
            super.add_order(obj);
            writeToFile();
        } catch (RuntimeException e) {
        	System.err.println("Object wasn’t added" + e + " "+obj);
        }
    }

    @Override
    public void cancel_order(CakeOrder obj) {
        try {
            super.order_list.remove(obj);
            writeToFile();
        } catch (RuntimeException ex) {
        	System.err.println("Object was not deleted" + ex +" "+obj);
        }
    }
    
    

	  
}

