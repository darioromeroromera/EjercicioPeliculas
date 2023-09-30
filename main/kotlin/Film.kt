class Film{
    private var codigoPelicula : Int? = null
    private var nombrePelicula : String? = ""
    private var generoPelicula : String? = ""

    constructor(codigoPelicula : Int?, nombrePelicula : String?, generoPelicula : String?){
        this.codigoPelicula = codigoPelicula
        this.nombrePelicula = nombrePelicula
        this.generoPelicula = generoPelicula
    }

    constructor(nombrePelicula : String?, generoPelicula : String?) {
        this.nombrePelicula = nombrePelicula
        this.generoPelicula = generoPelicula
    }

    public fun getCodigoPelicula() : Int? {
        return codigoPelicula
    }

    public fun getNombrePelicula() : String? {
        return nombrePelicula
    }

    public fun getGeneroPelicula() : String? {
        return generoPelicula
    }

    public fun setNombrePelicula(nombrePelicula : String?) : Unit {
        this.nombrePelicula = nombrePelicula
    }

    public fun setGeneroPelicula(generoPelicula: String?) : Unit {
        this.generoPelicula = generoPelicula
    }

    override fun toString(): String {
        return String.format("Código: %d, Nombre: %s, Género: %s\n", codigoPelicula, nombrePelicula, generoPelicula)
    }
}