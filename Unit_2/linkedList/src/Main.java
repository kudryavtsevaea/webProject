public class Main {
        public static void main(String[] args) {
                LinkList link = new LinkList();
                link.add (32);
                link.add (1);
                link.add ("солнышко");
                link.printLink();
                System.out.println("\n");
                link.deleteElem (32);
                link.printLink();
        }
}