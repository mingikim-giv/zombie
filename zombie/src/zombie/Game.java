package zombie;

import java.util.Scanner;

public class Game {
	private Scanner scan = new Scanner(System.in);
	
	private final int MOVE = 1;
	private final int END = 2;
	
	private final int HERO = 1;
	private final int ZOMBIE = 5;
	private final int MIDDLE_BOSS = 12;
	private final int BOSS = 18;
	private final int FINISH = 20;
	
	private final int ATTACK = 1;
	private final int HILL = 2;
	
	private Hero hero;
	private Zombie zombie;
	private MiddleBoss middleBoss;
	private Boss boss;
	
	private int position;	// 위치
	
	private Game() {
		hero = new Hero(HERO, 400, 40, 10);						// 위치/체력/공격력/포션개수
		zombie = new Zombie(ZOMBIE, 100, 10);					// 위치/체력/공격력
		middleBoss = new MiddleBoss(MIDDLE_BOSS, 300, 30, 100); // 위치/체력/공격력/스킬발동
		boss = new Boss(BOSS, 500, 50, 100, 100);				// 위치/체력/공격력/아머/스킬발동
		position = 1;
	}
	
	private static Game instance = new Game();
	public static Game getInstance() {
		return instance;
	}
	
	// print
	private void print() {
		System.out.printf("[STAGE %d]\n", position);
		System.out.println("이동하기[1]/종료하기[2]");
	}
	
	// runMenu
	private void runMenu(int sel) {
		if(sel == MOVE) {
			position ++;
			hero.setPosition(position);
			move();
		}
		else if(sel == END) {
			
		}
	}
	
	// move
	private void move() {
		if(hero.getPosition() == ZOMBIE) {
			System.out.println("좀비 등장! 싸워보자!!");
			while(true) {
				System.out.println("공격하기[1]/물약사용[2]");
				zombieSection(inputNumber("메뉴 선택"));
				
				if(hero.getHp() <= 0) {
					System.err.println("HERO DIE.. STAGE FAIL");
					break;
				}
				
				if(zombie.getHp() <= 0) {
					System.out.println("ZOMBIE DIE.. STAGE CLEAR");
					break;
				}
			}
		}
		
		if(hero.getPosition() == MIDDLE_BOSS) {
			System.out.println("중간 보스 등장! 싸워보자!!");
			while(true) {
				System.out.println("공격하기[1]/물약사용[2]");
				middleBossSection(inputNumber("메뉴 선택"));
				
				if(hero.getHp() <= 0) {
					System.err.println("HERO DIE.. STAGE FAIL");
					break;
				}
				
				if(middleBoss.getHp() <= 0) {
					System.out.println("MIDDLE_BOSS DIE.. STAGE CLEAR");
					break;
				}
			}
		}
		
		if(hero.getPosition() == BOSS) {
			System.out.println("보스 등장! 싸워보자!!");
			while(true) {
				System.out.println("공격하기[1]/물약사용[2]");
				bossSection(inputNumber("메뉴 선택"));
				
				if(hero.getHp() <= 0) {
					System.err.println("HERO DIE.. STAGE FAIL");
					break;
				}
				
				if(boss.getHp() <= 0) {
					System.out.println("BOSS DIE.. STAGE CLEAR");
					break;
				}
			}
		}
		
		if(hero.getPosition() == FINISH) {
			System.out.println("GAME CLEAR!!");
		}
	}
	
	// zombieSection
	private void zombieSection(int sel) {
		if(sel == ATTACK) {
			zombie.attack(hero);
			
			hero.attack(zombie);
		}
		else if(sel == HILL) {
			hero.recovery();
		}
	}
	
	// middleBossSection
	private void middleBossSection(int sel) {
		if(sel == ATTACK) {
			middleBoss.attack(hero);
			
			hero.attack(middleBoss);
		}
		else if(sel == HILL) {
			hero.recovery();
		}
	}
	
	// bossSection
	private void bossSection(int sel) {
		if(sel == ATTACK) {
			boss.attack(hero);
			
			hero.attack(boss);
		}
		else if(sel == HILL) {
			hero.recovery();
		}
	}
	
	// isEnd
	private boolean isEnd() {
		return hero.getPosition() < FINISH; 
	}
	
	// inputNumber
	private int inputNumber(String message) {
		int number = -1;
		
		try {
			System.out.println(message + ":");
			String input = scan.next();
			number = Integer.parseInt(input);
		} catch (Exception e) {
			System.err.println("숫자를 입력하세요.");
		}
		
		return number;
	}
	
	public void run() {
		while(isEnd()) {
			print();
			runMenu(inputNumber("메뉴 선택"));
		}
	}
}
