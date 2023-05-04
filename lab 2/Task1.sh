#!/bin/bash

echo "Enter an ID:"
read id
num=$id
count=0

while [ $num -ne 0 ]
do
	num=$(($num/10))
	count=$(($count+1))
done	


if [ $count -eq 8 ];
  then 
  	n=$id
  	n=$(($n/1000))
  	dept=$(($n%100))
  	if [ $dept -eq 1 ];
  		then n=$(($n/100))
  		sem=$(($n%10))
  		n=$(($n/10))
  		year=$n
  		case $sem in
   		1) echo "The student is from the Dept. of CSE enrolled in Spring 20$year.";;
  		2) echo "The student is from the Dept. of CSE enrolled in Fall 20$year.";;
 		3) echo "The student is from the Dept. of CSE enrolled in Summer 20$year.";;
  		*) echo "Invalid BRACU ID";;
		esac
	else
		echo "The student is not from the Dept. of CSE."
  	fi
  	

else
  echo "Invalid BRACU ID"
fi
