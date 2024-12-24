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
class BattleOutcomeSceneController:

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

  //Next Button
  @FXML
  protected var nextButton: Button = null

  // Set Images
  val enemyURL1: String = "/images/front_portrait/" + MainApp.enemyPokemon1.frontportrait
  val enemyURL2: String = "/images/front_portrait/" + MainApp.enemyPokemon2.frontportrait
  val userURL1: String = "/images/back_portrait/" + MainApp.userPokemon1.backportrait
  val userURL2: String = "/images/back_portrait/" + MainApp.userPokemon2.backportrait

  val enemyPortrait1: Image = new Image(getClass.getResourceAsStream(enemyURL1))
  val enemyPortrait2: Image = new Image(getClass.getResourceAsStream(enemyURL2))
  val userPortrait1: Image = new Image(getClass.getResourceAsStream(userURL1))
  val userPortrait2: Image = new Image(getClass.getResourceAsStream(userURL2))

  def initialize(): Unit =
    enemyImage1.image = enemyPortrait1
    enemyImage2.image = enemyPortrait2
    userImage1.image = userPortrait1
    userImage2.image = userPortrait2

    if MainApp.userPokemon1.current_hp <= 0 then
      userImage1.visible = false
    end if
    if MainApp.userPokemon2.current_hp <= 0 then
      userImage2.visible = false
    end if
    if MainApp.enemyPokemon1.current_hp <= 0 then
      enemyImage1.visible = false
    end if
    if MainApp.enemyPokemon2.current_hp <= 0 then
      enemyImage2.visible = false
    end if

    enemyName1.text = MainApp.enemyPokemon1.name()
    enemyName2.text = MainApp.enemyPokemon2.name()
    userName1.text = MainApp.userPokemon1.name() + ": " + MainApp.userPokemon1.current_hp + "/" + MainApp.userPokemon1.hp
    userName2.text = MainApp.userPokemon2.name() + ": " + MainApp.userPokemon2.current_hp + "/" + MainApp.userPokemon2.hp

    val enemyHp1: Double = MainApp.enemyPokemon1.current_hp / MainApp.enemyPokemon1.hp
    val enemyHp2: Double = MainApp.enemyPokemon2.current_hp / MainApp.enemyPokemon2.hp
    val userHp1: Double = MainApp.userPokemon1.current_hp / MainApp.userPokemon1.hp
    val userHp2: Double = MainApp.userPokemon2.current_hp / MainApp.userPokemon2.hp

    enemyHealth1.progress = enemyHp1
    enemyHealth2.progress = enemyHp2
    userHealth1.progress = userHp1
    userHealth2.progress = userHp2

    if !MainApp.postBattle then
      storyLabel.text = "You have lost the battle!"
      
      
  def handleNextDialogue(action: ActionEvent): Unit =
    showPostBattleScene()