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

  def showSecondScene(): Unit =
    val resource = getClass.getResource("view/SecondScene.fxml")
    val loader = new FXMLLoader(resource)
    loader.load()
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.get.center = roots
  end showSecondScene

  def showFirstUserBattleScene(): Unit =
    val resource = getClass.getResource("view/FirstUserBattleScene.fxml")
    val loader = new FXMLLoader(resource)
    loader.load()
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.get.center = roots
  end showFirstUserBattleScene

  def showSecondUserBattleScene(): Unit =
    val resource = getClass.getResource("view/SecondUserBattleScene.fxml")
    val loader = new FXMLLoader(resource)
    loader.load()
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.get.center = roots
  end showSecondUserBattleScene
  
  def setEnemyPokemon(enemy1: String, enemy2: String, user1: String): Unit =
    enemyPokemon1 = new EnemyPokemon(enemy1)
    enemyPokemon2 = new EnemyPokemon(enemy2)
    userPokemon1 = new UserPokemon(user1)

    //test if pokemon are set
    println(enemyPokemon1.name())
    println(enemyPokemon2.name())
    println(userPokemon1.name())
  end setEnemyPokemon

  def setUserPokemon(user2: String): Unit =
    userPokemon2 = new UserPokemon(user2)
    println(userPokemon2.name())
  end setUserPokemon

  def battle(): Unit =
    var userAction: Boolean = false
    while !userAction do
      MainApp.userPokemon1.turnCounterProgress()
      MainApp.userPokemon2.turnCounterProgress()
      MainApp.enemyPokemon1.turnCounterProgress()
      MainApp.enemyPokemon2.turnCounterProgress()

      if MainApp.userPokemon1.turn_counter() == 0 then
        MainApp.userPokemon1.turnCounterReset()
        
        showFirstUserBattleScene()

        userAction = true
        
      else if MainApp.userPokemon2.turn_counter() <= 0 then
        MainApp.userPokemon2.turnCounterReset()

        showSecondUserBattleScene()

        userAction = true

      else if MainApp.enemyPokemon1.turn_counter() <= 0 then
        MainApp.enemyPokemon1.turnCounterReset()

        userAction = true
        
      else if MainApp.enemyPokemon2.turn_counter() <= 0 then
        MainApp.enemyPokemon2.turnCounterReset()

        userAction = true
      end if
      
    end while

  //Testing encounters
  var encounterrate = new Encounter()
  var encounter1 = encounterrate.randomGrade()
  var encounter2 = encounterrate.randomGrade()
  var encounter3 = encounterrate.randomGrade()
  var encounter4 = encounterrate.randomGrade()
  var encounter5 = encounterrate.randomGrade()

  var enemyPokemon1: EnemyPokemon = null
  var enemyPokemon2: EnemyPokemon = null
  var userPokemon1: UserPokemon = null
  var userPokemon2: UserPokemon = null

  
end MainApp
