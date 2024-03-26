package zombie;

import java.util.Random;

abstract public class Unit {
	Random ran;
	private final int SIZE = 20;// 맵 사이즈
	
	private int hp;				// 체력
	private int position;		// 위치
	int maxPower;					// 최대 파워
	
	public Unit(int position, int hp, int maxPower) {
		this.position = position;
		this.hp = hp;
		this.maxPower = maxPower;
		ran = new Random();
	}
	
	public int getPosition() {
		return this.position;
	}
	public int getHp() {
		return this.hp;
	}
	public int getMaxHp() {
		return this.maxPower;
	}
	
	public void setPosition(int position) {
		this.position = position;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public void move() {
		if(position <= SIZE) {
			System.out.printf("[STAGE %d]\n", position);
		}
	}
	
	abstract void attack(Unit unit);
}
