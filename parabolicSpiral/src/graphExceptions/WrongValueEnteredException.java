/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphExceptions;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 *
 * @author VADIM
 */
public class WrongValueEnteredException extends GraphException{

    public WrongValueEnteredException() {
    }

    public WrongValueEnteredException(String message) {
        super(message);
    }

    public WrongValueEnteredException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongValueEnteredException(Throwable cause) {
        super(cause);
    }

    public WrongValueEnteredException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    @Override
    public String getMessage() {
        return super.getMessage(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getLocalizedMessage() {
        return super.getLocalizedMessage(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public synchronized Throwable getCause() {
        return super.getCause(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public synchronized Throwable initCause(Throwable cause) {
        return super.initCause(cause); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void printStackTrace(PrintStream s) {
        super.printStackTrace(s); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void printStackTrace(PrintWriter s) {
        super.printStackTrace(s); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return super.fillInStackTrace(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public StackTraceElement[] getStackTrace() {
        return super.getStackTrace(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setStackTrace(StackTraceElement[] stackTrace) {
        super.setStackTrace(stackTrace); //To change body of generated methods, choose Tools | Templates.
    }
    
}
