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
import javafx.scene.shape.Rectangle

@FXML
class FirstUserBattleSceneController:

  //Panel for move information
  @FXML
  protected var movePanel: Rectangle = null

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
  @FXML
  protected var moveLabel1: Label = null
  @FXML
  protected var moveLabel2: Label = null
  @FXML
  protected var moveLabel3: Label = null
  @FXML
  protected var moveLabel4: Label = null

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
  val enemyURL1: String = "/images/front_portrait/" + MainApp.enemyPokemon1.frontportrait
  val enemyURL2: String = "/images/front_portrait/" + MainApp.enemyPokemon2.frontportrait
  val userURL1: String = "/images/back_portrait/" + MainApp.userPokemon1.backportrait
  val userURL2: String = "/images/back_portrait/" + MainApp.userPokemon2.backportrait

  val enemyPortrait1: Image = new Image(getClass.getResourceAsStream(enemyURL1))
  val enemyPortrait2: Image = new Image(getClass.getResourceAsStream(enemyURL2))
  val userPortrait1: Image = new Image(getClass.getResourceAsStream(userURL1))
  val userPortrait2: Image = new Image(getClass.getResourceAsStream(userURL2))

  var actionType: String = ""
  var selectedMove: Int = 0
  var damage: Double = 0
  var faint: Boolean = false
  var faintTarget: String = ""

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

    enemyName1.text =  MainApp.enemyPokemon1.name()
    enemyName2.text =  MainApp.enemyPokemon2.name()
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

    storyLabel.text = "It is " + MainApp.userPokemon1.name() + "'s turn! What will " + MainApp.userPokemon1.name() + " do?"

  //Attack Actions
  def attackAction(action: ActionEvent): Unit =
    storyLabel.text = "What move will you use?"

    actionType = "attack"

    attackButton.visible = false
    observeButton.visible = false
    backButton.visible = true

    moveButton1.visible = true
    moveButton2.visible = true
    moveButton1.text = MainApp.userPokemon1.move1.name
    moveButton2.text = MainApp.userPokemon1.move2.name

  def move1Action(action: ActionEvent): Unit =
    storyLabel.text = "Which Pokemon will you target?"

    actionType = "target"
    selectedMove = 1

    moveButton1.visible = false
    moveButton2.visible = false
    
    movePanel.visible = true
    moveLabel1.visible = true
    moveLabel1.text = "Move: " + MainApp.userPokemon1.move1.name
    moveLabel2.visible = true
    moveLabel2.text = "Type: " + MainApp.userPokemon1.move1.move_type.name
    moveLabel3.visible = true
    moveLabel3.text = "Category: " + MainApp.userPokemon1.move1.move_category
    moveLabel4.visible = true
    moveLabel4.text = "Power: " + MainApp.userPokemon1.move1.power

    if MainApp.enemyPokemon1.current_hp > 0 then
      targetButton1.visible = true
      targetButton1.text = MainApp.enemyPokemon1.name()
    end if
    if MainApp.enemyPokemon2.current_hp > 0 then
      targetButton2.visible = true
      targetButton2.text = MainApp.enemyPokemon2.name()
    end if


  def move2Action(action: ActionEvent): Unit =
    storyLabel.text = "Which Pokemon will you target?"

    actionType = "target"
    selectedMove = 2

    moveButton1.visible = false
    moveButton2.visible = false

    movePanel.visible = true
    moveLabel1.visible = true
    moveLabel1.text = "Move: " + MainApp.userPokemon1.move2.name
    moveLabel2.visible = true
    moveLabel2.text = "Type: " + MainApp.userPokemon1.move2.move_type.name
    moveLabel3.visible = true
    moveLabel3.text = "Category: " + MainApp.userPokemon1.move2.move_category
    moveLabel4.visible = true
    moveLabel4.text = "Power: " + MainApp.userPokemon1.move2.power

    if MainApp.enemyPokemon1.current_hp > 0 then
      targetButton1.visible = true
      targetButton1.text = MainApp.enemyPokemon1.name()
    end if
    if MainApp.enemyPokemon2.current_hp > 0 then
      targetButton2.visible = true
      targetButton2.text = MainApp.enemyPokemon2.name()
    end if

  def target1Action(action: ActionEvent): Unit =
    if selectedMove == 1 then
      damage = MainApp.userPokemon1.move1Damage(MainApp.enemyPokemon1.type1.name, MainApp.enemyPokemon1.type2.name, MainApp.enemyPokemon1.defense, MainApp.enemyPokemon1.sp_defense)
    else if selectedMove == 2 then
      damage = MainApp.userPokemon1.move2Damage(MainApp.enemyPokemon1.type1.name, MainApp.enemyPokemon1.type2.name, MainApp.enemyPokemon1.defense, MainApp.enemyPokemon1.sp_defense)  
    end if
    
    MainApp.enemyPokemon1.hpChange(damage)

    targetButton1.visible = false
    targetButton2.visible = false
    backButton.visible = false
    nextButton.visible = true
    movePanel.visible = false
    moveLabel1.visible = false
    moveLabel2.visible = false
    moveLabel3.visible = false
    moveLabel4.visible = false

    enemyHealth1.progress = MainApp.enemyPokemon1.current_hp / MainApp.enemyPokemon1.hp
    storyLabel.text = MainApp.userPokemon1.name() +" has dealt " + damage + " damage to " + MainApp.enemyPokemon1.name()
    
    if MainApp.enemyPokemon1.current_hp <= 0 then
      faint = true
      faintTarget = MainApp.enemyPokemon1.name()
    
    
    
  def target2Action(action: ActionEvent): Unit =
    if selectedMove == 1 then
      damage = MainApp.userPokemon1.move1Damage(MainApp.enemyPokemon2.type1.name, MainApp.enemyPokemon2.type2.name, MainApp.enemyPokemon2.defense, MainApp.enemyPokemon2.sp_defense)
    else if selectedMove == 2 then
      damage = MainApp.userPokemon1.move2Damage(MainApp.enemyPokemon2.type1.name, MainApp.enemyPokemon2.type2.name, MainApp.enemyPokemon2.defense, MainApp.enemyPokemon2.sp_defense)
    end if
    MainApp.enemyPokemon2.hpChange(damage)

    targetButton1.visible = false
    targetButton2.visible = false
    backButton.visible = false
    nextButton.visible = true
    movePanel.visible = false
    moveLabel1.visible = false
    moveLabel2.visible = false
    moveLabel3.visible = false
    moveLabel4.visible = false

    enemyHealth2.progress = MainApp.enemyPokemon2.current_hp / MainApp.enemyPokemon2.hp
    storyLabel.text = MainApp.userPokemon1.name() + " has dealt " + damage + " damage to " + MainApp.enemyPokemon2.name()

    if MainApp.enemyPokemon2.current_hp <= 0 then
      faint = true
      faintTarget = MainApp.enemyPokemon2.name()


  //Obersvation Actions
  def observeAction(action: ActionEvent): Unit =
    storyLabel.text = "Which Pokemon do you want to observe?"

    actionType = "observe"

    attackButton.visible = false
    observeButton.visible = false
    backButton.visible = true

    if MainApp.userPokemon1.current_hp > 0 then
      userButton1.visible = true
    end if
    if MainApp.userPokemon2.current_hp > 0 then
      userButton2.visible = true
    end if
    if MainApp.enemyPokemon1.current_hp > 0 then
      enemyButton1.visible = true
    end if
    if MainApp.enemyPokemon2.current_hp > 0 then
      enemyButton2.visible = true
    end if

  def observeEnemy1(action: ActionEvent): Unit =
    storyLabel.text = MainApp.enemyPokemon1.observation()
    nextButton.visible = true
    backButton.visible = false

    userButton1.visible = false
    userButton2.visible = false
    enemyButton1.visible = false
    enemyButton2.visible = false

  def observeEnemy2(action: ActionEvent): Unit =
    storyLabel.text = MainApp.enemyPokemon2.observation()
    nextButton.visible = true
    backButton.visible = false

    userButton1.visible = false
    userButton2.visible = false
    enemyButton1.visible = false
    enemyButton2.visible = false

  def observeUser1(action: ActionEvent): Unit =
    storyLabel.text = MainApp.userPokemon1.observation()
    nextButton.visible = true
    backButton.visible = false

    userButton1.visible = false
    userButton2.visible = false
    enemyButton1.visible = false
    enemyButton2.visible = false

  def observeUser2(action: ActionEvent): Unit =
    storyLabel.text = MainApp.userPokemon2.observation()
    nextButton.visible = true
    backButton.visible = false

    userButton1.visible = false
    userButton2.visible = false
    enemyButton1.visible = false
    enemyButton2.visible = false


  //Back Action
  def handleBack(action: ActionEvent): Unit =
    if actionType == "attack" then
      attackButton.visible = true
      observeButton.visible = true
      backButton.visible = false

      moveButton1.visible = false
      moveButton2.visible = false

      storyLabel.text = "It is " + MainApp.userPokemon1.name() + "'s turn! What will " + MainApp.userPokemon1.name() + " do?"

    else if actionType == "target" then
      moveButton1.visible = true
      moveButton2.visible = true

      movePanel.visible = false
      moveLabel1.visible = false
      moveLabel2.visible = false
      moveLabel3.visible = false
      moveLabel4.visible = false
      
      targetButton1.visible = false
      targetButton2.visible = false
      actionType = "attack"

      storyLabel.text = "What move will you use?"

    else if actionType == "observe" then
      attackButton.visible = true
      observeButton.visible = true
      backButton.visible = false

      userButton1.visible = false
      userButton2.visible = false
      enemyButton1.visible = false
      enemyButton2.visible = false

      storyLabel.text = "It is " + MainApp.userPokemon1.name() + "'s turn! What will " + MainApp.userPokemon1.name() + " do?"
    end if


  //Handle Next Dialogue
  def handleNextDialogue(action: ActionEvent): Unit =
    if faint then
      storyLabel.text = faintTarget + " has fainted!"
      faint = false
    else  
      nextButton.visible = false
      battle()
    end if
