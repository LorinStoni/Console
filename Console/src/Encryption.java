public class Encryption
{
    public String caesar_encryptText(String text, int iMovement)
    {
        char[] ac  = text.toCharArray();

        int iAscii;
        int iAcLength = ac.length;
        for (int i = 0; i < iAcLength; i++)
        {
            iAscii = (int) ac[i];
            iAscii += iMovement;
            // wenn iAscii über '~' (= 126)
            if (iAscii > 126)
            {
                iAscii = 31 + (iAscii - 126);
            }
            ac[i] = (char) iAscii;
        }
        return new String(ac);
    }

    public String caesar_decryptText(String text, int iMovement)
    {
        char[] ac  = text.toCharArray();

        int iAscii;
        int iAcLength = ac.length;
        for (int i = 0; i < iAcLength; i++)
        {
            iAscii = (int) ac[i];
            iAscii -= iMovement;
            // wenn iAscii unter [space] (= 32)
            if (iAscii < 32)
            {
                iAscii = 127 - (32 - iAscii);
            }
            ac[i] = (char) iAscii;
        }
        return new String(ac);
    }
}
