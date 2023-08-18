package util;

/**
 * @className: Element
 * @description: the model of a consecutive char.
 */
public class Element {
    //the character
    private char value;

    //the count of duplication.
    private int count;

    public Element(char value, int count) {
        this.value = value;
        this.count = count;
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
