public class CakeCreator extends DessertCreator{

    @Override
    public Dessert createDessert(){
        return new Cake();
    }
}
