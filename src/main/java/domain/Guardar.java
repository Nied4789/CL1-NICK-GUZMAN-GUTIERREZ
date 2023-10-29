package domain;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Guardar {
	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
		EntityManager manager = factory.createEntityManager();
		
		EntityTransaction tx = manager.getTransaction();
		
		tx.begin();
		
		Empleado em = new Empleado();
		em.setNombres("Nick");
		em.setApellido_paterno("Guzman");
		em.setApellido_materno("Guitierrez");
		em.setSueldo(1200.0);
		em.setNro_hijos(0);
		em.setFecha_nacimiento(LocalDate.of(1995, 10, 10));
		
		
		manager.persist(em);
		
		tx.commit();
		
		
		List<Empleado> lista = manager.createQuery("from Empleado", Empleado.class).getResultList();
		for (Empleado departamento : lista) {
			System.out.println(departamento);
		}
		
	}

}
