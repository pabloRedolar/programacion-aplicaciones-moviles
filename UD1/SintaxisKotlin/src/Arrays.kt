fun main() {
    val weekend = arrayOf("Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo")

    weekend.forEach { dia -> println(dia) }


    for ((posicion, dia) in weekend.withIndex()){
        println("El dia ${posicion+1} de la semana es $dia")
    }


}