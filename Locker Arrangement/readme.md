Problem Statement:  

1.	There will be ‘n’  number of people  (max value of  ‘n’ would be 100000. This is an input to the algorithm)
2.	Each person has ‘x’ money  (min value of ‘x’ is  1 rupee and max will be ‘100000 ‘. This is an input to the algorithm)
3.	We will have  ‘y’ number of safety lockers / boxes  (‘y’   is an input to your algorithm) 
i.	The maximum number of ‘y’ should be less than or equal to ‘n’ and minimum is ‘1’
4.	We need to store money of person’s in provided lockers
5.	One person money cannot be stored in multiple boxes
6.	The amount should be distributed equally to possible extent as depicted in below examples.

Expectations : 

1.	The result of algorithm should depict  which person’s money should be stored in which box 
2.	The algorithm should be able to use it in Java technology
3.	Processing time should be very minimal  3 Secs
4.	Optimal distribution of amount across lockers

Examples :

e:g 1: 

•	In  this example I considered  ‘n’  as 10  persons 
•	Their amount balances are 

Person 	Money 	Person 	Money 
P1	1	P6	3
P2	100	P7	2
P3	30	P8	40
P4	20	P9	6
P5	5	P10	7

    ‘Y’  - Number of lockers , I supply 3 .

So , the distribution would be .

Lockers 	Persons 	Money 
L1	P2(100) 	100
L2	P3 (30) , P4(20) , P9(6), P1(1)	57
L3	P6(3),P7(2),P10(7), P8 (40) , P5(5)	57

e:g 2:

•	In this example I considered  ‘n’  as 10  persons 
•	Their amount balances are 

Person 	Money 	Person 	Money 
P1	10	P6	10
P2	10	P7	10
P3	10	P8	10
P4	10	P9	150
P5	10	P10	100

    ‘Y’  - Number of lockers , I supply 3 .

So , the distribution would be .

Lockers 	Persons 	Money 
L1	P9(150) 	150
L2	P10(100)	100
L3	P1 to P8	80
