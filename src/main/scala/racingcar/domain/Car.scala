package racingcar.domain

class Car(val name: String, val position: Int) {

  def move(moveDecisionMaker: MoveDecisionMaker): Car = {
    if (moveDecisionMaker.move) new Car(this.name, this.position + 1)
    else this
  }

  override def toString: String = {
    "Car(" + this.name + ":" + this.position + ")"
  }
}
