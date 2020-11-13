package com.controller;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import model.Suppliers;

@Controller
@RequestMapping("/supplier")
public class supplierController {
	@RequestMapping(method = RequestMethod.POST)
	public String listStudent(ModelMap model) {
		List<Suppliers> data = getAll();
		System.out.println(data);
		model.addAttribute("message", data);
		return "showSupplier";
	}
	List<Suppliers> getAll() {
		Configuration configObj = new Configuration();
		configObj.addClass(model.Suppliers.class);
		configObj.configure("/model/hibernate.cfg.xml");

		// Since Hibernate Version 4.x, ServiceRegistry Is Being Used
		ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder()
				.applySettings(configObj.getProperties()).build();
		Session session = null;
		session = configObj.buildSessionFactory(serviceRegistryObj).openSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();
			List data = session.createQuery(" FROM Suppliers ").list();
			for (Iterator iterator = data.iterator(); iterator.hasNext();) {
				Suppliers st = (Suppliers) iterator.next();
				System.out.print("ID: " + st.getId());
				System.out.print("companyName: " + st.getCompanyname());
				System.out.println("Address: " + st.getAddress());
				System.out.println("Email: " + st.getEmail());
				System.out.println("Phone: " + st.getPhone());
				System.out.println("salesName: " + st.getSalesName());
				System.out.println("salesPhone: " + st.getSalesPhone());
				System.out.println("salesEmail: " + st.getSalesEmail());
			}
			tx.commit();
			return data;
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return null;
	}
	
	public void addSup(Suppliers sup) {
		Configuration configObj = new Configuration();
		configObj.addClass(model.Suppliers.class);
		configObj.configure("/model/hibernate.cfg.xml");

		// Since Hibernate Version 4.x, ServiceRegistry Is Being Used
		ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder()
				.applySettings(configObj.getProperties()).build();
		Session sessionObj = null;
		// Creating Hibernate SessionFactory Instance
		try {
			sessionObj = configObj.buildSessionFactory(serviceRegistryObj).openSession();
			sessionObj.beginTransaction();
			sessionObj.save(sup);

			System.out.println("\n.......Records Saved Successfully To The Database.......\n");

			// Committing The Transactions To The Database
			sessionObj.getTransaction().commit();

		} catch (Exception sqlException) {
			if (null != sessionObj.getTransaction()) {
				System.out.println("\n.......Transaction Is Being Rolled Back.......");
				sessionObj.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} finally {
			if (sessionObj != null) {
				sessionObj.close();
			}
		}
	}
	@RequestMapping(value = "/supplieradd", method = RequestMethod.POST)
	public ModelAndView addSupplier(@ModelAttribute("Suppliers") Suppliers sup) {
		System.out.println("sup obj:" + sup);
		addSup(sup);		
		return  new ModelAndView("showSupplier","message",getAll());

	}
	
	public void updateSup(Suppliers sup) {
		Configuration configObj = new Configuration();
		configObj.addClass(model.Suppliers.class);
		configObj.configure("/model/hibernate.cfg.xml");

		// Since Hibernate Version 4.x, ServiceRegistry Is Being Used
		ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder()
				.applySettings(configObj.getProperties()).build();
		Session sessionObj = null;
		// Creating Hibernate SessionFactory Instance
		try {
			sessionObj = configObj.buildSessionFactory(serviceRegistryObj).openSession();
			sessionObj.beginTransaction();
			sessionObj.update(sup);

			System.out.println("\n.......Records Saved Successfully To The Database.......\n");

			// Committing The Transactions To The Database
			sessionObj.getTransaction().commit();

		} catch (Exception sqlException) {
			if (null != sessionObj.getTransaction()) {
				System.out.println("\n.......Transaction Is Being Rolled Back.......");
				sessionObj.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} finally {
			if (sessionObj != null) {
				sessionObj.close();
			}
		}
	}
	
	@RequestMapping(value = "/supplierupdate", method = RequestMethod.POST)
	public ModelAndView updateSupplier(@ModelAttribute("Suppliers") Suppliers sup) {
		System.out.println("sup obj:" + sup);
		updateSup(sup);		
		return  new ModelAndView("showSupplier","message",getAll());

	}
	
	public void deleteSup(Suppliers sup) {
		Configuration configObj = new Configuration();
		configObj.addClass(model.Suppliers.class);
		configObj.configure("/model/hibernate.cfg.xml");

		// Since Hibernate Version 4.x, ServiceRegistry Is Being Used
		ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder()
				.applySettings(configObj.getProperties()).build();
		Session sessionObj = null;
		// Creating Hibernate SessionFactory Instance
		try {
			sessionObj = configObj.buildSessionFactory(serviceRegistryObj).openSession();
			sessionObj.beginTransaction();
			sessionObj.delete(sup);

			System.out.println("\n.......Records Saved Successfully To The Database.......\n");

			// Committing The Transactions To The Database
			sessionObj.getTransaction().commit();

		} catch (Exception sqlException) {
			if (null != sessionObj.getTransaction()) {
				System.out.println("\n.......Transaction Is Being Rolled Back.......");
				sessionObj.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} finally {
			if (sessionObj != null) {
				sessionObj.close();
			}
		}
	}
	@RequestMapping(value = "/supplierdelete", method = RequestMethod.POST)
	public ModelAndView deleteSupplier(@ModelAttribute("Suppliers") Suppliers sup) {
		System.out.println("sup obj:" + sup);
		deleteSup(sup);		
		return  new ModelAndView("showSupplier","message",getAll());

	}
	
	
		List<Suppliers> reple() {
			Configuration configObj = new Configuration();
			configObj.addClass(model.Suppliers.class);
			configObj.configure("/model/hibernate.cfg.xml");

			// Since Hibernate Version 4.x, ServiceRegistry Is Being Used
			ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder()
					.applySettings(configObj.getProperties()).build();
			Session session = null;
			session = configObj.buildSessionFactory(serviceRegistryObj).openSession();
			Transaction tx = null;
			try {

				tx = session.beginTransaction();
				List data = session.createQuery("FROM Suppliers").list();
				for (Iterator iterator = data.iterator(); iterator.hasNext();) {
					Suppliers st = (Suppliers) iterator.next();
					System.out.print("companyName: " + st.getCompanyname());
				}
				tx.commit();
				return data;
			} catch (HibernateException e) {
				if (tx != null)
					tx.rollback();
				e.printStackTrace();
			} finally {
				session.close();
			}

			return null;
		}
	@RequestMapping(value = "/replenishment", method = RequestMethod.POST)
	public String replenishment(ModelMap model) {
			List<Suppliers> list = reple();
			System.out.println(list);
			model.addAttribute("message", list);
			return "showtest";
	}
	
	
}
