package OrtherCode.JMH;

import org.openjdk.jmh.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Thread)
public class JMHExample01 {
    private static final String DATA = "123";

    private List<String> arrayList;
    private List<String> linkedList;


}
