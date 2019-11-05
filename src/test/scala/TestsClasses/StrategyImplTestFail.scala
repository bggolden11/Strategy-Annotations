package TestsClasses

import Annonatation.StrategyImpl

/*
* Used for testing purposes only
*/

@StrategyImpl(algorithm = "fail")
class StrategyImplTestFail {
  def TestA:Unit = {
      if(true)
        throw new RuntimeException("This should alwys fail since it doesn't extend a StrategyTrait")
  }
}
