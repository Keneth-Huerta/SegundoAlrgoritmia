package segundoalrgoritmia;

import java.util.Scanner;

public class estresHidrico2 {
	private static String[] widgetsName = { "Baja California Sur", "Distrito Federal", "Sonora", "Coahuila", "Sinaloa",
			"Chihuahua", "Colima", "Aguascalientes", "Durango", "Baja California", "Guanajuato", "México", "Jalisco",
			"Zacatecas", "Querétaro", "Michoacán", "Morelos", "Tamaulipas", "Hidalgo", "Nayarit", "Nuevo León",
			"San Luis Potosí", "Tlaxcala", "Puebla", "Yucatán", "Guerrero", "Campeche", "Quintana Roo", "Oaxaca",
			"Veracruz", "Chiapas", "Tabasco" };
	private static double[] widgetChartText = { 5.00, 5.00, 5.00, 5.00, 5.00, 4.98, 4.93, 4.91, 4.92, 4.84, 4.86, 4.80,
			4.83, 4.51, 4.47, 4.84, 4.57, 4.69, 4.78, 4.76, 4.73, 4.72, 4.90, 4.85, 4.78, 4.55, 4.56, 4.63, 4.80, 4.75,
			4.62, 4.69, 4.62, 4.49, 4.67, 4.39, 4.57, 4.25, 4.50, 4.48, 4.45, 4.39, 4.49, 4.37, 4.30, 4.36, 3.94, 3.98,
			3.89, 4.26, 4.16, 3.94, 3.24, 3.40, 3.93, 3.06, 3.46, 3.93, 2.20, 3.08, 3.68, 2.95, 2.93, 3.11, 3.07, 3.02,
			2.57, 2.97, 2.99, 2.42, 2.19, 2.13, 1.12, 1.03, 1.06, 1.13, 0.96, 1.03, 1.07, 0.74, 0.82, 0.73, 0.97, 0.94,
			0.74, 0.42, 0.47, 0.63, 0.47, 0.41, 0.56, 0.35, 0.33, 0.29, 0.33, 0.30 };
	private static double[] widgetsTotal = { 5.00, 5.00, 4.93, 4.84, 4.80, 4.79, 4.78, 4.77, 4.74, 4.67, 4.63, 4.57,
			4.47, 4.47, 4.40, 4.25, 4.08, 3.83, 3.63, 3.63, 3.39, 3.08, 2.85, 2.26, 1.06, 1.05, 0.96, 0.86, 0.57, 0.49,
			0.40, 0.31 };

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Scanner R = new Scanner(System.in);
		int seleccion, sele, cons = 0;
		String repetir = "si";

