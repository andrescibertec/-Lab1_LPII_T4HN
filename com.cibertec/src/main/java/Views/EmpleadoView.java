package Views;

import Controllers.EmpleadoController;

public class EmpleadoView {

	
	public static void main(String[] args) {

		//CREAR EMPEADO
		//String empleado = new EmpleadoController().createEmpleado("Huaman", "Jhon",14,"Masculino",100);
		//String empleado = new EmpleadoController().createEmpleado("Cabanillas", "Andres",18,"Masculino",1200);
		//String empleado= new EmpleadoController().createEmpleado("Huaman", "Joselin",21,"Femenino",1500);
		//String empleado = new EmpleadoController().createEmpleado("Villanueva", "Marta",35,"Femenino",2000);

		//ELIMINAR EMPLEAOD
		//String empleado = new EmpleadoController().deleteEmpleado(1);
		//String empleado = new EmpleadoController().deleteEmpleado(2);
		
		//ACTUALIZAR EMPLEADO
		String empleado = new EmpleadoController().updateEmpleado(3, "Salas","Guillermo");
		
		//LEER EMPLEADO
		//String empleado = new EmpleadoController().getEmpleado(3);
		System.out.println(empleado);
	}
}
