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
  var user_score: Int = PokemonDescription.valueOf(_name)._user_score
  var enemy_score: Int = PokemonDescription.valueOf(_name)._enemy_score
  var actual_score: Double = 0

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
                          val _backportrait: String,
                          val _user_score: Int,
                          val _enemy_score: Int):
    //Grade 1 Pokemon
    case Caterpie extends PokemonDescription(  "Caterpie",   1, 105,  37,  32,  23,  18,  45,  "Bug",    "",          "Tackle",         "Bug_Bite",       "caterpie_front.png",   "caterpie_back.png",   12000, 2000)
    case Magikarp extends PokemonDescription(  "Magikarp",   1, 80,   19,  50,  19,  18,  76,  "Water",  "",          "Splash",         "Splash",         "magikarp_front.png",   "magikarp_back.png",   20000, 100)
    case Metapod extends PokemonDescription(   "Metapod",    1, 110,  28,  66,  28,  23,  31,  "Bug",    "",          "Tackle",         "Bug_Bite",       "metapod_front.png",    "metapod_back.png",    12000, 2000)
    case Pidgey extends PokemonDescription(    "Pidgey",     1, 100,  51,  36,  37,  32,  54,  "Normal", "Flying",    "Tackle",         "Gust",           "pidgey_front.png",     "pidgey_back.png",     12000, 2000)
    case Rattata extends PokemonDescription(   "Rattata",    1, 90,   60,  32,  25,  32,  69,  "Normal", "",          "Tackle",         "Bite",           "rattata_front.png",    "rattata_back.png",    12000, 2000)
    case Shuckle extends PokemonDescription(   "Shuckle",    1, 80,   19,  210, 14,  100, 9,   "Bug",    "Rock",      "Bug_Bite",       "Rock_Throw",     "shuckle_front.png",    "shuckle_back.png",    12000, 2000)
    case Sunkern extends PokemonDescription(   "Sunkern",    1, 90,   37,  27,  32,  27,  31,  "Grass",  "",          "Tackle",         "Razor_Leaf",     "sunkern_front.png",    "sunkern_back.png",    12000, 2000)
    case Swinub extends PokemonDescription(    "Swinub",     1, 110,  55,  36,  32,  27,  49,  "Bug",    "",          "Mud_Slap",       "Powder_Snow",    "swinub_front.png",     "swinub_back.png",     12000, 2000)

    //Grade 2 Pokemon
    case Beldum extends PokemonDescription(    "Beldum",     2, 100,  60,  70,  37,  54,  31,  "Steel",  "Psychic",   "Tackle",         "Zen_Headbutt",   "beldum_front.png",     "beldum_back.png",     10000, 4000)
    case Butterfree extends PokemonDescription("Butterfree", 2, 120,  51,  45,  77,  72,  67,  "Bug",    "Flying",    "Gust",           "Bug_Buzz",       "butterfree_front.png", "butterfree_back.png", 10000, 4000)
    case Chimchar extends PokemonDescription(  "Chimchar",   2, 120,  84,  61,  79,  61,  61,  "Fire",   "",          "Scratch",        "Ember",          "chimchar_front.png",   "chimchar_back.png",   10000, 4000)
    case Froakie extends PokemonDescription(   "Froakie",    2, 101,  76,  61,  74,  63,  60,  "Water",  "",          "Pound",          "Water_Gun",      "froakie_front.png",    "froakie_back.png",    10000, 4000)
    case Larvitar extends PokemonDescription(  "Larvitar",   2, 110,  68,  46,  46,  45,  41,  "Rock",   "Ground",    "Rock_Throw",     "Bite",           "larvitar_front.png",   "larvitar_back.png",   10000, 4000)
    case Pidgeotto extends PokemonDescription( "Pidgeotto",  2, 123,  66,  54,  55,  50,  69,  "Normal", "Flying",    "Gust",           "Wing_Attack",    "pidgeotto_front.png",  "pidgeotto_back.png",  10000, 4000)
    case Piloswine extends PokemonDescription( "Piloswine",  2, 160,  96,  71,  56,  51,  49,  "Ice",    "Ground",    "Mud_Slap",       "Ice_Fang",       "piloswine_front.png",  "piloswine_back.png",  10000, 4000)
    case Raticate extends PokemonDescription(  "Raticate",   2, 115,  74,  63,  41,  72,  73,  "Normal", "",          "Tackle",         "Crunch",         "raticate_front.png",   "raticate_back.png",   10000, 4000)
    case Rowlet extends PokemonDescription(    "Rowlet",     2, 128,  75,  65,  65,  60,  58,  "Grass",  "Flying",    "Tackle",         "Razor_Leaf",     "rowlet_front.png",     "rowlet_back.png",     10000, 4000)
    case Skrelp extends PokemonDescription(    "Skrelp",     2, 110,  66,  56,  61,  56,  31,  "Poison", "Water",     "Tackle",         "Acid",           "skrelp_front.png",     "skrelp_back.png",     10000, 4000)
    case Sunflora extends PokemonDescription(  "Sunflora",   2, 135,  78,  50,  99,  77,  31,  "Grass",  "",          "Pound",          "Razor_Leaf",     "sunflora_front.png",   "sunflora_back.png",  10000, 4000)

    //Grade 3 Pokemon
    case Dartrix extends PokemonDescription(   "Dartrix",    3, 140,  81,  71,  71,  66,  61,  "Grass",  "Flying",    "Leafage",        "Pluck",          "dartrix_front.png",    "dartrix_back.png",    8000, 6000)
    case Dragalge extends PokemonDescription(  "Dragalge",   3, 125,  86,  83,  93,  110, 44,  "Poison", "Dragon",    "Poison_Tail",    "Dragon_Pulse",   "dragalge_front.png",   "dragalge_back.png",   8000, 6000)
    case Frogadier extends PokemonDescription( "Frogadier",  3, 137,  82,  65,  84,  67,  91,  "Water",  "",          "Water_Gun",      "Water_Pulse",    "frogadier_front.png",  "frogadier_back.png",  8000, 6000)
    case Mamoswine extends PokemonDescription( "Mamoswine",  3, 170,  126, 71,  66,  52,  74,  "Ice",    "Ground",    "Ice_Fang",       "Bulldoze",       "mamoswine_front.png",  "mamoswine_back.png",  8000, 6000)
    case Mawile extends PokemonDescription(    "Mawile",     3, 110,  96,  86,  54,  49,  49,  "Steel",  "Fairy",     "Iron_Head",      "Play_Rough",     "mawile_front.png",     "mawile_back.png",     8000, 6000)
    case Metang extends PokemonDescription(    "Metang",     3, 120,  80,  90,  55,  72,  50,  "Steel",  "Psychic",   "Zen_Headbutt",   "Flash_Cannon",   "metang_front.png",     "metang_back.png",     8000, 6000)
    case Monferno extends PokemonDescription(  "Monferno",   3, 145,  106, 74,  101, 74,  77,  "Fire",   "Fighting",  "Flame_Wheel",    "Low_Kick",       "monferno_front.png",   "monferno_back.png",   8000, 6000)
    case Pidgeot extends PokemonDescription(   "Pidgeot",    3, 143,  82,  68,  68,  63,  86,  "Normal", "Flying",    "Wing_Attack",    "Aerial_Ace",     "pidgeot_front.png",    "pidgeot_back.png",    8000, 6000)
    case Pikachu extends PokemonDescription(   "Pikachu",    3, 100,  69,  46,  59,  51,  90,  "Electric","",         "Tackle",         "Thunderbolt",    "pikachu_front.png",    "pikachu_back.png",    8000, 6000)
    case Pupitar extends PokemonDescription(   "Pupitar",    3, 130,  89,  66,  64,  63,  50,  "Rock",   "Ground",    "Bite",           "Rock_Slide",     "pupitar_front.png",    "pupitar_back.png",    8000, 6000)
    case Raichu extends PokemonDescription(    "Raichu",     3, 120,  88,  50,  83,  69,  95,  "Electric","",         "Thunderbolt",    "Discharge",      "raichu_front.png",     "raichu_back.png",     8000, 6000)

    //Grade 4 Pokemon
    case Decidueye extends PokemonDescription( "Decidueye",  4, 161,  143, 95,  131, 120, 70,  "Grass",  "Ghost",     "Leaf_Blade",     "Spirit_Shackle", "decidueye_front.png",  "decidueye_back.png",  6000, 8000)
    case Greninja extends PokemonDescription(  "Greninja",   4, 155,  131, 90,  134, 90,  114, "Water",  "Dark",      "Water_Shuriken", "Night_Slash",    "greninja_front.png",   "greninja_back.png",   6000, 8000)
    case Gyarados extends PokemonDescription(  "Gyarados",   4, 178,  161, 100, 91,  120, 77,  "Water",  "Flying",    "Hydro_Pump",     "Dragon_Pulse",   "gyarados_front.png",   "gyarados_back.png",   6000, 8000)
    case Infernape extends PokemonDescription( "Infernape",  4, 159,  140, 90,  135, 90,  101, "Fire",   "Fighting",  "Flare_Blitz",    "Close_Combat",   "infernape_front.png",  "infernape_back.png",  6000, 8000)
    case Lapras extends PokemonDescription(    "Lapras",     4, 222,  89,  75,  84,  85,  64,  "Ice",    "Water",     "Ice_Beam",       "Hydro_Pump",     "lapras_front.png",     "lapras_back.png",     6000, 8000)
    case Metagross extends PokemonDescription( "Metagross",  4, 140,  132, 110, 91,  80,  67,  "Steel",  "Psychic",   "Psychic",        "Meteor_Mash",    "metagross_front.png",  "metagross_back.png",  6000, 8000)
    case Tyranitar extends PokemonDescription( "Tyranitar",  4, 160,  131, 95,  88,  85,  59,  "Rock",   "Dark",      "Crunch",         "Stone_Edge",     "tyranitar_front.png",  "tyranitar_back.png",  6000, 8000)

    //Grade 5 Pokemon
    case HoOh extends PokemonDescription(      "HoOh",       5, 312,  205, 150, 178, 190, 256, "Fire",   "Flying",    "Sacred_Fire",    "Sky_Attack",     "ho-oh_front.png",       "ho-oh_back.png",     2000, 12000)
    case Lugia extends PokemonDescription(     "Lugia",      5, 275,  161, 190, 156, 210, 188, "Psychic","Flying",    "Hydro_Pump",     "Sky_Attack",     "lugia_front.png",       "lugia_back.png",     2000, 12000)

    //Grade 6 Pokemon
    case Arceus extends PokemonDescription(    "Arceus",     6, 444,  372, 372, 372, 372, 372, "Normal", "",          "Hyper_Beam",     "Judgement",      "arceus_front.png",     "arceus_back.png",     100,  20000)

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

  //calculates the damage dealt by each move
  def move1Damage(defending_type1: String, defending_type2: String, enemy_defense: Int, enemy_sp_defense: Int): Double =
    var initial_damage: Double = 0

    //checks the move category and uses the appropriate stats
    if move1.move_category == "Physical" then
      initial_damage = attack * move1.power / 100
      initial_damage = move1.move_type.checkEffectiveness(defending_type1, initial_damage)
      initial_damage = move1.move_type.checkEffectiveness(defending_type2, initial_damage)
      if initial_damage == 0 then
        null
      else
        initial_damage -= enemy_defense
        if initial_damage <= 5 then
          initial_damage = 5
        end if
      end if
    else if move1.move_category == "Special" then
      initial_damage = sp_attack * move1.power / 100
      initial_damage = move1.move_type.checkEffectiveness(defending_type1, initial_damage)
      initial_damage = move1.move_type.checkEffectiveness(defending_type2, initial_damage)
      if initial_damage == 0 then
        null
      else
        initial_damage -= enemy_sp_defense
        if initial_damage <= 5 then
          initial_damage = 5
        end if
      end if
    end if
    initial_damage

  def move2Damage(defending_type1: String, defending_type2: String, enemy_defense: Int, enemy_sp_defense: Int): Double =
    var initial_damage: Double = 0

    if move2.move_category == "Physical" then
      initial_damage = attack * move2.power / 100
      initial_damage = move2.move_type.checkEffectiveness(defending_type1, initial_damage)
      initial_damage = move2.move_type.checkEffectiveness(defending_type2, initial_damage)
      if initial_damage == 0 then
        null
      else
        initial_damage -= enemy_defense
        if initial_damage <= 5 then
          initial_damage = 5
        end if
      end if
    else if move2.move_category == "Special" then
      initial_damage = sp_attack * move2.power / 100
      initial_damage = move2.move_type.checkEffectiveness(defending_type1, initial_damage)
      initial_damage = move2.move_type.checkEffectiveness(defending_type2, initial_damage)
      if initial_damage == 0 then
        null
      else
        initial_damage -= enemy_sp_defense
        if initial_damage <= 5 then
          initial_damage = 5
        end if
      end if
    end if
    initial_damage

end Pokemon


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

  def scoreCalculation(): Double =
    actual_score = enemy_score - enemy_score * (100 * current_hp/hp) / 100
    actual_score

end EnemyPokemon


class UserPokemon(_name: String) extends Pokemon(_name: String) :

  def scoreCalculation(): Double =
    actual_score = user_score * (100 * current_hp / hp) / 100  
    actual_score

end UserPokemon
