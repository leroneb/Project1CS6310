PROJECT 1 : Ian Kerman, Leron Bleasdale, Gouri Guin, Ed Serzo 

Simulation of heat diffusion on a heated plate

If you're wondering why I lowercase the readme files and uppercase all my 
class names with ES it's because I couldn't bring myself to lowercase 
class names and was willing to take points off for it (haha, yeah seriously).  

1> To compile : javac *.java

2> To run the program and generate an output file : java ES_rmatrix

Application options :
  -i <input file name>
  -o <output file name>

If no options are provided, the program uses es_input.txt from the directory
you run the application.  The output will be written to es_output.txt by default.

Example :
  java ES_rmatrix -i es_rmatrixi.txt -o es-rmatrixo.txt
  
Will run the program with es_rmatrixi.txt as the input file and es-rmatrixo.txt
as the output file

es_input.txt and es_output.txt have been included as sample input and output
files


Example output : 


       a      b      c      d      e      f      g      h      i      j      
-----------------------------------------------------------------------------
a    | -      b,33   c,10   c,33   b,54   c,34   c,53   b,89   c,98   c,95   
b    | a,33   -      d,36   d,13   e,21   d,60   d,33   e,56   d,78   d,75   
c    | a,10   d,36   -      d,23   d,57   f,24   d,43   d,92   d,88   d,85   
d    | c,33   b,13   c,23   -      b,34   c,47   g,20   b,69   g,65   g,62   
e    | b,54   b,21   b,57   b,34   -      g,57   g,17   h,35   g,62   g,59   
f    | c,34   c,60   c,24   c,47   g,57   -      g,40   g,92   i,72   g,82   
g    | d,53   d,33   d,43   d,20   e,17   f,40   -      e,52   i,45   j,42   
h    | e,89   e,56   e,92   e,69   e,35   e,92   e,52   -      e,97   j,38   
i    | g,98   g,78   g,88   g,65   g,62   f,72   g,45   g,97   -      j,83   
j    | g,95   g,75   g,85   g,62   g,59   g,82   g,42   h,38   i,83   -      



Please see the javadocs for additional information 


Total time spent - approximately 10.75 hours

  - Time that could have been done in :: probably two hours if I just went 
  with the down and dirty option.  I did know this in advance, but wanted to 
  give it a little more time since I felt it deserves it (and there are hundreds
  of quick and dirty implementations online)
  
readme file - 15 minutes

Application - 10 hours
	- Yep no kidding, I could have taken the easy route and just implemented
	the pseudocode in the book.  Would have been down & dirty, and probably
	ran faster (not that it's noticeable given a single program iteration and 
	the size of the data I used).  I choose to do a LITERAL implementation from 
	Dijkstra's original paper, as this is a pretty amazing algorithm that 
	he came up with.  Considering it's been over 50 years since he wrote it,
	and it's a computer science staple - felt it deserved more than just
	a quick and dirty write.  A little tribute to him, hah, he'd probably
	enjoy using objects versus procedural programming.
	
	The verbage in his paper was a little difficult to follow at first
		
Post review of requirements and testing - 30 minutes

Beautiful code is like a freshly baked chocolate chip cookie, just melts
in your mouth!  (though I'm not saying everything in here is beautiful,
I complain inside about my own code.. haha)
