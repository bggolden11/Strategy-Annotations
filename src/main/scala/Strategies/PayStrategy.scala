package Strategies

import Annonatation.{StrategyImpl, StrategyTrait}

/*
* This class implement the strategy design patter because the chosen operation is decided at runtime
* Whether it will pay half or pay all
* Can be seen how to chosen at runtime in the Service class
 */



@StrategyTrait(purpose = "pay")
trait PayStrategy {
  def pay(amountOwmed:Int):Unit
}

@StrategyImpl(algorithm = "pay full")
class payAll extends PayStrategy{
  override def pay(amountOwmed: Int): Unit = {
    System.out.println("You have " + amountOwmed + " but now that you've paid you have 0")
  }
}

@StrategyImpl(algorithm = "pay half")
class payHalf extends PayStrategy{
  override def pay(amountOwmed: Int): Unit = {
    System.out.println("You have " + amountOwmed + " but now that you've paid you have " + amountOwmed/2)
  }
}


