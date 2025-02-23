
interface EncendidoApagado {
    fun encender()
    fun apagar()
}

interface DispositivoElectronico {
    fun reiniciar()
}

interface Vehiculo {
    var motorEncendido: Boolean
    var kmHora: Int

    fun acelerar(aumento: Int)
    fun frenar(disminucion: Int)
}

class Telefono : EncendidoApagado, DispositivoElectronico {
    private var encendido = false

    override fun encender() {
        if (!encendido) {
            encendido = true
            println("Teléfono encendido")
        }
    }

    override fun apagar() {
        if (encendido) {
            encendido = false
            println("Teléfono apagado")
        }
    }

    override fun reiniciar() {
        if (encendido) {
            println("Reiniciando teléfono...")
        } else {
            println("No se puede reiniciar, el teléfono está apagado.")
        }
    }
}

class Lavadora : EncendidoApagado, DispositivoElectronico {
    private var encendida = false

    override fun encender() {
        encendida = true
        println("Lavadora encendida")
    }

    override fun apagar() {
        encendida = false
        println("Lavadora apagada")
    }

    override fun reiniciar() {
        if (encendida) {
            println("Lavadora reiniciada")
        } else {
            println("No se puede reiniciar, la lavadora está apagada.")
        }
    }
}

class Coche : EncendidoApagado, Vehiculo {
    override var motorEncendido = false
    override var kmHora = 0

    override fun encender() {
        motorEncendido = true
        println("Coche encendido")
    }

    override fun apagar() {
        motorEncendido = false
        kmHora = 0
        println("Coche apagado")
    }

    override fun acelerar(aumento: Int) {
        if (motorEncendido) {
            kmHora += aumento
            println("Acelerando... Velocidad actual: ${kmHora} km/h")
        } else {
            println("No se puede acelerar, el motor está apagado.")
        }
    }

    override fun frenar(disminucion: Int) {
        kmHora -= disminucion
        if (kmHora < 0) kmHora = 0
        println("Frenando... Velocidad actual: ${kmHora} km/h")
    }
}

fun main() {
    val miTelefono = Telefono()
    miTelefono.encender()
    miTelefono.reiniciar()
    miTelefono.apagar()

    println()

    val miLavadora = Lavadora()
    miLavadora.encender()
    miLavadora.reiniciar()
    miLavadora.apagar()

    println()

    val miCoche = Coche()
    miCoche.acelerar(20)
    miCoche.encender()
    miCoche.acelerar(50)
    miCoche.frenar(30)
    miCoche.frenar(30)
    miCoche.apagar()
}
