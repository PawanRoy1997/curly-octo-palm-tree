package problems;

import org.junit.jupiter.api.Assertions;

import java.io.*;
import java.net.URL;
import java.util.function.Consumer;

public abstract class BaseTest {
    private String expectedOutput = "";
    private String inputToProgram = "";
    private ByteArrayOutputStream outputStream;

    public void performTest(String inputFileName, String outputFileName, Runnable function) {
        setExpectedOutput(outputFileName);
        setInput(inputFileName);
        setOutputStream();
        provideInput();
        function.run();
        Assertions.assertEquals(expectedOutput, outputStream.toString());
    }

    private void setOutputStream() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    private void provideInput() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputToProgram.getBytes());
        System.setIn(inputStream);
    }

    private void setInput(String inputFileName) {
        File file = getFile(inputFileName);
        consumeFileAs(file, addLineToInput());
    }

    private void setExpectedOutput(String outputFileName) {
        File file = getFile(outputFileName);
        consumeFileAs(file, addLineToOutput());
    }

    private void consumeFileAs(File file, Consumer<String> fileConsumer) {
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            br.lines().forEach(fileConsumer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private File getFile(String outputFileName) {
        URL resources = this.getClass().getClassLoader().getResource(outputFileName);
        assert resources != null;
        return new File(resources.getPath());
    }

    private Consumer<String> addLineToOutput() {
        return line -> expectedOutput += line + "\n";
    }

    private Consumer<String> addLineToInput() {
        return line -> inputToProgram += line + "\n";
    }
}
