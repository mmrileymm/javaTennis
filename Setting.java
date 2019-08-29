package tennis;

import java.util.Scanner;

public class Setting {

	private Scanner scanner = new Scanner(System.in);
	String gender =null;
	String gameOption = null;
	String tie = null;

	int gameSet = 0;



	public void control() {

		genderCheck();
		
		gameOptionCheck();
		
		tieCheck();

		gameSetCheck();
		
		System.out.printf("> 게임설정 \n %s %s \n 타이브레이크 : %s\n",gender, gameOption, tie);
		System.out.printf(" 총 셋트수 : %d\n", gameSet);
		System.out.println();
	}

	private void gameSetCheck() {
		if (gender == "Male") {
			gameSet = 5;
		} else {
			gameSet = 3;
		}
	}

	private void tieCheck() {
		String regexTie = "^적용$|^미적용$";
		System.out.print("> 타이 브레이크 적용여부(적용 or 미적용) : ");
		while (true) {
			tie = scanner.nextLine();
			if(tie.matches(regexTie)) {
				tie = tie.equals("적용")? "Yes" : "No";
				break;
			}
			System.out.print("다시 입력하세요 (적용 or 미적용) : ");
		}

	}

	private void gameOptionCheck() {
		String regexSD = "^단식$|^복식$";
		System.out.print("> 단식 or 복식 선택 : ");
		while (true) {
			gameOption = scanner.nextLine();
			if(gameOption.matches(regexSD)) {
				gameOption = gameOption.equals("단식") ? "Single" : "Doubles";
				break;
			}
			System.out.print("다시 입력하세요 (단식 or 복식) : ");
		}

	}

	private void genderCheck() {
		String regexGender = "^남자$|^여자$";
		System.out.print("> 남자 or 여자 선택 : ");
		while (true) {
			gender = scanner.nextLine();
			if(gender.matches(regexGender)) {
				gender = gender.equals("남자") ? "Male" : "Female";
				break;
			}
			System.out.print("다시 입력하세요 (남자 or 여자) : ");
		}
	}

	public boolean getGameOption() {
		if (gameOption == "Single") {
			return true;
		} else {
			return false;
		}
	}

	public boolean getGenderOption() {
		if (gender == "Male") {
			return true;
		} else {
			return false;
		}
	}
	public boolean getTieOption() {
		if (tie == "Yes") {
			return true;
		} else {
			return false;
		}
	}

}