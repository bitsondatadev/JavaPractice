package us.brianolsen.spring.web.test.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
public class Log4J2PropertiesConf {
	private static Logger logger = LogManager.getLogger();
	
    public void performSomeTask(){
        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warn message");
        logger.error("This is an error message");
        logger.fatal("This is a fatal message");
    }
    
    @Test
    public void testPerformSomeTask() throws Exception {
        Log4J2PropertiesConf log4J2PropertiesConf=new Log4J2PropertiesConf();
        log4J2PropertiesConf.performSomeTask();
    }
}
