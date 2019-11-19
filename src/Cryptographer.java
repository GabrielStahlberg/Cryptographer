import java.io.*;

public class Cryptographer {
    /**
     * Metodo que criptografa um texto,
     * utilizando a criptografia de Cesar.
     */
    public static String encrypt(int key, String text){
        StringBuilder encryptedText = new StringBuilder();
        int textSize = text.length();

        // Criptografa cada caracter por vez
        for(int c=0; c < textSize; c++){
            int encryptedLetterASCII = ((int) text.charAt(c)) + key;
            encryptedText.append( (char)encryptedLetterASCII );
        }
        return encryptedText.toString();
    }

    /**
     * Metodo que descriptografa um texto,
     * utilizando a criptografia Cesar.
     */
    public static String decrypt(int key, String encryptedText){
        StringBuilder text = new StringBuilder();
        int textSize = encryptedText.length();

        // Descriptografa cada caracter por vez
        for(int c=0; c < textSize; c++){
            int decryptedLetterASCII = ((int) encryptedText.charAt(c)) - key;
            text.append( (char)decryptedLetterASCII );
        }
        return text.toString();
    }

    public static String readFile(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("File/input.txt"));

            String row;
            String text = "";

            while ((row = br.readLine()) != null) {
                text = row;
            }
            return text;
        } catch ( IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void writeFile(String text, String file){
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;

        try{
            fileWriter = new FileWriter(file, false);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(text);
            bufferedWriter.newLine();
            bufferedWriter.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args){

        try {
            int key = 7;
            String text = readFile();

            System.out.println(text);

            // Criptografando
            String encryptedText = encrypt(key, text);

            // Descriptografando
            String decryptedText = decrypt(key, encryptedText);

            writeFile(encryptedText, "File/output.txt");

            System.out.println("\n\nTEXTO CRIPTOGRAFADO: " + encryptedText);
            System.out.println("TEXTO DESCRIPTOGRAFADO: " + decryptedText);

            System.out.println("*****************************************************");

        } catch (RuntimeException e) {
            System.out.println("A chave de deslocamento foi informada incorretamente.");
            System.out.println("Execute o programa novamente e entre com uma chave valida.");
        }
    }
}
