package ch.makery.address.view

import ch.makery.address.MainApp
import ch.makery.address.MainApp.*
import javafx.event.ActionEvent
import javafx.fxml.FXML

@FXML
class StartScreenController:
  

  def handleStartGame(action: ActionEvent): Unit =
    showOpeningScene()

  def handleTutorialScreen(action: ActionEvent): Unit =
    showTutorialScene()