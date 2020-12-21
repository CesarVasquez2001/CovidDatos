package AdaProyecto;

public class DatosMundo {
	String Region,pais;
	int contagios;
	public DatosMundo(String reg, String pai, int contagi) {
		this.Region=reg;
		this.pais=pai;
		this.contagios=contagi;
	}
	public DatosMundo() {}
	public String getRegion() {
		return Region;
	}
	public void setRegion(String region) {
		Region = region;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public int getContagios() {
		return contagios;
	}
	public void setContagios(int contagios) {
		this.contagios = contagios;
	}
	@Override
	public String toString() {
		return "Region=" + Region + ", pais=" + pais + ", contagios=" + contagios;
	}
	
	

}
