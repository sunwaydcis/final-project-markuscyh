package `type`
abstract class Type() :
  var effective : List[String]
  var ineffective : List[String]
  var immune : List[String]

  def checkEffectiveness(defendingtype: String, damage: Double) : Double =
    if (effective.contains(defendingtype)) then
      damage * 2
    else if (ineffective.contains(defendingtype)) then
      damage / 2
    else if (immune.contains(defendingtype)) then
      damage * 0
    else
      damage
    end if

end Type


class Normal extends Type() :
  var effective = List(null)
  var ineffective = List("Rock","Steel")
  var immune = List("Ghost")
end Normal

class Fire extends Type() :
  var effective = List("Grass","Ice","Bug","Steel")
  var ineffective = List("Fire","Water","Rock","Dragon")
  var immune = List(null)
end Fire

class Water extends Type() :
  var effective = List("Fire","Ground","Rock")
  var ineffective = List("Water","Grass","Dragon")
  var immune = List(null)
end Water

class Electric extends Type() :
  var effective = List("Water","Flying")
  var ineffective = List("Electric","Grass","Dragon")
  var immune = List("Ground")
end Electric

class Grass extends Type() :
  var effective = List("Water","Ground","Rock")
  var ineffective = List("Fire","Grass","Poison","Flying","Bug","Dragon","Steel")
  var immune = List(null)
end Grass

class Ice extends Type() :
  var effective = List("Grass","Ground","Flying","Dragon")
  var ineffective = List("Fire","Water","Ice","Steel")
  var immune = List(null)
end Ice

class Fighting extends Type() :
  var effective = List("Normal","Ice","Dark","Steel","Rock")
  var ineffective = List("Poison","Flying","Psychic","Bug","Fairy")
  var immune = List("Ghost")
end Fighting

class Poison extends Type() :
  var effective = List("Grass","Fairy")
  var ineffective = List("Poison","Ground","Rock","Ghost")
  var immune = List("Steel")
end Poison

class Ground extends Type() :
  var effective = List("Fire","Electric","Poison","Rock","Steel")
  var ineffective = List("Grass","Bug")
  var immune = List("Flying")
end Ground

class Flying extends Type() :
  var effective = List("Grass","Fighting","Bug")
  var ineffective = List("Electric","Rock","Steel")
  var immune = List(null)
end Flying

class Psychic extends Type() :
  var effective = List("Fighting","Poison")
  var ineffective = List("Psychic","Steel")
  var immune = List("Dark")
end Psychic

class Bug extends Type() :
  var effective = List("Grass","Psychic","Dark")
  var ineffective = List("Fire","Fighting","Poison","Flying","Ghost","Steel","Fairy")
  var immune = List(null)
end Bug

class Rock extends Type() :
  var effective = List("Fire","Flying","Ice","Bug")
  var ineffective = List("Fighting","Ground","Steel")
  var immune = List(null)
end Rock

class Ghost extends Type() :
  var effective = List("Psychic","Ghost")
  var ineffective = List("Dark")
  var immune = List("Normal")
end Ghost

class Dragon extends Type() :
  var effective = List("Dragon")
  var ineffective = List("Steel")
  var immune = List("Fairy")
end Dragon

class Dark extends Type() :
  var effective = List("Psychic","Ghost")
  var ineffective = List("Fighting","Dark","Fairy")
  var immune = List(null)
end Dark

class Steel extends Type() :
  var effective = List("Ice","Rock","Fairy")
  var ineffective = List("Fire","Water","Electric","Steel")
  var immune = List(null)
end Steel

class Fairy extends Type() :
  var effective = List("Fighting","Dark","Dragon")
  var ineffective = List("Fire","Poison","Steel")
  var immune = List(null)
end Fairy