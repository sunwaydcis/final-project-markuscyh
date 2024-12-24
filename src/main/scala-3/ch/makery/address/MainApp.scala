package ch.makery.address

import javafx.fxml.FXMLLoader
import javafx.scene as jfxs
import pokemon.*
import scalafx.Includes.*
import scalafx.application.JFXApp3
import scalafx.application.JFXApp3.PrimaryStage
import scalafx.scene as sfxs
import scalafx.scene.Scene
import scalafx.scene.media.Media
import scalafx.scene.media.MediaPlayer
import java.nio.file.Paths

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
    encounter1 = encounterrate.randomGrade()
    encounter2 = encounterrate.randomGrade()
    encounter3 = encounterrate.randomGrade()
    encounter4 = encounterrate.randomGrade()
    encounter5 = encounterrate.randomGrade()

    val resource = getClass.getResource("view/StartScreen.fxml")
    val loader = new FXMLLoader(resource)
    loader.load()
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.get.center = roots
  end showStartScreen

  def showOpeningScene(): Unit =
    val resource = getClass.getResource("view/OpeningScene.fxml")
    val loader = new FXMLLoader(resource)
    loader.load()
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.get.center = roots
    val openingMusic: Media = new Media(Paths.get("src/main/resources/audio/opening_music.mp3").toUri.toString)
    var mediaPlayer: MediaPlayer = new MediaPlayer(openingMusic)
    mediaPlayer.volume = 75
    mediaPlayer.play()
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

  def showEnemyBattleScene(): Unit =
    val resource = getClass.getResource("view/EnemyBattleScene.fxml")
    val loader = new FXMLLoader(resource)
    loader.load()
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.get.center = roots
  end showEnemyBattleScene

  def showBattleOutcomeScene(): Unit =
    val resource = getClass.getResource("view/BattleOutcomeScene.fxml")
    val loader = new FXMLLoader(resource)
    loader.load()
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.get.center = roots
  end showBattleOutcomeScene

  def showPostBattleScene(): Unit =
    val resource = getClass.getResource("view/PostBattleScene.fxml")
    val loader = new FXMLLoader(resource)
    loader.load()
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.get.center = roots
  end showPostBattleScene
  
  def setEnemyPokemon(enemy1: String, enemy2: String, user1: String): Unit =
    enemyPokemon1 = new EnemyPokemon(enemy1)
    enemyPokemon2 = new EnemyPokemon(enemy2)
    userPokemon1 = new UserPokemon(user1)
  end setEnemyPokemon

  def setUserPokemon(user2: String): Unit =
    userPokemon2 = new UserPokemon(user2)
  end setUserPokemon

  def battle(): Unit =
    var userAction: Boolean = false
    while !userAction do
      if userPokemon1.current_hp <= 0 && userPokemon2.current_hp <= 0 then
        showBattleOutcomeScene()
        postBattle = false
        userAction = true
      else if enemyPokemon1.current_hp <= 0 && enemyPokemon2.current_hp <= 0 then
        showBattleOutcomeScene()
        userAction = true
      end if
      
      if userPokemon1.current_hp > 0 then
        userPokemon1.turnCounterProgress()
      end if
      if userPokemon2.current_hp > 0  then
        userPokemon2.turnCounterProgress()
      end if
      if enemyPokemon1.current_hp > 0  then
        enemyPokemon1.turnCounterProgress()
      end if
      if enemyPokemon2.current_hp > 0  then
        enemyPokemon2.turnCounterProgress()
      end if

      if userPokemon1.turn_counter == 0 then
        userPokemon1.turnCounterReset()
        showFirstUserBattleScene()
        userAction = true

      else if userPokemon2.turn_counter <= 0 then
        userPokemon2.turnCounterReset()
        showSecondUserBattleScene()
        userAction = true

      else if enemyPokemon1.turn_counter <= 0 then
        enemyPokemon1.turnCounterReset()
        attackingPokemon = enemyPokemon1
        showEnemyBattleScene()
        userAction = true

      else if enemyPokemon2.turn_counter <= 0 then
        enemyPokemon2.turnCounterReset()
        attackingPokemon = enemyPokemon2
        showEnemyBattleScene()
        userAction = true
      end if

    end while

  //Pokemon are set
  var encounterrate = new Encounter()
  var encounter1: String = null
  var encounter2: String = null
  var encounter3: String = null
  var encounter4: String = null
  var encounter5: String = null

  var enemyPokemon1: EnemyPokemon = null
  var enemyPokemon2: EnemyPokemon = null
  var userPokemon1: UserPokemon = null
  var userPokemon2: UserPokemon = null
  var attackingPokemon: EnemyPokemon = null

  var postBattle: Boolean = true

end MainApp
