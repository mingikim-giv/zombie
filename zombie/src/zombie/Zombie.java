package zombie;

public class Zombie extends Unit {
	private int power;	// 파워
	
	public Zombie(int position, int hp, int maxPower) {
		super(position, hp, maxPower);
	}

	@Override
	public void attack(Unit hero) {
		power = ran.nextInt(maxPower);
		
		hero.setHp(hero.getHp() - power);
		if(hero.getHp() <= 0) {
			hero.setHp(0);
		}
		
		System.out.printf("좀비가 %d의 파워로 공격\n", power);
		System.out.printf("영웅[HP: %d]\n", hero.getHp());
	}
	
}
