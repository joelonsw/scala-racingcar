package racingcar

import racingcar.controller.Controller
import racingcar.domain.RandomMoveDecisionMaker

object Application extends App {
  val controller = new Controller(new RandomMoveDecisionMaker)
  controller.play()
}
