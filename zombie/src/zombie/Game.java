package zombie;

import java.util.Scanner;

public class Game {
	private Scanner scan = new Scanner(System.in);
	
	private final int MOVE = 1;
	private final int END = 2;
	
	private final int HERO = 1;
	private final int ZOMBIE = 5;
	private final int BOSS = 15;
	private final int FINISH = 20;
	
	private final int ATTACK = 1;
	private final int HILL = 2;
	
	private Hero hero;
	private Boss boss;
	private Zombie zombie;
	
	private int position;	// 위치
	
	private Game() {
		hero = new Hero(HERO, 200, 40, 5);
		zombie = new Zombie(ZOMBIE, 100, 10);
		boss = new Boss(BOSS, 300, 50, 100);
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
