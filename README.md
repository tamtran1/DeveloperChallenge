# Captivation Software Developer Challenge

## Your Task
Develop an application that:
- Reads a stream of input characters consisting of only the character '1' and '0' from STDIN,
- Decodes every 8 input characters into a single, zero-padded ASCII equivalent (e.g. "01000011" decodes to 'C')
- Searches the decoded message for the string "CAPTIVATION", and once found, print the next 100 decoded characters to STDOUT

## Guidelines:
- The input will only ever consist of 1's and 0's, no input validation is required
- The input stream is to be treated as if it is never-ending
- Nothing else should be printed to STDOUT, only the 100 characters following the string "CAPTIVATION"
- This solution will be tested by an automated tool, so failure to adhere to this spec precisely will produce a failing result 
- Your solution should include instructions on how to run/build via Linux command line (or even better, be Docker-compatible)
- Your solution will be judged for correctness, performance, and style
- You may use any language you'd like, but you can only use standard libraries
