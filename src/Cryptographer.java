import java.io.*;

public class Cryptographer {

    private static final int KEY = 7;

    /**
     * Metodo que criptografa um texto, utilizando a criptografia de Cesar.
     * @param key Quantidade de caracteres que deverá ser "pulado", na tabela ASCII, para que o mesmo seja substituído e com isso "esconder" o texto original
     * @param text Texto que deverá ser criptografado
     * @return Texto criptografado
     */
    private static String encrypt(int key, String text){
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
     * Metodo que descriptografa um texto, utilizando a criptografia Cesar.
     * @param key Quantidade de caracteres que deverá ser "pulado", na tabela ASCII, para que o mesmo seja substituído e com isso saber qual caracter de fato era o original
     * @param encryptedText Texto criptografado
     * @return Texto original, ou seja, sem a criptografia
     */
    private static String decrypt(int key, String encryptedText){
        StringBuilder text = new StringBuilder();
        int textSize = encryptedText.length();

        // Descriptografa cada caracter por vez
        for(int c=0; c < textSize; c++){
            int decryptedLetterASCII = ((int) encryptedText.charAt(c)) - key;
            text.append( (char)decryptedLetterASCII );
        }
        return text.toString();
    }

    /**
     * Método utilizado para ler o conteúdo escrito dentro de um arquivo
     * @param fileName Nome do arquivo que será lido
     * @return Texto lido
     */
    private static String readFile(String fileName){
        try {
            if(fileName.endsWith(".txt")) {
                File file = new File(fileName);
                if(file.exists()) {
                    if(isSizeOk(file.length())) {
                        BufferedReader br = new BufferedReader(new FileReader(fileName));

                        String row;
                        String text = "";

                        while ((row = br.readLine()) != null) {
                            text = row;
                        }
                        return text;
                    } else {
                        System.out.println("Arquivo muito grande!");
                    }
                } else {
                    System.out.println("Não existe arquivo com o nome que foi passado.");
                }
            } else {
                System.out.println("A extensão do arquivo deve ser .txt");
            }
        } catch ( IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * Método utilizado para verificar o tamanho do arquivo
     * @param bytes Quantidade de bytes do arquivo
     * @return TRUE se possuir menos que 20mb. FALSE caso contrário
     */
    private static boolean isSizeOk(long bytes) {
        double kb = bytes / 1024;
        double mb = kb / 1024;

        System.out.println(bytes);
        System.out.println(kb);
        System.out.println(mb);
        if(mb <= 20) {
            return true;
        }
        return false;
    }

    /**
     * Método utilizado para criar um arquivo e gravar nele um texto informado
     * @param text Texto que será gravdo no arquivo gerado
     * @param fileName Nome do arquivo que será criado
     */
    public static void writeFile(String text, String fileName){
        if(fileName.endsWith(".txt")) {
            FileWriter fileWriter = null;
            BufferedWriter bufferedWriter = null;

            try{
                fileWriter = new FileWriter(fileName, false);
                bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(text);
                bufferedWriter.newLine();
                bufferedWriter.close();

            }catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("A extensão do arquivo deve ser .txt");
        }
    }


    public static void main(String[] args){
        try {
            if(args[0].equals("C")) {
                String text = readFile(args[1]);
                String encryptedText = encrypt(Cryptographer.KEY, text);
                writeFile(encryptedText, args[2]);
            } else {
                String text = readFile(args[1]);
                String decryptedText = decrypt(Cryptographer.KEY, text);
                writeFile(decryptedText, args[2]);
            }
        } catch (RuntimeException e) {
            System.out.println("Execute o programa novamente e entre com os parâmetros corretamente.");
        }
    }
}
