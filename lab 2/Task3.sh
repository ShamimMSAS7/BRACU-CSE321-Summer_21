#!/bin/bash
echo "Enter a number"
read num

prime_check(){
  n=$num
  if [[ $n -eq 1  || $n -eq 0 ]]
  	then echo "$num is not a Happy Prime number"
  else
  	for((i=2; i<=$n/2; i++))
  	do
  		m=$(($n%$i))
  		if [ $m -eq 0 ];
  			then echo "$num is not a Happy Prime number"
  			exit
  		fi
  	done
  	
	declare -a arr
  	happy_check
  fi
}

happy_check(){
	sum=0
	rem=0
	while [ $n -ne 0 ];
	do 
		rem=$(($n%10))
		sum=$(($sum+$rem*$rem))
		n=$(($n/10))	
	done
	
	if [ $sum -eq 1 ];
		then echo "$num is a Happy Prime number"
	else
		for i in ${arr[@]}
		do
			if [ $sum -eq $i ];
				then echo "$num is not a Happy Prime number"
	  			exit
	  		fi
	  	done
	  	
	  	n=$sum
	  	arr+=($sum)
	  	happy_check
	fi
}

prime_check
