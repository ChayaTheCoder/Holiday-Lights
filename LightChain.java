/**
 * A class that implements a chain of lights for
 * the holidays. Each chain contains initially 5
 * but you can remove some or change some by
 * colors.
 * 
 * @Author: Michaya Mohamed
 * @Version: 3-16-25
 */
class LightChain {

    /**
     * Use these constants in the main program to pass
     * a color to the routines in this file. When you
     * print this string, the output will set the
     * background of the appropriate color.
     */

    /**
     * ANSI escape code for red background with "Red" text.
     */
    final static String RED = "\u001b[41m Red  \u001b[0m";

    /**
     * ANSI escape code for green background with "Green" text.
     */
    final static String GREEN = "\u001b[42mGreen \u001b[0m";

    /**
     * ANSI escape code for yellow background with "Yellow" text.
     */
    final static String YELLOW = "\u001b[43mYellow\u001b[0m";

    /**
     * ANSI escape code for blue background with "Blue" text.
     */
    final static String BLUE = "\u001b[44m Blue \u001b[0m";

    /**
     * ANSI escape code for orange background with "Orange" text.
     */
    final static String ORANGE = "\u001b[41mOrange\u001b[0m";

    /**
     * ANSI escape code for purple background with "Purple" text.
     */
    final static String PURPLE = "\u001b[45mPurple\u001b[0m";

    /**
     * Plain white text with no ANSI background.
     */
    final static String WHITE = "White";

    /**
     * The reference to the beginning light node of this chain.
     */
    protected Node<String> headOfLightString;

    /**
     * Constructor, build a chain of lights: Red,Green,Blue,Yellow,White,
     * initializing the instance variable, headOfLightString.
     */
    public LightChain() {
        headOfLightString = new Node<>(RED, null);
        Node<String> second = new Node<>(GREEN, null);
        Node<String> third = new Node<>(BLUE, null);
        Node<String> fourth = new Node<>(YELLOW, null);
        Node<String> fifth = new Node<>(WHITE, null);

        // Linking the nodes together
        headOfLightString.setNext(second);
        second.setNext(third);
        third.setNext(fourth);
        fourth.setNext(fifth);
    }

    /**
     * Returns the color of the light bulb at position x.
     * 
     * @param pos position of the bulb to get
     * @return color
     */
    public String get(int pos) {
        Node<String> cur = headOfLightString;
        while (cur != null && pos > 0) {
            pos--;
            cur = cur.getNext();
        }
        if (cur != null) {
            return cur.getData();
        } else {
            return null;
        }
    }

    /**
     * Join two LightChains by connecting anotherPiece
     * to the end of this one.
     * 
     * @param anotherPiece a LightChain to append to this one
     * @return this chain, appropriate for doing multiple chaining
     */
    public LightChain join(LightChain anotherPiece) {
        Node<String> cur = headOfLightString;
        while (cur.getNext() != null) {
            cur = cur.getNext();
        }
        cur.setNext(anotherPiece.headOfLightString);
        return this;
    }

    /**
     * Traverse the light chain, printing the node
     * value for each.
     */
    public void traverseLightChain() {
        Node<String> current = headOfLightString;
        while (current != null) {
            System.out.print(current.getData() + " -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

    /**
     * Insert the newColor after another color (afterColor).
     * 
     * @param newColor   the color to be inserted
     * @param afterColor insert it after this color
     */
    public void insertAfter(String newColor, String afterColor) {
        Node<String> current = headOfLightString;

        // Traverse the list to find the node with afterColor
        while (current != null && !current.getData().equals(afterColor)) {
            current = current.getNext();
        }

        // If the color is found, insert the new node after it
        if (current != null) {
            Node<String> newNode = new Node<>(newColor);
            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }
    }

    /**
     * Remove the given color.
     * 
     * @param aColor the to-be-removed color
     */
    public void remove(String aColor) {
        while (headOfLightString != null && headOfLightString.getData()
                .equals(aColor)) {
            headOfLightString = headOfLightString.getNext();
        }

        Node<String> current = headOfLightString;
        while (current != null && current.getNext() != null) {
            if (current.getNext().getData().equals(aColor)) {
                current.setNext(current.getNext().getNext());
            } else {
                current = current.getNext();
            }
        }
    }

    /**
     * Replace all of the colors aColor with the given anotherColor.
     * 
     * @param aColor       the color to be replaced.
     * @param anotherColor the color that will replace it.
     */
    public void replaceAll(String aColor, String anotherColor) {
        Node<String> current = headOfLightString;

        while (current != null) {
            if (current.getData().equals(aColor)) {
                current.setData(anotherColor);
            }
            current = current.getNext();
        }
    }

    /**
     * A generic node class for use in linked data structures.
     * This class represents a single node that holds data of type T
     * and a reference to the next node in the structure.
     *
     * @param <T> the type of data stored in the node
     */
    class Node<T> {
        private T data;
        private Node<T> next;

        /**
         * Constructs a new node with the given data and next node reference.
         *
         * @param data the data to be stored in the node
         * @param next the reference to the next node in the structure
         */
        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        /**
         * Constructs a new node with the given data and no next node.
         *
         * @param data the data to be stored in the node
         */
        public Node(T data) {
            this(data, null);
        }

        /**
         * Returns the data stored in the node.
         *
         * @return the data stored in the node
         */
        public T getData() {
            return data;
        }

        /**
         * Sets the data stored in the node.
         *
         * @param data the new data to be stored in the node
         */
        public void setData(T data) {
            this.data = data;
        }

        /**
         * Returns the reference to the next node in the structure.
         *
         * @return the next node in the structure
         */
        public Node<T> getNext() {
            return next;
        }

        /**
         * Sets the reference to the next node in the structure.
         *
         * @param next the new next node in the structure
         */
        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
}
