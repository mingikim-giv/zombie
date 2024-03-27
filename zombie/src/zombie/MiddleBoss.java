package zombie;

public class MiddleBoss extends Zombie {
	private int power;	// 파워
	private int skill;	// 스킬
	
	public MiddleBoss(int position, int hp, int maxPower, int skill) {
		super(position, hp, maxPower);
		this.skill = skill;
	}
	
	public int getSkill() {
		return this.skill;
	}
	
	public void setSkill(int skill) {
		this.skill = skill;
	}
	
	@Override
	public void attack(Unit hero) {
		power = ran.nextInt(maxPower);
		
		hero.setHp(hero.getHp() - power);
		if(hero.getHp() <= 0) {
			hero.setHp(0);
		}
		
		System.out.printf("중간 보스가 %d의 파워로 공격\n", power);
		System.out.printf("HERO[HP: %d]\n", hero.getHp());
	}
}
