package automobile;

public class CapaciteDepasseeException extends Exception {
	
	private static final long serialVersionUID = -4379352179169816575L;
	private double carburant;

	public CapaciteDepasseeException(double carburant) {
		this.carburant = carburant;
	}

	@Override
	public String getMessage() {
		return "Votre reservoir a une capacite insuffisante pour mettre " + this.carburant + " d'essence";
	}

}
