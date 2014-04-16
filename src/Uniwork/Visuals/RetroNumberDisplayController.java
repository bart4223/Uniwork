package Uniwork.Visuals;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

public class RetroNumberDisplayController extends ShapeDisplayController{

    private static final byte[] CNUMBERS = new byte[] {
            (byte)0X7C, (byte)0XCE, (byte)0XCE, (byte)0XCE, (byte)0XCE, (byte)0XCE, (byte)0XCE, (byte)0X7C,  // 0
            (byte)0X1C, (byte)0X3C, (byte)0X7C, (byte)0XDC, (byte)0X1C, (byte)0X1C, (byte)0X1C, (byte)0X1C,  // 1
            (byte)0X7C, (byte)0XCE, (byte)0X8E, (byte)0X0E, (byte)0X1C, (byte)0X30, (byte)0X60, (byte)0XFE,  // 2
            (byte)0X7C, (byte)0XCE, (byte)0X8E, (byte)0X38, (byte)0X0E, (byte)0X8E, (byte)0XCE, (byte)0X7C,  // 3
            (byte)0X18, (byte)0X30, (byte)0X60, (byte)0XC0, (byte)0XDC, (byte)0XFE, (byte)0X1C, (byte)0X1C,  // 4
            (byte)0XFE, (byte)0XC0, (byte)0XC0, (byte)0XFC, (byte)0X0E, (byte)0X0E, (byte)0X8E, (byte)0XFC,  // 5
            (byte)0X18, (byte)0X30, (byte)0X60, (byte)0XFC, (byte)0XCE, (byte)0XCE, (byte)0XCE, (byte)0X7C,  // 6
            (byte)0XFE, (byte)0X0E, (byte)0X0E, (byte)0X0C, (byte)0X18, (byte)0X18, (byte)0X30, (byte)0X60,  // 7
            (byte)0X7C, (byte)0XCE, (byte)0XCE, (byte)0X7C, (byte)0XCE, (byte)0XCE, (byte)0XCE, (byte)0X7C,  // 8
            (byte)0X7C, (byte)0XCE, (byte)0XCE, (byte)0XCE, (byte)0X7C, (byte)0X0C, (byte)0X18, (byte)0X70,  // 9
    };

    protected Color FNumberColor;
    protected int FNumber;

    @Override
    protected void DoRender() {
        byte[] number = getSubByteArrayFrom(CNUMBERS, 1, 8, FNumber%10);
        drawByteArray(number, 1, FNumberColor);
    }

    public RetroNumberDisplayController(Canvas aCanvas, String aName) {
        super(aCanvas, aName);
        FNumberColor = Color.BLACK;
        FNumber = 0;
    }

    public void setNumberColor(Color aValue) {
        FNumberColor = aValue;
    }

    public Color getNumberColor() {
        return FNumberColor;
    }

    public void setNumber(int aValue) {
        FNumber = aValue;
    }

    public int getNumber() {
        return FNumber;
    }

}
