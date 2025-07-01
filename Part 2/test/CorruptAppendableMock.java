import java.io.IOException;

/**
 * Mock Class for a Corrupt Appendable that always fails.
 */

public class CorruptAppendableMock implements Appendable {
  @Override
  public Appendable append(CharSequence csq) throws IOException {
    throw new IOException();
  }

  @Override
  public Appendable append(CharSequence csq, int start, int end) throws IOException {
    throw new IOException();
  }

  @Override
  public Appendable append(char c) throws IOException {
    throw new IOException();
  }

  /*
  failing appendable
  to test if methods work correctly if the appendable fails
  fails everytime we use it


   */

}
