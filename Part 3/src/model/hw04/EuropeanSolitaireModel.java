package cs3500.marblesolitaire.model.hw04;

/**
 * This is a class that represents an {@code EuropeanSolitaireModel}. The shape of this board
 * is octagonal.
 */
public class EuropeanSolitaireModel extends AbstractModel {
  /**
   * Default constructor for a European Solitaire Marble Game. It has a default side length of 3
   * and the empty slot is at position (3,3).
   */
  public EuropeanSolitaireModel() {
    super(3, 3, 3);
  }

  /**
   * Constructor for European Solitaire Model that takes in a side length. The empty slot is at the
   * center of the board.
   *
   * @param sideLength the side length of the board
   * @throws IllegalArgumentException when side length given is not an odd number greater than 3
   */
  public EuropeanSolitaireModel(int sideLength) throws IllegalArgumentException {
    super(sideLength);
  }

  /**
   * Constructor for European Solitaire Model that takes in two parameters - row and column of the
   * empty position. The side length is defaulted to 3.
   *
   * @param row row position of empty slot
   * @param col column position of empty slot
   * @throws IllegalArgumentException when the row or column is an invalid position (out of bounds)
   */
  public EuropeanSolitaireModel(int row, int col) throws IllegalArgumentException {
    super(row, col);
  }

  /**
   * Constructor for European Solitaire Model that takes in a side length, and row and column of
   * the empty slot.
   *
   * @param sideLength the side length of the board
   * @param row        the row position of empty slot
   * @param col        the column position of empty slot
   * @throws IllegalArgumentException if the size is even or less than three OR if the
   *                                  row and column are invalid positions
   */
  public EuropeanSolitaireModel(int sideLength, int row, int col) throws IllegalArgumentException {
    super(sideLength, row, col);
  }

  /**
   * Is the given row and column within the board.
   *
   * @param row row position
   * @param col column position
   * @return whether the given row and column are in bounds.
   */
  protected boolean inBounds(int row, int col) {
    return row < this.getBoardSize() && col < this.getBoardSize() && row >= 0 && col >= 0;
  }

  @Override
  protected boolean withinValidBounds(int size, int row, int col) {
    return !this.notValidBounds(row, col);
  }

  /**
   * Determines if the given row and column are not in bounds.
   * @param row given row position
   * @param col given column position
   * @return whether the given row and column are not in bounds.
   */
  protected boolean notValidBounds(int row, int col) {
    if (!this.inBounds(row, col)) {
      return true;
    }
    int lowerBounds = super.size - 1;
    int upperBounds = (super.size * 2) - 2;

    if (row <= lowerBounds && col <= lowerBounds) {
      return row + col + 2 <= size;
    }
    if (row <= lowerBounds && col >= upperBounds) {
      return this.getBoardSize() + 1 + row - col <= size;
    }
    if (row >= upperBounds && col <= lowerBounds) {
      return this.getBoardSize() + 1 - row + col <= size;
    }
    if (row >= upperBounds && col >= upperBounds) {
      return (2 * this.getBoardSize() - row - col <= size);
    }
    return false;
  }
}
