package es.uco.mdas.tests;

import java.util.Random;

import es.uco.mdas.business.instalaciondeportiva.DetallesLocalidad;
import es.uco.mdas.datos.LocalidadDAO;
import es.uco.mdas.datos.LocalidadDAOImpFicheros;

public class TestLocalidades {

	public static void main(String[] args) {
		
		LocalidadDAO localidadDAO = new LocalidadDAOImpFicheros();
		Random generador = new Random();
		
		for (int i = 0; i < 10; i++) {
			String idLocalidad = "" + generador.nextInt(1000);
			DetallesLocalidad localidad = new DetallesLocalidad(idLocalidad, 1, 1, 1, "idInstalacion", "");
			System.out.println(localidad.toString());
			localidadDAO.insert(localidad);
		}
		
	}
	
}
