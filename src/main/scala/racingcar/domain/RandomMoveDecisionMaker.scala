package racingcar.domain

import scala.util.Random

class RandomMoveDecisionMaker extends MoveDecisionMaker {

  private val moveThreshold = 4

  private val random = new Random()

  override def move: Boolean = {
    random.nextInt(10) > moveThreshold
  }
}
