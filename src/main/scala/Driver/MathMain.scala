package Driver

import Service.ServiceImpl
import Strategies.ComputeStrategy
import _root_.Processor.Proccessor

/*
  Brian Goldenberg Strategy Design pattern implementation
  Main math driver function

 */
object MathMain extends App {
  type Computer = (Int, Int) => Int
  val proc = new Proccessor;
  //Annotation processing
  proc.doAnnotationProcessing("Strategies.ComputeStrategy")
  proc.doAnnotationProcessing("Strategies.addStrat")
  proc.doAnnotationProcessing("Strategies.subStrat")
  println(
       "Welcome to Brian's Strategy design pattern implementation of math strategy:) " +
       "\n------------------------------------------------------------\n"
  )

  println("Would you like to:\n" +
    "1. add \n" +
    "2. subtract\n" +
    "Input the number that corresponds to your desired operation")
  val desiredOperation = scala.io.StdIn.readLine().toInt
  try {
    val operation: ComputeStrategy = ServiceImpl.getOperation(desiredOperation)
    println("Input the first integer for the operation")
    val num1 = scala.io.StdIn.readLine().toInt

    println("Input the second integer for the operation")
    val num2 = scala.io.StdIn.readLine().toInt

    val answer:Int = operation.compute(num1,num2)
    println("The output is " + answer)
  }
  catch {
    case ex:NumberFormatException => println("Exception: Not a valid integer")
    case ex:Exception => println("EXCEPTION: Not a valid operation input")
  }
}
