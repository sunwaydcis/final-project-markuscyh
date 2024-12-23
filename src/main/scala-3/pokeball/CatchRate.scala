package pokeball

import scala.util.Random

class CatchRate:
  var name: String = null
  var catchrate: Double = 0
  var catchchance : Double = 0
  var catchsuccessthreshold : Double = 0

  var pokeball_grade: Int = Random.nextInt(300) + 1

  if pokeball_grade <= 150 then
    name = "Pokeball"
    catchrate = 1
  else if pokeball_grade <= 255 then
    name = "Greatball"
    catchrate = 1.5
  else if pokeball_grade <= 295 then
    name = "Ultraball"
    catchrate = 2
  else
    name = "Masterball"
    catchrate = 100
  end if

  def catchResult(grade: Int) : Boolean =
    grade match
      case 1 => grade1Catch()
      case 2 => grade2Catch()
      case 3 => grade3Catch()
      case 4 => grade4Catch()
      case 5 => grade5Catch()
      case 6 => grade6Catch()
    end match

  def grade1Catch() : Boolean =
    catchchance = 75 * catchrate
    catchsuccessthreshold = Random.nextInt(100) + 1;
    if (catchchance >= catchsuccessthreshold) then
      true
    else
      false

  def grade2Catch(): Boolean =
    catchchance = 60 * catchrate
    catchsuccessthreshold = Random.nextInt(100) + 1;
    if (catchchance >= catchsuccessthreshold) then
      true
    else
      false

  def grade3Catch(): Boolean =
    catchchance = 43 * catchrate
    catchsuccessthreshold = Random.nextInt(100) + 1;
    if (catchchance >= catchsuccessthreshold) then
      true
    else
      false

  def grade4Catch(): Boolean =
    catchchance = 22 * catchrate
    catchsuccessthreshold = Random.nextInt(100) + 1;
    if (catchchance >= catchsuccessthreshold) then
      true
    else
      false

  def grade5Catch(): Boolean =
    catchchance = 5 * catchrate
    catchsuccessthreshold = Random.nextInt(100) + 1;
    if (catchchance >= catchsuccessthreshold) then
      true
    else
      false

  def grade6Catch(): Boolean =
    catchchance = 2.5 * catchrate
    catchsuccessthreshold = Random.nextInt(100) + 1;
    if (catchchance >= catchsuccessthreshold) then
      true
    else
      false

end CatchRate