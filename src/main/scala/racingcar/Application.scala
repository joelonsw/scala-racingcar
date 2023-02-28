package racingcar

import racingcar.controller.Controller
import racingcar.domain.RandomNumberGenerator

object Application extends App {
  val controller = new Controller(new RandomNumberGenerator)
  controller.play()
}
