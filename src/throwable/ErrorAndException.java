package throwable;

import java.io.FileNotFoundException;

/**
 * @program: javabasic
 * @description: 异常实例
 * @author: cxr
 * @create: 2019-09-28 16:39
 **/
public class ErrorAndException {
    private void throwError(){
        throw new StackOverflowError();
    }
    private void throwRuntimeException(){
        throw new RuntimeException();
    }
    private void throwCheckedException() throws FileNotFoundException {
        throw new FileNotFoundException();
    }

    public static void main(String[] args) throws FileNotFoundException {
        ErrorAndException errorAndException = new ErrorAndException();
        errorAndException.throwError();
        errorAndException.throwRuntimeException();
        errorAndException.throwCheckedException();
    }
}
