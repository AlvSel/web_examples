package helper.info;

public class MessageInfo {
	private String username;
	private String licencia;
	private String fechaTiempo;
	
	public MessageInfo(String pUsername, String pLicencia, String pFechaTiempo) {
		this.username = pUsername;
		this.licencia = pLicencia;
		this.fechaTiempo = pFechaTiempo;
	}
	
	public String getUsername() {
		return this.username;
	}	
	
	public String getLicencia() {
		return this.licencia;
	}	

	public String getFechaTiempo(){
		return this.fechaTiempo;
	}
}