import java.io.IOException;
import java.nio.CharBuffer;

/**
 * Mock Class for a Corrupt Readable that always fails.
 */
public class CorruptReadableMock implements Readable {
  @Override
  public int read(CharBuffer cb) throws IOException {
    throw new IOException();
  }
}
