#!/bin/bash

#Shell script to TEST code submitted by user
#TODO-SHRAJAN To be migrated to different service/workers to minimise risk of program attacking and executing commands on our main system

INPUT_FILE=$1
OUTPUT_FILE=$2
JAVA_FILE="Solution.java"
CLASS_NAME="Solution"
#COMPILED_CLASS="files/$CLASS_NAME.class"

# Compile the Java file
javac $JAVA_FILE 2> output.txt

# Check if compilation succeeded
if [ $? -eq 0 ]; then
  echo "Running program against inputs "
  java Solution < input.txt > output.txt 2>&1
  echo "Finished executing program"
else
  echo "Error while running program"
fi