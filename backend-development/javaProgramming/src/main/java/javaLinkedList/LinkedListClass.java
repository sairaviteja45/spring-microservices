package javaLinkedList;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/linkedListClass")
public class LinkedListClass {

    /** Ways of Initialization of LinkedList  **/
    /** 1.Way*/
    LinkedList linkedList = new LinkedList();

    /** 2.Way*/
    LinkedList<Integer> linkedList1 = new LinkedList<>();

    /** 3.Way*/
    List<Integer> list = new LinkedList<>();

    /** 4.Way*/
    Queue<Integer> queue = new LinkedList<>();

    /** 5.Way*/
    Deque<Integer> deque = new LinkedList<>();

    /** 6.Way*/
    Collection<Integer> collection = new LinkedList<>();

    /** 7.Way*/
    Iterable<Integer> integers = new LinkedList<>();

    /** We can not Create LinkedList With PreDefined Size */
    /** LinkedList We can Create in Two Ways Only */
    /** 1.Create Empty LinkedList */
    public static void creatingEmptyLinkedList() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        System.out.println(linkedList);
        for(Integer integer : linkedList){
            System.out.print(integer);
        }
    }
    /**2.Creating with Data*/
    public static void creatingLinkedListWithData() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(3);
        linkedList.add(4);
        linkedList.addAll(list);
        System.out.println(list);
    }

    /** Major Operations We can Perform Using this LinkedList**/
    /** 1.Creation of List*/
    public static void creationOfLinkedList(){
        LinkedList<String> linkedList = new LinkedList<>();
    }
    /** 2.Addition of Elements into List*/
    /** A.Addition of Elements into LinkedList Using add() Method*/
    public static void additionOfElementsIntoLinkedListUsingAddMethod() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("First Element");
        linkedList.add("Second Element");
        linkedList.add("Third Element");
        linkedList.add("Fourth Element");
        linkedList.add("Fifth Element");
        System.out.println(linkedList);
        for (String string : linkedList) {
            System.out.println(string);
        }
    }

    /** B.Addition of Elements into LinkedList Using add() with Specific Position*/
    public static void additionOfElementsIntoLinkedListUsingAddMethodWithSpecificPosition() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(0, "First Element");
        linkedList.add(1, "Second Element");
        linkedList.add(2, "Third Element");
        linkedList.add(3, "Fourth Element");
        linkedList.add(4, "Fifth Element");

        System.out.println(linkedList);
        for (String string : linkedList) {
            System.out.println(string);
        }
    }

    /** C.Addition of Elements into LinkedList Using addAll() Method */
    public static void additionOfElementsIntoLinkedListUsingAddAllMethod() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(0, "First Element");
        linkedList.add(1, "Second Element");
        linkedList.add(2, "Third Element");
        linkedList.add(3, "Fourth Element");
        linkedList.add(4, "Fifth Element");

        LinkedList<String> linkedList2 = new LinkedList<>();
        linkedList2.add("First");
        linkedList2.add("Second");
        linkedList2.addAll(linkedList);

        System.out.println(linkedList2);
        for (String string : linkedList2) {
            System.out.println(string);
        }
    }

    /** D.Addition of Elements into LinkedList Using addAll() With Specific Position*/
    public static void additionOfElementsIntoLinkedListUsingAddAllWithSpecificPosition(){
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(0, "First Element");
        linkedList.add(1, "Second Element");
        linkedList.add(2, "Third Element");
        linkedList.add(3, "Fourth Element");
        linkedList.add(4, "Fifth Element");

        LinkedList<String> linkedList2 = new LinkedList<>();
        linkedList2.add("First");
        linkedList2.add("Second");
        linkedList2.addAll(0,linkedList);

        System.out.println(linkedList2);
        for (String string : linkedList2) {
            System.out.println(string);
        }
    }

    /** E.Addition Of Elements Into LinkedList Using AddFirst Method*/
    public static void additionOfElementsIntoLinkedListUsingAddFirstMethod() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("First Element");
        linkedList.add("Second Element");
        linkedList.add("Third Element");
        linkedList.add("Fourth Element");
        linkedList.addFirst("Fifth Element");

        System.out.println(linkedList);
        for (String string : linkedList) {
            System.out.println(string);
        }
    }

    /** F.Addition Of Elements Into LinkedList Using AddLast Method*/
    public static void additionOfElementsIntoLinkedListUsingAddLastMethod(){
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addLast("First Element");
        linkedList.add("Second Element");
        linkedList.add("Third Element");
        linkedList.add("Fourth Element");
        linkedList.add("Fifth Element");

        System.out.println(linkedList);
        for (String string : linkedList) {
            System.out.println(string);
        }
    }

    /** 3.Retrieval of Elements into List*/
    /** A.Retrieval Of Elements From LinkedList Using GetMethod */
    public static void retrievalOfElementsFromLinkedListUsingGetMethod() {
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("First Element");
        linkedList.add("Second Element");
        linkedList.add("Third Element");
        linkedList.add("Fourth Element");
        linkedList.add("Fifth Element");

        System.out.println(linkedList);
        System.out.println();
        System.out.println(linkedList.get(0));
    }

    /** B.Retrieval Of First Elements From LinkedList Using GetFirst Method */
    public static void retrievalOfFirstElementsFromLinkedListUsingGetFirstMethod() {
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("First Element");
        linkedList.add("Second Element");
        linkedList.add("Third Element");
        linkedList.add("Fourth Element");
        linkedList.add("Fifth Element");

        System.out.println(linkedList);
        System.out.println();
        System.out.println(linkedList.getFirst());
    }

    /** C.Retrieval Of Last Elements From LinkedList Using GetLast Method */
    public static void retrievalOfLastElementsFromLinkedListUsingGetLastMethod() {
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("First Element");
        linkedList.add("Second Element");
        linkedList.add("Third Element");
        linkedList.add("Fourth Element");
        linkedList.add("Fifth Element");

        System.out.println(linkedList);
        System.out.println();
        System.out.println(linkedList.getLast());
    }

    /** 4.Deletion of Elements from List*/
    /** A.Remove First Element From LinkedList Using Remove Method */
    public static void removeFirstElementFromLinkedListUsingRemoveMethod() {
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("First Element");
        linkedList.add("Second Element");
        linkedList.add("Third Element");
        linkedList.add("Fourth Element");
        linkedList.add("Fifth Element");

        System.out.println(linkedList);
        System.out.println();

        linkedList.remove();
        System.out.println();

        for (String string : linkedList) {
            System.out.println(string);
        }
    }

    /** B.Remove Elements From LinkedList Using Remove Method From Specific Index */
    public static void removeElementsFromLinkedListUsingRemoveMethodFromSpecificIndex() {
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("First Element");
        linkedList.add("Second Element");
        linkedList.add("Third Element");
        linkedList.add("Fourth Element");
        linkedList.add("Fifth Element");

        System.out.println(linkedList);
        System.out.println();

        linkedList.remove(1);
        System.out.println();

        for (String string : linkedList) {
            System.out.println(string);
        }
    }

    /** C.Remove Elements From LinkedList Using Remove Method With Object*/
    public static void removeElementsFromLinkedListUsingRemoveMethodWithObject() {
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("First Element");
        linkedList.add("Second Element");
        linkedList.add("Third Element");
        linkedList.add("Fourth Element");
        linkedList.add("Fifth Element");

        System.out.println(linkedList);
        System.out.println();

        linkedList.remove("Third Element");
        System.out.println();

        for (String string : linkedList) {
            System.out.println(string);
        }
    }

    /** D.Remove All Elements From LinkedList Using RemoveAll Method*/
    public static void removeElementsFromLinkedListUsingRemoveAllMethod() {
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("First Element");
        linkedList.add("Second Element");
        linkedList.add("Third Element");
        linkedList.add("Fourth Element");
        linkedList.add("Fifth Element");

        System.out.println(linkedList);
        System.out.println();

        boolean b = linkedList.removeAll(linkedList);
        System.out.println();

        for (String string : linkedList) {
            System.out.println(string);
        }
    }

    /** E.Remove First Elements From LinkedList Using RemoveFirst Method*/
    public static void removeFirstElementsFromLinkedListUsingRemoveFirstMethod() {
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("First Element");
        linkedList.add("Second Element");
        linkedList.add("Third Element");
        linkedList.add("Fourth Element");
        linkedList.add("Fifth Element");

        System.out.println(linkedList);
        System.out.println();

        linkedList.removeFirst();
        System.out.println();

        for (String string : linkedList) {
            System.out.println(string);
        }
    }

    /** F.Remove Last Element From LinkedList Using RemoveLast Method */
    public static void removeLastElementFromLinkedListUsingRemoveLastMethod() {
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("First Element");
        linkedList.add("Second Element");
        linkedList.add("Third Element");
        linkedList.add("Fourth Element");
        linkedList.add("Fifth Element");

        System.out.println(linkedList);
        System.out.println();

        linkedList.removeLast();
        System.out.println();

        for (String string : linkedList) {
            System.out.println(string);
        }
    }

    /** G.Remove Element From LinkedList Using RemoveFirstOccurrence Method */
    public static void removeElementFromLinkedListUsingRemoveFirstOccurrenceMethod() {
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("First Element");
        linkedList.add("Second Element");
        linkedList.add("Third Element");
        linkedList.add("Fourth Element");
        linkedList.add("Fifth Element");

        System.out.println(linkedList);
        System.out.println();
        linkedList.removeFirstOccurrence("Second Element");
        System.out.println();
        for (String string : linkedList) {
            System.out.println(string);
        }
    }

    /** H.Remove Elements From LinkedList Using RemoveLastOccurrence Method */

    /** I.Remove All Elements From the LinkedList Using Clear Method */
    public static void removeAllElementsFromLinkedListUsingClearMethod() {
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("First Element");
        linkedList.add("Second Element");
        linkedList.add("Third Element");
        linkedList.add("Fourth Element");
        linkedList.add("Fifth Element");

        System.out.println(linkedList);
        System.out.println();
        linkedList.clear();
        System.out.println();
        for (String string : linkedList) {
            System.out.println(string);
        }
    }

    /** 5.Verification of Elements in the List*/
    /** A.Verifying Single Element in LinkedList Using Contains Method*/
    public static void verifyingSingleElementInLinkedListUsingContainsMethod() {
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("First Element");
        linkedList.add("Second Element");
        linkedList.add("Third Element");
        linkedList.add("Fourth Element");
        linkedList.add("Fifth Element");

        System.out.println(linkedList);
        System.out.println();
        System.out.println(linkedList.contains("Fourth Element"));
    }

    /** B.Verifying Collection List in LinkedList Using ContainsAll Method */
    public static void verifyingCollectionListInLinkedListUsingContainsAllMethod() {
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("First Element");
        linkedList.add("Second Element");
        linkedList.add("Third Element");
        linkedList.add("Fourth Element");
        linkedList.add("Fifth Element");

        System.out.println(linkedList);
        System.out.println();
        System.out.println(linkedList.containsAll(linkedList));
    }

    /** 6.Update Elements in the List*/
    /** A.Updating Elements in LinkedList Using Set Method */
    public static void updatingElementsInLinkedListUsingSetMethod() {
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("First Element");
        linkedList.add("Second Element");
        linkedList.add("Third Element");
        linkedList.add("Fourth Element");
        linkedList.add("Fifth Element");

        System.out.println(linkedList);
        System.out.println();
        linkedList.set(0, "Tenth Element");
        System.out.println(linkedList);
    }
}
