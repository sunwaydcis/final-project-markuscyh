package pokemon

class Type(_pokemontype: String) :
  var name: String = _pokemontype
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
    name
  
    
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
    effective = List("")
    ineffective = List("Rock", "Steel")
    immune = List("Ghost")

  def Fire(): Unit =
    effective = List("Grass", "Ice", "Bug", "Steel")
    ineffective = List("Fire", "Water", "Rock", "Dragon")
    immune = List("")

  def Water(): Unit =
     effective = List("Fire", "Ground", "Rock")
     ineffective = List("Water", "Grass", "Dragon")
     immune = List("")

  def Electric(): Unit =
     effective = List("Water", "Flying")
     ineffective = List("Electric", "Grass", "Dragon")
     immune = List("Ground")

  def Grass(): Unit =
     effective = List("Water", "Ground", "Rock")
     ineffective = List("Fire", "Grass", "Poison", "Flying", "Bug", "Dragon", "Steel")
     immune = List("")

  def Ice(): Unit =
     effective = List("Grass", "Ground", "Flying", "Dragon")
     ineffective = List("Fire", "Water", "Ice", "Steel")
     immune = List("")

  def Fighting(): Unit =
     effective = List("Normal", "Ice", "Dark", "Steel", "Rock")
     ineffective = List("Poison", "Flying", "Psychic", "Bug", "Fairy")
     immune = List("Ghost")

  def Poison(): Unit =
     effective = List("Grass", "Fairy")
     ineffective = List("Poison", "Ground", "Rock", "Ghost")
     immune = List("Steel")

  def Ground(): Unit =
     effective = List("Fire", "Electric", "Poison", "Rock", "Steel")
     ineffective = List("Grass", "Bug")
     immune = List("Flying")

  def Flying(): Unit =
     effective = List("Grass", "Fighting", "Bug")
     ineffective = List("Electric", "Rock", "Steel")
     immune = List("")

  def Psychic(): Unit =
     effective = List("Fighting", "Poison")
     ineffective = List("Psychic", "Steel")
     immune = List("Dark")

  def Bug(): Unit =
     effective = List("Grass", "Psychic", "Dark")
     ineffective = List("Fire", "Fighting", "Poison", "Flying", "Ghost", "Steel", "Fairy")
     immune = List("")

  def Rock(): Unit =
     effective = List("Fire", "Flying", "Ice", "Bug")
     ineffective = List("Fighting", "Ground", "Steel")
     immune = List("")

  def Ghost(): Unit =
     effective = List("Psychic", "Ghost")
     ineffective = List("Dark")
     immune = List("Normal")

  def Dragon(): Unit =
     effective = List("Dragon")
     ineffective = List("Steel")
     immune = List("Fairy")

  def Dark(): Unit =
     effective = List("Psychic", "Ghost")
     ineffective = List("Fighting", "Dark", "Fairy")
     immune = List("")

  def Steel(): Unit =
     effective = List("Ice", "Rock", "Fairy")
     ineffective = List("Fire", "Water", "Electric", "Steel")
     immune = List("")

  def Fairy(): Unit =
     effective = List("Fighting", "Dark", "Dragon")
     ineffective = List("Fire", "Poison", "Steel")
     immune = List("")

  def None(): Unit =
     effective = List("")
     ineffective = List("")
     immune = List("")
end Type

