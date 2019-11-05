package Strategies

import Annonatation.{StrategyImpl, StrategyTrait}

/*
* This class implement the strategy design patter because the chosen operation is decided at runtime
* Whether it will add or subtract
* Can be seen how to chosen at runtime in the Service class
 */


//Trait for math implemtation is extended by every other class
@StrategyTrait(purpose = "compute")
trait ComputeStrategy {
  def compute(a:Int, b:Int):Int
}

@StrategyImpl(algorithm = "add")
class addStrat extends ComputeStrategy{
  override def compute(a: Int, b: Int): Int = a+b
}

@StrategyImpl(algorithm = "subtract")
class subStrat extends ComputeStrategy{
  override def compute(a: Int, b: Int): Int = a-b
}

