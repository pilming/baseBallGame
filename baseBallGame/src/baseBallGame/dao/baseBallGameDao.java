package baseBallGame.dao;

import java.util.Scanner;

public class baseBallGameDao {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("자릿수를 입력하세요");
		//웹에서는 드롭박스로 설정, 유효성검사 하지않기위해
		int positionalNum = sc.nextInt();
		
		int[] comNum = new int[positionalNum];
		
		int index = 0;
		while(index < positionalNum) {
			int tempNum = (int)((Math.random() * 10));
			
			//System.out.println("tempNum:" + tempNum);
			comNum[index] = tempNum;
			
			boolean dupilcate = false;
			
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
		System.out.print("컴퓨터 숫자 :");
		for(int i =0; i < positionalNum; i+=1) {
			System.out.print(comNum[i]);
		}
		System.out.println("");
		
		
		
		
		boolean clear = false;
		
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
							strikeCount += 1;
						}
					}
				}
				
				for(int j =0; j < positionalNum; j+=1) {
					if(i == j) {
						continue;
					} else {
						if(comNum[i] == Integer.parseInt(myNumArray[j]) ) {
							ballCount += 1;
						}
					}
				}
			}
			if(strikeCount == positionalNum) {
				clear = true;
				System.out.println("정답!");
			} else {
				outCount = positionalNum - (ballCount + strikeCount);
				System.out.printf("Ball : %d Strike : %d Out : %d \n", ballCount, strikeCount, outCount);
			}
		}
	}
}
