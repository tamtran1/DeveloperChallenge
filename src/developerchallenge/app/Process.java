package developerchallenge.app;


import developerchallenge.utils.Decoder;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


/**
 * Description: Its a process class use for decoding bit stream into ASCII characters.
 *  This class make up the running process for the decoding operation. It contains
 *  the algorithm use for search and buffer manipulation on receiving bits, and also
 *  contains a entry point main driver mechanism needed to run the process.
 *  The decoded bit stream are printed to the output stream.
 */
public class Process {
  private final String processId;
  private final String PREAMBLE;
  private final int PREAMBLE_BIT_LENGTH;
  private final int DATA_SIZE;
  private boolean preambleFound;
  private StringBuilder buff;
  private BufferedReader buffReader;

  private final BitManipulator isBinary;
  private final BitManipulator append;
  private final BitManipulator search;
  private final BitManipulator show;

  /**
   * Description: The process class constructor. Just use for initializing
   *  field members of the class.
   * 
   * @param id - String use for identifying the process
   * @param preamble - String containing the preamble to be search on the bit stream
   * @param dataSize - the size of data to decode after preamble is found in bytes
   */
  private Process(final String id, final String preamble, final int dataSize) {
    processId = id;
    PREAMBLE = preamble;
    PREAMBLE_BIT_LENGTH = PREAMBLE.length() * 8;
    DATA_SIZE = dataSize * 8; // in bits
    preambleFound = false;
    buff = new StringBuilder();
    buffReader = new BufferedReader(new InputStreamReader(System.in));

    isBinary = c -> {
      return (48 == (int)c || 49 == (int)c);
    };

    append = c -> {
      return buff.append(c) == null;
    };

    /**
     * Description: Fill up the buffer until PREAMBLE_BIT_LENGTH is reached.
     *  If we met PREAMBLE_BIT_LENGTH but preamble string is not found we drop
     *  oldest bit in the front of buffer and append new ones to the end when
     *  preamble is found, return true to stop seaching. When preamble is found,
     *  return true to stop seaching
     */
    search = c -> {
      if(buff.length() < PREAMBLE_BIT_LENGTH) {
        return append.data(c);
      } else if(Decoder.binStr2Ascii(buff).compareTo(PREAMBLE) != 0) {
        buff.deleteCharAt(0);
        return append.data(c);
      } else {                
        buff.setLength(0);
        return !append.data(c);
      }
    };

    /**
     * Description: Keep filling the buffer until DATA_SIZE is reached. Then 
     *  decodes it, print it to STDOUT, and clear the buffer, ready for next
     *  premable search
     */
    show = c -> {
      if(buff.length() < DATA_SIZE) {
        return !append.data(c);
      }
      System.out.println(Decoder.binStr2Ascii(buff));
      buff.setLength(0);
      return append.data(c);
    };
  }

  /**
   * Description: This method contains the algorithm use to search and
   *  manipulate the buffer space as it finds the preamble. It starts out
   *  by queueing incomming bits into the buffer until it reaches
   *  PREAMBLE_BIT_LENGTH. Then it drops the oldest bits from the buffer as
   *  new ones are being added in. When a preamble is found, it clears the
   *  buffer and shift to ingesting bits up to DATA_SIZE, it then decodes it,
   *  and prints it to the output stream. It uses a Decoder utility library
   *  to decode the string of bits in the buffer into a string of chars.
   */
  private void run() throws IOException {
    System.out.println("Started " + this);
    boolean found = false;
    try {
      while(true) {
        char c = (char)buffReader.read();
        if(isBinary.data(c)) {
           preambleFound = preambleFound ? show.data(c) : search.data(c);
        }
      }
    } catch(final IOException e) {
      throw e; // don't care, rethrowing
    }
  }

  /**
   * Description: The toString method of the process class
   * 
   * @return string containing relevant information needed for the running process
   */
  public String toString() {
    return processId +
      " - Preamble: " + PREAMBLE +
      " - Preamble bit length: " + PREAMBLE_BIT_LENGTH +
      " - Data bit size: " + DATA_SIZE;
  }

  /**
   * Description: The main entry point for the application
   */
  public static void main(String[] args) {
    final String processId = "decoder process";
    final String PREAMBLE = "CAPTIVATION";
    final int DATA_SIZE = 100; // in bytes
    Process process = new Process(processId, PREAMBLE, DATA_SIZE);

    try {
      process.run();
    } catch(final IOException e) {
      e.printStackTrace();
    }
  }
}