package zombie;

public class Boss extends Unit {
	private int protective;	// 보호막
	
	public Boss(int position, int hp, int maxHp) {
		super(position, hp, maxHp);
	}
	
	public int getProtective() {
		return this.protective;
	}
	
	public void setProtective(int protective) {
		this.protective = protective;
	}
	
	@Override
	public void attack(Unit hero) {
		
	}
	
	
}
