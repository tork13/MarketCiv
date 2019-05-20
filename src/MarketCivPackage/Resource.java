package MarketCivPackage;

public class Resource {
    private int quantity;
    private int cost;
    private String type;
    private int level;

    public Resource(int q, int c, String t, int l){
        quantity = q;
        cost = c;
        type = t;
        level = l;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getType() {
        return type;
    }

    public int getLevel() {
        return level;
    }

}
