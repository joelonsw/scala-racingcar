package racingcar.view

import racingcar.domain.Car

import scala.io.StdIn

object View {

  def receiveCarNames(): String = {
    println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
    StdIn.readLine()
  }

  def receiveRoundCount(): Integer = {
    println("시도할 회수는 몇회인가요?")
    StdIn.readInt()
  }

  def printResultMessage(): Unit = {
    println("실행 결과")
  }

  def announceRoundResult(cars: List[Car]): Unit = {
    cars.foreach(printSingleCarResult)
    println()
  }

  private def printSingleCarResult(car: Car): Unit = {
    println(car.name + " : " + ("-" * car.position))
  }

  def announceWinner(winners: List[String]): Unit = {
    val gameWinners = winners.mkString(", ");
    println(s"${gameWinners}가 최종 우승했습니다.")
  }
}
