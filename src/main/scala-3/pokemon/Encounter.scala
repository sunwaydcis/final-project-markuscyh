package pokemon
import scala.util.Random

case class Encounter() :
  def randomGrade() : String =
    val grade: Int = Random.nextInt(310) + 1
    if grade <= 100 then
      encounterGrade1()
    else if grade <= 180 then
      encounterGrade2()
    else if grade <= 240 then
      encounterGrade3()
    else if grade <= 280 then
      encounterGrade4()
    else if grade <= 309 then
      encounterGrade5()
    else
      encounterGrade6()
    end if
  end randomGrade

  def encounterGrade1() : String =
    var rate = Random.nextInt(8) + 1
    rate match
      case 1 => "Caterpie"
      case 2 => "Magikarp"
      case 3 => "Metapod"
      case 4 => "Pidgey"
      case 5 => "Rattata"
      case 6 => "Shuckle"
      case 7 => "Sunkern"
      case 8 => "Swinub"
    end match

  def encounterGrade2(): String =
    var rate = Random.nextInt(11) + 1
    rate match
      case 1 => "Beldum"
      case 2 => "Butterfree"
      case 3 => "Chimchar"
      case 4 => "Froakie"
      case 5 => "Larvitar"
      case 6 => "Pidgeotto"
      case 7 => "Piloswine"
      case 8 => "Raticate"
      case 9 => "Rowlet"
      case 10 => "Skrelp"
      case 11 => "Sunflora"
    end match

  def encounterGrade3(): String =
    var rate = Random.nextInt(11) + 1
    rate match
      case 1 => "Dartrix"
      case 2 => "Dragalge"
      case 3 => "Frogadier"
      case 4 => "Mamoswine"
      case 5 => "Mawile"
      case 6 => "Metang"
      case 7 => "Monferno"
      case 8 => "Pidgeot"
      case 9 => "Pikachu"
      case 10 => "Pupitar"
      case 11 => "Raichu"
    end match

  def encounterGrade4(): String =
    var rate = Random.nextInt(7) + 1
    rate match
      case 1 => "Decidueye"
      case 2 => "Greninja"
      case 3 => "Gyarados"
      case 4 => "Infernape"
      case 5 => "Lapras"
      case 6 => "Metagross"
      case 7 => "Tyranitar"
    end match

  def encounterGrade5(): String =
    var rate = Random.nextInt(2) + 1
    rate match
      case 1 => "HoOh"
      case 2 => "Lugia"
    end match

  def encounterGrade6(): String =
    var rate = Random.nextInt(1) + 1
    rate match
      case 1 => "Arceus"
    end match
end Encounter