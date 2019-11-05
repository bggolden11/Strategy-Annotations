package Processor;


import Annonatation.StrategyImpl;
import Annonatation.StrategyTrait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;


/*
*Main Processor classes. Contains the doAnnotationMethod
 */


public class Proccessor {
    static Logger logger = LoggerFactory.getLogger(Proccessor.class); //Logger
    private ArrayList<String> strategyClassName = new ArrayList<String>();
    int numberOfAlgorithms = 0;


    /*
    * Method that process the annotation
    * Takes in a class name and searches for that class. Then begins to process each annotation.
    * Annotation processing is done according to README.MD
    * See README.MD for more info
     */

    public void doAnnotationProcessing(String className) {
        Class<?> obj;
        try {
            obj = Class.forName(className);
        } catch (ClassNotFoundException e) {
            logger.error("Class not found" + className);
            return;
        }

        //Process the StrategyTrait
        if (obj.isAnnotationPresent(StrategyTrait.class)) {

            int numAlgorithms = 0;

            int numMethods = obj.getMethods().length;

            if (numMethods < 1) {
                //Error does not have any algorithms to imlement
                logger.error("Not a valid Strategy trait: has no algorithm to implement in trait");
                throw new RuntimeException("Used mainly for testing Error: has no algorithm to implement in trait");
            }
            strategyClassName.add(obj.getName());
        }

        //Process the StrategyImpl
        if (obj.isAnnotationPresent(StrategyImpl.class)) {
            java.lang.Class[] x = obj.getInterfaces();
            String interfaceName = x[0].getName();
            Class<?> upperClass = x[0];
            //Checks to make sure it's extending an StrategyTrait
            if (!upperClass.isAnnotationPresent(StrategyTrait.class)) {
                //Else fail and log what happned.
                logger.error("Not a valid Strategy Impl: Does not extend any Strategy interfaces");
                throw new RuntimeException("Used mainly for testing Error: does not extend a strategy trait");
            }
            numberOfAlgorithms = numberOfAlgorithms + 1;

        }
    }

}
