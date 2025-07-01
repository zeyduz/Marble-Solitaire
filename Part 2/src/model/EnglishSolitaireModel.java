package cs3500.marblesolitaire.model.hw02;

/**
 * This is a class that represents an {@code EnglishSolitaireModel}. This class has an arm
 * thickness and a game board as fields.
 */
public class EnglishSolitaireModel implements MarbleSolitaireModel {
  private final int armThickness;

  private final SlotState[][] gameBoard;

  /**
   * Empty Constructor that has arm thickness of 3 and empty position placed at row 3 column 3.
   */
  public EnglishSolitaireModel() {
    this(3, 3, 3);
  }

  /**
   * 2-parameter Constructor that has the given row and column of a position.
   *
   * @param sRow row position of the empty slot
   * @param sCol column position of the empty slot
   * @throws IllegalArgumentException when the sRow or sCol is an invalid position (out of bounds)
   */
  public EnglishSolitaireModel(int sRow, int sCol) throws IllegalArgumentException {
    this(3, sRow, sCol);
  }

  /**
   * Constructor that only takes in the arm thickness and sets the row and column at the center.
   *
   * @param armThickness number of marbles in the top row
   * @throws IllegalArgumentException if the arm thickness if even or less than 3
   */
  public EnglishSolitaireModel(int armThickness) throws IllegalArgumentException {
    this(armThickness, (armThickness - 1) + ((armThickness - 1) / 2),
            (armThickness - 1) + ((armThickness - 1) / 2));
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
    if (armThickness % 2 == 0 || armThickness < 3) {
      throw new IllegalArgumentException("Arm thickness must be an odd number greater than"
              + "or equal to 3.");
    }
    this.armThickness = armThickness;
    if (!(this.withinValidBounds(armThickness, row, column))) {
      throw new IllegalArgumentException("Invalid empty cell position ("
              + row + "," + column + ")");
    }
    this.gameBoard = new SlotState[this.getBoardSize()][this.getBoardSize()];

    for (int i = 0; i < this.getBoardSize(); i++) {
      for (int j = 0; j < this.getBoardSize(); j++) {
        if (this.withinValidBounds(armThickness, i, j) && (!(i == row && j == column))) {
          gameBoard[i][j] = SlotState.Marble;
        } else if (i == row && j == column) {
          gameBoard[i][j] = SlotState.Empty;
        } else {
          gameBoard[i][j] = SlotState.Invalid;
        }
      }
    }
  }

  /**
   * Determines whether this position lays within valid bounds.
   *
   * @param armThickness arm thickness of the game
   * @param row          the row of the position
   * @param col          the column of the position
   * @return whether the position is valid or not, i.e., within bounds of the baord
   */
  private boolean withinValidBounds(int armThickness, int row, int col) {
    int upperBound = armThickness * 2 - 2;
    int lowerBound = armThickness - 1;
    boolean columnInBounds = ((col >= lowerBound && col <= upperBound)
            && (row >= 0 && row < this.getBoardSize()));
    boolean rowInBounds = ((row >= lowerBound && row <= upperBound)
            && (col >= 0 && col < this.getBoardSize()));

    return columnInBounds || rowInBounds;
  }

