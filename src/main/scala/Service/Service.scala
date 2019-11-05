package Service

import Strategies._

trait Service {
  /*
  *Used in MathMain to get which implementation to use
   */
  def getOperation(desiredOperation:Int):ComputeStrategy

  /*
  * Used in PayMain to get which implementation to use at run time
   */
  def getPayType(desiredPay:Int):PayStrategy

  /*
  * Used in WorkMain to see whether that person is working on not.
  */
  def getWork(dayOfWeek:Int):Work
}

object ServiceImpl extends Service {

  //All algorithms are chosen at runtime

  def getOperation(desiredOperation: Int):ComputeStrategy = {
    desiredOperation match {
      case 1 => new addStrat
      case 2 => new subStrat
      case _ => throw new Exception("Not a valid input")
    }
  }

  def getPayType(desiredPay:Int):PayStrategy = {
   desiredPay match {
     case 1 => new payAll
     case 2 => new payHalf
     case _ => throw new Exception("Not a valid input")
   }
  }

  def getWork(dayOfWeek:Int):Work = {
    dayOfWeek match {
      case 1 => new Weekeday
      case 2 => new WeekEnd
      case _ => throw new Exception("Not a valid input")
    }
  }
}
