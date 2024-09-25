package som.pro.hibernate;





import javax.persistence.RollbackException;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String args[]) throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException, javax.transaction.RollbackException {

		System.out.println("project started ..");

		// create the object of configuration

		Configuration cfg = new Configuration();
		// call the method configure to configure the xml file
		cfg.configure();
		// call the method configure to configure the xml file and place the file name
		// if file is not present in the correct place
		// cfg.configure("hibernate.cfg.xml");

		// create the object of sessionfactory usig this factory object we can save
		// ,fetch the data used for multiple purpose
		SessionFactory factory = cfg.buildSessionFactory();

		// print the created object
		System.out.println(factory);

		// check the factory is closed or not
	    //System.out.println(factory.isClosed());
		
		// creating student object to pass the data to create table
		Student st = new Student();
		st.setId(101);
		st.setName("Somanath");
		st.setCity("DELHI");

		// print the student object which return student id,name and city
		// when we print the student object it calls the toString method present in
		// Student Entity/class
		System.out.println(st);

		//get the current session to write the save() inside it bcz save() is present in sessin so create the object of current session
		Session session=factory.openSession();
		///
		//create the transaction begin to commit  the changes done in database 
		Transaction tx=(Transaction) session.beginTransaction();
		//save the object st in the databse
		session.save(st);
		//after changes done in database get the currentTransaction  and commit it in database
		tx.commit();
		//close the session object
		session.close();
	}

}
