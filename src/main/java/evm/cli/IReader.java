package evm.cli;

public interface IReader {
    String readString(String message);
    int readInteger(String message);
    float readFloat(String message);
}
