package es.pioldoras.loC;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsoEmpleados {

	public static void main(String[] args) {

		// creación de objetos de tipo Empleado
//		
//		Empleados Empleado1=new DirectorEmpleado();
//		
//		//Uso de los objetos creados
//		
//		System.out.println(Empleado1.getTareas());
		ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext("aplicationContext.xml");

		Empleados Juan = contexto.getBean("miEmpleado", SecretarioEmpleado.class);
		System.out.println(Juan.getTareas());
		contexto.close();
	}
}
