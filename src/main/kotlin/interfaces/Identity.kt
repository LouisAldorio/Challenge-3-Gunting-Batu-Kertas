package interfaces

interface Identity {
    val name : String
}

interface PlayerIdentity : Identity {
    val firstName : String
    val lastName : String

    override val name: String
        get() = "$firstName $lastName"
}