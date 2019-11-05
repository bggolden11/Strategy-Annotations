package TestsClasses

import Annonatation.{StrategyImpl, StrategyTrait}

/*
* Used for testing purposes only
*/

@StrategyTrait(purpose = "pay")
trait StrategyTestPass {
  def test:Int
}

@StrategyImpl(algorithm = "test1")
class StrategyTestPassImpl extends StrategyTestPass{
  override def test: Int = 1
}
