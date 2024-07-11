package exercise;

class SafetyList {
    // BEGIN
    private int[] elements = new int[10];
    private int size = 0;

    public synchronized void add(int element) {
        elements[size] = element;
        size++;

        if (size == elements.length) {
            int[] newElements = new int[elements.length * 2];
            System.arraycopy(elements, 0, newElements, 0, elements.length);
            elements = newElements;

        }
    }

    public int get(int index) {
        return elements[index];
    }

    public int getSize() {
        return size;
    }
    // END
}
