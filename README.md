# Cryptographer

## Prerequisites
* JDK 11 installed

## Instructions

* After cloning the repository, go to "src" folder: `...Cryptographer/src`
* Execute the following command to compile: `javac Cryptographer.java`
* Run the application with the command: `java Cryptographer **ARG1** **ARG2** **ARG3**`

**OBS:**
* **ARG1:** Use `D` or `C`. `D = decrypt` and `C = encrypt, but in portuguese`
* **ARG2:** If the ARG1 is "D", specify the encrypted file name: `encrypted.txt`. If the ARG1 is "C", specify the input file name(file that contains the text that should be encrypted): `input.txt`.
* **ARG3:** If the ARG1 is "D", specify the output file name: `output.txt`. If the ARG1 is "C", specify the encrypted file name: `encrypted.txt`.

* **Examples:**
  *`java Cryptographer C input.txt encrypted.txt`
  *`java Cryptographer D encrypted.txt output.txt`

**WARNING:**
You need to encrypt a file before decrypt it
