package AdaProyecto;

public class DatosPeru {
	public String regionString;
	public int Positivos;
	public DatosPeru() {
	}
	public DatosPeru(String region, int Posi) {
		this.regionString=region;
		this.Positivos=Posi;
	}
	@Override
	public String toString() {
		return "ciudad: " + regionString + " Positivos= " + Positivos ;
	}
	public String getRegionString() {
		return regionString;
	}
	public void setRegionString(String regionString) {
		this.regionString = regionString;
	}
	public int getPositivos() {
		return Positivos;
	}
	public void setPositivos(int positivos) {
		Positivos = positivos;
	}
	

}
