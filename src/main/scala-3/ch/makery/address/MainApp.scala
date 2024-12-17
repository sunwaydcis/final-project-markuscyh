package ch.makery.address

import javafx.fxml.FXMLLoader
import javafx.scene as jfxs
import pokemon.*
import scalafx.Includes.*
import scalafx.application.JFXApp3
import scalafx.application.JFXApp3.PrimaryStage
import scalafx.scene as sfxs
import scalafx.scene.Scene

object MainApp extends JFXApp3:

  var roots: Option[sfxs.layout.BorderPane] = None

  override def start(): Unit =
    val rootResource = getClass.getResource("view/RootLayout.fxml")
    val loader = new FXMLLoader(rootResource)
    loader.load()
    roots = Option(loader.getRoot[jfxs.layout.BorderPane])

    stage = new PrimaryStage():
      title = "Pokemon Ole'Ga"
      scene = new Scene():
        root = roots.get

    showStartScreen()

  def showStartScreen(): Unit =
    val resource = getClass.getResource("view/StartScreen.fxml")
    val loader = new FXMLLoader(resource)
    loader.load()
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.get.center = roots

  def showOpeningScene(): Unit =
    val resource = getClass.getResource("view/OpeningScene.fxml")
    val loader = new FXMLLoader(resource)
    loader.load()
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.get.center = roots
  end showOpeningScene
  
  def showTutorialScene(): Unit =
    val resource = getClass.getResource("view/TutorialScene.fxml")
    val loader = new FXMLLoader(resource)
    loader.load()
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.get.center = roots
  end showTutorialScene
  
  //Testing encounters
  var encounterrate = new Encounter()
  var encounter1 = encounterrate.randomGrade()
  var encounter2 = encounterrate.randomGrade()
  var encounter3 = encounterrate.randomGrade()
  
  
  
end MainApp
