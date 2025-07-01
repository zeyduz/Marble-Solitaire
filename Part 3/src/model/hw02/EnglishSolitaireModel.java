package cs3500.marblesolitaire.model.hw02;

import cs3500.marblesolitaire.model.hw04.AbstractModel;

/**
 * This is a class that represents an {@code EnglishSolitaireModel}. This class has an arm
 * thickness and a game board as fields.
 */
public class EnglishSolitaireModel extends AbstractModel {
  /**
   * Empty Constructor that has arm thickness of 3 and empty position placed at row 3 column 3.
   */
  public EnglishSolitaireModel() {
    super(3, 3, 3);
  }

  /**
   * 2-parameter Constructor that has the given row and column of a position.
   *
   * @param sRow row position of the empty slot
   * @param sCol column position of the empty slot
   * @throws IllegalArgumentException when the sRow or sCol is an invalid position (out of bounds)
   */
  public EnglishSolitaireModel(int sRow, int sCol) throws IllegalArgumentException {
    super(sRow, sCol);
  }

  /**
   * Constructor that only takes in the arm thickness and sets the row and column at the center.
   *
   * @param armThickness number of marbles in the top row
   * @throws IllegalArgumentException if the arm thickness if even or less than 3
   */
  public EnglishSolitaireModel(int armThickness) throws IllegalArgumentException {
    super(armThickness);
  }

  /**
   * Constructor that takes in arm thickness, row, and column of the empty.
   *
   * @param armThickness number of marbles in the top row
   * @param row          row position of the empty slot
   * @param column       column position of the empty slot
   * @throws IllegalArgumentException if the arm thickness is even or less than three OR if the
   *                                  row and column are invalid positions
   */
  public EnglishSolitaireModel(int armThickness, int row, int column)
          throws IllegalArgumentException {
    super(armThickness, row, column);
  }

  @Override
  protected boolean withinValidBounds(int armThickness, int row, int col) {
    int upperBound = armThickness * 2 - 2;
    int lowerBound = armThickness - 1;
    boolean columnInBounds = ((col >= lowerBound && col <= upperBound)
            && (row >= 0 && row < this.getBoardSize()));
    boolean rowInBounds = ((row >= lowerBound && row <= upperBound)
            && (col >= 0 && col < this.getBoardSize()));

    return columnInBounds || rowInBounds;
  }
}