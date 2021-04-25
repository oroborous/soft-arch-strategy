package edu.wctc.templatemethod;

/**
 * This population never grows. It always remains
 * exactly the same, no matter how much time passes.
 */
public class NoGrowthColony extends BacteriaColony{
    public NoGrowthColony(long population) {
        super(population);
    }

    @Override
    public void grow() {
        return;
    }
}
