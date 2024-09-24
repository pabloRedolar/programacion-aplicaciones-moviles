fun main() {

}

fun getMonth(month: Int) {
    when (month) {
        1 -> print("Enero")
        2 -> print("Febrero")
        3 -> print("Marzo")
        4 -> print("Abril")
        5 -> print("Mayo")
        6 -> print("Junio")
        7 -> print("Julio")
        8 -> print("Agosto")
        9 -> print("Septiembre")
        10 -> print("Octubre")
        11 -> print("Noviembre")
        12 -> print("Diciembre")
        else -> println("Atontao")
    }
}

fun getTrimestre(month: Int) {
    when (month) {
        1-3 -> print("Es el primer trimestre")
        4-6 -> print("Es el segundo trimestre")
        7-9 -> print("Es el tercer trimestre")
        else -> println("Atontao")
    }
}

fun getSemestre(month: Int) {
    when (month) {
        in 1..6 -> print("Es el primer semestre")
        in 7..12 -> print("Es el segundo semestre")
        else -> println("Atontao")
    }
}



