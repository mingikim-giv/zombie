package zombie;

public class Boss extends Unit {
	private int armor;	// 보호막
	
	public Boss(int position, int hp, int maxHp) {
		super(position, hp, maxHp);
	}
	
	public int getProtective() {
		return this.armor;
	}
	
	public void setProtective(int value) {
		this.armor = value;
	}
	
	@Override
	public void attack(Unit hero) {
		
	}
	
	
}
