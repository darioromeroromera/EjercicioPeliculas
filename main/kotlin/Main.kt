import kotlin.collections.MutableMap

fun main() {
    var listaPeliculas : MutableMap<Int, Film> = mutableMapOf()
    while (true) {
        mostrarMenu()
        var opcion : String? = readLine()
        when (opcion) {
            "1" -> {
                var pelicula = crearPelicula(listaPeliculas)
                addPelicula(listaPeliculas, pelicula)
            }

            "2" -> {
                mostrarPorCodigo(listaPeliculas)
            }

            "3" -> {
                borrarPelicula(listaPeliculas)
            }

            "4" -> {
                editarPelicula(listaPeliculas)
            }
            "5" -> {
                listaPeliculas.forEach{println("Película ${(it.key) + 1}:\n${it.value}")}
            }
        }
    }
}

fun mostrarMenu() : Unit {
    println("Pulse el número correspondiente para acceder a las funciones del programa")
    println("1. Insertar nueva película")
    println("2. Mostrar película dado su código")
    println("3. Borrar película por su código")
    println("4. Editar una película")
    println("5. Ver todas las películas")
}

fun crearPelicula(listaPeliculas : MutableMap<Int, Film>) : Film {
    println("Introduzca el código de la película")
    var codigoPelicula : Int? = readLine()?.toInt()
    println("Introduzca el nombre de la película")
    var nombrePelicula : String? = readLine()
    println("Introduzca el género de la película")
    var generoPelicula : String? = readLine()

    var pelicula = Film(codigoPelicula, nombrePelicula, generoPelicula)

    return pelicula
}

fun crearPeliculaSinCodigo(listaPeliculas: MutableMap<Int, Film>) : Film {
    println("Introduzca el nombre de la película")
    var nombrePelicula : String? = readLine()
    println("Introduzca el género de la película")
    var generoPelicula : String? = readLine()

    var pelicula = Film(nombrePelicula, generoPelicula)

    return pelicula
}

fun addPelicula(listaPeliculas: MutableMap<Int, Film>, pelicula : Film) {
    if (listaPeliculas.isEmpty()) {
        listaPeliculas.put(0, pelicula)
    } else {
        listaPeliculas.put(listaPeliculas.entries.last().key + 1, pelicula)
    }
}

private fun mostrarPorCodigo(listaPeliculas: MutableMap<Int, Film>) {
    var encontrado = false
    println("Introduce el código a buscar")
    var codigo: Int? = readLine()?.toInt()
    listaPeliculas.forEach {
        if (it.value.getCodigoPelicula() == codigo) {
            println(it.value)
            encontrado = true
        }
    }
    if (!encontrado)
        println("No se ha encontrado ninguna película acorde a ese código")
}

private fun borrarPelicula(listaPeliculas: MutableMap<Int, Film>) {
    println("Introduce el código de película a borrar")
    var codigo: Int? = readLine()?.toInt()
    var keyABorrar: Int? = null
    listaPeliculas.forEach {
        if (it.value.getCodigoPelicula() == codigo)
            keyABorrar = it.key
    }
    keyABorrar.let { listaPeliculas.remove(keyABorrar) } ?: run {
        println("No se ha encontrado ninguna película acorde a ese código")
    }
}

private fun editarPelicula(listaPeliculas: MutableMap<Int, Film>) {
    var encontrado = false
    println("Introduce el código de la película a reemplazar")
    var codigoReemplazo = readLine()?.toInt()
    listaPeliculas.forEach {
        if (it.value.getCodigoPelicula() == codigoReemplazo) {
            encontrado = true
            var pelicula = crearPeliculaSinCodigo(listaPeliculas)
            it.value.setNombrePelicula(pelicula.getNombrePelicula())
            it.value.setGeneroPelicula(pelicula.getGeneroPelicula())

        }
    }
    if (!encontrado)
        println("No se ha encontrado ninguna película con el código introducido")
}