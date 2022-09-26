public class Main{
	public static void main(String[] args){
		String inputString = getMessage();
		System.out.println(analyseMessage(inputString));
	}

	public static String getMessage(){
		while(true){
			System.out.print("Enter your message with length 7:");
			java.util.Scanner scanner = new java.util.Scanner(System.in);
			String inputString = scanner.nextLine();
			char[] charString = inputString.toCharArray();
			int count = 0;
			for(int i = 0; i<charString.length; i++){
				if(charString[i] == '1' | charString[i] == '0'){
					count ++;
				}
			}
			if(count == charString.length & count == 7){
				return inputString;
			}
			else if(count == charString.length & count > 7){
				System.out.println("The message is too long");
			}
			else if(count == charString.length & count < 7){
				System.out.println("The message is too short");
			}
			else{
				System.out.println("The message is incorrect, please, use 0 and 1");
			}
		}
	}

	public static String analyseMessage(String stringMessage){
		char[] charMessage = stringMessage.toCharArray();
		int s1 = (charMessage[0]=='1')^(charMessage[2]=='1')^(charMessage[4]=='1')^(charMessage[6]=='1') ? 1 : 0;
		int s2 = (charMessage[1]=='1')^(charMessage[2]=='1')^(charMessage[5]=='1')^(charMessage[6]=='1') ? 1 : 0;
		int s3 = (charMessage[3]=='1')^(charMessage[4]=='1')^(charMessage[5]=='1')^(charMessage[6]=='1') ? 1 : 0;
		String s = "" + s1 + s2 + s3;

		int problemNumber;
		switch(s){
			case "001": 
				problemNumber = 4;
				break;
			
			case "010": 
				problemNumber = 2;
				break;

			case "011": 
				problemNumber = 6;
				break;

			case "100": 
				problemNumber = 1;
				break;

			case "101": 
				problemNumber = 5;
				break;

			case "110": 
				problemNumber = 3;
				break;

			case "111": 
				problemNumber = 7;
				break;
			default:
				return "" + charMessage[2] + charMessage[4] + charMessage[5] + charMessage[6] + " everything is ok";		
		}

		charMessage[problemNumber - 1] = charMessage[problemNumber - 1] == '1' ? '0' : '1';
		char[] outputChar = {charMessage[2], charMessage[4], charMessage[5], charMessage[6]};
		String outputMessage = new String(outputChar);
		String[] symbolsList = {"r1", "r2", "i1", "r3", "i2", "i3", "i4"};

		return outputMessage + " the wrong number is " + symbolsList[problemNumber - 1]; 		
 
	}
}