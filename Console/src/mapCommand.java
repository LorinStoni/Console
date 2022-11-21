public class mapCommand
{
    Encryption CEncryption = new Encryption();
    GUI CGUI = new GUI();

    public void mapCommand(String strEntireInput)
    {
//        searchPositions(int iIdxOfBracket1s, int iIdxOfCommas, int iIdxOfBracket2);


        // Index der aufgehenden Klammer (
        int iIdxOfBracket1 = strEntireInput.indexOf("(");
        // Index des Kommas zwischen den zwei Eingaben in den Klammern
        int iIdxOfComma = strEntireInput.indexOf(",");
        // Index der zugehenden Klammer )
        int iIdxOfBracket2 = strEntireInput.indexOf(")");

        strEntireInput.toLowerCase();
        char[] acEntireInput = strEntireInput.toCharArray();

        String strInputCommand = "";
        String strInputParameter1 = "";
        String strInputParameter2 = "";


        // sucht den Command aus dem strInput heraus
        // füllt den strInputCommand mit den Zeichen des acEntireInput
        for (int i = 0; i < iIdxOfBracket1; i++)
            strInputCommand += acEntireInput[i];

        // sucht den InputParameter1 aus dem acEntireInput heraus
        for (int i = iIdxOfBracket1 +1; i < iIdxOfComma; i++)
            strInputParameter1 += acEntireInput[i];

        int iIdxOfSpace = iIdxOfComma;
        // checkt, ob es nach dem Komma ein Leerschlag hat - wenn ja, dann den Leerschlag überspringen
        while (acEntireInput[iIdxOfComma+1] == ' ')
        {
            iIdxOfComma++;
            iIdxOfSpace++;
        }


        // sucht den InputParameter2 aus dem acEntireInput heraus
        for (int i = iIdxOfSpace+1; i < iIdxOfBracket2; i++)
            strInputParameter2 += acEntireInput[i];


        // strInputCommand mit allen möglichen Commands vergleichen
        switch (strInputCommand)
        {
            case "encryption.encrypt":
                String strEncryption = CEncryption.caesar_encryptText(strInputParameter1, Integer.parseInt(strInputParameter2));
                GUI.write_update("Output: " +
                        strEncryption
                );
                GUI.copyToClipboard(strEncryption);
                GUI.deleteInput();
                break;

            case "encryption.decrypt":
                strEncryption = CEncryption.caesar_decryptText(strInputParameter1, Integer.parseInt(strInputParameter2));
                GUI.write_update("Output: " +
                        strEncryption
                );
                GUI.copyToClipboard(strEncryption);
                GUI.deleteInput();
                break;

            case "System.help":
                String strEnter = System.getProperty("line.seperator");
                GUI.write_update("all commands: " +
                        "System: help() || " +
                        "encryption: encrypt(zu verschlüsselnder Text, Verschiebung) || decrypt(zu entschlüsselnder Text, Verschiebung)");
                break;

            case "System.copyToClipboard":
                GUI.copyToClipboard("Output");
                break;

        }

    }
}


/*
Alle commands:

encryption.encrypt(input1, input2 hier:int)
encryption.decrypt(input1, input2 hier:int)

 */

