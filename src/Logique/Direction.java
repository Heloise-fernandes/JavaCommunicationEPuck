package Logique;

public enum Direction {

	AVANCER("avancer"),
	RECULER("reculer"),
	TOURNER_D("tournerADroite"),
	TOURNER_G("tournerAGauche"),
	ARRET("arret");
	
	private final String direction;
	
	private Direction(String direction)
	{
		this.direction=direction;
	}
	
	@Override
	public String toString()
	{
		return direction;
	}	
}
