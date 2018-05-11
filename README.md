# Captivation Software Developer Challenge

## Your Task
Develop an application that:
- Reads a stream of input characters consisting of only the character '1' and '0' from STDIN,
- Decodes input characters into a single, zero-padded ASCII equivalent (e.g. "01000011" decodes to 'C')
- Searches the decoded message for the preamble string "CAPTIVATION", and once found, prints the next one hundred decoded characters to STDOUT

## Guidelines:
- The input stream is to be treated as if it is never-ending
- The input stream will only ever consist of combinations of the character '1' or '0', no input validation is required
- The encoded preamble string may be preceded by an arbitrary number of characters, and is not guaranteed to start at position 0.
- Multiple messages may occur within the same input stream, and the number of characters between messages is random
- Nothing else should be printed to STDOUT, only the one hundred characters following the preamble string "CAPTIVATION"

## Rules
- This solution will be tested by an automated tool, so failure to adhere to this spec precisely will produce a failing result 
- Your solution should include instructions on how to run/build via Linux command line (or even better, be Docker-compatible)
- Your solution will be judged for correctness, performance, and style
- You may use any language you'd like, but you can only use standard libraries

## STDOUT Generator
A reference data generator is provided at https://hub.docker.com/r/captivation/ascii-generator/:
```bash
#!/bin/bash
docker run -i captivation/ascii-generator > test.txt 
```
**Careful:** The ascii-generator should be piped to a file/executable as printing directly into the terminal may cause the terminal to become unresponsive. 
