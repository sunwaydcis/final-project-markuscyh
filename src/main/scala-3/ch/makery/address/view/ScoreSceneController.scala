package ch.makery.address.view

import ch.makery.address.MainApp
import ch.makery.address.MainApp.*
import javafx.event.ActionEvent
import javafx.scene as jfxs
import javafx.fxml.{FXML, FXMLLoader}
import javafx.scene.control.{Button, Label}
import scalafx.Includes.*
import scalafx.scene as sfxs

@FXML
class ScoreSceneController():

  @FXML
  protected var userHpScore: Label = null
  @FXML
  protected var enemyHpScore: Label = null
  @FXML
  protected var turnDivider: Label = null
  @FXML
  protected var caughtMultiplier: Label = null
  @FXML
  protected var totalScore: Label = null

  def initialize(): Unit =
    MainApp.caught += 1
    val totalUserHpScore: Double = math.ceil(MainApp.userPokemon1.scoreCalculation() + MainApp.userPokemon2.scoreCalculation()).toInt
    val totalEnemyHpScore: Double = math.ceil(MainApp.enemyPokemon1.scoreCalculation() + MainApp.enemyPokemon2.scoreCalculation()).toInt
    val finalScore: Double = math.ceil(((totalUserHpScore + totalEnemyHpScore) / MainApp.turns) * MainApp.caught).toInt

    userHpScore.text = totalUserHpScore + ""
    enemyHpScore.text = totalEnemyHpScore + ""
    turnDivider.text = MainApp.turns + ""
    caughtMultiplier.text = MainApp.caught + ""
    totalScore.text = finalScore + ""

  def handleReturn(action: ActionEvent): Unit =
    MainApp.mediaPlayer.stop()
    showStartScreen()