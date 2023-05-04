#!/bin/bash
echo "Enter your name:"
read name

for i in ./*.txt
do
  echo "$name" >> "$i"
done
