package jpa.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import pe.edu.cibertec.proyemp.jpa.domain.Departamento;
import pe.edu.cibertec.proyemp.jpa.domain.Empleado;

public class JPSTest {
	
	private EntityManager manager;
	
	public JPSTest(EntityManager manager) {
		this.manager = manager;
	}
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistenceUnit");
		EntityManager manager = factory.createEntityManager();
		JPSTest test = new JPSTest(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		test.crearEmpleados2();
		tx.commit();
		test.listarEmpleados();

	
	}
	private void crearEmpleados2() {
		Departamento java = new Departamento("Java");
		Empleado emp1=new Empleado("Bob");
		Empleado emp2=new Empleado("Mike");
		
//		List<Empleado> empleado=new ArrayList<Empleado>();
//		empleado.add(emp1);
//		empleado.add(emp2);
		
//		java.setEmpleados(empleado);
//		manager.persist(java); //persist sirve para insertar y modificar
        
		
		java.setEmpleados(Arrays.asList(emp1,emp2));
		manager.persist(java); //persist sirve para insertar y modificar
		
		
	}
	private void crearEmpleados() {
		Departamento departamento = new Departamento("Java");
		manager.persist(departamento); //persist sirve para insertar y modificar

		manager.persist(new Empleado("Bob",departamento));
		manager.persist(new Empleado("Mike",departamento));

        
		
	}
	private void listarEmpleados() {       //createNativeQuery
		List<Empleado> resultList = manager.createQuery("Select a From Empleado a", Empleado.class).getResultList();
		System.out.println("nro de empleados:" + resultList.size());
		for (Empleado next : resultList) {
			System.out.println("siguiente empleado: " + next);
		}
	}




}
