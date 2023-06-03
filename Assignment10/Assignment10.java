package Assignment10;

public class Assignment10 {
    public static void main(String args[]) {
        SList sList = new SList();
        SListIterator sListIterator = sList.iterator();
        sListIterator.insert(1);
        sListIterator.insert(2);
        sListIterator.insert(3);
        sListIterator.remove(2);
        System.out.println(sList.toString(sListIterator));
    }
}
