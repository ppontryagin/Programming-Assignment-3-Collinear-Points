# Programming-Assignment-3-Collinear-Points
Write a program to recognize line patterns in a given set of points.

## APIs. 
Each program should take the name of an input file as a command-line argument, read the input file 
(in the format specified below), print to standard output the line segments discovered (in the format specified below), 
and draw to standard draw the line segments discovered (in the format specified below). Here are the APIs

```
  public class Brute {
     public static void main(String[] args)
  }
  
public class Fast {
   public static void main(String[] args)
}
```

## Input format. 
Read the points from an input file in the following format: An integer N, followed by N pairs of integers (x, y), 
each between 0 and 32,767. Below are two examples.

```
% more input6.txt       % more input8.txt
6                       8
19000  10000             10000      0
18000  10000                 0  10000
32000  10000              3000   7000
21000  10000              7000   3000
 1234   5678             20000  21000
14000  10000              3000   4000
                         14000  15000
                          6000   7000
```

## Output format. 
Print to standard output the line segments that your program discovers, one per line. 
Print each line segment as an ordered sequence of its constituent points, separated by " -> ".

```
% java Brute input6.txt
(14000, 10000) -> (18000, 10000) -> (19000, 10000) -> (21000, 10000)
(14000, 10000) -> (18000, 10000) -> (19000, 10000) -> (32000, 10000)
(14000, 10000) -> (18000, 10000) -> (21000, 10000) -> (32000, 10000)
(14000, 10000) -> (19000, 10000) -> (21000, 10000) -> (32000, 10000)
(18000, 10000) -> (19000, 10000) -> (21000, 10000) -> (32000, 10000)

% java Brute input8.txt
(10000, 0) -> (7000, 3000) -> (3000, 7000) -> (0, 10000) 
(3000, 4000) -> (6000, 7000) -> (14000, 15000) -> (20000, 21000) 

% java Fast input6.txt
(14000, 10000) -> (18000, 10000) -> (19000, 10000) -> (21000, 10000) -> (32000, 10000) 

% java Fast input8.txt
(10000, 0) -> (7000, 3000) -> (3000, 7000) -> (0, 10000)
(3000, 4000) -> (6000, 7000) -> (14000, 15000) -> (20000, 21000)
```
