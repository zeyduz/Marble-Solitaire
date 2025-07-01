import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.StringReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

import static org.junit.Assert.assertEquals;


/**
 * Testing Triangle Solitaire View.
 */
public class TriangleSolitaireTextViewTest {
  private TriangleSolitaireModel model;
  private TriangleSolitaireModel model2;
  private TriangleSolitaireModel model3;
  private TriangleSolitaireModel model4;
  private Appendable ap;
  private Appendable ap2;
  private Appendable ap3;
  private Appendable ap4;
  private ModelMock mockModel;
  private TriangleSolitaireTextView view;
  private TriangleSolitaireTextView view2;
  private TriangleSolitaireTextView view3;
  private TriangleSolitaireTextView view4;
  private CorruptAppendableMock mockOut;
  private Readable in;


  @Before
  public void init() {
    this.model = new TriangleSolitaireModel();
    this.model2 = new TriangleSolitaireModel(2,1); // custom spacing
    this.model3 = new TriangleSolitaireModel(7); // size
    this.model4 = new TriangleSolitaireModel(9,5,4); // all 3 custom
    this.ap = new StringBuilder();
    this.ap2 = new StringBuffer();
    this.ap3 = new StringBuilder();
    this.ap4 = new StringBuffer();
    this.view = new TriangleSolitaireTextView(this.model);
    this.view2 = new TriangleSolitaireTextView(this.model2);
    this.view3 = new TriangleSolitaireTextView(this.model3);
    this.view4 = new TriangleSolitaireTextView(this.model4);
    this.mockOut = new CorruptAppendableMock();
    this.in = new StringReader("");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullModelState() {
    this.view = new TriangleSolitaireTextView(null, this.ap);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullApMock() {
    this.view = new TriangleSolitaireTextView(this.mockModel, null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullModelStateMock() {
    this.view = new TriangleSolitaireTextView(null, this.mockOut);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullAp() {
    this.view = new TriangleSolitaireTextView(this.model, null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorBothNull() {
    this.view = new TriangleSolitaireTextView(null, null);
  }

  @Test(expected = IllegalStateException.class)
  public void testCorruptAppendableBoard() throws IOException {
    TriangleSolitaireTextView view = new TriangleSolitaireTextView(this.mockModel, this.mockOut);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(this.mockModel,
            view, this.in);
    controller.playGame();
  }

  @Test(expected = IllegalStateException.class)
  public void testCorruptAppendableMessage() throws IOException {
    TriangleSolitaireTextView view = new TriangleSolitaireTextView(this.mockModel, this.mockOut);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(this.mockModel,
            view, this.in);
    controller.playGame();
  }


  @Test
  public void testToString() {
    assertEquals("    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O", view.toString());

    // custom spacing
    assertEquals("    O\n" +
            "   O O\n" +
            "  O _ O\n" +
            " O O O O\n" +
            "O O O O O", view2.toString());

    // specified dimension
    assertEquals("      _\n" +
            "     O O\n" +
            "    O O O\n" +
            "   O O O O\n" +
            "  O O O O O\n" +
            " O O O O O O\n" +
            "O O O O O O O", view3.toString());


    assertEquals("        O\n" +
            "       O O\n" +
            "      O O O\n" +
            "     O O O O\n" +
            "    O O O O O\n" +
            "   O O O O _ O\n" +
            "  O O O O O O O\n" +
            " O O O O O O O O\n" +
            "O O O O O O O O O", view4.toString());

    model4.move(3,2,5,4);
    assertEquals("        O\n" +
            "       O O\n" +
            "      O O O\n" +
            "     O O _ O\n" +
            "    O O O _ O\n" +
            "   O O O O O O\n" +
            "  O O O O O O O\n" +
            " O O O O O O O O\n" +
            "O O O O O O O O O", view4.toString());
  }

  @Test
  public void testRenderBoard() throws IOException {
    this.view = new TriangleSolitaireTextView(this.model, this.ap);

    this.model2 = new TriangleSolitaireModel(2,1);
    this.model3 = new TriangleSolitaireModel(8);
    this.model4 = new TriangleSolitaireModel(8,4,3);
    this.view2 = new TriangleSolitaireTextView(this.model2, this.ap2);
    this.view3 = new TriangleSolitaireTextView(this.model3, this.ap3);
    this.view4 = new TriangleSolitaireTextView(this.model4, this.ap4);


    // classic
    assertEquals("", ap.toString());
    assertEquals("", ap2.toString());
    assertEquals("", ap3.toString());
    assertEquals("", ap4.toString());
    // first, check that the board is added to the appendable correctly
    this.view.renderBoard();
    this.model.move(2,0,0,0);
    this.view.renderMessage("\n");
    this.view.renderBoard();
    assertEquals("    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "    O\n" +
            "   _ O\n" +
            "  _ O O\n" +
            " O O O O\n" +
            "O O O O O", ap.toString());

    //custom empty
    this.view2.renderBoard(); //2,1
    this.model2.move(4,3,2,1);
    this.view2.renderMessage("\n");
    this.view2.renderBoard();
    assertEquals("    O\n" +
            "   O O\n" +
            "  O _ O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "    O\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O _ O\n" +
            "O O O _ O", ap2.toString());

    // specific dimension
    this.view3.renderBoard();
    this.model3.move(2,2,0,0);
    this.view3.renderMessage("\n");
    this.view3.renderBoard();
    assertEquals("       _\n" +
            "      O O\n" +
            "     O O O\n" +
            "    O O O O\n" +
            "   O O O O O\n" +
            "  O O O O O O\n" +
            " O O O O O O O\n" +
            "O O O O O O O O\n" +
            "       O\n" +
            "      O _\n" +
            "     O O _\n" +
            "    O O O O\n" +
            "   O O O O O\n" +
            "  O O O O O O\n" +
            " O O O O O O O\n" +
            "O O O O O O O O", ap3.toString());

    // custom dimension && custom empty
    this.view4.renderBoard();
    this.view4.renderMessage("\n");
    this.view4.renderBoard();
    this.model4.move(2,1,4,3);
    assertEquals("       O\n" +
            "      O O\n" +
            "     O O O\n" +
            "    O O O O\n" +
            "   O O O _ O\n" +
            "  O O O O O O\n" +
            " O O O O O O O\n" +
            "O O O O O O O O\n" +
            "       O\n" +
            "      O O\n" +
            "     O O O\n" +
            "    O O O O\n" +
            "   O O O _ O\n" +
            "  O O O O O O\n" +
            " O O O O O O O\n" +
            "O O O O O O O O", ap4.toString());


  }

  @Test
  public void testRenderBoardAndMessage() throws IOException {
    this.view = new TriangleSolitaireTextView(this.model, this.ap);
    this.model = new TriangleSolitaireModel();
    this.model2 = new TriangleSolitaireModel(7);
    this.view2 = new TriangleSolitaireTextView(this.model2, this.ap2);

    assertEquals("", ap.toString());
    // first, check that the board is added to the appendable correctly
    this.view.renderBoard();
    assertEquals("    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O", ap.toString());

    // then, check that the messages are added to the appendable correctly
    this.view.renderMessage("\n" + "Make a move.");
    assertEquals("    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Make a move.", ap.toString());


    //now, do the same for a larger board but display message before
    this.view2.renderMessage("HI!");
    this.view2.renderMessage("\n");
    this.view2.renderBoard();
    assertEquals("HI!\n" +
            "      _\n" +
            "     O O\n" +
            "    O O O\n" +
            "   O O O O\n" +
            "  O O O O O\n" +
            " O O O O O O\n" +
            "O O O O O O O", ap2.toString());

    this.view2.renderMessage("\n" + "Make a move.");
    assertEquals("HI!\n" +
            "      _\n" +
            "     O O\n" +
            "    O O O\n" +
            "   O O O O\n" +
            "  O O O O O\n" +
            " O O O O O O\n" +
            "O O O O O O O\n" +
            "Make a move.", ap2.toString());

  }
}
