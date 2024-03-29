package cs3500.pa04;

import java.io.ByteArrayInputStream;
import java.util.Arrays;

/**
 * Mutable input stream for testing.
 */
public class MockInput extends ByteArrayInputStream {
  /**
   * Creates a new empty mock input stream.
   */
  public MockInput() {
    super(new byte[0]);
  }

  /**
   * Adds the given character sequence to the input stream succeeded by a line break character
   * (to make the scanner's nextLine function work correctly).
   *
   * @param input character sequence to add to this input stream.
   */
  public void input(CharSequence input) {
    addBytes((input.toString() + System.lineSeparator()).getBytes());
  }

  /**
   * Adds the given bytes to this input stream's buffer.
   *
   * @param bytes bytes to add
   */
  private void addBytes(byte[] bytes) {
    if (count == 0) {
      count += bytes.length;
      buf = bytes;
    } else {
      int originalLen = buf.length;
      int appendLen = bytes.length;
      byte[] result = Arrays.copyOf(buf, originalLen + appendLen);
      System.arraycopy(bytes, 0, result, originalLen, appendLen);
      count += appendLen;
      buf = result;
    }
  }
}
