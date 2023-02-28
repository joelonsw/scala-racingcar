package racingcar.controller

import racingcar.domain.{Car, MoveDecisionMaker}
import racingcar.view.View

class Controller(val moveDecisionMaker: MoveDecisionMaker) {

  def play(): Unit = {
    val initialCars: List[Car] = initiateCars()
    val roundCount: Integer = View.receiveRoundCount()
    View.printResultMessage()

    val finalResultCars: List[Car] = proceedAllRounds(initialCars, roundCount)
    announceWinner(finalResultCars)
  }

  private def initiateCars(): List[Car] = {
    val carNames: String = View.receiveCarNames()
    carNames.split(",").map(_.trim).map(new Car(_, 0)).toList
  }

  // TODO: 원리 파악하기 (이런게 된다고...?)
  private def proceedAllRounds(initialCars: List[Car], roundCount: Integer): List[Car] = {
    (1 to roundCount).foldLeft(initialCars) {(cars, _) => {
      proceedRound(cars)
    }}
  }

  private def proceedRound(cars: List[Car]): List[Car] = {
    val afterRound: List[Car] = cars.map(_.move(moveDecisionMaker))
    View.announceRoundResult(afterRound)
    afterRound
  }

  private def announceWinner(cars: List[Car]): Unit = {
    val maxPosition: Integer = cars.map(_.position).max
    val winners: List[String] = cars.filter(_.position == maxPosition).map(_.name)
    View.announceWinner(winners)
  }
}
