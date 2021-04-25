package edu.wctc.templatemethod;

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

    // This is the "template method": a series of steps which
    // are mostly defined here in the superclass. Subclasses
    // will only define the behavior of grow()
    public final void runSimulation(int timeSteps) {
        for (int i = 1; i <= timeSteps; i++) {
            grow();
            System.out.printf("Time %d, Population %d%n", i, population);
            introduceMutations();
            randomizeEnvironment();
        }
    }

    public abstract void grow();

    private void introduceMutations() {
        // Do some science-y stuff.
        // This part of the algorithm does not vary.
    }

    private void randomizeEnvironment() {
        // More science stuff.
        // Every simulation does this the same way.
    }
}
