// Superclass
class Person {
    protected String name;
    protected int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }
}

// Interface
interface Worker {
    void performDuties();
}

// Subclass: Chef
class Chef extends Person implements Worker {
    public Chef(String name, int id) {
        super(name, id);
    }

    public void performDuties() {
        System.out.println(name + " (Chef) is preparing meals.");
    }
}

// Subclass: Waiter
class Waiter extends Person implements Worker {
    public Waiter(String name, int id) {
        super(name, id);
    }

    public void performDuties() {
        System.out.println(name + " (Waiter) is serving customers.");
    }
}


public class RestaurantSystem {
    public static void main(String[] args) {
        Chef chef = new Chef("Gordon", 101);
        Waiter waiter = new Waiter("Emily", 102);

        chef.performDuties();
        waiter.performDuties();
    }
}
