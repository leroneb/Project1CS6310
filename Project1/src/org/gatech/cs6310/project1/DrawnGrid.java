package org.gatech.cs6310.project1;

import javax.swing.JPanel;
import javax.swing.JFrame;

import Tpdahp.HeatingPlatePrimitiveDouble;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.lang.Math;

/**
 * A class that demonstrates how to draw temperature grids in Java.
 * Displays a square grid in which the cells are painted with
 *   a random intensity of the Color red.
 * 
 * @author Spencer Rugaber, January, 2009
 */
public class DrawnGrid extends JPanel implements MatrixObserver {
	double[][] currentModelData = new double[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
	
	   /**
     * Number of rows of cells in the DrawnGrid 
     */
    private static final int NUMBER_OF_ROWS = 10;
    
    /**
     * Number of cells in a row 
     */
    private static final int NUMBER_OF_COLUMNS = 10;
    
 
    /**
     * Creates a DrawnGrid, which is a displayable rectangle.  
     * All units are in pixels.
     *
     * @param x X coordinate of the upper left hand corner of the
     *                 rectangle within the containing widget
     * @param y Y coordinate of the upper left hand corner of the
     *                 rectangle within the containing widget
     * @param w width of the rectangle
     * @param h height of the rectangle
     */
    public DrawnGrid(int x, int y, int w, int h) {
        ulhcX = x;
        ulhcY = y;
        width = w;
        height = h;
    }

    /**
     * Informs Swing of how much space is needed for drawing.
     * 
     * @return Dimension - the size of the drawing area
     * @override getPreferredSize in JPanel
     * @see javax.swing.JComponent#getPreferredSize()
     */
    public Dimension getPreferredSize() {
        return new Dimension(width, height);
    }
    
    /**
     * Paints one cell of the grid.
     *
     * @param aGraphics Graphics into which painting will be done
     * @param row row number of the grid cell
     * @param col column number of the grid cell
     * @param t intensity of Color red to be painted; a number from 0.0 to 1.0
     */
    private void paintSpot(Graphics aGraphics, int row, int col, double t) {
        int rowPos = ulhcY + row * CELL_HEIGHT;
        int colPos = ulhcX + col * CELL_WIDTH;

        // Overwrite everything that was there previously
        aGraphics.setColor(Color.black);
        aGraphics.fillRect(colPos, rowPos, CELL_WIDTH, CELL_HEIGHT);
        
        // Color in RGB format with green and blue values = 0.0
        aGraphics.setColor(new Color((float) t, 0f, 0f));    
        aGraphics.fillRect(colPos, rowPos, CELL_WIDTH, CELL_HEIGHT);
        
        System.out.println( "Paint spot " );
    }

    /**
     * Informs Swing how to render in terms of subcomponents.
     * @param aGraphics Graphics - Graphs context for drawing
     * @override paintComponent in JPanel
     * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
     */
    protected void paintComponent(Graphics aGraphics) {
        super.paintComponent(aGraphics);
        
        BufferedImage bi = new BufferedImage(getWidth(), getHeight(),
                BufferedImage.TYPE_INT_ARGB);
        Graphics anotherGraphics = bi.createGraphics();

        for (int i = 0; i < NUMBER_OF_ROWS; i++) {
            for (int j = 0; j < NUMBER_OF_COLUMNS; j++) {
                // Instead of calling random, here is where you
                //   would insert the call that would provide
                //   the temperature of the corresponding cell
                //   on the heated plate.
                paintSpot(anotherGraphics, i, j, currentModelData[i][j]/100);
System.out.println( "curren model data is " + currentModelData[i][j] );
            }
    }
        System.out.println( "paint component called" );
        
        aGraphics.drawImage(bi, 0, 0, this);
   }
    
    /**
     * Calling routine for DrawnGrid demo
     * @param args unused
     */
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setTitle("Java Drawing Demo");

        DrawnGrid myGrid = new DrawnGrid(BORDER_SIZE, BORDER_SIZE, 
                             WINDOW_SIZE, WINDOW_SIZE);

        jf.add( myGrid );
        jf.pack();   
        jf.setVisible(true);        
        
 try {
        Thread.sleep( 4000 );
 } catch( Exception e0 ) { }
 
		HeatingPlatePrimitiveDouble currentModel = new HeatingPlatePrimitiveDouble( );
		currentModel.register(myGrid);
		currentModel.runModel( 100, 0, 75, 25, NUMBER_OF_ROWS );

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    /**
     * Size of the containing window in pixels
     */
    private final static int WINDOW_SIZE = 400;
    
    /**
     * Amount of border space around the DrawnGrid in pixels
     */
    private final static int BORDER_SIZE = 50;

    /**
     * Height and width of the DrawnGrid in pixels 
     */
    private final static int GRID_SIZE = WINDOW_SIZE - 2 * BORDER_SIZE;
    
    /**
     * The height of a cell in pixels 
     */
    private static final int CELL_HEIGHT = GRID_SIZE / NUMBER_OF_COLUMNS;

    /**
     * The width of a cell in pixels
     */
    private static final int CELL_WIDTH = GRID_SIZE / NUMBER_OF_ROWS;

    /**
     * X-coordinate of the upper left hand corner of the rectangle
     *     within the containing widget
     */    
    private int ulhcX;
    
    /**
     * Y-coordinate of the upper left hand corner of the rectangle
     *     within the containing widget
     */
    private int ulhcY;
    
    /**
     * Width of the rectangle in pixels
     */
    private int width;
    
    /** 
     * Height of the rectangle in pixels
     */
    private int height;

	@Override
	public void receiveUpdate(double[][] myData) {
		System.out.println( "model update" );
		currentModelData = myData;
		repaint();
		try {
			Thread.sleep( 20 );
		} catch( Exception e0 ) {
			
		}
	}
}