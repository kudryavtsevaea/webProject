public class LinkList implements Linkable{

    class Node{
        private Node next;
        private Node prev;
        private Object info;

        Node(Node prev,Object info,Node next){
            this.prev = prev;
            this.info = info;
            this.next = next;
        }
    }

    private Node node_head;
    private Node node_tail;
    private int size = 0;

    public void add(Object info){
        Node temp = this.node_tail;
        Node newNode = new Node(temp,info,null);
        this.node_tail = newNode;
        if(node_head == null)
            this.node_head = newNode;
        else
            temp.next = newNode;
        this.size++;
    }

    public void deleteElem(Object info){
        if(info == null) {
            for (Node temp = node_head; temp != null; temp = temp.next) {
                if (temp.info == null)
                    deleteInfo(temp);
            }
        }
        else{
            for(Node temp = node_head;temp!=null;temp = temp.next){
                if(temp.info.equals(info))
                    deleteInfo(temp);
            }
        }
    }

    private void deleteInfo(Node x){
        Node prev = x.prev;
        Node next = x.next;

        if(prev == null)
            this.node_head = next;
        else{
            prev.next = next;
            x.prev = null;
        }

        if(next == null)
            this.node_tail = prev;
        else{
            next.prev = prev;
            x.next = null;
        }
        x.info = null;
        this.size--;
    }

    public void printLink(){
        Object[]result = new Object[size];
        int i = 0;
        for(Node temp = node_head; temp!=null; temp = temp.next)
            result[i++] = temp.info;

        Object[] info = result;
        for(Object temp:info)
            System.out.println(temp);
    }
}
