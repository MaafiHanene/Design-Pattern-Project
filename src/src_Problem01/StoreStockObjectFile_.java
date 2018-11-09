package src_Problem01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class StoreStockObjectFile_ implements IStockStoreObject_ {

	@Override
	public void sauvegarder(Object object, String file) {
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
			      new File(file)))){
			   oos.writeObject(object);
			   
			  } catch (FileNotFoundException e) {
			   // TODO Auto-generated catch block
			   e.printStackTrace();
			  } catch (IOException e) {
			   // TODO Auto-generated catch block
			   e.printStackTrace();
			  }

		
	}

	
		

	@Override
	public Object charger(String file) {
		Object obj = null;
		  try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(file)))){
		   obj = ois.readObject();
		   
		  } catch (FileNotFoundException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  } catch (IOException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return obj;
		 }
	


		
	}

	


