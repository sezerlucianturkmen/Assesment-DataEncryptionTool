package assestment;

import static assestment.KeyProvider.getKey;
import static utility.Table.getTable;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Decoder {

	public String doDecrytion(String chipperText, String studentID) {
		char[] chipperArray = getContext(chipperText);
		int[] keys = getKey(studentID);
		char[] plainArray = new char[chipperArray.length];
		String plainText;

		for (int i = 0; i < chipperArray.length; i++) {
			int keyindex = i % 5;
			plainArray[i] = decryptUnit(chipperArray[i], keys[keyindex]);
		}
		plainText = getFinalString(plainArray);
		System.out.println("Decrypted content: " + plainText);
		return plainText;
	}

	/**
	 * This method asks a character and mapped according to key value and return the
	 * final character.
	 * 
	 * @param unit
	 * @param keyValue
	 * @return
	 */
	private Character decryptUnit(Character unit, int keyValue) {
		Character temp = unit;
		if (keyValue > 0) {
			for (int i = 0; i < keyValue; i++) {
				Character ch = getKeysByValue(getTable(), temp);
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

	private char getKeysByValue(Map<Character, Character> map, char value) {
		return map.entrySet().stream().filter(entry -> Objects.equals(entry.getValue(), value)).map(Map.Entry::getKey)
				.collect(Collectors.toList()).get(0);
	}
}
