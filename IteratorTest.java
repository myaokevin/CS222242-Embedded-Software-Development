import java.util.ArrayList;
import java.util.List;

/*
Problem : 
There occurs a need to have a collection of carehouses attached with the hospital and each carehouse could also have a 
collection of patients  responsible for.
Sometimes, we would need to change the underlying structure that holds carehouse objects in a carehouse class and that holds Patient objects in a CareTaker class. 
In such an instance the general way of iteration would lead to changes in client any changes are made to the underlying storage struture.
The underlying storage collection structure would also be exposed to client in such an instance. 
*/
/*
Solution :
This could be solved using the iterator pattern. here we use a nested Iterator class within an aggregate class,
so that the changes would need to be made only withing the aggregate class, but not in the client .
This way, we could hide the storage structure and change the structure of it without making changes to the client.
*/

interface Collector { // Aggregate interface
    Iterator createIterator();
}

class CareHouses {
    private static int i = 0;
    private int id;
    private String name;

    public CareHouses(String name) {
        i++;
        this.id = i;
        this.name = name;
    }
    @Override
    public String toString() {
        return this.getClass().getSimpleName()+" : id = "+id+" Name: "+name;
    }
    // more methods and attributes available

}

interface Iterator {
    boolean hasNext();
    Object next();

}

class Hospital implements Collector {
    private String name;
    private List<CareHouses> careHouses = new ArrayList<>();
    private int count = 0; // count of carehouses in above list

    public Hospital(String name) {
        this.name = name;
    }

    public class CareHouseIterator implements Iterator {
        private int idx;

        public CareHouseIterator() {
            this.idx = 0;
        }

        @Override
        public Object next() {
            return careHouses.get(idx++);

        }

        @Override
        public boolean hasNext() {
            if (idx < count) {
                return true;
            } else
                return false;
        }

    }
    

    @Override
    public Iterator createIterator() {
        return new CareHouseIterator();
    }

    public Hospital addCareHouse(CareHouses c) {
        careHouses.add(c);
        count++;
        return this;

    }

    // more methods and attributes available

}
// Now consider CareTaker objects within a Carehouse

public class IteratorTest {
    public static void main(String[] args) {
        Hospital H = new Hospital("Hospital_01");
        H.addCareHouse(new CareHouses("CareHouse_01"));
        H.addCareHouse(new CareHouses("CareHouse_02"));
        H.addCareHouse(new CareHouses("CareHouse_03"));
        H.addCareHouse(new CareHouses("CareHouse_04"));
        H.addCareHouse(new CareHouses("CareHouse_05"));
        Iterator iter = H.createIterator();
        while (iter.hasNext())
            System.out.println(iter.next());
    }
}
