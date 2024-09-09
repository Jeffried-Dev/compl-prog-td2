package fr.uvsq.cprog.mvnjunit;

import org.junit.Test;
import static org.junit.Assert.*;

public class ChaineCrypteeTest {

    @Test
    public void testCrypte() {
        ChaineCryptee chaine = new ChaineCryptee("HELLO WORLD", 3);
        assertEquals("KHOOR ZRUOG", chaine.crypte());
        //System.out.println(chaine.crypte());
    }

    @Test
    public void testDecrypte() {
        ChaineCryptee chaine = new ChaineCryptee("KHOOR ZRUOG", 3);
        assertEquals("HELLO WORLD", chaine.decrypte());
        //System.out.println(chaine.decrypte());
    }

    @Test
    public void testCrypteNull() {
        ChaineCryptee chaine = new ChaineCryptee("", 3);
        assertEquals("", chaine.crypte());
        //System.out.println(chaine.crypte());
    }

    @Test
    public void testDeDecrypte(){
        assertEquals(new ChaineCryptee("HELLO WORLD", 3), ChaineCryptee.deCryptee("KHOOR ZRUOG", 3));
    }
    @Test
    public void testDeEnClair(){
        assertEquals(new ChaineCryptee("HELLO WORLD", 3), ChaineCryptee.deEnClair("HELLO WORLD", 3));
    }
}

