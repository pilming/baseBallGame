package baseBallGame.dao;

import java.util.Scanner;

public class baseBallGameDao {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("자릿수를 입력하세요");
		//웹에서는 드롭박스로 설정, 유효성검사 하지않기위해
		int positionalNum = sc.nextInt();
		
		//사용자가 정한 자릿수만큼 컴퓨터용 숫자 생성
		int[] comNum = new int[positionalNum];
		
		int index = 0;
		while(index < positionalNum) {
			//랜덤숫자 생성
			int tempNum = (int)((Math.random() * 10));
			
			//System.out.println("tempNum:" + tempNum);
			comNum[index] = tempNum;
			
			//중복된숫자가 있는지 확인하는 플래그
			boolean dupilcate = false;
			
			//중복된 숫자가 있다면 인덱스를 증가시키지않고 재반복
			for(int i =0; i < index; i+=1) {
				if(comNum[i] == tempNum) {
					dupilcate = true;
					break;
				}
			}
			
			if(!dupilcate) {
				
				index += 1;
			}
			
		}
		//컴퓨터 숫자 출력 게임 만들시엔 숨김
		System.out.print("컴퓨터 숫자 :");
		for(int i =0; i < positionalNum; i+=1) {
			System.out.print(comNum[i]);
		}
		System.out.println("");
		
		
		
		
		boolean clear = false;
		
		//숫자를 맞출때까지 반복
		while(!clear) {
			//웹에서는 인풋박스 길이 제한으로 길이고정시킨후 자릿수가 적진않은지, 숫자가 맞는지 체크
			System.out.println("숫자를 입력하세요");
			String myNum =  sc.next();
			
			String[] myNumArray = myNum.split("");
			/*
			for(int i =0; i < myNumArray.length; i+=1) {
				System.out.println(myNumArray[i]);
			}
			*/
			
			
			int ballCount = 0;
			int strikeCount = 0;
			int outCount = 0;
			
			for(int i =0; i < positionalNum; i+=1) {
				
				for(int j =0; j < positionalNum; j+=1) {
					if(i == j) {
						if(comNum[i] == Integer.parseInt(myNumArray[j]) ) {
							//컴퓨터 숫자와 위치도같고 숫자도 같다면 스트라이크
							strikeCount += 1;
						}
					}
				}
				
				for(int j =0; j < positionalNum; j+=1) {
					if(i == j) {
						continue;
					} else {
						if(comNum[i] == Integer.parseInt(myNumArray[j]) ) {
							//숫자만 같고 자리가 다르다면 볼
							ballCount += 1;
						}
					}
				}
			}
			if(strikeCount == positionalNum) {
				clear = true;
				System.out.println("정답!");
			} else {
				//볼카운트와 스트라이크를 뺀 나머지가 아웃카운트
				outCount = positionalNum - (ballCount + strikeCount);
				System.out.printf("Ball : %d Strike : %d Out : %d \n", ballCount, strikeCount, outCount);
			}
		}
	}
}
