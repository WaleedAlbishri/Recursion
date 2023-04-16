// Name: Waleed Albishri
// section: XA
// Email: wwalbishri@stu.kau.edu.sa
import java.util.ArrayList;
public class Recursion {

    public static void main(String[] args) {
        // new Site array to store sites in it
        ArrayList<Site> sites = new ArrayList<>();
        int budget = 80000000;
        String budgettoprint = String.format("%,d", budget);
        // create new site and store it in sites array
        sites.add(new Site("Site1", 20000000, new String[]{"Al-Aziziya", "Ar-Rihab", "Mosharafa", "Al-Faysaliya"}));
        sites.add(new Site("Site2", 50000000, new String[]{"Ar-Rihab", "Bani Malik", "An-Naseem", "Al-Balad"}));
        sites.add(new Site("Site3", 40000000, new String[]{"Al-Balad", "Al-Salam", "Al-Makarona", "As-Salmiya", "Al-Gozain"}));
        sites.add(new Site("Site4", 10000000, new String[]{"As-Salmiya", "Al-Gozain", "Al-Hamdaniya"}));
        sites.add(new Site("Site5", 30000000, new String[]{"Mosharafa", "Al-Faysaliya", "An-Naseem", "Al-Balad"}));
        sites.add(new Site("Site6", 10000000, new String[]{"Al-Balad", "Al-Salam", "Al-Hamdaniya"}));
        sites.add(new Site("Site7", 60000000, new String[]{"Al-Balad", "Mosharafa", "Al-Salam", "Al-Makarona", "As-Salmiya"}));
        sites.add(new Site("Site8", 50000000, new String[]{"Ar-Rihab", "Bani Malik", "Al-Makarona", "As-Salmiya", "Al-Balad"}));
        // send to recursion method
        ArrayList<Site> ww = bestknapsack(sites, budget, 0, new ArrayList<>());
        // print
        System.out.println("Suppose total available funds (budget) are: SARs "+ budgettoprint+". The optimal coverage is "+ww+" which covers "+calcmodeeer(ww)+" districts.");
    }

    public static ArrayList<Site> bestknapsack(ArrayList<Site> areas, int moneyB, int se, ArrayList<Site> jan6a) {
        // base case
        if (moneyB == 0 || se == (areas.size() - 1)) {
            return jan6a;
        } else if (areas.get(se).getCost() > moneyB) {
            return bestknapsack(areas, moneyB, se + 1, jan6a);
        } else {
            ArrayList<Site> jan6aK = new ArrayList<>();
            jan6aK.addAll(jan6a);
            jan6a.add(areas.get(se));
            ArrayList<Site> i = bestknapsack(areas, (moneyB - areas.get(se).getCost()), se + 1, jan6a);
            ArrayList<Site> ii = bestknapsack(areas, moneyB, se + 1, jan6aK);
            if (calcmodeeer(i) > calcmodeeer(ii)) {
                return i;
            } else {
                return ii;
            }
        }
    }
    
    public static int calcmodeeer(ArrayList<Site> areas) {
        // calc unique district
        ArrayList<String> tempareas = new ArrayList<>();
        for (int i = 0; i < areas.size(); i++) {
            for (String district : areas.get(i).getDistricts()) {
                if (!tempareas.contains(district)) {
                    tempareas.add(district);
                }
            }
        }
        return tempareas.size();
    }
}
