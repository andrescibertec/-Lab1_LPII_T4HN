package Controllers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Models.Empleado;


public class EmpleadoController {

	public String createEmpleado(String apellido, String nombre, int edad, String sexo, double salario)
	{
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		try {
			Empleado empleado = new Empleado(apellido, nombre, edad, sexo, salario);
			
			session.beginTransaction();
			session.save(empleado);
			session.getTransaction().commit();
			sessionFactory.close();
			
			return "Empleado creado";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Error al registrar Empleado";
	}
	
	
	// Eliminar empleado
	
		public String deleteEmpleado(int idempleado) 
		{
			SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
			
			Session session = sessionFactory.openSession();
			
			try {
			
				session.beginTransaction();
				Empleado empleado = session.get(Empleado.class, idempleado);
				session.delete(empleado);
				session.getTransaction().commit();
				sessionFactory.close();
				
				return "empleado eliminado correctamente";
			} catch (Exception e) {
			
				e.printStackTrace();

			}
			
			return "Error al eliminar empleado";
		}
		
		// Actualizar Empleado
		
		public String updateEmpleado(int idempleado,String apellido,String nombre)
		{
			SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
			Session session = sessionFactory.openSession();
			
			try {
				session.beginTransaction();
				Empleado empleado = session.get(Empleado.class, idempleado);
				empleado.setApellido(apellido);
				empleado.setNombre(nombre);
				session.update(empleado);
				session.getTransaction().commit();
				sessionFactory.close();
				
				return "Empleado actualizado correctamente";
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "Error al actualizar Empleado";
		}
		
		
		// Obtener o leer Empleado
		
		public String getEmpleado(int idempleado)
		{
			SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
			
			Session session = sessionFactory.openSession();
			
			try {
				
				session.beginTransaction();
				Empleado empledo = session.get(Empleado.class, idempleado);
				session.getTransaction().commit();		
				sessionFactory.close();
				
				return "Empleado encontrado";
			} catch (Exception e) {
				
				e.printStackTrace();
			
			}
			return "Empleado no encontrado";
		}
	}

