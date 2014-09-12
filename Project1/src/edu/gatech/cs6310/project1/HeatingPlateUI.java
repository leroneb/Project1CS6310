package edu.gatech.cs6310.project1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.text.MaskFormatter;

import edu.gatech.cs6310.factories.HeatingPlateFactory;

/**
 * A class that demonstrates how to draw temperature grids in Java. Displays a
 * square grid in which the cells are painted with a random intensity of the
 * Color red.
 * 
 * -- Just some quick hackage to this to make it render a matrix for a heating 
 * plate simulation.  (ers)
 * 
 * @author Spencer Rugaber, January, 2009
 */
public class HeatingPlateUI extends JPanel implements MatrixObserver {
	double[][] currentModelData = new double[1][1];

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
	 * X-coordinate of the upper left hand corner of the rectangle within the
	 * containing widget
	 */
	private int ulhcX;

	/**
	 * Y-coordinate of the upper left hand corner of the rectangle within the
	 * containing widget
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
	
	private int cellSize=0;
	
	private int matrixRowsColumns=1;

	/**
	 * Some Strings used in the UI - normally would put in a properties file
	 * but let's not get crazy here.. hah. ers
	 * 
	 */
	private String PRIMITIVE_FLOATING_POINT="Primitive Floating Point";
	private String PRIMITIVE_DOUBLE="Primitive Double";
	private String PRIMITIVE_FLOAT_WRAPPED="Primitive Float (Wrapped)";
	private String OBJECTS="Objects";
	/**
	 * Default constructor will use constants in this file to initialize
	 * height/width
	 */
	public HeatingPlateUI( ) {
		ulhcX = BORDER_SIZE;
		ulhcY = BORDER_SIZE;
		width = WINDOW_SIZE;
		height = WINDOW_SIZE;
	}
	
