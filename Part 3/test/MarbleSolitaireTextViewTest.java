import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.StringReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

import static org.junit.Assert.assertEquals;

/**
 * This is a test class for testing view methods.
 */
public class MarbleSolitaireTextViewTest {
  MarbleSolitaireModel model;
  MarbleSolitaireModel model1;
  MarbleSolitaireModel model3;
  MarbleSolitaireModel model4;
  MarbleSolitaireModel model5;
  MarbleSolitaireModel model6;
  MarbleSolitaireModel model7;
  MarbleSolitaireModel model8;
  MarbleSolitaireModel model9;
  MarbleSolitaireModel euroModel;
  MarbleSolitaireModel euroModel1;
  MarbleSolitaireModel euroModel3;
  MarbleSolitaireModel euroModel4;
  MarbleSolitaireModel euroModel5;
  MarbleSolitaireModel euroModel6;
  MarbleSolitaireModel euroModel7;
  MarbleSolitaireModel euroModel8;
  MarbleSolitaireModel euroModel9;
  Appendable modelLog;
  Appendable ap;
  Appendable ap2;
  Appendable ap3;
  Appendable ap4;
  Appendable ap5;
  Appendable euroAp;
  Appendable euroAp2;
  Appendable euroAp3;
  Appendable euroAp4;
  Appendable euroAp5;
  ModelMock mockModel;
  MarbleSolitaireView view;
  MarbleSolitaireView view1;
  MarbleSolitaireView view3;
  MarbleSolitaireView view4;
  MarbleSolitaireView view5;
  MarbleSolitaireView view6;
  MarbleSolitaireView view7;
  MarbleSolitaireView view8;
  MarbleSolitaireView view9;
  MarbleSolitaireView euroView;
  MarbleSolitaireView euroView1;
  MarbleSolitaireView euroView3;
  MarbleSolitaireView euroView4;
  MarbleSolitaireView euroView5;
  MarbleSolitaireView euroView6;
  MarbleSolitaireView euroView7;
  MarbleSolitaireView euroView8;
  MarbleSolitaireView euroView9;
  CorruptAppendableMock mockOut;
  Readable in;


