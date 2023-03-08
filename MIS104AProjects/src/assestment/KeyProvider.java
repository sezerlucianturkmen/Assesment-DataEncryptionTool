package assestment;

public class KeyProvider {

	/**
	 * This method provides 5 digits key int array from StudentID given by user
	 * 
	 * @param studentID
	 * @return
	 */
	public static int[] getKey(String studentID) {
		char[] charList = studentID.toCharArray();
		int[] key = new int[5];
		int index = studentID.length() - 1;
		for (int i = 4; i >= 0; i--) {
			key[i] = Character.getNumericValue(charList[index]);
			index--;
		}
		return key;
	}
}