	/**
	 * Creates a DrawnGrid, which is a displayable rectangle. All units are in
	 * pixels.
	 * 
	 * @param x
	 *            X coordinate of the upper left hand corner of the rectangle
	 *            within the containing widget
	 * @param y
	 *            Y coordinate of the upper left hand corner of the rectangle
	 *            within the containing widget
	 * @param w
	 *            width of the rectangle
	 * @param h
	 *            height of the rectangle
	 */
	public HeatingPlateUI(int x, int y, int w, int h) {
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
	 * @param aGraphics
	 *            Graphics into which painting will be done
	 * @param row
	 *            row number of the grid cell
	 * @param col
	 *            column number of the grid cell
	 * @param t
	 *            intensity of Color red to be painted; a number from 0.0 to 1.0
	 */
	private void paintSpot(Graphics aGraphics, int row, int col, double t) {
		int rowPos = ulhcY + row * cellSize;
		int colPos = ulhcX + col * cellSize;

		// Overwrite everything that was there previously
		aGraphics.setColor(Color.black);
		aGraphics.fillRect(colPos, rowPos, cellSize, cellSize);

		// Color in RGB format with green and blue values = 0.0
		aGraphics.setColor(new Color((float) t, 0f, 0f));
		aGraphics.fillRect(colPos, rowPos, cellSize, cellSize);

		// System.out.println( "Paint spot " );
	}

	/**
	 * Informs Swing how to render in terms of subcomponents.
	 * 
	 * @param aGraphics
	 *            Graphics - Graphs context for drawing
	 * @override paintComponent in JPanel
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	protected void paintComponent(Graphics aGraphics) {
		super.paintComponent(aGraphics);

		BufferedImage bi = new BufferedImage(getWidth(), getHeight(),
				BufferedImage.TYPE_INT_ARGB);
		Graphics anotherGraphics = bi.createGraphics();
		for (int i = 0; i < matrixRowsColumns; i++) {
			for (int j = 0; j < matrixRowsColumns; j++) {
				// Instead of calling random, here is where you
				// would insert the call that would provide
				// the temperature of the corresponding cell
				// on the heated plate.
				paintSpot(anotherGraphics, i, j, currentModelData[i][j] / 100);
			}
		}

		aGraphics.drawImage(bi, 0, 0, this);
	}

	private Timer timer = null;
	private JFrame jf = new JFrame();
	final static String[] options = new String[101];
	static {
		for( int counter=0; counter <= 100; counter++ ) {
			options[counter] = String.valueOf( counter );
		}
	}

	JButton runButton = new JButton("Run");
	JTextField matrixSize = new JTextField();//createFormatter("#####"));
	String[] algoOptions =  { PRIMITIVE_DOUBLE, PRIMITIVE_FLOATING_POINT, PRIMITIVE_FLOAT_WRAPPED, OBJECTS };
	JComboBox algoComboBox = new JComboBox( algoOptions );

	public void displayJFrame() {
		jf.setTitle("Heating Plate demo");
		
		JPanel runPanel = new JPanel( );
		runButton.setBounds(0,  0,  100,  100);
		runPanel.add(runButton);
		
		JPanel myPanel = new JPanel( new BorderLayout());
		JPanel optionsPanel = new JPanel( new GridLayout( 5, 1, 10, 10) );
		optionsPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
		
		JPanel temperaturePanel = new JPanel( );
		temperaturePanel.setLayout(new GridLayout(2, 2, 10, 10));
		
		final JComboBox topTemperature = new JComboBox( options );
		topTemperature.setSelectedItem( "75" );
		JLabel topText = new JLabel( "Top" );
		final JComboBox bottomTemperature = new JComboBox( options );
		JLabel bottomText = new JLabel( "Bottom" );
		bottomTemperature.setSelectedItem( "75" );
		final JComboBox leftTemperature = new JComboBox( options );
		JLabel leftText = new JLabel( "Left" );
		leftTemperature.setSelectedItem( "75" );
		final JComboBox rightTemperature = new JComboBox( options );
		JLabel rightText = new JLabel( "Right" );
		rightTemperature.setSelectedItem( "75" );

		temperaturePanel.add( topText, BorderLayout.NORTH); 
		temperaturePanel.add( topTemperature, BorderLayout.NORTH);
		temperaturePanel.add( bottomText, BorderLayout.NORTH); 
		temperaturePanel.add( bottomTemperature, BorderLayout.NORTH);
		temperaturePanel.add( leftText, BorderLayout.NORTH); 
		temperaturePanel.add( leftTemperature, BorderLayout.NORTH);
		temperaturePanel.add( rightText, BorderLayout.NORTH); 
		temperaturePanel.add( rightTemperature, BorderLayout.NORTH);
		temperaturePanel.add(this, BorderLayout.CENTER);

		JLabel temperatureLabel = new JLabel( "Initial Edge Temperatures" );
		temperatureLabel.setHorizontalTextPosition(SwingConstants.CENTER);

		optionsPanel.add( temperatureLabel );
		optionsPanel.add( temperaturePanel);
		
		JPanel matrixSizePanel = new JPanel( new GridLayout( 2, 1, 10, 10) );
		JLabel matrixSizeLabel = new JLabel( "Size of Matrix (Integer)" );
		matrixSizePanel.add( matrixSizeLabel );
		matrixSizePanel.add( matrixSize );
		
		JPanel algoTypePanel = new JPanel( new GridLayout( 2, 1, 10, 10 ));
		algoTypePanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
		JLabel algoLabel = new JLabel( "Pick an Algorithm" );
		algoLabel.setHorizontalTextPosition(SwingConstants.CENTER);

		algoTypePanel.add( algoLabel );
		algoTypePanel.add( algoComboBox );
		
		optionsPanel.add( algoTypePanel );
		optionsPanel.add( matrixSizePanel );
		
		
		runButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Integer.parseInt( matrixSize.getText());
				} catch( Exception e0 ) {
					// Default size if a valid one isn't provided
					matrixSize.setText( "3" );
				}
				// Make sure we start on the appropriate thread so that repaints occur!
				new Thread() {
					public void run() {
						// Could separate program types out into it's own class/file
						// Primitive double is the default
						HeatingPlateFactory.PROGRAM_TYPES programType = HeatingPlateFactory.PROGRAM_TYPES.PRIMITIVE_DOUBLE;
						
						System.out.println( "Selected >> " + algoComboBox.getSelectedItem());
						
						// Move strings into constants
						if( algoComboBox.getSelectedItem().toString().equals( PRIMITIVE_FLOATING_POINT )) {
							programType = HeatingPlateFactory.PROGRAM_TYPES.PRIMITIVE_FLOAT;							
						} else if( algoComboBox.getSelectedItem().toString().equals( PRIMITIVE_FLOAT_WRAPPED )) {
							programType = HeatingPlateFactory.PROGRAM_TYPES.WRAPPED_FLOAT;														
						} else if( algoComboBox.getSelectedItem().toString().equals( OBJECTS )) {
							programType = HeatingPlateFactory.PROGRAM_TYPES.OBJECT;
						} 

						HeatingPlateModel currentModel = HeatingPlateFactory.getInstance( ).getHeatingPlate(programType);
								
						currentModel.register(HeatingPlateUI.this);
						
						setupUI(Integer.parseInt(matrixSize.getText()));
						currentModel.runModel(Integer.parseInt(topTemperature.getSelectedItem().toString()), 
								Integer.parseInt(bottomTemperature.getSelectedItem().toString()), 
								Integer.parseInt(leftTemperature.getSelectedItem().toString()), 
								Integer.parseInt(rightTemperature.getSelectedItem().toString()), 
								Integer.parseInt(matrixSize.getText()));
					}
				}.start();
			}
		});

		myPanel.add( this, BorderLayout.CENTER );
		myPanel.add( optionsPanel, BorderLayout.EAST );
		myPanel.add( runPanel, BorderLayout.SOUTH);

		jf.add( myPanel );
		jf.pack();
		jf.setVisible(true);

		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * Always an NxN matrix where N is matrixSize
	 * 
	 * @param matrixSize
	 */
	private void setupUI( int matrixSize ) {
		// Matrix here is defined as the inner matrix of the heating plate :: doesn't include
		// the edges.  This is a bit hackish
		matrixRowsColumns=matrixSize+2;
		cellSize=GRID_SIZE / (matrixSize+2);
	}
	
	private MaskFormatter createFormatter(String s) {
	    MaskFormatter formatter = null;
	    try {
	        formatter = new MaskFormatter(s);
	    } catch (java.text.ParseException exc) {
	        System.err.println("formatter is bad: " + exc.getMessage());
	    }
	    return formatter;
	}


	@Override
	public void receiveUpdate(double[][] myData) {
		currentModelData = myData;
		jf.repaint();

		try {
			// Simple pause
			Thread.sleep(50);
		} catch (Exception e0) {

		}
	}
	
	public void updatesComplete( ) {
		runButton.setEnabled(true);
	}
}