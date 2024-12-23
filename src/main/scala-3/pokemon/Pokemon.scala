package pokemon

import scala.util.Random

abstract class Pokemon(_name : String):
  // Gets the Pokemon from the enum
  var grade: Int = PokemonDescription.valueOf(_name)._grade
  var hp: Double = PokemonDescription.valueOf(_name)._hp
  var current_hp: Double = PokemonDescription.valueOf(_name)._hp
  var attack: Int = PokemonDescription.valueOf(_name)._attack
  var defense: Int = PokemonDescription.valueOf(_name)._defense
  var sp_attack: Int = PokemonDescription.valueOf(_name)._sp_attack
  var sp_defense: Int = PokemonDescription.valueOf(_name)._sp_defense
  var speed: Int = PokemonDescription.valueOf(_name)._speed
  var turn_speed: Int = 500 - speed
  var turn_counter: Int = turn_speed
  var type1: Type = new Type(PokemonDescription.valueOf(_name)._type1)
  var type2: Type = new Type(PokemonDescription.valueOf(_name)._type2)
  var move1: Move = new Move(PokemonDescription.valueOf(_name)._move1)
  var move2: Move = new Move(PokemonDescription.valueOf(_name)._move2)
  var frontportrait: String = PokemonDescription.valueOf(_name)._frontportrait
  var backportrait: String = PokemonDescription.valueOf(_name)._backportrait

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
                          val _move1: String,
                          val _move2: String,
                          val _frontportrait: String,
                          val _backportrait: String):
    //Grade 1 Pokemon
    case Caterpie extends PokemonDescription(  "Caterpie",   1, 105,  32,  36,  23,  22,  45,  "Bug",    "",          "Tackle",         "Bug_Bite",       "caterpie_front.png",   "caterpie_back.png")
    case Magikarp extends PokemonDescription(  "Magikarp",   1, 80,   14,  54,  19,  22,  76,  "Water",  "",          "Splash",         "Splash",         "magikarp_front.png",   "magikarp_back.png")
    case Metapod extends PokemonDescription(   "Metapod",    1, 110,  23,  70,  28,  27,  31,  "Bug",    "",          "Tackle",         "Bug_Bite",       "metapod_front.png",    "metapod_back.png")
    case Pidgey extends PokemonDescription(    "Pidgey",     1, 100,  46,  40,  37,  36,  54,  "Normal", "Flying",    "Tackle",         "Gust",           "pidgey_front.png",     "pidgey_back.png")
    case Rattata extends PokemonDescription(   "Rattata",    1, 90,   55,  36,  25,  36,  69,  "Normal", "",          "Tackle",         "Bite",           "rattata_front.png",    "rattata_back.png")
    case Shuckle extends PokemonDescription(   "Shuckle",    1, 80,   14,  211, 14,  100, 9,   "Bug",    "Rock",      "Bug_Bite",       "Rock_Throw",     "shuckle_front.png",    "shuckle_back.png")
    case Sunkern extends PokemonDescription(   "Sunkern",    1, 90,   32,  31,  32,  31,  31,  "Grass",  "",          "Tackle",         "Razor_Leaf",     "sunkern_front.png",    "sunkern_back.png")
    case Swinub extends PokemonDescription(    "Swinub",     1, 110,  50,  40,  32,  31,  49,  "Bug",    "",          "Mud_Slap",       "Powder_Snow",    "swinub_front.png",     "swinub_back.png")

    //Grade 2 Pokemon
    case Beldum extends PokemonDescription(    "Beldum",     2, 100,  55,  76,  37,  58,  31,  "Steel",  "Psychic",   "Tackle",         "Zen_Headbutt",   "beldum_front.png",     "beldum_back.png")
    case Butterfree extends PokemonDescription("Butterfree", 2, 120,  46,  49,  77,  76,  67,  "Bug",    "Flying",    "Gust",           "Bug_Buzz",       "butterfree_front.png", "butterfree_back.png")
    case Chimchar extends PokemonDescription(  "Chimchar",   2, 120,  79,  65,  79,  65,  61,  "Fire",   "",          "Scratch",        "Ember",          "chimchar_front.png",   "chimchar_back.png")
    case Froakie extends PokemonDescription(   "Froakie",    2, 101,  71,  65,  74,  67,  60,  "Water",  "",          "Pound",          "Water_Gun",      "froakie_front.png",    "froakie_back.png")
    case Larvitar extends PokemonDescription(  "Larvitar",   2, 110,  63,  50,  46,  49,  41,  "Rock",   "Ground",    "Rock_Throw",     "Bite",           "larvitar_front.png",   "larvitar_back.png")
    case Pidgeotto extends PokemonDescription( "Pidgeotto",  2, 123,  61,  58,  55,  54,  69,  "Normal", "Flying",    "Gust",           "Wing_Attack",    "pidgeotto_front.png",  "pidgeotto_back.png")
    case Piloswine extends PokemonDescription( "Piloswine",  2, 160,  91,  75,  56,  55,  49,  "Ice",    "Ground",    "Mud_Slap",       "Ice_Fang",       "piloswine_front.png",  "piloswine_back.png")
    case Raticate extends PokemonDescription(  "Raticate",   2, 115,  69,  67,  41,  76,  73,  "Normal", "",          "Tackle",         "Crunch",         "raticate_front.png",   "raticate_back.png")
    case Rowlet extends PokemonDescription(    "Rowlet",     2, 128,  70,  69,  65,  64,  58,  "Grass",  "Flying",    "Tackle",         "Razor_Leaf",     "rowlet_front.png",     "rowlet_back.png")
    case Skrelp extends PokemonDescription(    "Skrelp",     2, 110,  61,  60,  61,  60,  31,  "Poison", "Water",     "Tackle",         "Acid",           "skrelp_front.png",     "skrelp_back.png")
    case Sunflora extends PokemonDescription(  "Sunflora",   2, 135,  73,  54,  100,  81,  31,  "Grass",  "",          "Pound",          "Razor_Leaf",     "sunflora_front.png",   "sunflora_back.png")

    //Grade 3 Pokemon
    case Dartrix extends PokemonDescription(   "Dartrix",    3, 140,  76,  75,  71,  70,  61,  "Grass",  "Flying",    "Leafage",        "Pluck",          "dartrix_front.png",    "dartrix_back.png")
    case Dragalge extends PokemonDescription(  "Dragalge",   3, 125,  81,  87,  93,  115, 44,  "Poison", "Dragon",    "Poison_Tail",    "Dragon_Pulse",   "dragalge_front.png",   "dragalge_back.png")
    case Frogadier extends PokemonDescription( "Frogadier",  3, 137,  77,  69,  84,  71,  91,  "Water",  "",          "Water_Gun",      "Water_Pulse",    "frogadier_front.png",  "frogadier_back.png")
    case Mamoswine extends PokemonDescription( "Mamoswine",  3, 170,  121, 75,  66,  56,  74,  "Ice",    "Ground",    "Ice_Fang",       "Bulldoze",       "mamoswine_front.png",  "mamoswine_back.png")
    case Mawile extends PokemonDescription(    "Mawile",     3, 110,  91,  90,  54,  53,  49,  "Steel",  "Fairy",     "Iron_Head",      "Play_Rough",     "mawile_front.png",     "mawile_back.png")
    case Metang extends PokemonDescription(    "Metang",     3, 120,  75,  94,  55,  76,  50,  "Steel",  "Psychic",   "Zen_Headbutt",   "Flash_Cannon",   "metang_front.png",     "metang_back.png")
    case Monferno extends PokemonDescription(  "Monferno",   3, 145,  101, 78,  101, 78,  77,  "Fire",   "Fighting",  "Flame_Wheel",    "Low_Kick",       "monferno_front.png",   "monferno_back.png")
    case Pidgeot extends PokemonDescription(   "Pidgeot",    3, 143,  77,  72,  68,  67,  86,  "Normal", "Flying",    "Wing_Attack",    "Aerial_Ace",     "pidgeot_front.png",    "pidgeot_back.png")
    case Pikachu extends PokemonDescription(   "Pikachu",    3, 100,  64,  50,  59,  55,  90,  "Electric","",         "Tackle",         "Thunderbolt",    "pikachu_front.png",    "pikachu_back.png")
    case Pupitar extends PokemonDescription(   "Pupitar",    3, 130,  84,  70,  64,  67,  50,  "Rock",   "Ground",    "Bite",           "Rock_Slide",     "pupitar_front.png",    "pupitar_back.png")
    case Raichu extends PokemonDescription(    "Raichu",     3, 120,  83,  54,  83,  73,  95,  "Electric","",         "Thunderbolt",    "Discharge",      "raichu_front.png",     "raichu_back.png")

    //Grade 4 Pokemon
    case Decidueye extends PokemonDescription( "Decidueye",  4, 161,  138, 105, 131, 130, 70,  "Grass",  "Ghost",     "Leaf_Blade",     "Spirit_Shackle", "decidueye_front.png",  "decidueye_back.png")
    case Greninja extends PokemonDescription(  "Greninja",   4, 155,  126, 97,  134, 101, 114, "Water",  "Dark",      "Water_Shuriken", "Night_Slash",    "greninja_front.png",   "greninja_back.png")
    case Gyarados extends PokemonDescription(  "Gyarados",   4, 178,  156, 109, 91,  130, 77,  "Water",  "Flying",    "Hydro_Pump",     "Dragon_Pulse",   "gyarados_front.png",   "gyarados_back.png")
    case Infernape extends PokemonDescription( "Infernape",  4, 159,  135, 101, 135, 101, 101, "Fire",   "Fighting",  "Flare_Blitz",    "Close_Combat",   "infernape_front.png",  "infernape_back.png")
    case Lapras extends PokemonDescription(    "Lapras",     4, 222,  84,  77,  84,  91,  64,  "Ice",    "Water",     "Ice_Beam",       "Hydro_Pump",     "lapras_front.png",     "lapras_back.png")
    case Metagross extends PokemonDescription( "Metagross",  4, 140,  127, 121, 91,  82,  67,  "Steel",  "Psychic",   "Psychic",        "Meteor_Mash",    "metagross_front.png",  "metagross_back.png")
    case Tyranitar extends PokemonDescription( "Tyranitar",  4, 160,  126, 103, 88,  87,  59,  "Rock",   "Dark",      "Crunch",         "Stone_Edge",     "tyranitar_front.png",  "tyranitar_back.png")

    //Grade 5 Pokemon
    case HoOh extends PokemonDescription(      "HoOh",       5, 312,  200, 156, 178, 226, 256, "Fire",   "Flying",    "Sacred_Fire",    "Sky_Attack",     "ho-oh_front.png",       "ho-oh_back.png")
    case Lugia extends PokemonDescription(     "Lugia",      5, 213,  156, 200, 156, 226, 178, "Psychic","Flying",    "Hydro_Pump",     "Sky_Attack",     "lugia_front.png",       "lugia_back.png")

    //Grade 6 Pokemon
    case Arceus extends PokemonDescription(    "Arceus",     6, 444,  372, 372, 372, 372, 372, "Normal", "",          "Hyper_Beam",     "Judgement",      "arceus_front.png",     "arceus_back.png")

  end PokemonDescription

  // Getters
  def name(): String =
    _name
  
  def observation(): String =
    "The " + type1.pokemontype() + " " + type2.pokemontype() + " type " + _name + " has a max health of " + hp + ", an attack of " + attack + ", defense of " + defense +", special attack of " + sp_attack + ", special defense of " + sp_defense + " and a speed of " + speed + "."

  
  // Setters
  def hpChange(change: Double): Unit =
    current_hp -= change
    if current_hp < 0 then
      current_hp = 0
    end if

  def turnCounterProgress(): Unit =
    turn_counter -= 1

  def turnCounterReset(): Unit =
    turn_counter = turn_speed

  def move1Damage(defending_type1: String, defending_type2: String, enemy_defense: Int, enemy_sp_defense: Int): Double =
    var initial_damage: Double = 0

    if move1.move_category == "Physical" then
      initial_damage = attack * move1.power / 100
      println(initial_damage)
      initial_damage = move1.move_type.checkEffectiveness(defending_type1, initial_damage)
      println(initial_damage)
      initial_damage = move1.move_type.checkEffectiveness(defending_type2, initial_damage)
      println(initial_damage)
      if initial_damage == 0 then
        null
      else
        initial_damage -= enemy_defense
        println(initial_damage + " - " + enemy_defense)
        println(initial_damage)
        if initial_damage <= 5 then
          initial_damage = 5
        end if
      end if
    else if move1.move_category == "Special" then
      initial_damage = sp_attack * move1.power / 100
      println(initial_damage)
      initial_damage = move1.move_type.checkEffectiveness(defending_type1, initial_damage)
      println(initial_damage)
      initial_damage = move1.move_type.checkEffectiveness(defending_type2, initial_damage)
      println(initial_damage)
      if initial_damage == 0 then
        null
      else
        initial_damage -= enemy_sp_defense
        println(initial_damage + " - " + enemy_sp_defense)
        println(initial_damage)
        if initial_damage <= 5 then
          initial_damage = 5
        end if
      end if
    end if
    println(initial_damage)
    initial_damage

  def move2Damage(defending_type1: String, defending_type2: String, enemy_defense: Int, enemy_sp_defense: Int): Double =
    var initial_damage: Double = 0

    if move2.move_category == "Physical" then
      initial_damage = attack * move2.power / 100
      println(initial_damage)
      initial_damage = move2.move_type.checkEffectiveness(defending_type1, initial_damage)
      println(initial_damage)
      initial_damage = move2.move_type.checkEffectiveness(defending_type2, initial_damage)
      println(initial_damage)
      if initial_damage == 0 then
        null
      else
        initial_damage -= enemy_defense
        println(initial_damage + " - " + enemy_defense)
        println(initial_damage)
        if initial_damage <= 5 then
          initial_damage = 5
        end if
      end if
    else if move2.move_category == "Special" then
      initial_damage = sp_attack * move2.power / 100
      println(initial_damage)
      initial_damage = move2.move_type.checkEffectiveness(defending_type1, initial_damage)
      println(initial_damage)
      initial_damage = move2.move_type.checkEffectiveness(defending_type2, initial_damage)
      println(initial_damage)
      if initial_damage == 0 then
        null
      else
        initial_damage -= enemy_sp_defense
        println(initial_damage + " - " + enemy_sp_defense)
        println(initial_damage)
        if initial_damage <= 5 then
          initial_damage = 5
        end if
      end if
    end if
    println(initial_damage)
    initial_damage

end Pokemon

class UserPokemon(_name: String) extends Pokemon(_name: String) :
end UserPokemon

class EnemyPokemon(_name: String) extends Pokemon(_name: String) :
  var selectedMove: Move = null
  var selectedTarget: UserPokemon = null

  def setSelectedTarget(targetPokemon1: UserPokemon, targetPokemon2: UserPokemon): Unit =
    val targetchoice: Int = Random.nextInt(4) + 1

    if targetchoice <= 2 then
      selectedTarget = targetPokemon1
    else if targetchoice <= 4 then
      selectedTarget = targetPokemon2
    end if

  def attackAI(): Double =
    val movechoice: Int = Random.nextInt(4) + 1
    var damagedealt: Double = 0

    if movechoice <= 2 then
      selectedMove = move1
      damagedealt = move1Damage(selectedTarget.type1.name, selectedTarget.type2.name, selectedTarget.defense, selectedTarget.sp_defense)

    else if movechoice <= 4 then
      selectedMove = move2
      damagedealt = move2Damage(selectedTarget.type1.name, selectedTarget.type2.name, selectedTarget.defense, selectedTarget.sp_defense)

    end if

    damagedealt

end EnemyPokemon
