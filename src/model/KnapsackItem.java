package model;

public class KnapsackItem {
	
	private int id;
	private int weight;
	private int price;
	
	public KnapsackItem(int id, int weight, int price){
		this.id = id;
		this.weight = weight;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.id;
        hash = 71 * hash + this.weight;
        hash = 71 * hash + this.price;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final KnapsackItem other = (KnapsackItem) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.weight != other.weight) {
            return false;
        }
        if (this.price != other.price) {
            return false;
        }
        return true;
    }
}
