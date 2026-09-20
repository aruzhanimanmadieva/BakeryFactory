public class WeddingBakeryFactory implements BakeryFactory{

    @Override
    public BakeryCake createCake(){
        return new WeddingCake();
    }

    @Override
    public BakeryDecoration createDecoration(){
        return new WeddingDecoration();
    }
}
