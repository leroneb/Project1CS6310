PROJECT 1 : Ian Kerman, Leron Bleasdale, Gouri Guin, Ed Serzo 

Simulation of heat diffusion on a heated plate

There are five applications which can be run, four can be run without a head
(display), the fifth requires one.

	Twfahp.Demo -- Text interface, wrapped float array
	Tpfahp.Demo -- Text interface, floating point array
	Tpdahp.Demo -- Text interface, double array
	Tpdohp.Demo -- Text interface, double Object implementation
	Gallhp.demo -- Requires a display, displays a window and enables the user to 
		select from any of the previous demo programs and see a real-time
		visual representation of the model.
		
1> To compile : (windows) compile.bat
				(unix) compile.sh

2> To run : java <program name> <application options>

Where <program name> is one of the five above listed programs

<application options> (required) :
  -t <top of the plate temperature : Integer>
  -b <bottom of the plate temperature : Integer>
  -l <left of the plate temperature : Integer>
  -r <right of the plate temperature : Integer>
  -d <dimension of the internal lattice : Integer>
		Internal lattice is defined as everything in the plate, except for the borders
<application options> (not required) :
  -debug true
  	 For more verbose logging
  	 
Example :
  java Twfahp.Demo -t 100 -b 100 -l 100 -r 100 -d 3
  

Example output : 

  C:\Users\bonzo\git\Project1\src>java Twfahp.Demo -t 100 -b 0 -l 25 -r 50 -d 3
  
Running the model using wrapped Float array

100     100     100     100     100
25      57.14   66.74   66.07   50
25      36.83   43.75   47.54   50
25      21.43   23.88   30.36   50
0       0       0       0       0