package zombie;

public class Boss extends MiddleBoss {
	private int armor;	// 보호막
	private int skill;	// 스킬
	
	public Boss(int position, int hp, int maxPower, int armor, int skill) {
		super(position, hp, maxPower, skill);
		this.armor = armor;
		this.skill = skill;
	}
	
	public int getArmor() {
		return this.armor;
	}
	
	public void setArmor(int value) {
		this.armor = value;
	}
	
	@Override
	public void attack(Unit hero) {
		int intensive = ran.nextInt(5);
		
		if(intensive == 1) {
			System.out.println("보스 필살기 발동!");
			int power = (ran.nextInt(maxPower)+1) * 2;
			int damage = hero.getHp() - power;
			hero.setHp(damage);
			
			if(hero.getHp() <= 0) {
				hero.setHp(0);
			}
			
			System.out.printf("보스가 %d의 파워로 공격!\n", power);
			System.out.printf("HERO[HP: %d]\n", hero.getHp());
		}
		else if(intensive == 2) {
			System.out.println("보스 스킬 발동!");
			int power = skill;
			int damage = hero.getHp() - power;
			hero.setHp(damage);
			
			if(hero.getHp() <= 0) {
				hero.setHp(0);
			}
			
			System.out.printf("보스가 %d의 파워로 공격!\n", power);
			System.out.printf("HERO[HP: %d]\n", hero.getHp());
		}
		else {
			System.out.println("보스 기본 공격!");
			int power = ran.nextInt(maxPower)+1;
			int damage = hero.getHp() - power;
			hero.setHp(damage);
			
			if(hero.getHp() <= 0) {
				hero.setHp(0);
			}
			
			System.out.printf("보스가 %d의 파워로 공격!\n", power);
			System.out.printf("HERO[HP: %d]\n", hero.getHp());
		}
	}
	
}
