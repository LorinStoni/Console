import javax.swing.*;
import javax.swing.event.DocumentEvent;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GUI {
    static JTextArea input = new JTextArea();
    static JLabel output = new JLabel("Output");

    static Encryption Encryption = new Encryption();

    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        int iWidth = 1000;
        int iHeight = 500;

        frame.setSize(iWidth, iHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setName("Console");
        frame.add(panel);

        panel.setLayout(null);


        input.setBounds(10, 10, iWidth-40, iHeight/2-10);
        input.setToolTipText("Input field");

        input.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_ENTER)
                {
                    new mapCommand().mapCommand(read_input());

                    /*
                    String strInput = read_input();
                    String strEncryption = Encryption.caesar_encryptText(strInput, 3);
                    write_update(strEncryption);
                    deleteInput();

                    );

                     */
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {

            }
            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        panel.add(input);


        output.setBounds(10, iHeight/2+10, iWidth-40, iHeight/2-10);
        panel.add(output);


        frame.setVisible(true);
    }

    private static void checkInput(int iEvent, DocumentEvent e)
    {
        write_update(iEvent + e.toString());
    }



    public static void deleteOutput()
    {
        output.setText("");
    }

    public static void deleteInput()
    {
        input.setText("");
    }

    public static void write_update(String text)
    {
        output.setText(text);
    }


    public static String read_input()
    {
        return input.getText();
    }

    public static void copyToClipboard(String strCopy)
    {
        switch (strCopy)
        {
            case "Input":
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(
                        new StringSelection(input.getText()), null);
                break;
            case "Output":
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(
                        new StringSelection(output.getText()), null);
                break;
            default:
                StringSelection strs = new StringSelection(strCopy);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(strs, null);
                break;
        }
    }
}


