// Name: Waleed Albishri
// section: XA
// Email: wwalbishri@stu.kau.edu.sa
public class Site {
   private String name;
   private int cost;
   private String[] districts;

    public Site(String name, int cost, String[] districts) {
        this.name = name;
        this.cost = cost;
        this.districts = districts;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public String[] getDistricts() {
        return districts;
    }

    @Override
    public String toString() {
        return name;
    }
   
   
}
