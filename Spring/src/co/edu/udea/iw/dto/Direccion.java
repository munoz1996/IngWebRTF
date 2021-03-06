package co.edu.udea.iw.dto;

public class Direccion {
	
	private DireccionId direccionid;
	private String direccion;
	private String telefono;
	private Ciudad ciudad;
	private Boolean preferida;
	
	public DireccionId getDireccionid() {
		return direccionid;
	}
	public void setDireccionid(DireccionId direccionid) {
		this.direccionid = direccionid;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Ciudad getCiudad() {
		return ciudad;
	}
	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}
	public Boolean getPreferida() {
		return preferida;
	}
	public void setPreferida(Boolean preferida) {
		this.preferida = preferida;
	}
	
	
}
