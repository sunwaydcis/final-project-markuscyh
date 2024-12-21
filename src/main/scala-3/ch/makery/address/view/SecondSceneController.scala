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

@FXML
class SecondSceneController():

  @FXML
  protected var storyLabel: Label = null
  @FXML
  protected var firstImage: ImageView = null
  @FXML
  protected var secondImage: ImageView = null
  @FXML
  protected var nextButton: Button = null
  @FXML
  protected var firstSelect: Button = null
  @FXML
  protected var secondSelect: Button = null
  @FXML
  protected var startButton: Button = null  


  // Set Images
  val pokemonPortrait1: String = "/images/front_portrait/" + MainApp.enemyPokemon1.frontportrait
  val pokemonPortrait2: String = "/images/front_portrait/" + MainApp.enemyPokemon2.frontportrait

  val image1: Image = new Image(getClass.getResourceAsStream(pokemonPortrait1))
  val image2: Image = new Image(getClass.getResourceAsStream(pokemonPortrait2))

  // Count will allow for story progression
  var count: Int = 0

  val storyDialogue1: String = "Nice, you managed to catch the " + MainApp.userPokemon1.name()
  val storyDialogue2: String = "However, the other two Pokemon are still standing in front of you and they are about to attack"
  val storyDialogue3: String = "Your one newly caught Pokemon surely can't defeat them on it's own. Good thing you just so happened to bring your partner Pokemon's Pokeball"
  val storyDialogue4: String = "Your partner will make this an equal battle. However, you struggle to remember who is your partner"
  val storyDialogue5: String = "Who is your partner?"
  var storyDialogue6: String = null
  var storyDialogue7: String = null


  var storyList = Array(storyDialogue1, storyDialogue2, storyDialogue3, storyDialogue4, storyDialogue5)

  def initialize() =
    storyLabel.text = storyList(count)

    firstImage.image = image1
    secondImage.image = image2

  def handleNextDialogue(action: ActionEvent): Unit =
    count = 1 + count
    storyLabel.text = storyList(count)

    if (count == 4) then
      //Reveals buttons
      firstSelect.visible = true
      secondSelect.visible = true

      //Sets the text for the buttons
      firstSelect.text = MainApp.encounter4
      secondSelect.text = MainApp.encounter5

      //Hides Next Button
      nextButton.visible = false
    end if

    if (count == 6) then
      //Hides Next Button
      nextButton.visible = false
      startButton.visible = true
    end if

  def selectFirst(action: ActionEvent): Unit =
    setUserPokemon(MainApp.encounter4)

    nextButton.visible = true
    firstSelect.visible = false
    secondSelect.visible = false

    storyDialogue6 = "Alright! With " + MainApp.userPokemon2.name() + " and " + MainApp.userPokemon1.name() + ", you will surely be able to beat your opponents!"
    storyDialogue7 = "The" + MainApp.enemyPokemon1.name() + " and " + MainApp.enemyPokemon2.name() + " attack! Battle Start!"
    storyList = Array(storyDialogue1, storyDialogue2, storyDialogue3, storyDialogue4, storyDialogue5, storyDialogue6, storyDialogue7)
    count = 1 + count
    storyLabel.text = storyList(count)

  def selectSecond(action: ActionEvent): Unit =
    setUserPokemon(MainApp.encounter5)

    nextButton.visible = true
    firstSelect.visible = false
    secondSelect.visible = false

    storyDialogue6 = "Alright! With " + MainApp.userPokemon2.name() + " and " + MainApp.userPokemon1.name() + ", you will surely be able to beat your opponents!"
    storyDialogue7 = "The " + MainApp.enemyPokemon1.name() + " and " + MainApp.enemyPokemon2.name() + " attack! Battle Start!"
    storyList = Array(storyDialogue1, storyDialogue2, storyDialogue3, storyDialogue4, storyDialogue5, storyDialogue6, storyDialogue7)
    count = 1 + count
    storyLabel.text = storyList(count)
    
  def startBattle(action: ActionEvent): Unit =
    battle()