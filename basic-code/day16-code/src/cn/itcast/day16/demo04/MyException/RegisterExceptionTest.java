package cn.itcast.day16.demo04.MyException;

public class RegisterExceptionTest extends Exception{
    public RegisterExceptionTest() {
    }

    public RegisterExceptionTest(String message) {
        super(message);
    }

}
