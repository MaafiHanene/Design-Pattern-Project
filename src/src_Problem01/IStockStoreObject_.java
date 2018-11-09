package src_Problem01;
//serialization
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
public interface IStockStoreObject_{
	public void sauvegarder(Object object,String file);
	public Object charger(String file);
	
	

}
