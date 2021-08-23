internal class Lose : Decision() {

    override fun showDecision(player: Player?) {
        println("Pemain ${player!!.playerNum} (${player.name}) KALAH!")
    }
}