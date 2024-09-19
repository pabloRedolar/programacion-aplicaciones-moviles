fun main() {
    //Dos tipos mutables e inmutables

    //Listas inmutables

    val readOnly: List<String> = listOf("Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo")
    readOnly.size //muestra el tamaño de la lista
    readOnly.get(3)
    readOnly.first()
    readOnly.last()
    println(readOnly)

    val a = readOnly.filter { it == "Lunes" }
    println(a)

    //Listas mutables

    var listamutables: MutableList<String> = mutableListOf("Lunes", "Martes", "Miercoles")
    listamutables.firstOrNull()


}