package modelo;

public class Productos {
	private String nArticulo;
	private String seccion;
	private String precio;
	private String pOrigen;
	private int codigo;

	public Productos() {

		nArticulo = "";
		seccion = "";
		precio = "";
		pOrigen = "";
		codigo=0;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getnArticulo() {
		return nArticulo;
	}

	public void setnArticulo(String nArticulo) {
		this.nArticulo = nArticulo;
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getpOrigen() {
		return pOrigen;
	}

	public void setpOrigen(String pOrigen) {
		this.pOrigen = pOrigen;
	}

}