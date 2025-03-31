package mission;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import mission.model.AsciiGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AsciiGeneratorTest {
    private AsciiGenerator asciiGenerator;

    @BeforeEach
    void setUp() {
        asciiGenerator = new AsciiGenerator();
    }

    @Test
    void getNumberAsciiDesign0Test() {
        List<String> ascii = asciiGenerator.getNumberAsciiDesign(0);
        List<String> zero = List.of("◼◼◼", "◼ ◼", "◼ ◼", "◼ ◼", "◼◼◼");
        assertEquals(zero, ascii);
    }

    @Test
    void getNumberAsciiDesign9Test() {
        List<String> ascii = asciiGenerator.getNumberAsciiDesign(9);
        List<String> zero = List.of("◼◼◼", "◼ ◼", "◼◼◼", "  ◼", "  ◼");
        assertEquals(zero, ascii);
    }

    @Test
    void getNumberAsciiDesign2Test() {
        List<String> ascii = asciiGenerator.getNumberAsciiDesign(2);
        List<String> zero = List.of("◼◼◼", "  ◼", "◼◼◼", "◼  ", "◼◼◼");
        assertEquals(zero, ascii);
    }

    @Test
    void 범위를_초과하면_예외_발생() {
        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> asciiGenerator.getNumberAsciiDesign(10)
        );
    }

    @Test
    void generateAsciiPrintoutTest() {
        List<String> result = asciiGenerator.generateAsciiPrintout(List.of(1, 2, 3, 4), 2);
        result.forEach(System.out::println);
    }
}
