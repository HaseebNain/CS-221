import java.util.Scanner;

/**
 * Simple utility for playing with data structures via command line menu.
 * 
 * @author mvail
 */
public class CmdLineTester {
	private enum ListOption {
		addAfter, addFront, addRear,
//		add, addIndex, 
		removeElement, removeFirst, removeLast,
//		removeIndex, 
//		get, set, 
		first, last,
		contains, size, isEmpty, toString,
		quit, invalid
	}
	
	private static Scanner kbd;
	private static UnorderedListADT<Integer> list;

	/**
	 * Give the menu of data structure methods and 
	 * process choices until user chooses to quit.
	 * 
	 * @param args unused
	 */
	public static void main(String[] args) {
		list = new GoodUnorderedList<Integer>();
		
		kbd = new Scanner(System.in);
		
		ListOption choice = ListOption.invalid;
		
		do {
			printMenu();
			
			String input = kbd.nextLine().trim();
		
			//match number choice to the corresponding ListOption
			try {
				int choiceNum = Integer.parseInt(input);
				if (choiceNum > 0 && choiceNum < ListOption.values().length) {
					for (ListOption o : ListOption.values()) {
						if (choiceNum-1 == o.ordinal()) {
							choice = o;
						}
					}
				} else {
					choice = ListOption.invalid;
				}
			} catch (NumberFormatException nfe) {
				choice = ListOption.invalid;
			}
			
			//perform the chosen operation
			switch (choice) {
			case addAfter:
				unoListAddAfter();
				break;
			case addFront:
				unoListAddFront();
				break;
			case addRear:
				unoListAddRear();
				break;
//				case add:
//				idxListAdd();
//				break;
//			case addIndex:
//				idxListAddIndex();
//				break;
			case removeElement:
				listRemoveElement();
				break;
			case removeFirst:
				list.removeFirst();
				break;
			case removeLast:
				list.removeLast();
				break;
//			case removeIndex:
//				idxListRemoveIndex();
//				break;
//			case get:
//				idxListGet();
//				break;
//			case set:
//				idxListSet();
//				break;
			case first:
				System.out.println("first: " + list.first());
				break;
			case last:
				System.out.println("last: " + list.last());
				break;
			case contains:
				listContains();
				break;
			case size:
				System.out.println("size: " + list.size());
				break;
			case isEmpty:
				System.out.println("isEmpty: " + list.isEmpty());
				break;
			case toString:
				System.out.println("toString: " + list.toString());
				break;
			case quit:
				break;
			default:
				System.out.println("Invalid choice.");
			}
		} while (choice != ListOption.quit);
		
		kbd.close();
	}
	
	/** display the menu */
	private static void printMenu() {
		int opt = 0;
		System.out.println("What next?");
		for (ListOption o : ListOption.values()) {
			if (o.ordinal() < ListOption.values().length-1) {
				System.out.println("\t" + (opt+1) + " " + o.name());
				opt++;
			}
		}
		System.out.print("Number Choice: ");
	}

	private static void unoListAddAfter() {
		try {
			System.out.print("Integer to add: ");
			Integer newInt = Integer.parseInt(kbd.nextLine().trim());
			
			System.out.print("Target Integer: ");
			Integer targetInt = Integer.parseInt(kbd.nextLine().trim());
			
			list.addAfter(newInt, targetInt);
		} catch (NumberFormatException nfe) {
			System.out.println("Invalid Integer.");
		}
	}
	
	private static void unoListAddFront() {
		System.out.print("Integer to add: ");
		try {
			list.addToFront(Integer.parseInt(kbd.nextLine().trim()));
		} catch (NumberFormatException nfe) {
			System.out.println("Invalid Integer.");
		}
	}
	
	private static void unoListAddRear() {
		System.out.print("Integer to add: ");
		try {
			list.addToRear(Integer.parseInt(kbd.nextLine().trim()));
		} catch (NumberFormatException nfe) {
			System.out.println("Invalid Integer.");
		}
	}
	
//	private static void idxListAdd() {}
	
//	private static void idxListAddIndex() {}
	
	private static void listRemoveElement() {
		System.out.print("Integer to remove: ");
		try {
			list.remove(Integer.parseInt(kbd.nextLine().trim()));
		} catch (NumberFormatException nfe) {
			System.out.println("Invalid Integer.");
		}
	}

//	private static void idxListRemoveIndex() {}

//	private static void idxListGet() {}

//	private static void idxListSet() {}

	private static void listContains() {
		System.out.print("Integer to find: ");
		try {
			System.out.println("contains: " + list.contains(Integer.parseInt(kbd.nextLine().trim())));
		} catch (NumberFormatException nfe) {
			System.out.println("Invalid Integer.");
		}
	}

}
