package fr.uvsq.cprog.mvnjunit;

public class ChaineCryptee {
    private String chaineEnClair;
    //private String chaineCryptee;
    private int decalage;

    private ChaineCryptee(final String chaineEnClair, final int decalage) {
        this.chaineEnClair = chaineEnClair;
        this.decalage = decalage;
       // this.chaineCryptee = ;
    }

    public static ChaineCryptee CCrypterDeEnClair(final String chaineEnClair, final int decalage){
        return new ChaineCryptee(chaineEnClair, decalage);
    }

    public static ChaineCryptee CCrypterDeChiffree(final String chaineChiffree, final int decalage){
        StringBuilder chaineClair = new StringBuilder();
        for (char caractere : chaineChiffree.toCharArray()) {
            if (Character.isLetter(caractere)) {
                char base = Character.isUpperCase(caractere) ? 'A' : 'a';
                char nouveauCaractere = (char) ((caractere - base - decalage + 26) % 26 + base);
                chaineClair.append(nouveauCaractere);
            } else {
                chaineClair.append(caractere);
            }
        }
        return new ChaineCryptee(chaineClair.toString(), decalage);
    }

    public String crypte() {
        StringBuilder chaineChiffree = new StringBuilder();
        for (char caractere : chaineEnClair.toCharArray()) {
            if (Character.isLetter(caractere)) {
                char nouveauCaractere = decaleCaractere(caractere, decalage);
                chaineChiffree.append(nouveauCaractere);
            } else {
                chaineChiffree.append(caractere);
            }
        }

        return chaineChiffree.toString();
       // return chaineCryptee;
    }

    public String decrypte() {
        return chaineEnClair;
//        StringBuilder chaineChiffree = new StringBuilder();
//        for (char caractere : chaineEnClair.toCharArray()) {
//            if (Character.isLetter(caractere)) {
//                char nouveauCaractere = decaleCaractere(caractere, -decalage);
//                chaineChiffree.append(nouveauCaractere);
//            } else {
//                chaineChiffree.append(caractere);
//            }
//        }
//        return chaineChiffree.toString();
    }

    public char decaleCaractere(char caractere, int decalage) {
        char base = Character.isUpperCase(caractere) ? 'A' : 'a';
        return (char) ((caractere - base + decalage + 26) % 26 + base);
    }

    public static ChaineCryptee deCryptee(String chaineChiffree, int decalage) {
        return new ChaineCryptee(new ChaineCryptee(chaineChiffree, decalage).decrypte(), decalage);
    }

    public static ChaineCryptee deEnClair(String chaineEnClair, int decalage) {
        return new ChaineCryptee(chaineEnClair, decalage);
    }
}