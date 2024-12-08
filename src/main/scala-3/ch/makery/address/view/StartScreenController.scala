package ch.makery.address.view

import ch.makery.address.MainApp
import ch.makery.address.MainApp.*
import javafx.event.ActionEvent
import javafx.scene as jfxs
import javafx.fxml.{FXML, FXMLLoader}
import javafx.scene.control.Button
import scalafx.Includes.*
import scalafx.scene as sfxs

@FXML
class StartScreenController():
  

  def handleStartGame(action: ActionEvent): Unit =
    showOpeningScene()

  def handleTutorialScreen(action: ActionEvent): Unit =
    showTutorialScene()