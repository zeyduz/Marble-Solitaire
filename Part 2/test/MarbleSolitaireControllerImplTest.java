import org.junit.Before;
import org.junit.Test;

import java.io.Reader;
import java.io.StringReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

import static org.junit.Assert.assertEquals;

/**
 * This is a test class for testing the controller.
 */
public class MarbleSolitaireControllerImplTest {
  Appendable modelLog;
  Appendable viewLog;
  MarbleSolitaireModel mockModel;
  MarbleSolitaireView mockView;
  MarbleSolitaireModel model;
  MarbleSolitaireModel modelCustomEmpty;
  MarbleSolitaireModel modelA5;
  MarbleSolitaireModel modelA5CustomEmpty;
  MarbleSolitaireView view;
  MarbleSolitaireView viewWithMockModel;
  CorruptReadableMock mockIn;
  Readable in;

  @Before
  public void init() {
    this.modelLog = new StringBuilder();
    this.viewLog = new StringBuilder();
    this.mockModel = new EnglishSolitaireModelMock(this.modelLog);
    this.mockView = new MarbleSolitaireViewMock(this.viewLog);
    this.model = new EnglishSolitaireModel();
    this.modelCustomEmpty = new EnglishSolitaireModel(4, 3);
    this.modelA5 = new EnglishSolitaireModel(5);
    this.modelA5CustomEmpty = new EnglishSolitaireModel(5, 4, 4);
    this.view = new MarbleSolitaireTextView(this.model);
    this.viewWithMockModel = new MarbleSolitaireTextView(this.mockModel);
    this.mockIn = new CorruptReadableMock();
    this.in = new StringReader("4 2 4 4 q");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testControllerConstructorNullModel() {
    new MarbleSolitaireControllerImpl(null, this.mockView, this.in);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testControllerConstructorNullView() {
    new MarbleSolitaireControllerImpl(this.mockModel, null, this.in);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testControllerConstructorNullReadable() {
    new MarbleSolitaireControllerImpl(this.mockModel, this.mockView, null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testControllerConstructorNullModelAndView() {
    new MarbleSolitaireControllerImpl(null, null, this.in);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testControllerConstructorNullModelAndReadable() {
    new MarbleSolitaireControllerImpl(null, this.mockView, null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testControllerConstructorNullViewAndReadable() {
    new MarbleSolitaireControllerImpl(this.mockModel, null, null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testControllerConstructorAllNull() {
    new MarbleSolitaireControllerImpl(null, null, null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testControllerConstructorModelAndViewNotMockReadableNull() {
    new MarbleSolitaireControllerImpl(this.model, this.view, null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testControllerConstructorModelNullViewNotMockReadableNull() {
    new MarbleSolitaireControllerImpl(null, this.view, null);
  }

  @Test(expected = IllegalStateException.class)
  public void testReadableOutWithCorruptReadableAndMockModelAndView() {
    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(this.mockModel, this.mockView, this.mockIn);
    controller.playGame();
  }

  @Test(expected = IllegalStateException.class)
  public void testReadableOutWithCorruptReadable() {
    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(this.model, this.view, this.mockIn);
    controller.playGame();
  }

  @Test(expected = IllegalStateException.class)
  public void testReadableOutNotEnoughInputs3Inputs() {
    Readable in = new StringReader("4 2 4");

    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(this.mockModel, this.mockView, in);
    controller.playGame();
  }

  @Test(expected = IllegalStateException.class)
  public void testReadableOutNotEnoughInputs5Inputs() {
    Readable in = new StringReader("4 2 4 4 4");

    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(this.mockModel, this.mockView, in);
    controller.playGame();
  }

  @Test(expected = IllegalStateException.class)
  public void testReadableOutWithNoQAtEnd() {
    Readable in = new StringReader("4 2 4 4");

    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(this.mockModel, this.mockView, in);
    controller.playGame();
  }

  @Test(expected = IllegalStateException.class)
  public void testReadableOutWithNoQAtEndAndInvalidMove() {
    Readable in = new StringReader("4 2 4 3");

    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(this.mockModel, this.mockView, in);
    controller.playGame();
  }

  @Test(expected = IllegalStateException.class)
  public void testReadableOutWithNegative() {
    Readable in = new StringReader("4 -1 4 3");

    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(this.mockModel, this.mockView, in);
    controller.playGame();
  }

  @Test
  public void testMockModelValidInputs() {
    // right
    mockModel.move(3, 1, 3, 3);
    assertEquals("Moved from (4,2) to (4,4)." + "\n", this.modelLog.toString());
    // left
    mockModel.move(3, 4, 3, 2);
    assertEquals("Moved from (4,2) to (4,4).\n"
            + "Moved from (4,5) to (4,3)." + "\n", this.modelLog.toString());
    // down
    mockModel.move(1, 3, 3, 3);
    assertEquals("Moved from (4,2) to (4,4).\n"
            + "Moved from (4,5) to (4,3)." + "\n"
            + "Moved from (2,4) to (4,4)." + "\n", this.modelLog.toString());
    // up
    mockModel.move(5, 4, 3, 4);
    assertEquals("Moved from (4,2) to (4,4).\n"
            + "Moved from (4,5) to (4,3)." + "\n"
            + "Moved from (2,4) to (4,4)." + "\n"
            + "Moved from (6,5) to (4,5)." + "\n", this.modelLog.toString());

    // bad move
    mockModel.move(0, 4, 1, 4);
    assertEquals("Moved from (4,2) to (4,4).\n"
            + "Moved from (4,5) to (4,3)." + "\n"
            + "Moved from (2,4) to (4,4)." + "\n"
            + "Moved from (6,5) to (4,5)." + "\n"
            + "Moved from (1,5) to (2,5)." + "\n", this.modelLog.toString());

  }

  @Test
  public void testMockViewUpperQuit() {
    Reader in = new StringReader("Q");
    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(this.mockModel, this.mockView, in);
    controller.playGame();

    assertEquals("Rendered Board: \n" +
            "Rendered Message: Score: 0\n" +
            "Rendered Message: Enter the row and column of the from and to positions.\n" +
            "Rendered Message: Game quit!\n" +
            "Rendered Message: State of game when quit:\n" +
            "Rendered Board: \n" +
            "Rendered Message: Score: 0" + "\n", this.viewLog.toString());
  }

  @Test
  public void testMockViewLowerQuit() {
    Reader in = new StringReader("q");
    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(this.mockModel, this.mockView, in);
    controller.playGame();

    assertEquals("Rendered Board: \n" +
            "Rendered Message: Score: 0\n" +
            "Rendered Message: Enter the row and column of the from and to positions.\n" +
            "Rendered Message: Game quit!\n" +
            "Rendered Message: State of game when quit:\n" +
            "Rendered Board: \n" +
            "Rendered Message: Score: 0" + "\n", this.viewLog.toString());
  }

  @Test
  public void testMockModelQuitInMiddle() {
    Reader in = new StringReader("4 2 q");
    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(this.mockModel, this.mockView, in);
    controller.playGame();

    assertEquals("Rendered Board: \n" +
            "Rendered Message: Score: 0\n" +
            "Rendered Message: Enter the row and column of the from and to positions.\n" +
            "Rendered Message: Game quit!\n" +
            "Rendered Message: State of game when quit:\n" +
            "Rendered Board: \n" +
            "Rendered Message: Score: 0" + "\n", this.viewLog.toString());
  }

  @Test
  public void testMockModelMoveThenQuitOnFromCol() {
    Reader in = new StringReader("4 2 4 4 2 q");
    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(this.mockModel, this.mockView, in);
    controller.playGame();

    assertEquals("Rendered Board: \n" +
            "Rendered Message: Score: 0\n" +
            "Rendered Message: Enter the row and column of the from and to positions.\n" +
            "Rendered Board: \n" +
            "Rendered Message: Score: 0\n" +
            "Rendered Message: Enter the row and column of the from and to positions.\n" +
            "Rendered Message: Game quit!\n" +
            "Rendered Message: State of game when quit:\n" +
            "Rendered Board: \n" +
            "Rendered Message: Score: 0" + "\n", this.viewLog.toString());
  }

  //Multiple moves q then valid move
  @Test
  public void testMoveQMove() {
    Readable in = new StringReader("4 2 4 4 q 4 5 4 3");

    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(this.mockModel, this.mockView, in);
    controller.playGame();

    assertEquals("Rendered Board: \n" +
            "Rendered Message: Score: 0\n" +
            "Rendered Message: Enter the row and column of the from and to positions.\n" +
            "Rendered Board: \n" +
            "Rendered Message: Score: 0\n" +
            "Rendered Message: Enter the row and column of the from and to positions.\n" +
            "Rendered Message: Game quit!\n" +
            "Rendered Message: State of game when quit:\n" +
            "Rendered Board: \n" +
            "Rendered Message: Score: 0" + "\n", this.viewLog.toString());

  }

  //Multiple moves q then invalid move
  @Test
  public void testMoveQInvalidMove() {
    Readable in = new StringReader("4 2 4 4 q 4 4 4 4");

    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(this.mockModel, this.mockView, in);
    controller.playGame();

    assertEquals("Rendered Board: \n" +
            "Rendered Message: Score: 0\n" +
            "Rendered Message: Enter the row and column of the from and to positions.\n" +
            "Rendered Board: \n" +
            "Rendered Message: Score: 0\n" +
            "Rendered Message: Enter the row and column of the from and to positions.\n" +
            "Rendered Message: Game quit!\n" +
            "Rendered Message: State of game when quit:\n" +
            "Rendered Board: \n" +
            "Rendered Message: Score: 0" + "\n", this.viewLog.toString());
  }


  @Test
  public void testMockViewInputs() {
    Reader in = new StringReader("4 2 4 4 q");
    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(mockModel, mockView, in);
    controller.playGame();

    assertEquals("Rendered Board: " + "\n"
            + "Rendered Message: Score: 0" + "\n"
            + "Rendered Message: Enter the row and column of the from and to positions." + "\n"
            + "Rendered Board: " + "\n"
            + "Rendered Message: Score: 0" + "\n"
            + "Rendered Message: Enter the row and column of the from and to positions." + "\n"
            + "Rendered Message: Game quit!" + "\n"
            + "Rendered Message: State of game when quit:" + "\n"
            + "Rendered Board: " + "\n"
            + "Rendered Message: Score: 0" + "\n", this.viewLog.toString());
  }

  @Test
  public void testMockViewInputsNoMoreMoves() {
    Reader in = new StringReader("4 2 4 4 4 5 4 3 4 7 4 5 2 4 4 4 5 4 3 4 7 4 5 4");
    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(this.model, this.mockView, in);
    controller.playGame();

    assertEquals("Rendered Board: " + "\n" + "Rendered Message: Score: 32" + "\n"
            + "Rendered Message: Enter the row and column of the from and to positions." + "\n"
            + "Rendered Board: " + "\n"
            + "Rendered Message: Score: 31" + "\n"
            + "Rendered Message: Enter the row and column of the from and to positions." + "\n"
            + "Rendered Board: " + "\n"
            + "Rendered Message: Score: 30" + "\n"
            + "Rendered Message: Enter the row and column of the from and to positions." + "\n"
            + "Rendered Board: " + "\n" + "Rendered Message: Score: 29" + "\n"
            + "Rendered Message: Enter the row and column of the from and to positions." + "\n"
            + "Rendered Board: " + "\n" + "Rendered Message: Score: 28" + "\n"
            + "Rendered Message: Enter the row and column of the from and to positions." + "\n"
            + "Rendered Board: " + "\n" + "Rendered Message: Score: 27" + "\n"
            + "Rendered Message: Enter the row and column of the from and to positions." + "\n"
            + "Rendered Message: Game over!" + "\n"
            + "Rendered Board: " + "\n"
            + "Rendered Message: Score: 26" + "\n", this.viewLog.toString());
  }

  @Test
  public void testMockViewWithMultipleInvalidInputsButValidMove() {
    Reader in = new StringReader("-1 4 QUIT 2 quit 4 slkjfs ! idk 4 q"); // add 10000 ....

    MarbleSolitaireControllerImpl controller =
            new MarbleSolitaireControllerImpl(this.mockModel, this.mockView, in);

    controller.playGame();

    assertEquals("Moved from (4,2) to (4,4)." + "\n", this.modelLog.toString());


    assertEquals("Rendered Board: " + "\n" + "Rendered Message: Score: 0" + "\n"
            + "Rendered Message: Enter the row and column of the from and to positions." + "\n"
            + "Rendered Message: Enter a valid integer." + "\n"
            + "Rendered Message: Enter a valid integer." + "\n"
            + "Rendered Message: Enter a valid integer." + "\n"
            + "Rendered Message: Enter a valid integer." + "\n"
            + "Rendered Message: Enter a valid integer." + "\n"
            + "Rendered Message: Enter a valid integer." + "\n" + "Rendered Board: " + "\n"
            + "Rendered Message: Score: 0" + "\n"
            + "Rendered Message: Enter the row and column of the from and to positions." + "\n"
            + "Rendered Message: Game quit!" + "\n"
            + "Rendered Message: State of game when quit:" + "\n" + "Rendered Board: " + "\n"
            + "Rendered Message: Score: 0" + "\n", this.viewLog.toString());
  }

  @Test
  public void testMockInvalidMovesThenValidMOve() {
    Readable in = new StringReader("1 2 6 6 2 4 4 4 q");

    MarbleSolitaireControllerImpl controller =
            new MarbleSolitaireControllerImpl(this.mockModel, this.mockView, in);

    controller.playGame();

    assertEquals("Moved from (1,2) to (6,6)." + "\n"
            + "Moved from (2,4) to (4,4)." + "\n", this.modelLog.toString());


    assertEquals("Rendered Board: " + "\n" + "Rendered Message: Score: 0" + "\n"
            + "Rendered Message: Enter the row and column of the from and to positions." + "\n"
            + "Rendered Board: " + "\n" + "Rendered Message: Score: 0" + "\n"
            + "Rendered Message: Enter the row and column of the from and to positions." + "\n"
            + "Rendered Board: " + "\n" + "Rendered Message: Score: 0" + "\n"
            + "Rendered Message: Enter the row and column of the from and to positions." + "\n"
            + "Rendered Message: Game quit!" + "\n"
            + "Rendered Message: State of game when quit:" + "\n"
            + "Rendered Board: " + "\n"
            + "Rendered Message: Score: 0" + "\n", this.viewLog.toString());
  }

  @Test
  public void testGameWithCharMidMove() {

    Appendable out = new StringBuilder();
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(model,
                    new MarbleSolitaireTextView(model, out),
                    new StringReader("4 2 p 4 4 q"));

    controller.playGame();

    assertEquals("    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 32\n"
            + "Enter the row and column of the from and to positions.\n"
            + "Enter a valid integer.\n"
            + "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O _ _ O O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 31\n"
            + "Enter the row and column of the from and to positions.\n"
            + "Game quit!\n"
            + "State of game when quit:\n"
            + "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O _ _ O O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 31\n", out.toString());
  }

  @Test
  public void testGameOverMove() {

    Appendable out = new StringBuilder();
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(model,
                    new MarbleSolitaireTextView(model, out),
                    new StringReader("4 2 4 4 6 3 4 3 5 1 5 3 5 4 5 2 5 6 5 4 7 5 5 5 4 5 6 5"
                            + " 7 3 7 5 7 5 5 5 3 3 5 3 1 3 3 3 2 5 4 5 4 5 6 5 6 5 6 3 6 3 4 3"
                            + " 4 3 2 3 3 1 5 1 5 1 5 3 5 3 5 5 3 7 3 5 3 4 3 6 5 7 3 7 3 7 3"
                            + " 5 1 5 1 3 1 3 3 3 3 2 3 4 3 4 3 6 3 6 5 6 5 6 5 4 5 4"
                            + " 3 4 2 4 4 4"));

    controller.playGame();

    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Enter the row and column of the from and to positions.\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "Enter the row and column of the from and to positions.\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ O O O O O\n" +
            "O O _ O O O O\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "Score: 30\n" +
            "Enter the row and column of the from and to positions.\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ O O O O O\n" +
            "_ _ O O O O O\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "Score: 29\n" +
            "Enter the row and column of the from and to positions.\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ O O O O O\n" +
            "_ O _ _ O O O\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "Score: 28\n" +
            "Enter the row and column of the from and to positions.\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ O O O O O\n" +
            "_ O _ O _ _ O\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "Score: 27\n" +
            "Enter the row and column of the from and to positions.\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ O O O O O\n" +
            "_ O _ O O _ O\n" +
            "    _ O _\n" +
            "    O O _\n" +
            "Score: 26\n" +
            "Enter the row and column of the from and to positions.\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ O O _ O O\n" +
            "_ O _ O _ _ O\n" +
            "    _ O O\n" +
            "    O O _\n" +
            "Score: 25\n" +
            "Enter the row and column of the from and to positions.\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ O O _ O O\n" +
            "_ O _ O _ _ O\n" +
            "    _ O O\n" +
            "    _ _ O\n" +
            "Score: 24\n" +
            "Enter the row and column of the from and to positions.\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ O O _ O O\n" +
            "_ O _ O O _ O\n" +
            "    _ O _\n" +
            "    _ _ _\n" +
            "Score: 23\n" +
            "Enter the row and column of the from and to positions.\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O _ O O O O\n" +
            "O _ _ O _ O O\n" +
            "_ O O O O _ O\n" +
            "    _ O _\n" +
            "    _ _ _\n" +
            "Score: 22\n" +
            "Enter the row and column of the from and to positions.\n" +
            "    _ O O\n" +
            "    _ O O\n" +
            "O O O O O O O\n" +
            "O _ _ O _ O O\n" +
            "_ O O O O _ O\n" +
            "    _ O _\n" +
            "    _ _ _\n" +
            "Score: 21\n" +
            "Enter the row and column of the from and to positions.\n" +
            "    _ O O\n" +
            "    _ O _\n" +
            "O O O O _ O O\n" +
            "O _ _ O O O O\n" +
            "_ O O O O _ O\n" +
            "    _ O _\n" +
            "    _ _ _\n" +
            "Score: 20\n" +
            "Enter the row and column of the from and to positions.\n" +
            "    _ O O\n" +
            "    _ O _\n" +
            "O O O O _ O O\n" +
            "O _ _ O _ O O\n" +
            "_ O O O _ _ O\n" +
            "    _ O O\n" +
            "    _ _ _\n" +
            "Score: 19\n" +
            "Enter the row and column of the from and to positions.\n" +
            "    _ O O\n" +
            "    _ O _\n" +
            "O O O O _ O O\n" +
            "O _ _ O _ O O\n" +
            "_ O O O _ _ O\n" +
            "    O _ _\n" +
            "    _ _ _\n" +
            "Score: 18\n" +
            "Enter the row and column of the from and to positions.\n" +
            "    _ O O\n" +
            "    _ O _\n" +
            "O O O O _ O O\n" +
            "O _ O O _ O O\n" +
            "_ O _ O _ _ O\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 17\n" +
            "Enter the row and column of the from and to positions.\n" +
            "    _ O O\n" +
            "    O O _\n" +
            "O O _ O _ O O\n" +
            "O _ _ O _ O O\n" +
            "_ O _ O _ _ O\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 16\n" +
            "Enter the row and column of the from and to positions.\n" +
            "    _ O O\n" +
            "    O O _\n" +
            "_ O _ O _ O O\n" +
            "_ _ _ O _ O O\n" +
            "O O _ O _ _ O\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 15\n" +
            "Enter the row and column of the from and to positions.\n" +
            "    _ O O\n" +
            "    O O _\n" +
            "_ O _ O _ O O\n" +
            "_ _ _ O _ O O\n" +
            "_ _ O O _ _ O\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 14\n" +
            "Enter the row and column of the from and to positions.\n" +
            "    _ O O\n" +
            "    O O _\n" +
            "_ O _ O _ O O\n" +
            "_ _ _ O _ O O\n" +
            "_ _ _ _ O _ O\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 13\n" +
            "Enter the row and column of the from and to positions.\n" +
            "    _ O O\n" +
            "    O O _\n" +
            "_ O _ O O _ _\n" +
            "_ _ _ O _ O O\n" +
            "_ _ _ _ O _ O\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 12\n" +
            "Enter the row and column of the from and to positions.\n" +
            "    _ O O\n" +
            "    O O _\n" +
            "_ O _ _ _ O _\n" +
            "_ _ _ O _ O O\n" +
            "_ _ _ _ O _ O\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 11\n" +
            "Enter the row and column of the from and to positions.\n" +
            "    _ O O\n" +
            "    O O _\n" +
            "_ O _ _ _ O O\n" +
            "_ _ _ O _ O _\n" +
            "_ _ _ _ O _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 10\n" +
            "Enter the row and column of the from and to positions.\n" +
            "    _ O O\n" +
            "    O O _\n" +
            "_ O _ _ O _ _\n" +
            "_ _ _ O _ O _\n" +
            "_ _ _ _ O _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 9\n" +
            "Enter the row and column of the from and to positions.\n" +
            "    O _ _\n" +
            "    O O _\n" +
            "_ O _ _ O _ _\n" +
            "_ _ _ O _ O _\n" +
            "_ _ _ _ O _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 8\n" +
            "Enter the row and column of the from and to positions.\n" +
            "    _ _ _\n" +
            "    _ O _\n" +
            "_ O O _ O _ _\n" +
            "_ _ _ O _ O _\n" +
            "_ _ _ _ O _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 7\n" +
            "Enter the row and column of the from and to positions.\n" +
            "    _ _ _\n" +
            "    _ O _\n" +
            "_ _ _ O O _ _\n" +
            "_ _ _ O _ O _\n" +
            "_ _ _ _ O _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 6\n" +
            "Enter the row and column of the from and to positions.\n" +
            "    _ _ _\n" +
            "    _ O _\n" +
            "_ _ _ _ _ O _\n" +
            "_ _ _ O _ O _\n" +
            "_ _ _ _ O _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 5\n" +
            "Enter the row and column of the from and to positions.\n" +
            "    _ _ _\n" +
            "    _ O _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ O _ _ _\n" +
            "_ _ _ _ O O _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 4\n" +
            "Enter the row and column of the from and to positions.\n" +
            "    _ _ _\n" +
            "    _ O _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ O _ _ _\n" +
            "_ _ _ O _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 3\n" +
            "Enter the row and column of the from and to positions.\n" +
            "    _ _ _\n" +
            "    _ O _\n" +
            "_ _ _ O _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 2\n" +
            "Enter the row and column of the from and to positions.\n" +
            "Game over!\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ O _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 1\n", out.toString());
  }

  @Test
  public void testGameDiag() {
    Appendable out = new StringBuilder();
    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(this.model,
                    new MarbleSolitaireTextView(this.model, out),
                    new StringReader("4 2 5 3 q"));

    controller.playGame();

    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Enter the row and column of the from and to positions.\n" +
            "Invalid move. Play again.\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n", out.toString());
  }

  //sart w q
  @Test
  public void testGameDecimalAndOtherInvalidInputs() {
    Appendable out = new StringBuilder();
    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(this.model,
                    new MarbleSolitaireTextView(this.model, out),
                    new StringReader("0.4 4 2 4 -88 4 Q"));

    controller.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Enter the row and column of the from and to positions.\n" +
            "Enter a valid integer.\n" +
            "Enter a valid integer.\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "Enter the row and column of the from and to positions.\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n", out.toString());
  }

  @Test
  public void testGameStartQThenMove() {
    Appendable out = new StringBuilder();
    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(this.model,
                    new MarbleSolitaireTextView(this.model, out),
                    new StringReader("q 4 2 4 4"));

    controller.playGame();

    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Enter the row and column of the from and to positions.\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n", out.toString());
  }

  @Test
  public void testGameWithCustomEmpty() {
    Appendable out = new StringBuilder();
    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(this.modelCustomEmpty,
                    new MarbleSolitaireTextView(this.modelCustomEmpty, out),
                    new StringReader("3 4 p 5 4 q"));

    controller.playGame();

    assertEquals("    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 32\n"
            + "Enter the row and column of the from and to positions.\n"
            + "Enter a valid integer.\n"
            + "    O O O\n"
            + "    O O O\n"
            + "O O O _ O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 31\n"
            + "Enter the row and column of the from and to positions.\n"
            + "Game quit!\n"
            + "State of game when quit:\n"
            + "    O O O\n"
            + "    O O O\n"
            + "O O O _ O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 31\n", out.toString());
  }

  @Test
  public void testArmThickness5() {
    Appendable out = new StringBuilder();
    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(this.modelA5,
                    new MarbleSolitaireTextView(this.modelA5, out),
                    new StringReader("5 7 7 7 4 5 q"));

    controller.playGame();

    assertEquals("        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O _ O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "Score: 104\n" +
            "Enter the row and column of the from and to positions.\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "O O O O O O _ O O O O O O\n" +
            "O O O O O O _ O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "Score: 103\n" +
            "Enter the row and column of the from and to positions.\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "O O O O O O _ O O O O O O\n" +
            "O O O O O O _ O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "Score: 103\n", out.toString());
  }

  //    this.modelA5CustomEmpty = new EnglishSolitaireModel(5, 4, 4);
  @Test
  public void testA5CustomEmpty() {
    Appendable out = new StringBuilder();
    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(this.modelA5CustomEmpty,
                    new MarbleSolitaireTextView(this.modelA5CustomEmpty, out),
                    new StringReader("3 5 1 5 2 7 2 5 1 2 3 q"));

    controller.playGame();

    assertEquals("        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "O O O O _ O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "Score: 104\n" +
            "Enter the row and column of the from and to positions.\n" +
            "Invalid move. Play again.\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "O O O O _ O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "Score: 104\n" +
            "Invalid move. Play again.\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "O O O O _ O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "Score: 104\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "O O O O _ O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "Score: 104\n", out.toString());

  }
}