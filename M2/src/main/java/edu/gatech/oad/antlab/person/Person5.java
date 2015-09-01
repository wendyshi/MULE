package edu.gatech.oad.antlab.person;

/**
 *  A simple class for person 5
 *  returns their name and a
 *  modified string 
 *  
 *  @author Bob
 *  @version 1.1
 */
public class Person5 {
  /** Holds the persons real name */
  private String name;
  	/**
	 * The constructor, takes in the persons
	 * name
	 * @param pname the person's real name
	 */
  public Person5(String pname) {
    name = pname;
  }
  	/**
	 * This method should take the string
	 * input and return its characters rotated
	 * 2 positions.
	 * given "gtg123b" it should return
	 * "g123bgt".
	 * @param input the string to be modified
	 * @return the modified string
	 */
	private String calc(String input) {
		int len = input.length();
		String tag = "";
		for (int i = 0; i < 2; i++){
			for (int j = 0; j < len - 1; j++) {
				char a = tag.charAt(j);
				char b = tag.charAt(j + 1);
				b = a;
				a = b;
			}
		}
		return tag;
	}
	
	/**
	 * Return a string rep of this object
	 * that varies with an input string
	 *
	 * @param input the varying string
	 * @return the string representing the 
	 *         object
	 */
	public String toString(String input) {
	  return name + calc(input);
	}

}
