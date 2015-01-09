package org.fix4j.test.plumbing;

/**
 * User: ben
 * Date: 21/11/14
 * Time: 4:49 PM
 */
public abstract class AbstractChainedConsumer<M> implements Consumer<M>, Processor<M>{
    private final Consumer<M> destination;

    public AbstractChainedConsumer(final Consumer<M> destination) {
        this.destination = destination;
    }

    @Override
    public void accept(M m) {
        m = process(m);
        if(m != null){
            destination.accept(m);
        }
    }
}
