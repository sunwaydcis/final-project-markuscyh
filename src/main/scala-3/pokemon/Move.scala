package pokemon

class Move(__name: String):
  var _move_type: String = MoveDescription.valueOf(__name).move_type()
  var _move_category: String = MoveDescription.valueOf(__name).move_category()
  var _power: Int = MoveDescription.valueOf(__name).power()
  var _name: String = MoveDescription.valueOf(__name).name()

  enum MoveDescription(val _name: String,
                       val _move_type: String,
                       val _move_category: String,
                       val _power: Int):
    //Normal Type Moves
    case Tackle extends MoveDescription(        "Tackle",         "Normal",   "Physical", 40)
    case Scratch extends MoveDescription(       "Scratch",        "Normal",   "Physical", 40)
    case Pound extends MoveDescription(         "Pound",          "Normal",   "Physical", 45)
    case Hyper_Beam extends MoveDescription(    "Hyper Beam",     "Normal",   "Physical", 150)
    case Judgement extends MoveDescription(     "Judgement",      "Normal",   "Special",  150)

    //Fire Type Moves
    case Ember extends MoveDescription(         "Ember",          "Fire",     "Special",  40)
    case Flame_Wheel extends MoveDescription(   "Flame Wheel",    "Fire",     "Physical", 60)
    case Flare_Blitz extends MoveDescription(   "Flare Blitz",    "Fire",     "Physical", 120)
    case Sacred_Fire extends MoveDescription(   "Sacred Fire",    "Fire",     "Physical", 100)

    //Water Type Moves
    case Splash extends MoveDescription(        "Splash",         "Water",    "Physical", 0)
    case Water_Gun extends MoveDescription(     "Water Gun",      "Water",    "Special",  40)
    case Water_Pulse extends MoveDescription(   "Water Pulse",    "Water",    "Special",  60)
    case Water_Shuriken extends MoveDescription("Water Shuriken", "Water",    "Special",  75)
    case Hydro_Pump extends MoveDescription(    "Hydro Pump",     "Water",    "Special",  110)

    //Electric Type Moves
    case Thunderbolt extends MoveDescription(   "Thunderbolt",    "Electric", "Special",  90)
    case Discharge extends MoveDescription(     "Discharge",      "Electric", "Special",  80)

    //Grass Type Moves
    case Leafage extends MoveDescription(       "Leafage",        "Grass",    "Physical", 60)
    case Razor_Leaf extends MoveDescription(    "Razor Leaf",     "Grass",    "Physical", 55)
    case Leaf_Blade extends MoveDescription(    "Leaf Blade",     "Grass",    "Physical", 90)

    //Ice Type Moves
    case Powder_Snow extends MoveDescription(   "Powder Snow",    "Ice",      "Special",  40)
    case Ice_Fang extends MoveDescription(      "Ice Fang",       "Ice",      "Physical", 65)
    case Ice_Beam extends MoveDescription(      "Ice Beam",       "Ice",      "Special",  90)

    //Fighting Type Moves
    case Low_Kick extends MoveDescription(      "Low Kick",       "Fighting", "Physical", 65)
    case Close_Combat extends MoveDescription(  "Close Combat",   "Fighting", "Physical", 120)

    //Poison Type Moves
    case Acid extends MoveDescription(          "Acid",           "Poison",   "Special",  40)
    case Poison_Tail extends MoveDescription(   "Poison Tail",    "Poison",   "Physical", 50)

    //Ground Type Moves
    case Mud_Slap extends MoveDescription(      "Mud Slap",       "Ground",   "Special",  20)
    case Bulldoze extends MoveDescription(      "Bulldoze",       "Ground",   "Physical", 60)

    //Flying Type Moves
    case Gust extends MoveDescription(          "Gust",           "Flying",   "Special",  40)
    case Wing_Attack extends MoveDescription(   "Wing Attack",    "Flying",   "Physical", 55)
    case Pluck extends MoveDescription(         "Pluck",          "Flying",   "Physical", 60)
    case Aerial_Ace extends MoveDescription(    "Aerial Ace",     "Flying",   "Physical", 65)
    case Sky_Attack extends MoveDescription(    "Sky Attack",     "Flying",   "Physical", 140)

    //Psychic Type Moves
    case Zen_Headbutt extends MoveDescription(  "Zen Headbutt",   "Psychic",  "Physical", 80)
    case Psychic extends MoveDescription(       "Psychic",        "Psychic",  "Special",  90)

    //Bug Type Moves
    case Bug_Bite extends MoveDescription(      "Bug Bite",       "Bug",      "Physical", 60)
    case Bug_Buzz extends MoveDescription(      "Bug Buzz",       "Bug",      "Special",  90)

    //Rock Type Moves
    case Rock_Throw extends MoveDescription(    "Rock Throw",     "Rock",     "Physical", 50)
    case Rock_Slide extends MoveDescription(    "Rock Slide",     "Rock",     "Physical", 75)
    case Stone_Edge extends MoveDescription(    "Stone Edge",     "Rock",     "Physical", 100)

    //Ghost Type Moves
    case Spirit_Shackle extends MoveDescription("Spirit Shackle", "Ghost",    "Physical", 80)

    //Dragon Type Moves
    case Dragon_Pulse extends MoveDescription(  "Dragon Pulse",   "Dragon",   "Special",  85)

    //Dark Type Moves
    case Bite extends MoveDescription(          "Bite",           "Dark",     "Physical", 60)
    case Crunch extends MoveDescription(        "Crunch",         "Dark",     "Physical", 80)
    case Night_Slash extends MoveDescription(   "Night Slash",    "Dark",     "Physical", 70)

    //Steel Type Moves
    case Iron_Head extends MoveDescription(     "Iron Head",      "Steel",    "Physical", 80)
    case Flash_Cannon extends MoveDescription(  "Flash Cannon",   "Steel",    "Special",  80)
    case Meteor_Mash extends MoveDescription(   "Meteor Mash",    "Steel",    "Physical", 90)

    //Fairy Type Moves
    case Play_Rough extends MoveDescription(    "Play Rough",     "Fairy",    "Physical", 90)

    def name(): String =
      _name

    def move_type(): String =
      _move_type

    def move_category(): String =
      _move_category

    def power(): Int =
      _power

  end MoveDescription

end Move