package Driver

import Processor.Proccessor
import Service.ServiceImpl
import Strategies.Work

/*
  Brian Goldenberg Strategy Design pattern implementation
  Main math driver function

 */

object WorkMain extends App {
  val proc = new Proccessor;
  //Annotation processing
  proc.doAnnotationProcessing("Strategies.Work")
  proc.doAnnotationProcessing("Strategies.Weekeday")
  proc.doAnnotationProcessing("Strategies.WeekEnd")
  println(
    "Welcome to Brian's Strategy design pattern implementation of work strategy :) " +
      "\n------------------------------------------------------------\n"
  )

  println("Would you like to:\n" +
    "1. Weekday \n" +
    "2. Weekend\n" +
    "Input the number that corresponds to your desired day")
  val desireDay = scala.io.StdIn.readLine().toInt
  try {
    val operation: Work = ServiceImpl.getWork(desireDay)
    if(operation.work()) {
      println("You are working today")
    }
    else{
      println("You are not working today")
    }
  }
  catch {
    case ex:NumberFormatException => println("Exception: Not a valid integer")
    case ex:Exception => println("EXCEPTION: Not a valid operation input")
  }
}
