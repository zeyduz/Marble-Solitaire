import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * Mock for Model.
 */
public class ModelMock implements MarbleSolitaireModel {

  private final Appendable log;

  /**
   * Constructor for mock english model.
   *
   * @param log log of inputs
   */
  public ModelMock(Appendable log) {
    this.log = log;
  }

  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    try {
      this.log.append("Moved from (" + (fromRow + 1) + "," + (fromCol + 1)
              + ") to (" + (toRow + 1) + "," + (toCol + 1) + ")." + "\n");
    } catch (IOException ignored) {
    }
  }

  @Override
  public boolean isGameOver() {
    return false;
  }

  @Override
  public int getBoardSize() {
    return 0;
  }

  @Override
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    return null;
  }

  @Override
  public int getScore() {
    return 0;
  }
}
