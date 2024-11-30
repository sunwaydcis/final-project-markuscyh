package pokemon

abstract class Pokemon(_name : String):
  var _grade: Int = PokemonDescription.valueOf(_name).grade()
  var _hp: Double = PokemonDescription.valueOf(_name).hp()
  var _attack: Int = PokemonDescription.valueOf(_name).attack()
  var _defense: Int = PokemonDescription.valueOf(_name).defense()
  var _sp_attack: Int = PokemonDescription.valueOf(_name).sp_attack()
  var _sp_defense: Int = PokemonDescription.valueOf(_name).sp_defense()
  var _speed: Int = PokemonDescription.valueOf(_name).speed()
  var _type1: String = PokemonDescription.valueOf(_name).type1()
  var _type2: String = PokemonDescription.valueOf(_name).type2()

  enum PokemonDescription(val _name: String,
                          val _grade: Int,
                          val _hp: Double,
                          val _attack: Int,
                          val _defense: Int,
                          val _sp_attack: Int,
                          val _sp_defense: Int,
                          val _speed: Int,
                          val _type1: String,
                          val _type2: String):
    case Caterpie extends PokemonDescription("Caterpie", 1, 105, 31, 36, 22, 22, 45, "Bug", null)

    def grade() : Int =
      _grade

    def hp() : Double =
      _hp

    def attack(): Int =
      _attack

    def defense(): Int =
      _defense

    def sp_attack() : Int =
      _sp_attack

    def sp_defense() : Int =
      _sp_defense

    def speed() : Int =
      _speed

    def type1() : String =
      _type1

    def type2() : String =
      _type2

  end PokemonDescription

  def name() : String =
    _name

  def grade(): Int =
    _grade

  def hp(): Double =
    _hp

  def attack(): Int =
    _attack

  def defense(): Int =
    _defense

  def sp_attack(): Int =
    _sp_attack

  def sp_defense(): Int =
    _sp_defense

  def speed(): Int =
    _speed

  def type1(): String =
    _type1

  def type2(): String =
    _type2

  def hpChange(change: Double) : Unit =
    _hp += change

end Pokemon

class UserPokemon(_name: String) extends Pokemon(_name: String) :
end UserPokemon

class EnemyPokemon(_name: String) extends Pokemon(_name: String) :
end EnemyPokemon
