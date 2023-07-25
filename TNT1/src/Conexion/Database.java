package Conexion;

public class Database {

    private String nombreBD;
    private String  usuarioBD;
    private String  contraseñaBd;
    
	public String getNombreBD() {
            System.out.println(nombreBD);
		return nombreBD;
	}
	public void setNombreBD(String nombreBD) {
		this.nombreBD = nombreBD;
	}
	public String getUsuarioBD() {
            System.out.println(usuarioBD);
		return usuarioBD;
	}
	public void setUsuarioBD(String usuarioBD) {
		this.usuarioBD = usuarioBD;
	}
	public String getContraseñaBd() {
            System.out.println(contraseñaBd);
		return contraseñaBd;
	}
	public void setContraseñaBd(String contraseñaBd) {
		this.contraseñaBd = contraseñaBd;
	}

    
}