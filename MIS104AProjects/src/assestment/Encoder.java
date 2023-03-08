package assestment;

import static assestment.KeyProvider.getKey;
import static utility.Table.getTable;

public class Encoder {

	public String doEncrytion(String plainText, String studentID) {
		char[] plainArray = getContext(plainText);
		int[] keys = getKey(studentID);
		char[] chipperArray = new char[plainArray.length];
		String chipperText;

		for (int i = 0; i < plainArray.length; i++) {
			int keyindex = i % 5;
			chipperArray[i] = encryptUnit(plainArray[i], keys[keyindex]);
		}
		chipperText = getFinalString(chipperArray);
		System.out.println("Encrypted content: " + chipperText);
		return chipperText;
	}

	/**
	 * This method asks a character and mapped according to key value and return the
	 * final character.
	 * 
	 * @param unit
	 * @param keyValue
	 * @return
	 */
	private Character encryptUnit(Character unit, int keyValue) {
		Character temp = unit;
		if (keyValue > 0) {
			for (int i = 0; i < keyValue; i++) {
				Character ch = getTable().get(temp);
				temp = ch;
			}
			System.out.println(unit + " is decoded " + keyValue + " times." + "Result : " + temp);
			return temp;

		} else {
			System.out.println("Key is 0, You have not looked at the map");
			return temp;
		}
	}

	/**
	 * This method provides a char array according to given String content
	 * 
	 * @param content
	 * @return
	 */
	private char[] getContext(String content) {
		return content.toCharArray();
	}

	/**
	 * This method provides String value from given char array
	 * 
	 * @param array
	 * @return
	 */
	private String getFinalString(char[] array) {
		StringBuilder sb = new StringBuilder();

		for (char chars : array)
			sb.append(chars);

		return sb.toString();
	}
}
