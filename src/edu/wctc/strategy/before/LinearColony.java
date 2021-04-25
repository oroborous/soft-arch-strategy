package edu.wctc.strategy.before;

/**
 * A linear growth algorithm adds the same
 * number of individuals to the population
 * (the delta) every time step. It doesn't
 * take population size into account when
 * determining how many new organisms are
 * created.
 *
 * For example, a population of size 100
 * with a delta of 5 will grow to 105, 110,
 * 115, and so on. Even when the population
 * reaches 1,000,000, it will still only grow
 * by 5 at a time.
 */
public class LinearColony extends BacteriaColony {
    private int delta;

    public LinearColony(long population, int delta) {
        super(population);
        this.delta = delta;
    }

    @Override
    public void grow() {
        population += delta;
    }
}
