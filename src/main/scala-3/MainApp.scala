package ch.makery.address
import `type`.Type
import pokemon.*
import javafx.fxml.FXMLLoader
import scalafx.scene as sfxs
import javafx.scene as jfxs
import scalafx.Includes.*
import scalafx.application.JFXApp3
import scalafx.application.JFXApp3.PrimaryStage
import scalafx.scene.Scene
import scala.util.Random

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


  //Testing encounters
  var encounterrate = new Encounter()
  var e = encounterrate.randomGrade()
  println(e)
  var pokemon = new UserPokemon(e)
  println(pokemon.name())
  println(pokemon.grade())
end MainApp
