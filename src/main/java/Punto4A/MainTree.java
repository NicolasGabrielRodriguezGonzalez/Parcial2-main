package Punto4A;

public class MainTree {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        int[] keys = {50, 30, 70, 20, 40, 60, 80, 55, 65};
        for (int k : keys) {
            tree.insert(k);
        }

        System.out.println("===== 4a) contarEquiposEnRango =====");
        int[][] ranges = {{35, 62}, {20, 80}, {41, 54}, {60, 60}, {1, 19}, {70, 30}};
        for (int[] r : ranges) {
            System.out.println("Rango [" + r[0] + ", " + r[1] + "] -> "
                    + BinarySearchTree.contarEquiposEnRango(tree.getRoot(), r[0], r[1]));
        }
        System.out.println("Arbol vacio -> " + BinarySearchTree.contarEquiposEnRango(null, 1, 100));

        System.out.println("\n===== 4b) Eliminar 50 (mayor de la izquierda) =====");
        tree.printSideways();
        System.out.println("InOrden inicial: " + tree.inOrder());
        tree.delete(50);
        System.out.println();
        tree.printSideways();
        System.out.println("InOrden final:   " + tree.inOrder());   // 20 30 40 55 60 65 70 80
    }
}
