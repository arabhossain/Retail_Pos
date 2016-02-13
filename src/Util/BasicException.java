/*
    Software Engineer
    ---------------------------------------
    Md. Arab Hossain
    Email: arabhossain317@diu.edu.bd
           green.arab1995@gmail.com
    Mobile: +8801827-464330
            +8801737-331037
    Daffodil International University(Student)
 */

package Util;

/**
 *
 * @author Loser
 */
public class BasicException extends java.lang.Exception {
    
    /**
     * Creates a new instance of <code>DataException</code> without detail message.
     */
    public BasicException() {
    }

    /**
     *
     * @param msg
     */
    public BasicException(String msg) {
        super(msg);
    }
    
    /**
     *
     * @param msg
     * @param cause
     */
    public BasicException(String msg, Throwable cause) {
        super(msg, cause);
    }
    
    /**
     *
     * @param cause
     */
    public BasicException(Throwable cause) {
        super(cause);
    }
}
