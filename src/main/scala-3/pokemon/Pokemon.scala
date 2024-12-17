package pokemon

import javafx.scene.image.Image

abstract class Pokemon(_name : String):
  // Gets the Pokemon from the enum
  var _grade: Int = PokemonDescription.valueOf(_name).grade()
  var _hp: Double = PokemonDescription.valueOf(_name).hp()
  var _attack: Int = PokemonDescription.valueOf(_name).attack()
  var _defense: Int = PokemonDescription.valueOf(_name).defense()
  var _sp_attack: Int = PokemonDescription.valueOf(_name).sp_attack()
  var _sp_defense: Int = PokemonDescription.valueOf(_name).sp_defense()
  var _speed: Int = PokemonDescription.valueOf(_name).speed()
  var _type1: String = PokemonDescription.valueOf(_name).type1()
  var _type2: String = PokemonDescription.valueOf(_name).type2()
  var _frontportrait: String = PokemonDescription.valueOf(_name).frontportrait()
  var _backportrait: String = PokemonDescription.valueOf(_name).backportrait()

  enum PokemonDescription(val _name: String,
                          val _grade: Int,
                          val _hp: Double,
                          val _attack: Int,
                          val _defense: Int,
                          val _sp_attack: Int,
                          val _sp_defense: Int,
                          val _speed: Int,
                          val _type1: String,
                          val _type2: String,
                          val _frontportrait: String,
                          val _backportrait: String):
    //Grade 1 Pokemon
    case Caterpie extends PokemonDescription(  "Caterpie",   1, 105,  31,  36,  22,  22,  45,  "Bug",    null,        "caterpie_front.png",   "caterpie_back.png")
    case Magikarp extends PokemonDescription(  "Magikarp",   1, 80,   13,  54,  18,  22,  76,  "Water",  null,        "magikarp_front.png",   "magikarp_back.png")
    case Metapod extends PokemonDescription(   "Metapod",    1, 110,  22,  70,  27,  27,  31,  "Bug",    null,        "metapod_front.png",    "metapod_back.png")
    case Pidgey extends PokemonDescription(    "Pidgey",     1, 100,  45,  40,  36,  36,  54,  "Normal", "Flying",    "pidgey_front.png",     "pidgey_back.png")
    case Rattata extends PokemonDescription(   "Rattata",    1, 90,   54,  36,  26,  36,  69,  "Normal", null,        "rattata_front.png",    "rattata_back.png")
    case Shuckle extends PokemonDescription(   "Shuckle",    1, 80,   13,  211, 13,  150, 9,   "Bug",    "Rock",      "shuckle_front.png",    "shuckle_back.png")
    case Sunkern extends PokemonDescription(   "Sunkern",    1, 90,   31,  31,  31,  31,  31,  "Grass",  null,        "sunkern_front.png",    "sunkern_back.png")
    case Swinub extends PokemonDescription(    "Swinub",     1, 110,  49,  40,  31,  31,  49,  "Bug",    null,        "swinub_front.png",     "swinub_back.png")

    //Grade 2 Pokemon
    case Beldum extends PokemonDescription(    "Beldum",     2, 100,  54,  76,  36,  58,  31,  "Steel",  "Psychic",   "beldum_front.png",     "beldum_back.png")
    case Butterfree extends PokemonDescription("Butterfree", 2, 120,  45,  49,  76,  76,  67,  "Bug",    "Flying",    "butterfree_front.png", "butterfree_back.png")
    case Chimchar extends PokemonDescription(  "Chimchar",   2, 120,  78,  65,  78,  65,  61,  "Fire",   null,        "chimchar_front.png",   "chimchar_back.png")
    case Froakie extends PokemonDescription(   "Froakie",    2, 101,  70,  65,  73,  67,  60,  "Water",  null,        "froakie_front.png",    "froakie_back.png")
    case Larvitar extends PokemonDescription(  "Larvitar",   2, 110,  62,  50,  45,  49,  41,  "Rock",   "Ground",    "larvitar_front.png",   "larvitar_back.png")
    case Pidgeotto extends PokemonDescription( "Pidgeotto",  2, 123,  60,  58,  54,  54,  69,  "Normal", "Flying",    "pidgeotto_front.png",  "pidgeotto_back.png")
    case Piloswine extends PokemonDescription( "Piloswine",  2, 160,  90,  75,  55,  55,  49,  "Ice",    "Ground",    "piloswine_front.png",  "piloswine_back.png")
    case Raticate extends PokemonDescription(  "Raticate",   2, 115,  68,  67,  40,  76,  73,  "Normal", null,        "raticate_front.png",   "raticate_back.png")
    case Rowlet extends PokemonDescription(    "Rowlet",     2, 128,  69,  69,  64,  64,  58,  "Grass",  "Flying",    "rowlet_front.png",     "rowlet_back.png")
    case Skrelp extends PokemonDescription(    "Skrelp",     2, 110,  60,  60,  60,  60,  31,  "Poison", "Water",     "skrelp_front.png",     "skrelp_back.png")
    case Sunflora extends PokemonDescription(  "Sunflora",   2, 135,  72,  54,  99,  81,  31,  "Grass",  null,        "sunflora_front.png",   "sunflora_back.png")

    //Grade 3 Pokemon
    case Dartrix extends PokemonDescription(   "Dartrix",    3, 140,  75,  75,  70,  70,  61,  "Grass",  "Flying",    "dartrix_front.png",    "dartrix_back.png")
    case Dragalge extends PokemonDescription(  "Dragalge",   3, 125,  80,  87,  92,  115, 44,  "Poison", "Dragon",    "dragalge_front.png",   "dragalge_back.png")
    case Frogadier extends PokemonDescription( "Frogadier",  3, 137,  76,  69,  83,  71,  91,  "Water",  null,        "frogadier_front.png",  "frogadier_back.png")
    case Mamoswine extends PokemonDescription( "Mamoswine",  3, 170,  120, 75,  65,  56,  74,  "Ice",    "Ground",    "mamoswine_front.png",  "mamoswine_back.png")
    case Mawile extends PokemonDescription(    "Mawile",     3, 110,  90,  90,  53,  53,  49,  "Steel",  "Fairy",     "mawile_front.png",     "mawile_back.png")
    case Metang extends PokemonDescription(    "Metang",     3, 120,  74,  94,  54,  76,  50,  "Steel",  "Psychic",   "metang_front.png",     "metang_back.png")
    case Monferno extends PokemonDescription(  "Monferno",   3, 145,  100, 78,  100, 78,  77,  "Fire",   "Fighting",  "monferno_front.png",   "monferno_back.png")
    case Pidgeot extends PokemonDescription(   "Pidgeot",    3, 143,  76,  72,  67,  67,  86,  "Normal", "Flying",    "pidgeot_front.png",    "pidgeot_back.png")
    case Pikachu extends PokemonDescription(   "Pikachu",    3, 100,  63,  50,  58,  55,  90,  "Electric",null,       "pikachu_front.png",    "pikachu_back.png")
    case Pupitar extends PokemonDescription(   "Pupitar",    3, 130,  83,  70,  63,  67,  50,  "Rock",   "Ground",    "pupitar_front.png",    "pupitar_back.png")
    case Raichu extends PokemonDescription(    "Raichu",     3, 120,  82,  54,  82,  73,  95,  "Electric",null,       "raichu_front.png",     "raichu_back.png")

    //Grade 4 Pokemon
    case Decidueye extends PokemonDescription( "Decidueye",  4, 161,  137, 105, 130, 130, 70,  "Grass",  "Ghost",     "decidueye_front.png",  "decidueye_back.png")
    case Greninja extends PokemonDescription(  "Greninja",   4, 155,  125, 97,  133, 101, 114, "Water",  "Dark",      "greninja_front.png",   "greninja_back.png")
    case Gyarados extends PokemonDescription(  "Gyarados",   4, 178,  155, 109, 90,  130, 77,  "Water",  "Flying",    "gyarados_front.png",   "gyarados_back.png")
    case Infernape extends PokemonDescription( "Infernape",  4, 159,  134, 101, 134, 101, 101, "Fire",   "Fighting",  "infernape_front.png",  "infernape_back.png")
    case Lapras extends PokemonDescription(    "Lapras",     4, 222,  83,  77,  83,  91,  64,  "Ice",    "Water",     "lapras_front.png",     "lapras_back.png")
    case Metagross extends PokemonDescription( "Metagross",  4, 140,  126, 121, 90,  82,  67,  "Steel",  "Psychic",   "metagross_front.png",  "metagross_back.png")
    case Tyranitar extends PokemonDescription( "Tyranitar",  4, 160,  125, 103, 87,  87,  59,  "Rock",   "Dark",      "tyranitar_front.png",  "tyranitar_back.png")

    //Grade 5 Pokemon
    case HoOh extends PokemonDescription(      "HoOh",       5, 312,  200, 156, 178, 226, 256, "Fire",   "Flying",    "ho-oh_back.png",       "ho-oh_back.png")
    case Lugia extends PokemonDescription(     "Lugia",      5, 213,  156, 200, 156, 226, 178, "Psychic","Flying",    "lugia_back.png",       "lugia_back.png")

    //Grade 6 Pokemon
    case Arceus extends PokemonDescription(    "Arceus",     6, 444,  372, 372, 372, 372, 372, "Normal", null,        "arceus_front.png",     "arceus_back.png")

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
      
    def frontportrait() : String =
      _frontportrait
    
    def backportrait() : String =
      _backportrait

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

  def frontportrait(): String =
    _frontportrait

  def backportrait(): String =
    _backportrait  

  def hpChange(change: Double) : Unit =
    _hp += change

end Pokemon

class UserPokemon(_name: String) extends Pokemon(_name: String) :
end UserPokemon

class EnemyPokemon(_name: String) extends Pokemon(_name: String) :
end EnemyPokemon
