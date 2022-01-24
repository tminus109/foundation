public class FleetOfThings {
    public static void main(String[] args) {
        Fleet fleet = new Fleet();
        Thing milk = new Thing("Get milk");
        Thing obstacles = new Thing("Remove the obstacles");
        Thing up = new Thing("Stand up");
        Thing lunch = new Thing("Eat lunch");

        fleet.add(milk);
        fleet.add(obstacles);
        fleet.add(up);
        fleet.add(lunch);
        up.complete();
        lunch.complete();
        System.out.println(fleet);
    }
}