  /**
   * Determines if the marble contained in the given row and column have marbles adjacent to it.
   *
   * @param fromRow the row of the from position
   * @param fromCol the column of the from position
   * @param toRow   the row of the to position
   * @param toCol   the column of the to position
   * @return whether the given marble has any marbles adjacent to it
   * @throws IllegalArgumentException if the given row,col position does not contain a marble
   */
  private boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol)
          throws IllegalArgumentException {
    // check conditions first:
    // from must be a marble, to must be empty, and marble must exist between them
    if (this.getSlotAt(fromRow, fromCol) != SlotState.Marble) {
      return false;
    } else if (this.getSlotAt(toRow, toCol) != SlotState.Empty) {
      return false;
    } else if ((Math.abs(fromRow - toRow) == 2) && fromCol != toCol) {
      return false;
    } else if ((Math.abs(fromCol - toCol) == 2) && fromRow != toRow) {
      return false;
    } else if (fromRow != toRow && fromCol != toCol) {
      return false;
    } else if (fromRow == toRow && (Math.abs(fromCol - toCol)) != 2) {
      return false;
    } else if (fromCol == toCol && (Math.abs(fromRow - toRow)) != 2) {
      return false;
    }
    return this.canHopOver(fromRow + 1, fromCol, toRow, toCol)
            || this.canHopOver(fromRow - 1, fromCol, toRow, toCol)
            || this.canHopOver(fromRow, fromCol + 1, toRow, toCol)
            || this.canHopOver(fromRow, fromCol - 1, toRow, toCol);
  }

  /**
   * Determines if the marble contained in the given row and column have marbles adjacent to it.
   *
   * @param row the row of the from position
   * @param col the column of the from position
   * @return whether the given marble has any marbles adjacent to it
   * @throws IllegalArgumentException if the given row,col position does not contain a marble
   */
  private boolean moveablePlay(int row, int col) throws IllegalArgumentException {
    if (this.getSlotAt(row, col) != SlotState.Marble) {
      return false;
    }
    return this.canHopOver(row + 1, col, row + 2, col)
            || this.canHopOver(row - 1, col, row - 2, col)
            || this.canHopOver(row, col + 1, row, col + 2)
            || this.canHopOver(row, col - 1, row, col - 2);
  }

  /**
   * Given that the given row,col of the marble and empty slot are valid, determines if this a
   * hop-able (i.e., can a marble jump over the marble with the given row,col into the empty slot
   * with the given row,col) move.
   *
   * @param marbleRow the row of the marble's position
   * @param marbleCol the column of the marble's position
   * @param emptyRow  the row of the empty slot's position
   * @param emptyCol  the column of the empty slot's position
   * @return whether a marble can hop over the marble with the given row,col into the empty
   *         slot with the given row,col
   */
  private boolean canHopOver(int marbleRow, int marbleCol, int emptyRow, int emptyCol) {
    if (!(this.withinValidBounds(armThickness, marbleRow, marbleCol)
            && this.withinValidBounds(armThickness, emptyRow, emptyCol))) {
      return false;
    }
    return this.getSlotAt(marbleRow, marbleCol) == SlotState.Marble
            && this.getSlotAt(emptyRow, emptyCol) == SlotState.Empty;
  }

  /**
   * Sets the SlotState of the slot that lays between a marble and an empty, when moved.
   *
   * @param fromRow row of from position
   * @param fromCol column of from position
   * @param toRow   row of to position
   * @param toCol   column of to position
   */
  private void setMiddleSlot(int fromRow, int fromCol, int toRow, int toCol) {
    // up
    if (toRow < fromRow) {
      this.gameBoard[fromRow - 1][fromCol] = SlotState.Empty;
    }
    // down
    else if (toRow > fromRow) {
      this.gameBoard[fromRow + 1][fromCol] = SlotState.Empty;
    }
    // left
    else if (toCol < fromCol) {
      this.gameBoard[fromRow][fromCol - 1] = SlotState.Empty;
    }
    // right
    else if (toCol > fromCol) {
      this.gameBoard[fromRow][fromCol + 1] = SlotState.Empty;
    }
  }


  /**
   * Move a single marble from a given position to another given position.
   * A move is valid only if the from and to positions are valid. Specific
   * implementations may place additional constraints on the validity of a move.
   *
   * @param fromRow the row number of the position to be moved from
   *                (starts at 0)
   * @param fromCol the column number of the position to be moved from
   *                (starts at 0)
   * @param toRow   the row number of the position to be moved to
   *                (starts at 0)
   * @param toCol   the column number of the position to be moved to
   *                (starts at 0)
   * @throws IllegalArgumentException if the move is not possible
   * @throws IllegalStateException when the game is over
   */
  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol)
          throws IllegalArgumentException, IllegalStateException {
    if (this.withinValidBounds(armThickness, toRow, toCol)
            && this.withinValidBounds(armThickness, fromRow, fromCol)
            && this.isValidMove(fromRow, fromCol, toRow, toCol)) {
      this.gameBoard[toRow][toCol] = SlotState.Marble;
      this.gameBoard[fromRow][fromCol] = SlotState.Empty;
      this.setMiddleSlot(fromRow, fromCol, toRow, toCol);
    } else {
      throw new IllegalArgumentException("Move is not possible.");
    }
  }

  @Override
  public boolean isGameOver() {
    for (int i = 0; i < this.getBoardSize(); i++) {
      for (int j = 0; j < this.getBoardSize(); j++) {
        if (this.moveablePlay(i, j)) {
          return false;
        }
      }
    }
    return true;
  }


  @Override
  public int getBoardSize() {
    return (armThickness * 3) - 2;
  }

  @Override
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    if ((row >= this.getBoardSize() || row < 0) || (col >= this.getBoardSize() || col < 0)) {
      throw new IllegalArgumentException("Invalid position: Position out of bounds.");
    }
    return this.gameBoard[row][col];
  }

  @Override
  public int getScore() {
    int counter = 0;
    for (SlotState[] row : this.gameBoard) {
      for (SlotState elem : row) {
        if (elem.equals(SlotState.Marble)) {
          counter++;
        }
      }
    }
    return counter;
  }
}