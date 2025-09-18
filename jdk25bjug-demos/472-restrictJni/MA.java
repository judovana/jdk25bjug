import java.lang.foreign.*;

public class MA{
  public static void main(final String... args) throws Exception {
   try (Arena arena = Arena.ofShared()) {
     SequenceLayout SEQUENCE_LAYOUT = MemoryLayout.sequenceLayout(1024, ValueLayout.JAVA_INT);
     MemorySegment segment = arena.allocate(SEQUENCE_LAYOUT);
     int sum = segment.elements(ValueLayout.JAVA_INT).parallel()
                      .mapToInt(s -> s.get(ValueLayout.JAVA_INT, 0))
                      .sum();
    }
  }
}
