package zombie;

public class Hero extends Unit {
	private int power;		// 파워
	private int portion;	// 물약
	
	public Hero(int position, int hp, int maxPower, int portion) {
		super(position, hp, maxPower);
		this.portion = portion;
	}
	
	public void recovery() {
		if(portion > 0) {
			setHp(getHp() + 100);
			System.out.printf("물약 사용 [HP:%d]\n", getHp());
			portion --;
		}
		else if(portion == 0) {
			System.err.println("물약이 없습니다.");
		}
	}
	
	@Override
	public void attack(Unit enemy) {
		
		if(enemy instanceof Boss) {
			Boss boss = (Boss) enemy;
			power = ran.nextInt(maxPower);
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
		else if(enemy instanceof MiddleBoss) {
			power = ran.nextInt(maxPower);
			enemy.setHp(enemy.getHp() - power);
			
			if(enemy.getHp() <= 0) {
				enemy.setHp(0);
			}
			System.out.printf("영웅이 %d의 파워로 공격\n", power);
			System.out.printf("MiddleBoss[HP: %d]\n", enemy.getHp());
		}
		else if(enemy instanceof Zombie) {
			power = ran.nextInt(maxPower);
			enemy.setHp(enemy.getHp() - power);
			
			if(enemy.getHp() <= 0) {
				enemy.setHp(0);
			}
			System.out.printf("영웅이 %d의 파워로 공격\n", power);
			System.out.printf("ZOMBIE[HP: %d]\n", enemy.getHp());
		}
	}

}
