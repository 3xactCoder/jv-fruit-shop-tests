package core.basesyntax.service.impl;

import core.basesyntax.service.FileReader;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FileReaderImplTest {
    private static final String VALID_FILE_PATH = "src/test/resources/test_input.csv";
    private static final String INVALID_FILE_PATH = "src/test/resources/non_existent.csv";
    private FileReader fileReader;

    @BeforeEach
    public void setUp() {
        fileReader = new FileReaderImpl();
    }

    @Test
    public void read_validPath_ok() {
        List<String> actual = fileReader.read(VALID_FILE_PATH);
        Assertions.assertEquals(2, actual.size());
        Assertions.assertEquals("type,fruit,quantity", actual.get(0));
        Assertions.assertEquals("b,banana,20", actual.get(1));
    }

    @Test
    public void read_invalidPath_notOk() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            fileReader.read(INVALID_FILE_PATH);
        });
    }
}




