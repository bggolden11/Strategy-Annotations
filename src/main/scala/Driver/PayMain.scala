package Driver

import Processor.Proccessor
import Service.ServiceImpl
import Strategies.{ComputeStrategy, PayStrategy}

/*
  Brian Goldenberg Strategy Design pattern implementation
  Main pay driver function

 */

object PayMain extends App {
  val proc = new Proccessor;
  //Annotation processing
  proc.doAnnotationProcessing("Strategies.PayStrategy")
  proc.doAnnotationProcessing("Strategies.payAll")
  proc.doAnnotationProcessing("Strategies.payHalf")
  println(
    "Welcome to Brian's Strategy design pattern implementation of pay strategy :) " +
      "\n------------------------------------------------------------\n"
  )

  println("Would you like to:\n" +
    "1. pay all \n" +
    "2. pay half\n" +
    "Input the number that corresponds to your desired operation")
  val desiredOperation = scala.io.StdIn.readLine().toInt
  try {
    val operation: PayStrategy = ServiceImpl.getPayType(desiredOperation)
    println("How much money do you have?")
    val num1 = scala.io.StdIn.readLine().toInt

   operation.pay(num1)

  }
  catch {
    case ex:NumberFormatException => println("Exception: Not a valid integer")
    case ex:Exception => println("EXCEPTION: Not a valid operation input")
  }
}
