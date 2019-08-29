package tennis;

import java.util.Scanner;

public class Player {

	String singlePlayer1, singlePlayer2;
	String doublesPlayerA1, doublesPlayerA2, doublesPlayerB1, doublesPlayerB2;
	private Scanner scanner = new Scanner(System.in);
	//boolean gameOption = true;
	boolean gameOption = false;

	public Player() {}
	//디폴트생성자- 아무것도 초기화하지않지만 기본임

	public Player( boolean gameOption) {
		this.gameOption = gameOption;
	}//위의 필드들을 초기화하기위해서 만드는것이 매개변수가 있는생성자


	public void PlayerName() {

		// System.out.print("이름을 입력하세요:");

		//true->단식,  fulse->복식
		if (gameOption) {
			System.out.print("선수 이름을 입력하세요(2명)\n");
			singlePlayer1 = scanner.next();
			singlePlayer2 = scanner.next();

			System.out.printf("선수 1 : %s, 선수 2 : %s\n", singlePlayer1, singlePlayer2);

		}else {
			System.out.println("선수 이름을 입력하세요(A팀 2명)");
			doublesPlayerA1 = scanner.next();
			doublesPlayerA2 = scanner.next();
			System.out.println("선수 이름을 입력하세요(B팀 2명)");
			doublesPlayerB1 = scanner.next();
			doublesPlayerB2 = scanner.next();

			System.out.printf("A팀 : %s, %s\nB팀 : %s, %s\n",
					doublesPlayerA1, doublesPlayerA2, doublesPlayerB1, doublesPlayerB2);
		}
		System.out.println();
		
	} // PlayerName


}
