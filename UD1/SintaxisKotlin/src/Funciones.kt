fun main(){
//    mostrarNombre()
//    mostrarMiprimerNOmbre()
//    showMyAge()
    primerBucle(10, 0)
}

fun mostrarNombre(){
    println("Hola me llamo pepe")
}

fun mostrarMiprimerNOmbre(){
    println("mi apellido es rodriguez")
}

fun showMyAge(){
    println("Tengo 19 tacos")
}

fun primerBucle(inicio:Int, final:Int){
    var inicio1 = inicio

    while (inicio1!=final) {
        inicio1--
        println(inicio1)
    }
}