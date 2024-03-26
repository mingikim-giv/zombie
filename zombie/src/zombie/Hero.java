package zombie;

public class Hero extends Unit {
	private int power;	// 파워
	
	
	public Hero(int position, int hp, int maxHp) {
		super(position, hp, maxHp);
	}

	@Override
	public void attack(Unit enemy) {
		
		if(enemy instanceof Boss) {
			Boss boss = (Boss) enemy;
			power = ran.nextInt(maxHp);
			int bossP = boss.getArmor() - power;
			int bossH = boss.getHp() - power;
			
			if(boss.getArmor() > 0) {
				if(bossP >= 0) {
					boss.setArmor(bossP);
				}
				else {
					boss.setArmor(0);
					boss.setHp(boss.getHp() - bossP);
				}
			}
			else {
				boss.setHp(bossH);
			}
			
			if(boss.getHp() <= 0) {
				boss.setHp(0);
			}
			System.out.printf("영웅이 %d의 파워로 공격\n", power);
			System.out.printf("BOSS[HP: %d/ARMOR: %d]\n", boss.getHp(), boss.getArmor());
		}
		else {
			power = ran.nextInt(maxHp);
			enemy.setHp(enemy.getHp() - power);
			
			if(enemy.getHp() <= 0) {
				enemy.setHp(0);
			}
			System.out.printf("영웅이 %d의 파워로 공격\n", power);
			System.out.printf("ZOMBIE[HP: %d]\n", enemy.getHp());
		}
	}

}
