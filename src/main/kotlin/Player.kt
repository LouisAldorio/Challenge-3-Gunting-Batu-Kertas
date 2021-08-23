import interfaces.PlayerIdentity

internal class Player(val playerNum: Int) : PlayerIdentity {

    internal lateinit var choice : String

    override lateinit var firstName: String
    override lateinit var  lastName: String
}