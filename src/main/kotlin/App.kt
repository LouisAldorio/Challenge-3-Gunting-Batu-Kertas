class App {
    companion object {
        private val PERMITTED_ELEMENTS: List<String> = arrayListOf("gunting", "batu", "kertas")
        internal val playerOne = Player(1)
        internal val playerTwo = Player(2)

        @JvmStatic
        fun main(args: Array<String>) {
            App().start()
        }
    }

    private fun start() {
        header()
        inputPreparation(playerOne)
        print("\n")
        inputPreparation(playerTwo)

        print("\n")
        println("Hasil: ")
        compare(playerOne, playerTwo)
    }

    private fun header() {
        println(
            """
            =========================="
            GAME SUIT TERMINAL VERSION"
            =========================="
        """.trimIndent()
        )
    }

    private fun inputPreparation(player: Player) {
        do {
            println("${player.playerNum}. Masukkan Pemain ${player.playerNum}: ")
            print("Nama Depan    : ")
            player.firstName = readLine().toString()
            print("Nama Belakang : ")
            player.lastName = readLine().toString()
            print("Pilihan : ")
            player.choice = readLine()?.lowercase() ?: ""

            val condition = player.choice == "" || !PERMITTED_ELEMENTS.contains(player.choice)
                    || player.firstName == "" || player.lastName == ""

            if (condition) {
                println("Input tidak Valid")
                print("\n")
            }
        } while (condition)
    }

    private fun compare(playerOne: Player, playerTwo: Player) {

        if (playerOne.choice == playerTwo.choice) {

            Draw().showDecision(null)

        } else if (playerOne.choice == "gunting" && playerTwo.choice == "kertas"
            || playerOne.choice == "batu" && playerTwo.choice == "gunting"
            || playerOne.choice == "kertas" && playerTwo.choice == "batu"
        ) {

            Win().showDecision(playerOne)
            Lose().showDecision(playerTwo)

        } else if (playerOne.choice == "gunting" && playerTwo.choice == "batu"
            || playerOne.choice == "kertas" && playerTwo.choice == "gunting"
            || playerOne.choice == "batu" && playerTwo.choice == "kertas"
        ) {

            Win().showDecision(playerTwo)
            Lose().showDecision(playerOne)

        }
    }
}