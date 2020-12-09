package ru.prpaha.changelly.dto;

/**
 * @author Proskurin Pavel (prpaha@rambler.ru)
 */
public class TestRequestData {

    private final String param1;
    private final String param2;

    public TestRequestData(String param1, String param2) {
        this.param1 = param1;
        this.param2 = param2;
    }

    public String getParam1() {
        return param1;
    }

    public String getParam2() {
        return param2;
    }

}
