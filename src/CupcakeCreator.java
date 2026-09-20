public class CupcakeCreator extends DessertCreator{

    @Override
    public Dessert createDessert(){
        return new Cupcake();
    }
}
