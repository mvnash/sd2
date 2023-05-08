import java.io.File;
import java.io.IOException;
import java.util.Map;

public class TestMain {

    /*
    public static void main(String[] args) {
        String s = "Bonjour! Au revoir!";
        Map<Character, Integer> freq = Huffman.computeFreq(s);
        Huffman.Node root = Huffman.buildTree(freq);
        System.out.println("Nbre de lettre dans la chaine de caractère à encoder: " + root.getFreq());
        System.out.println("Fréquence des lettres dans le sous-arbre de gauche: " + root.getLeft().getFreq());
        System.out.println("Fréquence des lettres dans le sous-arbre de droite: " + root.getRight().getFreq());

        System.out.println("buildcode");
        Map<Character, String> code= Huffman.buildCode(root);
        System.out.println(code);

        System.out.println("compress");
        String compress = Huffman.compress(s, code);
        System.out.println(compress);

        System.out.println("expand:");
        String texteOriginal = Huffman.expand(root,compress);
        System.out.println(texteOriginal);
    }

     */

    public static void main(String[] args) throws IOException {
        String s=HuffmanReadFile.loadFile(new File("11-0.txt"));
        Map<Character, Integer> freq = Huffman.computeFreq(s);
        Huffman.Node root = Huffman.buildTree(freq);
        Map<Character, String> code= Huffman.buildCode(root);
        String compress = Huffman.compress(s, code);
        HuffmanWriteFile.write("fichier_compresse",compress);
        String texteOriginal =
                Huffman.expand(root,HuffmanReadFile.read("fichier_compresse"));
        System.out.println(texteOriginal);
    }

}
