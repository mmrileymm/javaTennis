package tennis;

import java.io.IOException;

public class MainGame {

	public static void main(String[] args) {
		printTitle();
		Setting setting = new Setting();
		setting.control();
		Player player = new Player(setting.getGameOption());
		player.PlayerName();
		
		if(setting.getTieOption()) {
			Tie t = new Tie(setting.gameSet, player);
			t.runGame();
			t.printResult();
		} else {
			Game g = new Game(setting.gameSet, player);
			g.runGame();
			g.printResult();
		}
		System.out.println("\n테니스 경기가 종료되었습니다. 엔터를 누르면 프로그램을 종료합니다.");
		try {
			System.in.read();
		} catch (IOException e) {
			
		}
	} // main

	public static void printTitle() {

		System.out.println("▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣");
		System.out.println("▣--------------------------------------------------------------------------------▣");
		System.out.println("▣----▣▣▣▣▣▣-▣▣▣▣▣-▣-------▣-▣-------▣-▣▣▣▣▣---▣▣▣▣▣-----▣");
		System.out.println("▣---------▣------▣---------▣-▣----▣-▣-▣----▣-----▣------▣--------------▣");
		System.out.println("▣---------▣------▣▣▣▣▣-▣---▣--▣-▣---▣--▣-----▣--------▣▣▣▣------▣");
		System.out.println("▣---------▣------▣---------▣-----▣▣-▣-----▣▣-----▣---------------▣-----▣");
		System.out.println("▣---------▣------▣▣▣▣▣-▣-------▣-▣-------▣-▣▣▣▣▣--▣▣▣▣▣------▣");
		System.out.println("▣--------------------------------------------------------------------------------▣");
		System.out.println("▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣");

		System.out.println();
		System.out.println("=======================시작하시려면 엔터를 눌러주세요 *^_^*=========================");
		try {
			System.in.read();
			System.in.skip(System.in.available());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			int time =100;
			Thread.sleep(time);
			System.out.println("S");
			Thread.sleep(time);
			System.out.println("　T");
			Thread.sleep(time);
			System.out.println("　　A");
			Thread.sleep(time);
			System.out.println("　　　R");
			Thread.sleep(time);
			System.out.println("　　　　T");
			Thread.sleep(time);
			System.out.println("　　　　　★");
			Thread.sleep(time);
			System.out.println("　　　　　　^.~ !!!");
			System.out.println();
			System.out.println();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
