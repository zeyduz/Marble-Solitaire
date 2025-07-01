import java.io.IOException;

import cs3500.marblesolitaire.view.MarbleSolitaireView;

/**
 * Mock for view.
 */
public class MarbleSolitaireViewMock implements MarbleSolitaireView {
  private final Appendable log;

  /**
   * Constructor for mock view.
   *
   * @param log log of inputs
   */
  public MarbleSolitaireViewMock(Appendable log) {
    this.log = log;
  }

  @Override
  public void renderBoard() throws IOException {
    try {
      this.log.append("Rendered Board: " + "\n");
    } catch (IOException ignored) {
    }
  }

  @Override
  public void renderMessage(String message) throws IOException {
    try {
      if (!(message.equals("\n"))) {
        this.log.append("Rendered Message: " + message);
      }
    } catch (IOException ignored) {
    }
  }
}
