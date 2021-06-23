import java.util.ArrayList;
import java.util.List;

class Shape {
    /* ... */ }

class Circle extends Shape {
    /* ... */ }

class Rectangle extends Shape {
    /* ... */ }

class Node<T> implements Comparable<T> {

    public int compareTo(T obj) {
        /* ... */
        return 0;
    }

    // ...

}

public class GenericsRev {
    public static void main(String[] args) {

        Node<String> aNode = new Node<>(); // type inference

        Comparable<String> comp = aNode;

    }
}
