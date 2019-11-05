package Strategies

import Annonatation.{StrategyImpl, StrategyTrait}

/*
* This class implement the strategy design patter because the chosen operation is decided at runtime
* Whether it will work that day or not
* Can be seen how to chosen at runtime in the Service class
 */

@StrategyTrait(purpose = "hire")
trait Work {
  def work():Boolean
}

@StrategyImpl(algorithm = "weekday")
class Weekeday extends Work{
  override def work(): Boolean =  true
}

@StrategyImpl(algorithm = "weekend")
class WeekEnd extends Work{
  override def work(): Boolean = false
}




