internal class Win : Decision() {

    override fun showDecision(player: Player?) {
        println("Pemain ${player!!.playerNum} (${player.name}) MENANG!")
    }
}