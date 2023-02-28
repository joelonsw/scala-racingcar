package racingcar.domain

class Car(val name: String, val position: Int) {

  // TODO: 함수형으로 리팩터링
  def move(number: Int): Car = {
    if (number > 4) new Car(name, position + 1)
    else this
  }

  override def toString: String = {
    "Car(" + this.name + ":" + this.position + ")"
  }
}