  @Before
  public void init() {
    this.model = new EnglishSolitaireModel();
    this.model1 = new EnglishSolitaireModel();
    this.model3 = new EnglishSolitaireModel(0, 2);
    this.model4 = new EnglishSolitaireModel(5, 5, 5);
    this.model5 = new EnglishSolitaireModel(0, 4);
    this.model6 = new EnglishSolitaireModel(4, 4);
    this.model7 = new EnglishSolitaireModel(7);
    this.model8 = new EnglishSolitaireModel(9, 12, 5);
    this.model9 = new EnglishSolitaireModel(11, 27, 18);
    this.euroModel = new EuropeanSolitaireModel();
    this.euroModel1 = new EuropeanSolitaireModel();
    this.euroModel3 = new EuropeanSolitaireModel(0, 2);
    this.euroModel4 = new EuropeanSolitaireModel(5, 5, 5);
    this.euroModel5 = new EuropeanSolitaireModel(0, 4);
    this.euroModel6 = new EuropeanSolitaireModel(4, 4);
    this.euroModel7 = new EuropeanSolitaireModel(7);
    this.euroModel8 = new EuropeanSolitaireModel(9, 12, 5);
    this.euroModel9 = new EuropeanSolitaireModel(11, 27, 18);
    this.modelLog = new StringBuilder();
    this.mockModel = new ModelMock(this.modelLog);
    this.ap = new StringBuilder();
    this.ap2 = new StringBuffer();
    this.ap3 = new StringBuffer();
    this.ap4 = new StringBuilder();
    this.ap5 = new StringBuilder();
    this.euroAp = new StringBuilder();
    this.euroAp2 = new StringBuffer();
    this.euroAp3 = new StringBuffer();
    this.euroAp4 = new StringBuilder();
    this.euroAp5 = new StringBuilder();
    this.view = new MarbleSolitaireTextView(model);
    this.view1 = new MarbleSolitaireTextView(model1);
    this.view3 = new MarbleSolitaireTextView(model3);
    this.view4 = new MarbleSolitaireTextView(model4);
    this.view5 = new MarbleSolitaireTextView(model5);
    this.view6 = new MarbleSolitaireTextView(model6);
    this.view7 = new MarbleSolitaireTextView(model7);
    this.view8 = new MarbleSolitaireTextView(model8);
    this.view9 = new MarbleSolitaireTextView(model9);
    this.euroView = new MarbleSolitaireTextView(euroModel);
    this.euroView1 = new MarbleSolitaireTextView(euroModel1);
    this.euroView3 = new MarbleSolitaireTextView(euroModel3);
    this.euroView4 = new MarbleSolitaireTextView(euroModel4);
    this.euroView5 = new MarbleSolitaireTextView(euroModel5);
    this.euroView6 = new MarbleSolitaireTextView(euroModel6);
    this.euroView7 = new MarbleSolitaireTextView(euroModel7);
    this.euroView8 = new MarbleSolitaireTextView(euroModel8);
    this.euroView9 = new MarbleSolitaireTextView(euroModel9);

    this.mockOut = new CorruptAppendableMock();
    this.in = new StringReader("");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullModelState() {
    this.view = new MarbleSolitaireTextView(null, this.ap);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullApMock() {
    this.view = new MarbleSolitaireTextView(this.mockModel, null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullModelStateMock() {
    this.view = new MarbleSolitaireTextView(null, this.mockOut);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullAp() {
    this.view = new MarbleSolitaireTextView(this.model, null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorBothNull() {
    this.view = new MarbleSolitaireTextView(null, null);
  }

  @Test(expected = IllegalStateException.class)
  public void testCorruptAppendableBoard() throws IOException {
    MarbleSolitaireView view = new MarbleSolitaireTextView(this.mockModel, this.mockOut);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(this.mockModel,
            view, this.in);
    controller.playGame();
  }

  @Test(expected = IllegalStateException.class)
  public void testCorruptAppendableMessage() throws IOException {
    MarbleSolitaireView view = new MarbleSolitaireTextView(this.mockModel, this.mockOut);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(this.mockModel,
            view, this.in);
    controller.playGame();
  }


  @Test
  public void testToString() {
    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", euroView.toString());

    assertEquals("    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O", view.toString());

    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", euroView1.toString());

    assertEquals("    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O", view1.toString());

    // arm length 3 and empty slot at (0,2)
    assertEquals("    _ O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O", view3.toString());

    assertEquals("    _ O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", euroView3.toString());

    assertEquals("        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O _ O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O", view4.toString());

    assertEquals("        O O O O O\n" +
            "      O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O _ O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "      O O O O O O O\n" +
            "        O O O O O", euroView4.toString());

    // arm length 3 and empty slot at (0,4) expected
    assertEquals("    O O _\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O", view5.toString());

    assertEquals("    O O _\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", euroView5.toString());

    assertEquals("    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "O O O O _ O O\n"
            + "    O O O\n"
            + "    O O O", view6.toString());

    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ O O\n" +
            "  O O O O O\n" +
            "    O O O", euroView6.toString());

    assertEquals("            O O O O O O O\n"
            + "            O O O O O O O\n"
            + "            O O O O O O O\n"
            + "            O O O O O O O\n"
            + "            O O O O O O O\n"
            + "            O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O _ O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O\n"
            + "            O O O O O O O\n"
            + "            O O O O O O O\n"
            + "            O O O O O O O\n"
            + "            O O O O O O O\n"
            + "            O O O O O O O\n"
            + "            O O O O O O O", view7.toString());


    assertEquals("            O O O O O O O\n" +
            "          O O O O O O O O O\n" +
            "        O O O O O O O O O O O\n" +
            "      O O O O O O O O O O O O O\n" +
            "    O O O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O _ O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O O O O O O O\n" +
            "    O O O O O O O O O O O O O O O\n" +
            "      O O O O O O O O O O O O O\n" +
            "        O O O O O O O O O O O\n" +
            "          O O O O O O O O O\n" +
            "            O O O O O O O", euroView7.toString());

    assertEquals("                O O O O O O O O O\n"
            + "                O O O O O O O O O\n"
            + "                O O O O O O O O O\n"
            + "                O O O O O O O O O\n"
            + "                O O O O O O O O O\n"
            + "                O O O O O O O O O\n"
            + "                O O O O O O O O O\n"
            + "                O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O _ O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "                O O O O O O O O O\n"
            + "                O O O O O O O O O\n"
            + "                O O O O O O O O O\n"
            + "                O O O O O O O O O\n"
            + "                O O O O O O O O O\n"
            + "                O O O O O O O O O\n"
            + "                O O O O O O O O O\n"
            + "                O O O O O O O O O", view8.toString());


    assertEquals("                O O O O O O O O O\n" +
            "              O O O O O O O O O O O\n" +
            "            O O O O O O O O O O O O O\n" +
            "          O O O O O O O O O O O O O O O\n" +
            "        O O O O O O O O O O O O O O O O O\n" +
            "      O O O O O O O O O O O O O O O O O O O\n" +
            "    O O O O O O O O O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O _ O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "    O O O O O O O O O O O O O O O O O O O O O\n" +
            "      O O O O O O O O O O O O O O O O O O O\n" +
            "        O O O O O O O O O O O O O O O O O\n" +
            "          O O O O O O O O O O O O O O O\n" +
            "            O O O O O O O O O O O O O\n" +
            "              O O O O O O O O O O O\n" +
            "                O O O O O O O O O", euroView8.toString());

    assertEquals("                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O _ O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O", view9.toString());

    assertEquals("                    O O O O O O O O O O O\n" +
            "                  O O O O O O O O O O O O O\n" +
            "                O O O O O O O O O O O O O O O\n" +
            "              O O O O O O O O O O O O O O O O O\n" +
            "            O O O O O O O O O O O O O O O O O O O\n" +
            "          O O O O O O O O O O O O O O O O O O O O O\n" +
            "        O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "      O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "    O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "    O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "      O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "        O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "          O O O O O O O O O O O O O O O O O O O O O\n" +
            "            O O O O O O O O O O O O O O O O O O O\n" +
            "              O O O O O O O O O O O _ O O O O O\n" +
            "                O O O O O O O O O O O O O O O\n" +
            "                  O O O O O O O O O O O O O\n" +
            "                    O O O O O O O O O O O", euroView9.toString());

    model9.move(29, 18, 27, 18);
    euroModel9.move(29,18,27,18);

    assertEquals("                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O _ O O\n"
            + "                    O O O O O O O O _ O O\n"
            + "                    O O O O O O O O O O O", view9.toString());

    assertEquals("                    O O O O O O O O O O O\n" +
            "                  O O O O O O O O O O O O O\n" +
            "                O O O O O O O O O O O O O O O\n" +
            "              O O O O O O O O O O O O O O O O O\n" +
            "            O O O O O O O O O O O O O O O O O O O\n" +
            "          O O O O O O O O O O O O O O O O O O O O O\n" +
            "        O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "      O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "    O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "    O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "      O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "        O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "          O O O O O O O O O O O O O O O O O O O O O\n" +
            "            O O O O O O O O O O O O O O O O O O O\n" +
            "              O O O O O O O O O O O O O O O O O\n" +
            "                O O O O O O O O O O _ O O O O\n" +
            "                  O O O O O O O O O _ O O O\n" +
            "                    O O O O O O O O O O O", euroView9.toString());

    // arm length 3 and empty slot at (2,6)
    MarbleSolitaireModel m = new EnglishSolitaireModel(2, 6);
    MarbleSolitaireTextView t = new MarbleSolitaireTextView(m);
    assertEquals("    O O O\n"
            + "    O O O\n"
            + "O O O O O O _\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O", t.toString());

    // arm length 3 and empty slot at (2,6)
    MarbleSolitaireModel euroM = new EuropeanSolitaireModel(2, 6);
    MarbleSolitaireTextView euroT = new MarbleSolitaireTextView(m);
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O _\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", t.toString());

  }

  @Test
  public void testRenderBoard() throws IOException {
    this.view = new MarbleSolitaireTextView(this.model, this.ap);
    this.model4 = new EnglishSolitaireModel(2, 4);
    this.model5 = new EnglishSolitaireModel(5);
    this.model6 = new EnglishSolitaireModel(5, 4, 4);
    this.view1 = new MarbleSolitaireTextView(this.model5, this.ap2);
    this.view3 = new MarbleSolitaireTextView(this.model4, this.ap3);
    this.view6 = new MarbleSolitaireTextView(this.model6, this.ap4);

    this.euroView = new MarbleSolitaireTextView(this.euroModel, this.euroAp);
    this.euroModel4 = new EuropeanSolitaireModel(2, 4);
    this.euroModel5 = new EuropeanSolitaireModel(5);
    this.euroModel6 = new EuropeanSolitaireModel(5, 4, 4);
    this.euroView1 = new MarbleSolitaireTextView(this.euroModel5, this.euroAp2);
    this.euroView3 = new MarbleSolitaireTextView(this.euroModel4, this.euroAp3);
    this.euroView6 = new MarbleSolitaireTextView(this.euroModel6, this.euroAp4);


    assertEquals("", ap.toString());
    assertEquals("", ap2.toString());
    assertEquals("", ap3.toString());
    // first, check that the board is added to the appendable correctly
    this.view.renderBoard();
    this.model.move(3, 1, 3, 3);
    this.view.renderMessage("\n");
    this.view.renderBoard();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", ap.toString());


    // european
    assertEquals("", euroAp.toString());
    assertEquals("", euroAp2.toString());
    assertEquals("", euroAp3.toString());
    // first, check that the board is added to the appendable correctly
    this.euroView.renderBoard();
    this.euroModel.move(3, 1, 3, 3);
    this.euroView.renderMessage("\n");
    this.euroView.renderBoard();
    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", euroAp.toString());

    //custom empty
    this.view3.renderBoard();
    this.model4.move(0, 4, 2, 4);
    this.view3.renderMessage("\n");
    this.view3.renderBoard();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O _ O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "    O O _\n" +
            "    O O _\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", ap3.toString());

    //custom empty euro
    this.euroView3.renderBoard();
    this.euroModel4.move(0, 4, 2, 4);
    this.euroView3.renderMessage("\n");
    this.euroView3.renderBoard();
    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O _ O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "    O O _\n" +
            "  O O O _ O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", euroAp3.toString());

    //a=5
    this.view1.renderBoard();
    this.model5.move(6, 4, 6, 6);
    this.view1.renderMessage("\n");
    this.view1.renderBoard();
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
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O _ _ O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O", ap2.toString());


    //a=5 euro
    this.euroView1.renderBoard();
    this.euroModel5.move(6, 4, 6, 6);
    this.euroView1.renderMessage("\n");
    this.euroView1.renderBoard();
    assertEquals("        O O O O O\n" +
            "      O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O _ O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "      O O O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "      O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O _ _ O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "      O O O O O O O\n" +
            "        O O O O O", euroAp2.toString());

    // a=5, custom empty
    this.view6.renderBoard();
    this.view6.renderMessage("\n");
    this.view6.renderBoard();
    this.model6.move(4, 2, 4, 4);
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
            "        O O O O O", ap4.toString());

    // a=5, custom empty euro
    this.euroView6.renderBoard();
    this.euroView6.renderMessage("\n");
    this.euroView6.renderBoard();
    this.euroModel6.move(4, 2, 4, 4);
    assertEquals("        O O O O O\n" +
            "      O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "O O O O _ O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "      O O O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "      O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "O O O O _ O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "      O O O O O O O\n" +
            "        O O O O O", euroAp4.toString());
  }

  @Test
  public void testRenderMessage() throws IOException {
    this.view = new MarbleSolitaireTextView(this.model, this.ap);
    this.view.renderMessage("\n" + "Make a move.");
    this.view.renderMessage("\n");
    this.view.renderMessage("\n");
    this.view.renderMessage("Hi how are you there are more tests below wow lol");
    this.view.renderMessage("\n" + "o8u42u8952kjhfshks");
    this.view.renderMessage("\n" + "!@#$%^&*(");

    assertEquals("\n" +
            "Make a move.\n" +
            "\n" +
            "Hi how are you there are more tests below wow lol\n" +
            "o8u42u8952kjhfshks\n" +
            "!@#$%^&*(", ap.toString());


    this.euroView = new MarbleSolitaireTextView(this.euroModel, this.euroAp);
    this.euroView.renderMessage("\n" + "Make a move.");
    this.euroView.renderMessage("\n");
    this.euroView.renderMessage("\n");
    this.euroView.renderMessage("Hi how are you there are more tests below wow lol");
    this.euroView.renderMessage("\n" + "othis is a test for european");
    this.euroView.renderMessage("\n" + "!@#$%^&*( 893274728487243");

    assertEquals("\n" +
            "Make a move.\n" +
            "\n" +
            "Hi how are you there are more tests below wow lol\n" +
            "othis is a test for european\n" +
            "!@#$%^&*( 893274728487243", euroAp.toString());
  }

  @Test
  public void testRenderBoardAndMessage() throws IOException {
    this.view = new MarbleSolitaireTextView(this.model, this.ap);
    this.model4 = new EnglishSolitaireModel(2, 4);
    this.model5 = new EnglishSolitaireModel(5);
    this.view1 = new MarbleSolitaireTextView(this.model5, this.ap2);
    this.view3 = new MarbleSolitaireTextView(this.model4, this.ap3);

    this.euroView = new MarbleSolitaireTextView(this.euroModel, this.euroAp);
    this.euroModel4 = new EuropeanSolitaireModel(2, 4);
    this.euroModel5 = new EuropeanSolitaireModel(5);
    this.euroView1 = new MarbleSolitaireTextView(this.euroModel5, this.euroAp2);
    this.euroView3 = new MarbleSolitaireTextView(this.euroModel4, this.euroAp3);

    assertEquals("", ap.toString());
    // first, check that the board is added to the appendable correctly
    this.view.renderBoard();
    assertEquals("    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O", ap.toString());

    // then, check that the messages are added to the appendable correctly
    this.view.renderMessage("\n" + "Make a move.");
    assertEquals("    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O" + "\n"
            + "Make a move.", ap.toString());


    assertEquals("", euroAp.toString());
    // first, check that the board is added to the appendable correctly
    this.euroView.renderBoard();
    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", euroAp.toString());

    // then, check that the messages are added to the appendable correctly
    this.euroView.renderMessage("\n" + "Make a move.");
    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Make a move.", euroAp.toString());

    // for custom empty
    this.view3.renderMessage("THIS IS ME TESTING THE RENDERING OF MY MESSAGES.!456");
    assertEquals("THIS IS ME TESTING THE RENDERING OF MY MESSAGES.!456", ap3.toString());
    this.view3.renderBoard();
    this.view3.renderMessage("\n");
    assertEquals("THIS IS ME TESTING THE RENDERING OF MY MESSAGES.!456    O O O\n" +
            "    O O O\n" +
            "O O O O _ O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n", ap3.toString());

    // for custom empty euro
    this.euroView3.renderMessage("THIS IS ME TESTING THE RENDERING OF MY MESSAGES.!456");
    assertEquals("THIS IS ME TESTING THE RENDERING OF MY MESSAGES.!456", euroAp3.toString());
    this.euroView3.renderBoard();
    this.euroView3.renderMessage("\n");
    assertEquals("THIS IS ME TESTING THE RENDERING OF MY MESSAGES.!456    O O O\n" +
            "  O O O O O\n" +
            "O O O O _ O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n", euroAp3.toString());

    // now, do the same for a larger board but display message before
    this.view1.renderMessage("HI!");
    this.view1.renderMessage("\n");
    this.view1.renderBoard();
    assertEquals("HI!\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O _ O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O", ap2.toString());

    this.view1.renderMessage("\n" + "Make a move.");
    assertEquals("HI!\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O _ O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O" + "\n"
            + "Make a move.", ap2.toString());


    // now, do the same for a larger board but display message before IN EURO
    this.euroView1.renderMessage("HI!");
    this.euroView1.renderMessage("\n");
    this.euroView1.renderBoard();
    assertEquals("HI!\n" +
            "        O O O O O\n" +
            "      O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O _ O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "      O O O O O O O\n" +
            "        O O O O O", euroAp2.toString());

    this.euroView1.renderMessage("\n" + "Make a move.");
    assertEquals("HI!\n" +
            "        O O O O O\n" +
            "      O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O _ O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "      O O O O O O O\n" +
            "        O O O O O\n" +
            "Make a move.", euroAp2.toString());
  }
}
