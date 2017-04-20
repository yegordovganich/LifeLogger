package lifelogger.server;

import org.hibernate.cfg.Configuration;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.hibernate.SessionFactory;


public class HibernateSessionFactory extends UnicastRemoteObject {
	private static final long serialVersionUID = -3364392900482144881L;

	protected HibernateSessionFactory() throws RemoteException {
		super();
	}

	private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	public static SessionFactory getHibernateSessionFactory() {
		return sessionFactory;
	}
}
