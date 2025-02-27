import java.util.ArrayList;
import java.util.List;

class SpotifyPlan {
    private String planName;
    private List<PlanItem> items = new ArrayList<>();

    public SpotifyPlan(String planName) {
        this.planName = planName;
    }

    public void add(PlanItem item) {
        items.add(item);
    }

    public double getTotalCost() {
        return items.stream().mapToDouble(PlanItem::getCost).sum();
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder("Spotify Plan " + planName + ":\n");
        for (PlanItem item : items) {
            text.append(item).append("\n");
        }
        text.append("Total cost: ").append(getTotalCost());
        return text.toString();
    }
}

class PlanItem {
    private String name;
    private double cost;

    public PlanItem(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return name + ": $" + cost;
    }
}

abstract class SpotifyPlanBuilder {
    protected SpotifyPlan plan;

    public void reset(String planName) {
        plan = new SpotifyPlan(planName);
    }

    public SpotifyPlan getPlan() {
        return plan;
    }

    public abstract void addMainFeature();
    public abstract void addAdditionalFeature();
    public abstract void addPremiumFeature();
    public abstract void addFamilyFeature();
}

class IndividualPlanBuilder extends SpotifyPlanBuilder {
    @Override
    public void addMainFeature() {
        plan.add(new PlanItem("Música sin anuncios", 9.99));
    }

    @Override
    public void addAdditionalFeature() {
        plan.add(new PlanItem("Descargas offline", 2.99));
    }

    @Override
    public void addPremiumFeature() {
        plan.add(new PlanItem("Calidad de audio alta", 4.99));
    }

    @Override
    public void addFamilyFeature() {
    }
}

class FamilyPlanBuilder extends SpotifyPlanBuilder {
    @Override
    public void addMainFeature() {
        plan.add(new PlanItem("Música sin anuncios", 14.99));
    }

    @Override
    public void addAdditionalFeature() {
        plan.add(new PlanItem("Descargas offline", 0.0));
    }

    @Override
    public void addPremiumFeature() {
        plan.add(new PlanItem("Calidad de audio alta", 0.0));
    }

    @Override
    public void addFamilyFeature() {
        plan.add(new PlanItem("Acceso familiar (6 cuentas)", 0.0));
    }
}

class SpotifyPlanDirector {
    private SpotifyPlanBuilder builder;

    public SpotifyPlanDirector(SpotifyPlanBuilder builder) {
        this.builder = builder;
    }

    public void constructPlan(String planName) {
        builder.reset(planName);
        builder.addMainFeature();
        builder.addAdditionalFeature();
        builder.addPremiumFeature();
        builder.addFamilyFeature();
    }
}

public class builder {
    public static void main(String[] args) {
        SpotifyPlanBuilder individualBuilder = new IndividualPlanBuilder();
        SpotifyPlanDirector individualDirector = new SpotifyPlanDirector(individualBuilder);
        individualDirector.constructPlan("Individual");
        System.out.println(individualBuilder.getPlan());

        SpotifyPlanBuilder familyBuilder = new FamilyPlanBuilder();
        SpotifyPlanDirector familyDirector = new SpotifyPlanDirector(familyBuilder);
        familyDirector.constructPlan("Familiar");
        System.out.println(familyBuilder.getPlan());
    }
}
