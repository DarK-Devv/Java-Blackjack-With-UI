package model;


/**
 *
 * Prints info, warning and error messages
 *
 */
public class Logger {

    /**
     * Instance of Logger singleton
     */
    public static Logger instance;

    /**
     * Levels of logging
     */
    public enum LogLevel{ALL, DEV, PROD};


    private static LogLevel logLevel;

    /**
     * Sets system log level.
     * Levels: ALL, DEV, PROD.
     * if set to:
     * ALL, prints ALL, DEV and PROD messages.
     * DEV, prints DEV and PROD messages.
     * PROD, prints only PROD messages.
     *
     * @param lvl must be enum LogLevel
     */
    public static void setLogLevel(LogLevel lvl){
        logLevel = lvl;
        if (lvl == LogLevel.DEV) {
            System.out.println("!!!!!!!!!!!!!!!!!!");
            System.out.println("!!   Loglevel   !!");
            System.out.println("!!    set to    !!");
            System.out.println("!!      dev     !!");
            System.out.println("!!!!!!!!!!!!!!!!!!");
            System.out.println("\n\n");
        }else {
            System.out.println("!!!!!!!!!!!!!!!!!!");
            System.out.println("!!   Loglevel   !!");
            System.out.println("!!    set to    !!");
            System.out.println("!!      all     !!");
            System.out.println("!!!!!!!!!!!!!!!!!!");
            System.out.println("\n\n");
        }
    }

    /**
     * Prints message if message loglevel is same or narrower than system loglevel
     *
     * @param lvl must be enum LogLevel (ALL, DEV or PROD)
     * @param message String to be printed to console
     */
    public static void log(LogLevel lvl, String message){
        if (lvl.ordinal() >= logLevel.ordinal()){
            System.out.println(message);
        }
    }


}
