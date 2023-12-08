import java.util.*;

// Class Door definition 
class Door {
  protected boolean isOpen = false;
  public void openDoor() {
    if(!isOpen) {
      System.out.println("Door opened");
      isOpen = true;
    }
    else {
      System.out.println("Door already open!");
    }
  }
  public void closeDoor() {
    if(isOpen) {
      System.out.println("Door closed");
      isOpen = false;
    }
    else {
      System.out.println("Door already closed!");
    }
  }
}

// Class DoorWithLock definition
class DoorWithLock extends Door {
  protected boolean isLocked = false;
  public void openDoor() {
    if(!isOpen && isLocked) {
      System.out.println("Door is locked and cannot be opened!");
      return;
    }
    super.openDoor(); // Note that you can reuse superclass functionality!
  }
  public void lockDoor() {
    if(isOpen) {
      System.out.println("Open door cannot be locked!");
      return;
    }
    else if(isLocked) {
      System.out.println("Door already locked!");
      return;
    }
    System.out.println("Door locked");
    isLocked = true;
  }
  public void unlockDoor() {
    if(!isLocked) {
      System.out.println("Door is not locked!");
      return;
    }
    System.out.println("Door unlocked");
    isLocked = false;
  }
}

// Class DoorWithLock definition
class DoorWithCodeLock extends DoorWithLock {
  private int code = 0;
  public void lockDoor() {
    Scanner in = new Scanner(System.in);
    if(!isOpen && !isLocked) {
      System.out.print("Give lock code to lock: ");
      code = in.nextInt();
      System.out.println("Door locked");
      isLocked = true;
      return;
    }
    super.lockDoor();
  }
  public void unlockDoor() {
    Scanner in = new Scanner(System.in);
    if(isLocked) {
      System.out.print("Give lock code to unlock: ");
      if(in.nextInt() == code) {
        System.out.println("Door unlocked!");
        isLocked = false;
        return;
      } 
      System.out.println("Invalid code!");
      return;
    }
    super.unlockDoor(); // Note that you can reuse superclass functionality!
  }
}
public class TestDoor {
  public static void main(String[] args) {
    int input = 0;
    Scanner in = new Scanner(System.in);
    DoorWithLock door = new DoorWithCodeLock();

    // Loop for the menu
    do {
      
      // Print the options
      System.out.println("1. Open door");
      System.out.println("2. Close door");
      System.out.println("3. Lock door");
      System.out.println("4. Unlock door");
      System.out.println("5. Exit");
      System.out.print("Make your choice: ");

      // Read user input and act accordingly
      input = in.nextInt();
      switch(input) {
        case 1:
          door.openDoor();
          break;
        case 2:
          door.closeDoor();
          break;
        case 3:
          door.lockDoor();
          break;
        case 4:
          door.unlockDoor();
          break;
        case 5: 
          System.out.println("Bye!");
          break;
        default:
          System.out.println("Invalid input!");
      }
    } while(input != 5);
  }
}