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
import javafx.scene.shape.Rectangle

@FXML
class PostBattleSceneController():

  @FXML
  protected var black: Rectangle = null
  @FXML
  protected var storyLabel: Label = null
  @FXML
  protected var firstImage: ImageView = null
  @FXML
  protected var secondImage: ImageView = null
  @FXML
  protected var firstpokeball: ImageView = null
  @FXML
  protected var secondpokeball: ImageView = null
  @FXML
  protected var nextButton: Button = null
  @FXML
  protected var finalButton: Button = null


  val pokeball: CatchRate = new CatchRate()

  // Set Images
  val pokemonPortrait1: String = "/images/front_portrait/" + MainApp.enemyPokemon1.frontportrait
  val pokemonPortrait2: String = "/images/front_portrait/" + MainApp.enemyPokemon2.frontportrait
  val pokeballPortrait: String = "/images/pokeballs/" + pokeball.name + ".png"

  val image1: Image = new Image(getClass.getResourceAsStream(pokemonPortrait1))
  val image2: Image = new Image(getClass.getResourceAsStream(pokemonPortrait2))
  val pokeballimage: Image = new Image(getClass.getResourceAsStream(pokeballPortrait))

  // Count will allow for story progression
  var count: Int = 0

  val pokemon1Catch: Boolean = pokeball.catchResult(MainApp.enemyPokemon1.grade)
  val pokemon2Catch: Boolean = pokeball.catchResult(MainApp.enemyPokemon2.grade)

  var storyDialogue1: String = null
  var storyDialogue2: String = null
  var storyDialogue3: String = null
  var storyDialogue4: String = null
  var storyDialogue5: String = "You rush to obtain the Pokeballs to catch the weakened Pokemon. You grab, pull out - "
  var storyDialogue6: String = "Two " + pokeball.name + "s and throw them at the wild Pokemon"
  var storyDialogue7: String = "One"
  var storyDialogue8: String = "Two"
  var storyDialogue9: String = "Three"
  var storyDialogue10: String = null
  var storyDialogue11: String = null
  var storyDialogue12: String = "The End"

  if MainApp.postBattle then
    storyDialogue1 = "The two wild Pokemon have been defeated. They can now be captured safely, thats if you had any Pokeballs on you."
    storyDialogue2 = "As you turn to leave the forest and go home with your newly acquired partner, you spot a glint in a nearby bush."
    storyDialogue3 = "You step forward to take a closer look and rather than one glint, you spot two glints in the bush."
    storyDialogue4 = "You recognize the glints being from two Pokeballs of the same type. What type of Pokeballs, you weren't able to see as the two wild Pokemon start to recover."

    if pokemon1Catch && pokemon2Catch then
      storyDialogue10 = "Congratulations, you have caught " + MainApp.enemyPokemon1.name() + " and " + MainApp.enemyPokemon2.name()
      storyDialogue11 = "With your new companions, you head home with a spring in your step. Today was a good day."
    else if pokemon1Catch && !pokemon2Catch then
      storyDialogue10 = "You have caught " + MainApp.enemyPokemon1.name() + ", but " + MainApp.enemyPokemon2.name() + " broke free and escaped"
      storyDialogue11 = "Despite one Pokemon escaping you got two new partners in " + MainApp.userPokemon1.name() + " and " + MainApp.enemyPokemon1.name() + " and decide to go home to rest"
    else if pokemon1Catch && pokemon2Catch then
      storyDialogue10 = "You have caught " + MainApp.enemyPokemon2.name() + ", but " + MainApp.enemyPokemon1.name() + " broke free and escaped"
      storyDialogue11 = "Despite one Pokemon escaping you got two new partners in " + MainApp.userPokemon1.name() + " and " + MainApp.enemyPokemon2.name() + " and decide to go home to rest"
    else if !pokemon1Catch && !pokemon2Catch then
      storyDialogue10 = "What a shame! Both " + MainApp.enemyPokemon1.name() + " and " + MainApp.enemyPokemon2.name() + " broke free and escaped"
      storyDialogue11 = "Whatever, you already got yourself one new friend in " + MainApp.userPokemon1.name() + " and head home"
    end if


  else
    storyDialogue1 = "Your have been bested by the wild Pokemon and are left defenseless"
    storyDialogue2 = "The wild Pokemon close in on you to attack, when all of a sudden- "
    storyDialogue3 = "You blacked out. Unable to accept the fact that you have been beaten in a Pokemon battle."
    storyDialogue4 = "Good Riddance you sore loser."

  end if

  var storyList = Array(storyDialogue1, storyDialogue2, storyDialogue3, storyDialogue4, storyDialogue5, storyDialogue6, storyDialogue7, storyDialogue8, storyDialogue9, storyDialogue10, storyDialogue11)


  def initialize() =
    storyLabel.text = storyList(count)

    firstImage.image = image1
    secondImage.image = image2

  def handleNextDialogue(action: ActionEvent): Unit =
    count = 1 + count
    storyLabel.text = storyList(count)

    if !MainApp.postBattle then

      if count == 2 then
        black.visible = true
        firstImage.visible = false
        secondImage.visible = false
      else if count == 3 then
        finalButton.visible = true
        finalButton.text = "Game Over"
        nextButton.visible = false

      end if

    else if MainApp.postBattle then

      if count == 6 then
        firstImage.visible = false
        secondImage.visible = false
        firstpokeball.visible = true
        secondpokeball.visible = true
        firstpokeball.image = pokeballimage
        secondpokeball.image = pokeballimage

      else if count == 9 then
        if !pokemon1Catch then
          firstImage.visible = true
          firstpokeball.visible = false

        else if !pokemon2Catch then
          secondImage.visible = true
          secondpokeball.visible = false

        end if

      else if count == 10 then
        finalButton.visible = true
        finalButton.text = "The End"
        nextButton.visible = false

      end if
    end if



  def handleFinalButton(action: ActionEvent): Unit =
      showStartScreen()
