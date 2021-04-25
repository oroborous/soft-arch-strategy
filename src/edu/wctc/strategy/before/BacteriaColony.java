package edu.wctc.strategy.before;

public abstract class BacteriaColony {
    // The current number of organisms in the colony
    protected long population = 0;

    public BacteriaColony(long population) {
        this.population = population;
    }

    // Notice that we don't have a setPopulation() method
    // The population can only be changed by calling grow()
    public long getPopulation() {
        return population;
    }

    public abstract void grow();
}
