import java.util.*;


public class Huffman {

    static class Node {
        private char ch;
        private int freq;
        private final Node left, right;

        public Node(char ch, int freq, Node left, Node right) {
            this.ch = ch;
            this.freq = freq;
            this.left = left;
            this.right = right;
        }

        public boolean isLeaf() {
            return left == null && right == null;
        }

        public int getFreq() {
            return freq;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }
    }

    // renvoie une map qui a comme clé les lettres de la chaine de
    // caractère donnée en paramètre et comme valeur la fréquence de
    // ces lettres
    public static Map<Character, Integer> computeFreq(String s) {
        HashMap<Character, Integer> mapFrequence = new HashMap<>();
        int i = 0;
        char[] tableauString = s.toCharArray();
        while (i < s.length()) {
            if (!mapFrequence.containsKey(tableauString[i])) {
                mapFrequence.put(tableauString[i], 1);
            } else {
                Integer nbrDejaPresent = mapFrequence.remove(tableauString[i]);
                nbrDejaPresent++;
                mapFrequence.put(tableauString[i], nbrDejaPresent);
            }
            i++;
        }
        return mapFrequence;
    }

    // renvoie l'arbre de Huffman obtenu à partir de la map des fréquences des lettres
    public static Node buildTree(Map<Character, Integer> freq) {

        // ETAPE 1
        PriorityQueue<Node> filePrio = new PriorityQueue<>(Comparator.comparing(Node::getFreq));
        Set<Character> ensembleCharacter = freq.keySet();
        for (Character character : ensembleCharacter) {
            int nbrFrequence = freq.get(character);
            filePrio.add(new Node(character, nbrFrequence, null, null));
        }

        // ETAPE 2 CHAQUE BOUCLE
        while (filePrio.size() > 1) {
            Node filsGauche = filePrio.poll();
            Node filsDroit = filePrio.poll();
            filePrio.add(new Node('\u0000', filsGauche.getFreq() + filsDroit.getFreq(), filsGauche, filsDroit));
        }

        return filePrio.peek();
    }

    // renvoie une map qui associe chaque lettre à son code (suite de 0 et de 1).
    // Ce code est obtenu en parcourant l'arbre de Huffman donné en paramètre
    public static Map<Character, String> buildCode(Node root) {
        HashMap<Character, String> mapCode = new HashMap<>();
        String chemin = "";
        buildCode(root, chemin, mapCode);

        return mapCode;
    }

    private static void buildCode(Node node, String chemin, HashMap<Character, String> mapCode) {

        if (node.isLeaf()) {
            mapCode.put(node.ch, chemin);
        } else {
            buildCode(node.getLeft(), chemin + "0", mapCode);
            buildCode(node.getRight(), chemin + "1", mapCode);
        }

    }


    // encode la chaine de caractère prise en paramètre en une chaine de
    // bit (0 et 1) en utilisant la map des codes codeMap
    public static String compress(String s, Map<Character, String> codeMap) {
        String encode = "";
        for (char c : s.toCharArray()) {
            encode += codeMap.get(c);
        }
        return encode;
    }

    // Cette méthode décode une chaine de 0 et de 1 codé à l'aide de l'algorithme de Huffman
    // En paramètre, en plus de la chaine à décoder, est spécifié la racine de l'arbre de
    // Huffman
    public static String expand(Node root, String t) {
        String text = "";
        Node nodeParcouru = root;
        for (char c : t.toCharArray()) {

            if (nodeParcouru.isLeaf()) {
                text += nodeParcouru.ch;
                nodeParcouru = root;

            }

			if (c == '0') {
                nodeParcouru = nodeParcouru.getLeft();
            } else {
                nodeParcouru = nodeParcouru.getRight();
            }
        }
        return text;
    }

}