		while (repetir.equalsIgnoreCase("si")) {
			cons++;
			System.out.println("1. SEGURIDAD HÍDRICA Y CERTEZA JURÍDICA DEL AGUA"
					+ "\n2. EL ESTRÉS HÍDRICO EN MÉXICO: RETOS, ESTRATEGIAS Y TENDENCIAS FUTURAS DE CÓMO ENFRENTAR EL DÍA CERO"
					+ "\n3. Escasez de agua |  Decenio Internacional para la Acción \"El agua, fuente de vida\" 2005-2015"
					+ "\n4. Obtener ranking");

			sele = in.nextInt();
			if (sele == 1) {

				System.out.println(
						"México se encuentra en la posición 24 a nivel mundial en cuanto a estrés hídrico, lo que indica que es necesario prever el futuro y los posibles impactos del cambio climático en las condiciones hidrológicas del país. Se estima que para 2030, la disponibilidad de agua disminuirá debido al aumento de la temperatura y la evapotranspiración, lo que llevará a una reducción del 10% con respecto al año 2000. Si no se atiende la situación de estrés hídrico, podrían surgir problemas de escasez, sobreexplotación y contaminación del agua, así como conflictos sociales y económicos. Además, existe una disparidad geográfica entre la disponibilidad de agua y la distribución de la población y sus actividades económicas en México. Por otro lado, la certeza jurídica en la gestión del agua y las concesiones es un componente esencial para garantizar la seguridad hídrica. Es necesario adoptar políticas integradas sobre el agua y el clima, mejorar la gestión cooperativa de los recursos hídricos y aumentar las inversiones en el sector hídrico.");
				System.out.println(
						"\nel Consejo Consultivo del Agua (CCA) en México, titulada \"Seguridad hídrica\", describe la situación crítica del agua en el país y urge a tomar medidas para garantizar este recurso vital. Aquí una síntesis de los puntos clave:\r\n"
								+ //
								"\r\n" + //
								"Principales desafíos:\r\n" + //
								"\r\n" + //
								"Escasez y sobreexplotación: México ocupa el puesto 24 a nivel mundial en estrés hídrico, lo que significa que la demanda de agua supera la disponibilidad. Esto se debe a la sobreexplotación de acuíferos y la irregularidad de las lluvias.\r\n"
								+ //
								"Contaminación: La polución de ríos y fuentes subterráneas amenaza la calidad del agua para consumo humano y ecosistemas.\r\n"
								+ //
								"Inequidad: 21 millones de personas en México no tienen acceso a agua potable segura, principalmente en zonas rurales e indígenas.\r\n"
								+ //
								"Gobernanza débil: La falta de una gestión integral y colaborativa del agua, sumada a la poca claridad en los derechos de uso, exacerba los problemas anteriores.\r\n"
								+ //
								"Consecuencias:\r\n" + //
								"\r\n" + //
								"Conflictos sociales y económicos: La escasez y mala calidad del agua pueden generar tensiones entre comunidades y sectores económicos que dependen de este recurso.\r\n"
								+ //
								"Impacto en la salud: El agua contaminada provoca enfermedades y limita el desarrollo humano.\r\n"
								+ //
								"Vulnerabilidad ante el cambio climático: Las sequías e inundaciones más frecuentes agravan la situación hídrica.\r\n"
								+ //
								"Medidas urgentes:\r\n" + //
								"\r\n" + //
								"Gestión cooperativa: Se requiere una participación conjunta de autoridades, comunidades y usuarios para administrar el agua de manera sostenible.\r\n"
								+ //
								"Políticas integradas: Es necesario vincular las políticas hídricas con las de cambio climático, desarrollo urbano y económico.\r\n"
								+ //
								"Inversión: Aumentar la inversión en infraestructura y saneamiento para garantizar el acceso universal a agua potable y saneamiento.\r\n"
								+ //
								"Certeza jurídica: Clarificar los derechos y responsabilidades sobre el agua para evitar conflictos y promover su uso eficiente.\r\n"
								+ //
								"En resumen, la seguridad hídrica en México es un reto crítico que requiere acciones inmediatas y concertadas para garantizar el derecho humano al agua, impulsar el desarrollo sostenible y prevenir conflictos sociales.\n");
			} else if (sele == 2) {

				System.out.println(
						"El artículo aborda el tema del estrés hídrico en México, destacando los desafíos, estrategias y tendencias futuras para hacer frente a esta problemática. Se menciona que solo el 1% del agua en el planeta está disponible para consumo humano y que América Latina es la región con la mayor cantidad de agua dulce por persona, pero también enfrenta limitaciones debido a su consumo. El estrés hídrico se relaciona principalmente con las condiciones climáticas y las actividades humanas, como el crecimiento de la población y la extracción excesiva del agua. Se mencionan casos específicos de estrés hídrico en diferentes regiones de México, como la Ciudad de México y el norte del país. También se discuten estrategias para enfrentar esta problemática, como la captación de agua de lluvia, la mejora de la infraestructura, la implementación de normativas y el uso de nuevas tecnologías para el tratamiento del agua. Se concluye que el estrés hídrico es un desafío importante que requiere una mejor gobernanza y administración del agua.");

				System.out.println(
						"\nEl artículo \"El Estrés Hídrico en México: Retos, Estrategias y Tendencias Futuras de Cómo Enfrentar el Día Cero\" publicado en la revista científica Diotima aborda la problemática del estrés hídrico a nivel mundial y específicamente en México. Los autores, encabezados por Cristina Morales Figueroa, examinan la alta presión hídrica global, derivada de factores sociales, económicos y ambientales, y se enfocan en la situación de países que enfrentan escasez extrema de agua, conocida como \"Día Cero\".\r\n"
								+ //
								"\r\n" + //
								"Destacan la combinación de deficiente infraestructura hidráulica, mala gobernanza y sequías extremas como desencadenantes del estrés hídrico. Los resultados muestran el alto costo de garantizar acceso seguro al agua. El artículo realiza una revisión de literatura sobre los desafíos actuales, estrategias y tendencias futuras para enfrentar el colapso de los recursos hídricos.\r\n"
								+ //
								"\r\n" + //
								"Se subraya la importancia del acceso seguro al agua como derecho humano y fuente de vida, y se señala que solo el 1% del agua del planeta está disponible para consumo humano. América Latina, aunque cuenta con la mayor cantidad de agua dulce por persona, enfrenta limitaciones debido a un alto consumo.\r\n"
								+ //
								"\r\n" + //
								"El documento destaca la situación crítica en México, donde el estrés hídrico se relaciona con la sobreexplotación de acuíferos, malas prácticas de tratamiento de aguas residuales y factores climáticos. Se presenta un análisis detallado de la distribución inequitativa del agua, la sobreexplotación de acuíferos y la contaminación, así como los impactos sociales y económicos, como migración y aumento en los precios de alimentos.\r\n"
								+ //
								"\r\n" + //
								"En cuanto a las estrategias, se sugiere la captación de agua de lluvia, el mejoramiento de la infraestructura y la implementación de normativas para controlar desechos peligrosos. Además, se aboga por la responsabilidad ambiental a nivel administrativo, empresarial y civil, así como por el desarrollo de tecnologías y plantas de tratamiento de aguas residuales.\r\n"
								+ //
								"\r\n" + //
								"El artículo concluye señalando la necesidad de nuevas reformas políticas y tecnológicas para abordar la sobreexplotación de recursos hídricos, mejorar la distribución del agua y mitigar los efectos del cambio climático. También destaca la importancia de la concientización y participación de la población en la conservación del agua.\n");
			} else if (sele == 3) {

				System.out.println(
						"La escasez de agua es un problema global que afecta a todos los continentes. Cerca de 1.200 millones de personas viven en áreas con escasez física de agua y otros 1.600 millones se enfrentan a escasez económica de agua. La escasez de agua es causada por el uso y consumo insostenible, la distribución desigual y la contaminación del agua. Este problema afecta a varios Objetivos de Desarrollo del Milenio de las Naciones Unidas, como la educación, la igualdad de género, la salud y el medio ambiente. La escasez de agua también se relaciona con la desertificación y el cambio climático. En el futuro, se espera que más personas vivan en áreas con escasez absoluta de agua y estrés hídrico.");

				System.out.println(
						"\nLa escasez de agua es un problema global que afecta a todos los continentes, impactando a alrededor de 1.200 millones de personas que viven en áreas con falta física de agua y 500 millones más que se acercan a esta situación. Además, 1.600 millones, aproximadamente un cuarto de la población mundial, enfrentan escasez económica de agua debido a la falta de infraestructura para su transporte desde fuentes como ríos y acuíferos.\r\n"
								+ //
								"\r\n" + //
								"Este fenómeno, uno de los principales desafíos del siglo XXI, es resultado tanto de factores naturales como de la actividad humana. Aunque hay suficiente agua potable en el planeta para abastecer a toda la población, la distribución desigual, el desperdicio, la contaminación y una gestión insostenible contribuyen a la escasez.\r\n"
								+ //
								"\r\n" + //
								"La gestión de la escasez de agua es crucial para alcanzar los Objetivos de Desarrollo del Milenio (ODM), ya que afecta directamente a aspectos como la pobreza, la seguridad alimentaria, la educación, las cuestiones de género, la salud y el medio ambiente. El estrés hídrico se mide en términos de la relación agua/población, y diversas zonas experimentan situaciones de escasez absoluta cuando el suministro anual cae por debajo de ciertos umbrales, como los 1.000 m3 por persona.\r\n"
								+ //
								"\r\n" + //
								"El informe destaca que la escasez de agua es un concepto relativo y puede ser tanto una construcción social como una consecuencia de cambios climáticos. Además, ofrece datos alarmantes sobre el futuro, proyectando que en 2025, 1.800 millones de personas podrían vivir en áreas con escasez absoluta de agua, y en 2030, casi la mitad de la población mundial podría enfrentar estrés hídrico, afectando especialmente a África Subsahariana.\r\n"
								+ //
								"\r\n" + //
								"Finalmente, se mencionan iniciativas de la ONU, como el Día Mundial del Agua, que buscan crear conciencia y promover la cooperación global para abordar la gestión sostenible del agua y combatir la escasez.\n");
			} else if (sele == 4) {
				System.out.println(
						"Puntuación sectorial del riesgo de Estrés hídrico inicial de los estados de la republica mexicana, de la forma siguiente \n1. Riesgo bajo \n2. Riesgo Medio bajo \n3. Riesgo Medio alto \n4. Riesgo Alto \n5. Riesgo extremadamente alto");

				seleccion = in.nextInt();
				System.out.println();
				if (seleccion == 1) {

					country(0, 1);
				} else if (seleccion == 2) {

					country(1, 2);
				} else if (seleccion == 3) {

					country(2, 3);
				} else if (seleccion == 4) {

					country(3, 4);
				} else if (seleccion == 5) {

					country(4, 5);
				} else {
					System.out.println("Coloca un valor valido");
				}
			}
			System.out.println("Quieres repetir?");
			repetir = R.nextLine();
		}
		System.out.println("La cantidad de consultas fueron: " + cons);
	}

	public static void country(int min, int max) {
		int cont = 0;

		for (int i = 1; i < widgetsTotal.length; i++) {

			if (widgetsTotal[i] >= min && widgetsTotal[i] <= max) {

				System.out.println(widgetsName[i] + ": " + widgetsTotal[i]);

				System.out.print("Agricola: " + widgetChartText[i * 3 - 3] + "\n");
				System.out.print("Doméstico: " + widgetChartText[i * 3 - 2] + "\n");
				System.out.print("Industrial: " + widgetChartText[i * 3 - 1] + "\n\n");
				cont++;

			}

		}
		System.out.println("La cantidad de estados en esta categoría son: " + cont);
	}
}
