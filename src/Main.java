public class Main {

    public static void main(String[] args) {

        // Factory Method
        DessertCreator cakeCreator = new CakeCreator();
        Dessert cake = cakeCreator.createDessert();
        cake.prepare();

        DessertCreator cupcakeCreator = new CupcakeCreator();
        Dessert cupcake = cupcakeCreator.createDessert();
        cupcake.prepare();

        System.out.println();

        // Abstract Factory: Birthday
        BakeryFactory birthdayFactory = new BirthdayBakeryFactory();

        BakeryCake birthdayCake = birthdayFactory.createCake();
        BakeryDecoration birthdayDecoration = birthdayFactory.createDecoration();

        birthdayCake.make();
        birthdayDecoration.decorate();

        System.out.println();

        // Abstract Factory: Wedding/
        BakeryFactory weddingFactory = new WeddingBakeryFactory();

        BakeryCake weddingCake = weddingFactory.createCake();
        BakeryDecoration weddingDecoration = weddingFactory.createDecoration();

        weddingCake.make();
        weddingDecoration.decorate();
    }
}
