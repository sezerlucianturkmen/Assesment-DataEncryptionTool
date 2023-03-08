package assestment;
import java.util.Scanner;

public class ApplicationManager {

	private final Scanner scanner = new Scanner(System.in);
	private final Encoder encoder = new Encoder();
	private final Decoder decoder = new Decoder();
	private String studentID;
	private String plainText;
	private String chipperText;

	public void menu() {
		int input = 0;
		studentID = askKey();
		do {
			System.out.println("-----------MENU----------");
			System.out.println("0-Exit ");
			System.out.println("1-Encryption");
			System.out.println("2-Decryption");
			System.out.println("------make selection------");
			input = Integer.parseInt(scanner.nextLine());

			switch (input) {
			case 1:
				System.out.println("--------------------------");
				System.out.println("Please enter any content to encrypt");
				plainText = scanner.nextLine();
				encoder.doEncrytion(plainText, studentID);
				break;
			case 2:
				System.out.println("--------------------------");
				System.out.println("Please enter any content to decrypt");
				chipperText = scanner.nextLine();
				decoder.doDecrytion(chipperText, studentID);
				break;
			case 0:
				System.exit(0);
				break;

			}
		} while (true);
	}

	private String askKey() {
		System.out.println("--------------------------");
		System.out.println("Please enter your student ID");
		return scanner.nextLine();
	}

}
