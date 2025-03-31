package mission.model;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import mission.utils.Utility;

public class AsciiGenerator {
    private final List<List<String>> data;

    static private final List<String> fileNames = List.of(
            "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
    );
    static private final int ASCII_HEIGHT = 5;

    public AsciiGenerator() {
        data = new ArrayList<>();
        fileNames.forEach(fileName -> {
            try {
                Path path = Paths.get(Objects.requireNonNull(
                        getClass().getClassLoader().getResource("numberAsciiDesign/" + fileName + ".txt")
                ).toURI());
                String content = Files.readString(path);

                List<String> paddedLines = Arrays.stream(content.split("\n"))
                        .map(line -> String.format("%-3s", line))
                        .toList();

                data.add(paddedLines);
            } catch (URISyntaxException | IOException e) {
                throw new IllegalStateException("[ERROR] 아스키아트를 로드하지 못했습니다.");
            }
        });
    }

    public List<String> getNumberAsciiDesign(int number) {
        try {
            return data.get(number);
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalStateException("[ERROR] 범위를 초과했습니다. ");
        }
    }

    private List<List<String>> getNumberAsciiDesign(List<Integer> numbers) {
        return numbers.stream().map(this::getNumberAsciiDesign).toList();
    }

    private List<String> concatAsciiLine(List<List<String>> lines) {
        return IntStream.range(0, ASCII_HEIGHT)
                .mapToObj(lineIndex -> {
                    List<String> line = new ArrayList<>();
                    lines.forEach(ascii -> line.add(ascii.get(lineIndex)));
                    return String.join("  ", line);
                })
                .toList();
    }

    public List<String> generateAsciiPrintout(List<Integer> numbers, int width) {
        return Utility.chunkList(numbers, width).stream()
                .map(this::getNumberAsciiDesign)
                .map(this::concatAsciiLine)
                .flatMap(list -> Stream.concat(list.stream(), Stream.of("")))
                .toList();
    }
}
