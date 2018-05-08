# Captivation Software Developer Challenge

## Your Task
Develop an application that prints a recurring message once its preamble pattern is found from an input stream of binary-encoded characters.

## Requirements
 - Read an arbitrarily long string from STDIN consisting only of the binary representation of ASCII characters 
    
     > Example: "01000011" should yield the character 'C'
   
 - Look for the equivalent of the string "CAPTIVATION" in the input stream, and once found, print the next 100 characters to STDOUT. 
   
     > Example Input: fooCAPTIVATIONbar baz
     >
     > Expected Output: bar baz
 
 - Do not write anything else to STDOUT, only the 100 characters following the string "CAPTIVATION"
 
 
## Guidelines:
 
 - Your solution should include instructions on how to run/build via Linux command line (or even better, be Docker-compatible)
 - Your solution will be judged for correctness, performance, and style
 - You may use any language you'd like, but you can only use standard libraries
 - No input validation is required
