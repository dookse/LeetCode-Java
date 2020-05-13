package problems.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

// 1436. Destination City
public class P1436 {

    private Map<String, Path> pathMap = new HashMap<>();

    public String destCity(List<List<String>> paths) {
        for (List<String> pathList : paths) {
            String pathName = pathList.get(0);
            String destination = pathList.get(1);
            Path path = pathMap.getOrDefault(pathName, new Path(pathName));
            Path next = pathMap.getOrDefault(destination, new Path(destination));
            path.next = next;
            pathMap.putIfAbsent(pathName, path);
            pathMap.putIfAbsent(destination, next);
        }
        Path start = pathMap.get(paths.get(0).get(0));
        return getDestName(start);
    }

    private String getDestName(Path path) {
        if (path.next == null) {
            return path.name;
        }
        return getDestName(path.next);
    }

    static class Path {

        String name;
        Path next;

        public Path(final String name) {
            this.name = name;
        }
    }

    @Test
    public void test1() {
        List<List<String>> input = new ArrayList<>();
        input.add(Arrays.asList("London", "New York"));
        input.add(Arrays.asList("New York", "Lima"));
        input.add(Arrays.asList("Lima", "Sao Paulo"));
        String expected = "Sao Paulo";
        assertThat(destCity(input)).isEqualTo(expected);
    }
}
