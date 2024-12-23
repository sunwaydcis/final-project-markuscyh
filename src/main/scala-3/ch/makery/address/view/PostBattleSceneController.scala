package ch.makery.address.view

import pokemon.*
import pokeball.*
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
class PostBattleSceneController():

  @FXML
  protected var storyLabel: Label = null
  @FXML
  protected var firstImage: ImageView = null
  @FXML
  protected var secondImage: ImageView = null
  @FXML
  protected var nextButton: Button = null
  @FXML
  protected var finalButton: Button = null


  // Set Images
  val pokemonPortrait1: String = "/images/front_portrait/" + MainApp.enemyPokemon1.frontportrait
  val pokemonPortrait2: String = "/images/front_portrait/" + MainApp.enemyPokemon2.frontportrait

  val image1: Image = new Image(getClass.getResourceAsStream(pokemonPortrait1))
  val image2: Image = new Image(getClass.getResourceAsStream(pokemonPortrait2))

  // Count will allow for story progression
  var count: Int = 0

  var storyDialogue1: String = null
  var storyDialogue2: String = null
  var storyDialogue3: String = null
  var storyDialogue4: String = null
  var storyDialogue5: String = null
  var storyDialogue6: String = null
  var storyDialogue7: String = null
  var storyDialogue8: String = null
  var storyDialogue9: String = null
  var storyDialogue10: String = null

  val pokeball: CatchRate = new CatchRate()
  val pokemon1Catch: Boolean = pokeball.catchResult(MainApp.enemyPokemon1.grade)
  val pokemon2Catch: Boolean = pokeball.catchResult(MainApp.enemyPokemon2.grade)

  if MainApp.postBattle then
    storyDialogue1 = "The two wild Pokemon have been defeated. They can now be captured safely, thats if you had any Pokeballs on you."
    storyDialogue2 = "As you turn to leave the forest and go home with your newly acquired partner, you spot a glint in a nearby bush."
    storyDialogue3 = "You step forward to take a closer look and rather than one glint, you spot two glints in the bush."
    storyDialogue4 = "You recognize the glints being from two Pokeballs of the same type. What type of Pokeballs, you weren't able to see as the two wild Pokemon start to recover."
    storyDialogue5 = "You rush to obtain the Pokeballs to catch the weakened Pokemon. You grab, pull out - "
    storyDialogue6 = "Two " + pokeball.name + "s and throw them at the wild Pokemon"
    storyDialogue7 = "One"
    storyDialogue8 = "Two"
    storyDialogue9 = "Three"
    if pokemon1Catch && pokemon2Catch then
      storyDialogue10 = "Congratulations, you have caught " + MainApp.enemyPokemon1.name() + " and " + MainApp.enemyPokemon2.name()
    else if pokemon1Catch && !pokemon2Catch then
      storyDialogue10 = "You have caught " + MainApp.enemyPokemon1.name() + ", but " + MainApp.enemyPokemon2.name() + " broke free and escaped"
    else if pokemon1Catch && pokemon2Catch then
      storyDialogue10 = "You have caught " + MainApp.enemyPokemon2.name() + ", but " + MainApp.enemyPokemon1.name() + " broke free and escaped"
    else if !pokemon1Catch && !pokemon2Catch then
      storyDialogue10 = "What a shame! Both " + MainApp.enemyPokemon1.name() + " and " + MainApp.enemyPokemon2.name() + " broke free and escaped"
    end if

  else
    storyDialogue1 = "Your have been bested by the wild Pokemon and are left defenseless"
    storyDialogue2 = "The wild Pokemon close in on you to attack, when all of a sudden- "
    storyDialogue3 = "You blacked out. Unable to accept the fact that you have been beaten in a Pokemon battle."
    storyDialogue4 = "Good Riddance"

  end if

  var storyList = Array(storyDialogue1, storyDialogue2, storyDialogue3, storyDialogue4, storyDialogue5, storyDialogue6, storyDialogue7, storyDialogue8, storyDialogue9)


  def initialize() =
    storyLabel.text = storyList(count)

    firstImage.image = image1
    secondImage.image = image2

  def handleNextDialogue(action: ActionEvent): Unit =
    count = 1 + count
    storyLabel.text = storyList(count)

    if !MainApp.postBattle then
      if count == 3 then
        finalButton.visible = true
        finalButton.text = "Game Over"
        nextButton.visible = false
      end if
    else if MainApp.postBattle then
      if count == 6 then
        nextButton.visible = false
        Thread.sleep(2000)
        count = 1 + count
        storyLabel.text = storyList(count)
        Thread.sleep(2000)
        count = 1 + count
        storyLabel.text = storyList(count)
        Thread.sleep(2000)
        count = 1 + count
        storyLabel.text = storyList(count)
        nextButton.visible = true
      end if
    end if


  def handleFinalButton(action: ActionEvent): Unit =
    if !MainApp.postBattle then
      showStartScreen()
    end if
