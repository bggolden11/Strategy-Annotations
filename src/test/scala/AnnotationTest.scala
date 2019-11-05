import java.lang.Exception
import java.lang.annotation.Annotation

import Annonatation.{StrategyImpl, StrategyTrait}
import Processor.Proccessor
import TestsClasses.{StrategyImplTestFail, StrategyTraitTestFail}
import org.scalatest.FlatSpec

/*
* Scala file where the annotation testing is done.
* Uses the TestClasses folder and all the classes inside for verifying the annotations
* work correctly.
* Total of 6 tests. Tests include both Exceptions and correct input
 */

class AnnotationTest extends FlatSpec {

  val annotationClass = classOf[StrategyImplTestFail].getAnnotation(classOf[StrategyImpl])
  val annotationTrait = classOf[StrategyTraitTestFail].getAnnotation(classOf[StrategyTrait])
  val proc = new Proccessor;


  "StrategyImpl" should "get the algorithm " in {
    annotationClass match {
      case x: StrategyImpl => assert(x.algorithm() == "fail")
      case _ => fail("Did not find annotation")
    }
  }

  "StrategyTrait" should "get the purpose" in {
    annotationTrait match {
      case x: StrategyTrait => assert(x.purpose() == "testing")
      case _ => fail("Did not find annotation")
    }
  }

  "Processor" should "throw an exception when Strategy trait does not have any methods" in {
    assertThrows[Exception] {
      proc.doAnnotationProcessing("TestsClasses.StrategyTraitTestFail")
      }
    }

  "Processor" should  "throw an exception does not extend a StrategyTrait " in {
    assertThrows[Exception] {
      proc.doAnnotationProcessing("TestsClasses.StrategyImplTestFail")
      }
    }

   "Process" should "Not throw an exception when it is trait implemented correctly" in {
     try{
       proc.doAnnotationProcessing("TestsClasses.StrategyTestPass")
       //Excpected so continue
     }
     catch {
       case _: Exception => fail("Was not supposed to throw an exception")
     }
   }

  "Process" should "Not throw an exception when it is class implemented correctly" in {
    try{
      proc.doAnnotationProcessing("TestsClasses.StrategyTestPassImpl")
      //Excpected so continue
    }
    catch {
      case _: Exception => fail("Was not supposed to throw an exception")
    }
  }


  }


