package ch.makery.address.view

import pokemon.*
import ch.makery.address.MainApp
import ch.makery.address.MainApp.*
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.control.Label
import scalafx.Includes.*
import javafx.scene.image.ImageView
import javafx.scene.image.Image
import javafx.scene.control.Button
import scalafx.scene.media.{Media, MediaPlayer}

import java.nio.file.Paths


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
  @FXML
  protected var nextButton: Button = null
  @FXML
  protected var firstSelect: Button = new Button()
  @FXML
  protected var secondSelect: Button = new Button()
  @FXML
  protected var thirdSelect: Button = new Button()


  //Allows for the retrieval of necessary Pokemon Information
  var pokemonEncounter1: EnemyPokemon = new EnemyPokemon(MainApp.encounter1)
  var pokemonEncounter2: EnemyPokemon = new EnemyPokemon(MainApp.encounter2)
  var pokemonEncounter3: EnemyPokemon = new EnemyPokemon(MainApp.encounter3)

  //Sets the image for the Pokemon
  val pokemonPortrait1: String = "/images/front_portrait/" + pokemonEncounter1.frontportrait
  val pokemonPortrait2: String = "/images/front_portrait/" + pokemonEncounter2.frontportrait
  val pokemonPortrait3: String = "/images/front_portrait/" + pokemonEncounter3.frontportrait

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
  val storyDialogue5: String = "It is a " + pokemonEncounter1.name() + ", a " + pokemonEncounter2.name() + " and a " + pokemonEncounter3.name()
  val storyDialogue6: String = "The three Pokemon are Pokemon that you were planning to add to your team, however you only have a single Masterball on you right now. You are certain that no matter which of the three you catch, the other two will attack you. "
  val storyDialogue7: String = "Which of the three Pokemon will you catch?"

  val storyList = List(storyDialogue1, storyDialogue2, storyDialogue3, storyDialogue4, storyDialogue5, storyDialogue6, storyDialogue7)



  def initialize() =
    storyLabel.text = storyList(count)


  def handleNextDialogue(action: ActionEvent): Unit =
    count = 1 + count
    storyLabel.text = storyList(count)

    if (count == 3) then
      MainApp.mediaPlayer.stop()
      val tenseMusic: Media = new Media(Paths.get("src/main/resources/audio/tense_music.mp3").toUri.toString)
      MainApp.mediaPlayer = null
      MainApp.mediaPlayer = new MediaPlayer(tenseMusic)
      MainApp.mediaPlayer.play()
      firstImage.image = image1
      secondImage.image = image2
      thirdImage.image = image3
    end if
    
    if (count == 6) then
      //Reveals buttons
      firstSelect.visible = true
      secondSelect.visible = true
      thirdSelect.visible = true

      //Sets the text for the buttons
      firstSelect.text = pokemonEncounter1.name()
      secondSelect.text = pokemonEncounter2.name()
      thirdSelect.text = pokemonEncounter3.name()

      //Hides Next Button
      nextButton.visible = false
    end if

  def catchFirst(action: ActionEvent): Unit =
    setEnemyPokemon(pokemonEncounter2.name(), pokemonEncounter3.name(), pokemonEncounter1.name())
    showSecondScene()
    
  def catchSecond(action: ActionEvent): Unit =
    setEnemyPokemon(pokemonEncounter1.name(), pokemonEncounter3.name(), pokemonEncounter2.name())
    showSecondScene()
    
  def catchThird(action: ActionEvent): Unit =
    setEnemyPokemon(pokemonEncounter1.name(), pokemonEncounter2.name(), pokemonEncounter3.name())
    showSecondScene()