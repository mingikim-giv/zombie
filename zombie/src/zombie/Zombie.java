package zombie;

public class Zombie extends Unit {
	private int power;	// 파워
	
	public Zombie(int position, int hp, int maxHp) {
		super(position, hp, maxHp);
	}

	@Override
	public void attack(Unit hero) {
		power = ran.nextInt(maxHp);
	}
	
}
