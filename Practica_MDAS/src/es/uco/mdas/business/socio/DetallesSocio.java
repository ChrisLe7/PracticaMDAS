package es.uco.mdas.business.socio;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class DetallesSocio  extends DetallesCliente implements Serializable{

	private static final long serialVersionUID = 1L;	
	private String idSocio;
	private Date antiguedad;
	private Categoria categoria;
	
	/**
	 * Constructor completo de un Socio
	 * @param idSocio Id del socio
	 * @param nombreSocio Nombre del socio
	 * @param ApellidosSocio Apellidos del socio
	 * @param direccion Direccion del socio
	 * @param telefonoContacto Telefono del socio
	 * @param edad Edad del socio
	 * @param antiguedad Antiguedad del socio
	 * @param categoria Categoria del socio
	 */
	public DetallesSocio(String idSocio, String nombreSocio, String apellidosSocio, String direccion,
			String telefonoContacto, Date edad, Date antiguedad, Categoria categoria) {
		super(nombreSocio, apellidosSocio, direccion, telefonoContacto, edad);
		this.idSocio = idSocio;
		this.antiguedad = antiguedad;
		this.categoria = categoria;
	}
	
	/**
	 * Constructor por defecto de un Socio, solo obligar� al id del Socio
	 * @param idSocio Id del socio
	 */
	public DetallesSocio(String idSocio) {
		this(idSocio,"", "", "", "", null, null, Categoria.Adulto);
	}
	
	/**
	 * Contructor de socio a partir de la id y de datos de un cliente
	 * @param idSocio Id del socio
	 * @param cliente Datos del cliente
	 */
	public DetallesSocio (String idSocio, DetallesCliente cliente) {
		this(idSocio,cliente.getNombreSocio(), cliente.getApellidosSocio(), cliente.getDireccion(), cliente.getTelefonoContacto(), 
	        		cliente.getFechaNacimiento(), new Date(), Categoria.Adulto);
		 
		int aniosSocioOro = 65; // edad minima requerida para ser socio de oro
        int aniosSocioAdulto = 18; // edad minima requerida para ser socio adulto
        Categoria categoria;
        
        if (cliente.getEdad() >= aniosSocioOro) {
        	categoria = Categoria.Oro;
        }
        else { 
	        if (cliente.getEdad() >= aniosSocioAdulto) {
	        	categoria = Categoria.Adulto;
	        }	        
	        else {
	            categoria =  Categoria.Infantil;
	        }
        }
        
        this.categoria = categoria;
       
	}

	/**
	 * Devuelve el Identificador del Socio
	 * 	@return ID del Socio
	 */
	public String getIdSocio() {
		return idSocio;
	}
	
	/**
	 * Asigna una id al socio
	 * 
	 * @param idSocio Id a asignar al socio
	 */	
	public void setIdSocio(String idSocio) {
		this.idSocio = idSocio;
	}
	
	/**
	 * Devuelve la fecha de inicio de la creaci�n del Socio
	 * @return Fecha del Creacion del Socio
	 */
	public Date getFechaAntiguedad() {
		return antiguedad;
	}

	/**
	 * Asigna la fecha de inicio de la creaci�n del Socio
	 * @param antiguedad Fecha de la Creacion del Socio
	 */
	public void setFechaAntiguedad(Date antiguedad) {
		this.antiguedad = antiguedad;
	}
	
	/**
	 * Devuelve el numero de a�os ha sido socio 
	 * @return Tiempo siendo socio
	 */
	public int getAntiguedad() {
		Period tiempo = Period.between(LocalDate.ofEpochDay(this.antiguedad.getTime()), LocalDate.now());
		return tiempo.getYears();
	}
	
	/**
	 * Devuelve la categoria del socio
	 * @return Categoria del cliente, la cual podr� ser de los tipos indicados en el Enum Categoria
	 */
	public Categoria getCategoria() {
		return categoria;
	}
	
	/**
	 * Asigna como categoria del cliente la categoria pasada.
	 * @param categoria Nueva categor�a asignada al cliente
	 */
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
