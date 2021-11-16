import java.util.EnumSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class MyCollector implements Collector<Integer, TreeSet<Integer>, Integer> {
    @Override
    public Supplier<TreeSet<Integer>> supplier() {
        return TreeSet::new;
    }

    @Override
    public BiConsumer<TreeSet<Integer>, Integer> accumulator() {
        return TreeSet::add;
    }

    @Override
    public BinaryOperator<TreeSet<Integer>> combiner() {
        return (a,b) -> {
            a.addAll(b);
            return a;
        };
    }

    @Override
    public Function<TreeSet<Integer>, Integer> finisher() {
        return s -> s.stream().findFirst().get();

    }

    @Override
    public Set<Characteristics> characteristics() {
        return EnumSet.of(Characteristics.CONCURRENT);
    }

}
