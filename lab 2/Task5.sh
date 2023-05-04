#!/bin/bash

echo "Enter Operation"
read operation

echo "Enter Operand1: "
read operand1

echo "Enter Operand2: "
read operand2

case $operation in 
 "+") result=$(($operand1+$operand2));;
 "-") result=$(($operand1-$operand2));;
 "*") result=$(($operand1*$operand2));;
 "/") result=$(($operand1/$operand2));;
esac 
echo "The result is $result"
