package ch.makery.address.view

import pokemon.*
import ch.makery.address.MainApp
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.control.Label
import scalafx.Includes.*
import javafx.scene.image.ImageView //Need to use JavaFX because cannot convert scalafx ImageView to javafx ImageView
import javafx.scene.image.Image

import scala.io.Source


@FXML
class OpeningSceneController():

  @FXML
  protected var storyLabel: Label = null
  @FXML
  protected var firstImage: ImageView = null
  @FXML
  protected var secondImage: ImageView = null
  @FXML
  protected var thirdImage: ImageView = null


  var pokemonEncounter1: EnemyPokemon = new EnemyPokemon(MainApp.encounter1)
  var pokemonEncounter2: EnemyPokemon = new EnemyPokemon(MainApp.encounter2)
  var pokemonEncounter3: EnemyPokemon = new EnemyPokemon(MainApp.encounter3)

  val pokemonPortrait1: String = "/images/front_portrait/pidgeot_front.png"
  val pokemonPortrait2: String = "/images/front_portrait/dartrix_front.png"
  val pokemonPortrait3: String = "/images/front_portrait/sunflora_front.png"


  val image1: Image = new Image(getClass.getResourceAsStream(pokemonPortrait1))
  val image2: Image = new Image(getClass.getResourceAsStream(pokemonPortrait2))
  val image3: Image = new Image(getClass.getResourceAsStream(pokemonPortrait3))


  // Count will allow for story progression
  var count: Int = 0

  // The game dialogue is set.
  val storyDialogue1: String = "It is a beautiful day. The birds are singing and the sun is shining. The good weather and atmosphere of the day prompted you to go on a walk in the forest just out of town"
  val storyDialogue2: String = "All seems to be going well, when all of a sudden you spot some ruffling in the bushes."
  val storyDialogue3: String = "You step forward to take a closer look when all of a sudden -"
  val storyDialogue4: String = "Three wild Pokemon appeared!"
  val storyDialogue5: String = "It is a " + pokemonEncounter1.name() + ", " + pokemonEncounter2.name() + " and " + pokemonEncounter3.name()

  val storyList = List(storyDialogue1, storyDialogue2, storyDialogue3, storyDialogue4, storyDialogue5)



  def initialize() =
    var pokemon_portrait1 = "caterpie_front.png"
    val image1: Image = new Image(getClass.getResourceAsStream("/images/front_portrait/caterpie_front.png"))
    storyLabel.text = storyList(count)


  def handleNextDialogue(action: ActionEvent): Unit =
    count = 1 + count
    storyLabel.text = storyList(count)

    if (count == 4) {
      firstImage.image = image1
      secondImage.image = image2
      thirdImage.image = image3
    }

