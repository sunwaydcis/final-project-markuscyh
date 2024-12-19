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
import javafx.scene.control.ProgressBar

@FXML
class BattleSceneController():

  //Label for battle dialogue
  @FXML
  protected var storyLabel: Label = null
  @FXML
  protected var enemyName1: Label = null
  @FXML
  protected var enemyName2: Label = null
  @FXML
  protected var userName1: Label = null
  @FXML
  protected var userName2: Label = null

  //Pokemon ImageViews
  @FXML
  protected var enemyImage1: ImageView = null
  @FXML
  protected var enemyImage2: ImageView = null
  @FXML
  protected var userImage1: ImageView = null
  @FXML
  protected var userImage2: ImageView = null

  //Pokemon Healthbars
  @FXML
  protected var enemyHealth1: ProgressBar = null
  @FXML
  protected var enemyHealth2: ProgressBar = null
  @FXML
  protected var userHealth1: ProgressBar = null
  @FXML
  protected var userHealth2: ProgressBar = null

  //Start Battle Button
  @FXML
  protected var startButton: Button = null

  //Attack, Observe and Back Button
  @FXML
  protected var attackButton: Button = null
  @FXML
  protected var observeButton: Button = null
  @FXML
  protected var backButton: Button = null

  //Pokemon Observe Buttons
  @FXML
  protected var userButton1: Button = null
  @FXML
  protected var userButton2: Button = null
  @FXML
  protected var enemyButton1: Button = null
  @FXML
  protected var enemyButton2: Button = null

  //Pokemon Move Buttons
  @FXML
  protected var moveButton1: Button = null
  @FXML
  protected var moveButton2: Button = null

  //Move Target Buttons
  @FXML
  protected var targetButton1: Button = null
  @FXML
  protected var targetButton2: Button = null

  //Next Button
  @FXML
  protected var nextButton: Button = null

  // Set Images
  val enemyURL1: String = "/images/front_portrait/" + MainApp.enemyPokemon1.frontportrait()
  val enemyURL2: String = "/images/front_portrait/" + MainApp.enemyPokemon2.frontportrait()
  val userURL1: String = "/images/back_portrait/" + MainApp.userPokemon1.backportrait()
  val userURL2: String = "/images/back_portrait/" + MainApp.userPokemon2.backportrait()

  val enemyPortrait1: Image = new Image(getClass.getResourceAsStream(enemyURL1))
  val enemyPortrait2: Image = new Image(getClass.getResourceAsStream(enemyURL2))
  val userPortrait1: Image = new Image(getClass.getResourceAsStream(userURL1))
  val userPortrait2: Image = new Image(getClass.getResourceAsStream(userURL2))

  //Set an action boolean
  var userAction: Boolean = false

  def initialize(): Unit =
    enemyImage1.image = enemyPortrait1
    enemyImage2.image = enemyPortrait2
    userImage1.image = userPortrait1
    userImage2.image = userPortrait2

    enemyName1.text =  MainApp.enemyPokemon1.name()
    enemyName2.text =  MainApp.enemyPokemon2.name()
    userName1.text = MainApp.userPokemon1.name() + ": " + MainApp.userPokemon1.current_hp() + "/" + MainApp.userPokemon1.hp()
    userName2.text = MainApp.userPokemon2.name() + ": " + MainApp.userPokemon2.current_hp() + "/" + MainApp.userPokemon2.hp()

    enemyHealth1.progress = 1f
    enemyHealth2.progress = 1f
    userHealth1.progress = 1f
    userHealth2.progress = 1f

    storyLabel.text = "The" + MainApp.enemyPokemon1.name() + " and " + MainApp.enemyPokemon2.name() + " attack!"

  def startBattle(action: ActionEvent): Unit =
    startButton.visible = false
    battle()

  def battle(): Unit =
    while true do
      MainApp.userPokemon1.turnCounterProgress()
      MainApp.userPokemon2.turnCounterProgress()
      MainApp.enemyPokemon1.turnCounterProgress()
      MainApp.enemyPokemon2.turnCounterProgress()

      println("running")

      if MainApp.userPokemon1.turn_counter() == 0 then
        MainApp.userPokemon1.turnCounterReset()

        attackButton.visible = true
        observeButton.visible = true
        
        while !userAction do
          null
        end while
        
        userAction = true

      end if



      if MainApp.userPokemon2.turn_counter() == 0 then
        MainApp.userPokemon2.turnCounterReset()

        attackButton.visible = true
        observeButton.visible = true
        
        while !userAction do
          null
        end while

      end if



      if MainApp.enemyPokemon1.turn_counter() == 0 then
        MainApp.enemyPokemon1.turnCounterReset()
        println("enemy 1")
      end if



      if MainApp.enemyPokemon2.turn_counter() == 0 then
        MainApp.enemyPokemon2.turnCounterReset()
        println("enemy 2")
      end if
    end while

  def observeAction(action: ActionEvent): Unit =
    attackButton.visible = false
    observeButton.visible = false

    userButton1.visible = true
    userButton2.visible = true
    enemyButton1.visible = true
    enemyButton2.visible = true

  def observeEnemy1(action: ActionEvent): Unit =
    storyLabel.text = MainApp.enemyPokemon1.observation()
    nextButton.visible = true

    userButton1.visible = false
    userButton2.visible = false
    enemyButton1.visible = false
    enemyButton2.visible = false

  def observeEnemy2(action: ActionEvent): Unit =
    storyLabel.text = MainApp.enemyPokemon2.observation()
    nextButton.visible = true

    userButton1.visible = false
    userButton2.visible = false
    enemyButton1.visible = false
    enemyButton2.visible = false

  def observeUser1(action: ActionEvent): Unit =
    storyLabel.text = MainApp.userPokemon1.observation()
    nextButton.visible = true

    userButton1.visible = false
    userButton2.visible = false
    enemyButton1.visible = false
    enemyButton2.visible = false

  def observeUser2(action: ActionEvent): Unit =
    storyLabel.text = MainApp.userPokemon2.observation()
    nextButton.visible = true

    userButton1.visible = false
    userButton2.visible = false
    enemyButton1.visible = false
    enemyButton2.visible = false

  def handleNextDialogue(action: ActionEvent): Unit =
    nextButton.visible = false
    userAction = true
