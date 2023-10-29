package domain;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Modificar {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        EntityManager manager = factory.createEntityManager();

        EntityTransaction tx = manager.getTransaction();
        tx.begin();

        Long idempleado = 2L; 
        String nuevoNombre = "Juan Mecanico :v"; 

        Empleado empleado = manager.find(Empleado.class, idempleado);
        if (empleado != null) {
            empleado.setNombres(nuevoNombre);
        }

        tx.commit();
        List<Empleado> lista = manager.createQuery("from Empleado", Empleado.class).getResultList();
		for (Empleado departamento : lista) {
			System.out.println(departamento);
		}

        factory.close();
        
        

	}

}
