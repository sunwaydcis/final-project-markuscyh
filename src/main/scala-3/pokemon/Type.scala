package pokemon

class Type(_pokemontype: String) :
  var effective : List[String] = null
  var ineffective : List[String] = null
  var immune : List[String] = null

  _pokemontype match
    case "Normal" => Normal()
    case "Fire" => Fire()
    case "Water" => Water()
    case "Electric" => Electric()
    case "Grass" => Grass()
    case "Ice" => Ice()
    case "Fighting" => Fighting()
    case "Poison" => Poison()
    case "Ground" => Ground()
    case "Flying" => Flying()
    case "Psychic" => Psychic()
    case "Bug" => Bug()
    case "Rock" => Rock()
    case "Ghost" => Ghost()
    case "Dragon" => Dragon()
    case "Dark" => Dark()
    case "Steel" => Steel()
    case "Fairy" => Fairy()
    case _ => None()
  end match

  def pokemontype(): String =
    _pokemontype
  
  def checkEffectiveness(defendingtype: String, damage: Double) : Double =
    if effective.contains(defendingtype) then
      damage * 2
    else if ineffective.contains(defendingtype) then
      damage / 2
    else if immune.contains(defendingtype) then
      damage * 0
    else
      damage
    end if

  def Normal(): Unit =
    var effective = List("")
    var ineffective = List("Rock", "Steel")
    var immune = List("Ghost")

  def Fire(): Unit =
    var effective = List("Grass", "Ice", "Bug", "Steel")
    var ineffective = List("Fire", "Water", "Rock", "Dragon")
    var immune = List("")

  def Water(): Unit =
    var effective = List("Fire", "Ground", "Rock")
    var ineffective = List("Water", "Grass", "Dragon")
    var immune = List("")

  def Electric(): Unit =
    var effective = List("Water", "Flying")
    var ineffective = List("Electric", "Grass", "Dragon")
    var immune = List("Ground")

  def Grass(): Unit =
    var effective = List("Water", "Ground", "Rock")
    var ineffective = List("Fire", "Grass", "Poison", "Flying", "Bug", "Dragon", "Steel")
    var immune = List("")

  def Ice(): Unit =
    var effective = List("Grass", "Ground", "Flying", "Dragon")
    var ineffective = List("Fire", "Water", "Ice", "Steel")
    var immune = List("")

  def Fighting(): Unit =
    var effective = List("Normal", "Ice", "Dark", "Steel", "Rock")
    var ineffective = List("Poison", "Flying", "Psychic", "Bug", "Fairy")
    var immune = List("Ghost")

  def Poison(): Unit =
    var effective = List("Grass", "Fairy")
    var ineffective = List("Poison", "Ground", "Rock", "Ghost")
    var immune = List("Steel")

  def Ground(): Unit =
    var effective = List("Fire", "Electric", "Poison", "Rock", "Steel")
    var ineffective = List("Grass", "Bug")
    var immune = List("Flying")

  def Flying(): Unit =
    var effective = List("Grass", "Fighting", "Bug")
    var ineffective = List("Electric", "Rock", "Steel")
    var immune = List("")

  def Psychic(): Unit =
    var effective = List("Fighting", "Poison")
    var ineffective = List("Psychic", "Steel")
    var immune = List("Dark")

  def Bug(): Unit =
    var effective = List("Grass", "Psychic", "Dark")
    var ineffective = List("Fire", "Fighting", "Poison", "Flying", "Ghost", "Steel", "Fairy")
    var immune = List("")

  def Rock(): Unit =
    var effective = List("Fire", "Flying", "Ice", "Bug")
    var ineffective = List("Fighting", "Ground", "Steel")
    var immune = List("")

  def Ghost(): Unit =
    var effective = List("Psychic", "Ghost")
    var ineffective = List("Dark")
    var immune = List("Normal")

  def Dragon(): Unit =
    var effective = List("Dragon")
    var ineffective = List("Steel")
    var immune = List("Fairy")

  def Dark(): Unit =
    var effective = List("Psychic", "Ghost")
    var ineffective = List("Fighting", "Dark", "Fairy")
    var immune = List("")

  def Steel(): Unit =
    var effective = List("Ice", "Rock", "Fairy")
    var ineffective = List("Fire", "Water", "Electric", "Steel")
    var immune = List("")

  def Fairy(): Unit =
    var effective = List("Fighting", "Dark", "Dragon")
    var ineffective = List("Fire", "Poison", "Steel")
    var immune = List("")

  def None(): Unit =
    var effective = List("")
    var ineffective = List("")
    var immune = List("")
end Type

