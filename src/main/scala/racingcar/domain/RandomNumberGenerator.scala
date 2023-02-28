package racingcar.domain

import scala.util.Random

class RandomNumberGenerator extends NumberGenerator {

  private val random = new Random()

  override def generate: Int = {
    random.nextInt(10)
  }
}
