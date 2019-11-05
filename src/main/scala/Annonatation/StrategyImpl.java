package Annonatation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/*
* Used for actual classes. Should be used when extending a StrategyTrait trait.
* Proccessor checks that annotation meets guidlines
* */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface StrategyImpl {
    String algorithm();
}