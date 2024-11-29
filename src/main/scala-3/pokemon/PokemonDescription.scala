
enum PokemonDescription (val name: String,
                         val hp: Double,
                         val attack: Int,
                         val defense: Int,
                         val sp_attack: Int,
                         val sp_defense: Int,
                         val speed: Int,
                         val type1: String,
                         val type2: String) :
  case Caterpie extends PokemonDescription("Caterpie",  105,  31, 36, 22, 22, 45, "Bug",  null)


end PokemonDescription
