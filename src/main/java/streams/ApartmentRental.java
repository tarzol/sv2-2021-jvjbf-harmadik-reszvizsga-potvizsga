package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ApartmentRental {

    private List<Apartment> apartments = new ArrayList<>();

    public void addApartment(Apartment apartment) {
        apartments.add(apartment);
    }

//    Legyen egy metódus, ami location alapján leszűri a lakásokat.
    public List<Apartment> findApartmentByLocation(String location){
        return apartments.stream()
                .filter(a->a.getLocation().equals(location))
                .collect(Collectors.toList());
    }

//    Legyen egy metódus, ami paraméterül vár valamennyi extrát és visszaadja azokat a lakásokat amik ezt tartalmazzák.
       public List<Apartment> findApartmentByExtras(String... extras ) {
            return null;
//        return apartments.stream()
//                .filter(a->a.getExtras().contains())
   }


//    Legyen egy metódus, ami egy beérkezett fürdőszoba típus alapján visszaadja, hogy van-e olyan lakás a listában
    public boolean isThereApartmentWithBathroomType(BathRoomType bathRoomType) {
        return apartments.stream()
                .anyMatch(a->a.getBathRoomType().equals(bathRoomType));
    }

//    Legyen egy metódus, ami kigyűjti egy listába, hogy milyen méretű apartmanok vannak a listában.
    public List<Integer> findApartmentsSize() {
        return apartments.stream()
                .map(a->a.getSize())
                .collect(Collectors.toList());
    }



}
