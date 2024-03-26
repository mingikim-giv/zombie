package zombie;

import java.util.Random;

abstract public class Unit {
	Random ran;
	private final int SIZE = 20;// 맵 사이즈
	
	private int hp;				// 체력
	private int position;		// 위치
	private int maxHp;			// 최대 체력
	
	public Unit(int position, int hp, int maxHp) {
		this.position = position;
		this.hp = hp;
		this.maxHp = maxHp;
		ran = new Random();
	}
	
	public int getPosition() {
		return this.position;
	}
	public int getHp() {
		return this.hp;
	}
	public int getMaxHp() {
		return this.maxHp;
	}
	
	public void setPosition(int position) {
		this.position = position;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public void move() {
		if(position <= SIZE) {
			System.out.printf("[현재 위치]: %d\n", position);
		}
	}
	abstract void attack(Unit unit);
}
