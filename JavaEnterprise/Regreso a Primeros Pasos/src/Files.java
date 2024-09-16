
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JTextArea;

public class Files {

    public static void main(String[] args) {

        new FileRead().read();
    }

}

class FileRead {

    public ArrayList read() {
        try {
            FileReader reader = new FileReader("C:\\Users\\kenet\\OneDrive - Instituto Politecnico Nacional\\Documents\\algo.txt");
            int c = 0;
            ArrayList<Character> list = new ArrayList<>();

            while (c != -1) {

                c = reader.read();
                char word = (char) c;
                if (c != -1) {

                    System.out.print(word);
                    list.add(word);
                }

            }
            reader.close();
            return list;
        } catch (IOException e) {
            return null;
        }

    }

    public void write(JTextArea obj) {

        try {
            FileWriter write = new FileWriter("C:\\Users\\kenet\\OneDrive - Instituto Politecnico Nacional\\Documents\\algo.txt",true);

            for (int i = 0; i < obj.getText().length(); i++) {

                write.append(obj.getText().charAt(i));
            }
            write.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

}
