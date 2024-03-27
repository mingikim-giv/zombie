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
		int skillRan = ran.nextInt(3);
		
		if(skillRan == 1) {
			System.out.println("중간 보스 스킬 발동!");
			power = skill;
			int damage = hero.getHp() - power;
			hero.setHp(damage);
			
			if(hero.getHp() <= 0) {
				hero.setHp(0);
			}
			
			System.out.printf("중간 보스가 %d의 파워로 공격!\n", power);
			System.out.printf("HERO[HP: %d]\n", hero.getHp());
		}
		else {
			System.out.println("중간 보스 공격!");
			power = ran.nextInt(maxPower);
			int damage = hero.getHp() - power;
			hero.setHp(damage);
			
			if(hero.getHp() <= 0) {
				hero.setHp(0);
			}
			
			System.out.printf("중간 보스가 %d의 파워로 공격\n", power);
			System.out.printf("HERO[HP: %d]\n", hero.getHp());
		}
	}
}
