package edu.wctc.strategy.before;

/**
 * Logistic growth is like exponential growth, but it takes
 * into account the reality that populations can't grow beyond
 * what their environment can support (the carrying capacity).
 *
 * Therefore, as the population nears its maximum, the rate
 * of growth declines. When graphed, the number of organisms
 * produces an S-shaped curve, as the population hovers around
 * its maximum level.
 *
 * See https://www.khanacademy.org/science/biology/ecology/population-growth-and-regulation/a/exponential-logistic-growth
 */
public class LogisticColony extends BacteriaColony {
    // Percent growth of organisms per time unit
    private double growthRate;
    // The carrying capacity of the environment
    private long maxPopulation;

    public LogisticColony(long population, double growthRate, long maxPopulation) {
        super(population);
        this.growthRate = growthRate;
        this.maxPopulation = maxPopulation;
    }

    @Override
    public void grow() {
        double instantaneousGrowthRate = Math.log1p(growthRate);
        long numerator = population * maxPopulation;
        double denominator = population + (maxPopulation - population) * Math.pow(Math.E, -1 * instantaneousGrowthRate);
        population = Math.round(numerator / denominator);
    }
}
