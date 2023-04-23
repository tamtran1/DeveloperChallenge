package developerchallenge.utils;


/**
 * Description: This is the Decoder utility class. Its intent is to
 *  provides reusable codes as static member method for other classes
 *  to use. The caller does not need to instantiate class object to use
 *  the static methods within this class and this is intentional by design.
 */
public class Decoder {
  /**
   * Description: This method converts a string of bits into a string of ASCII
   *  characters.
   * 
   * @param dat - the buffer containg bit string
   * @return - the string containing the decoded ASCII characters
   */
  public static String binStr2Ascii(final StringBuilder dat) {
    if(0 == dat.length() || dat.length() % 8 != 0) {
      return "";
    }
    int ascii; // the ascii integer representation of the character
    StringBuilder buff = new StringBuilder();
    for(int i = 0; i < dat.length(); i += 8) {
      ascii = Integer.parseInt(dat.substring(i, i + 8), 2); // fetch 8 bits from data and convert it into ascii integer
      buff.append((char)ascii); // turn ascii value into a char and append it to the buffer
    }
    return buff.toString();
  }
}