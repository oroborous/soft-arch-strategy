package edu.wctc.strategy.before;

/**
 * Exponential growth assumes that a population can
 * continue growing infinitely. When graphed, the
 * population size forms a J-shaped curve
 * that grows forever steeper and taller.
 *
 * Of course, this kind of growth can't happen in the
 * real world because of environmental constraints.
 * The LogisticGrowth strategy represents a more
 * realistic algorithm in this regard.
 *
 * See https://www.khanacademy.org/science/biology/ecology/population-growth-and-regulation/a/exponential-logistic-growth
 */
public class ExponentialColony extends BacteriaColony {
    // Percent growth of organisms per time unit
    private double growthRate;

    public ExponentialColony(long population, double growthRate) {
        super(population);
        this.growthRate = growthRate;
    }

    @Override
    public void grow() {
        population = Math.round(population * (1 + growthRate));
    }
}
