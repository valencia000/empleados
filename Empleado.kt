data class Empleado(
    val nombre: String,
    val edad: Int,
    val salario: Double,
    val departamento: String
)

fun main() {
    val empleados = mutableListOf(
        Empleado("Juan", 25, 2500.0, "IT"),
        Empleado("Ana", 35, 3200.0, "Recursos Humanos"),
        Empleado("Pedro", 40, 4000.0, "IT"),
        Empleado("Lucía", 28, 2800.0, "Marketing"),
        Empleado("Sofía", 45, 5000.0, "Recursos Humanos")
    )

    println("📌 Lista inicial de empleados:")
    empleados.map { it.nombre }.forEach { println(it) }

    // Modificaciones
    empleados.add(Empleado("Carlos", 31, 3500.0, "Marketing"))
    empleados[0] = Empleado("Andrea", 29, 3100.0, "IT")
    empleados.removeIf { it.nombre == "Juan" }

    println("\n📌 Lista después de modificaciones:")
    empleados.map { it.nombre }.forEach { println(it) }

    // Filtrar mayores de 30
    val mayores30 = empleados.filter { it.edad > 30 }
    println("\n📌 Empleados mayores de 30:")
    mayores30.map { it.nombre }.forEach { println(it) }

    // Agrupar por departamento
    val agrupados = empleados.groupBy { it.departamento }
    println("\n📌 Empleados agrupados por departamento:")
    agrupados.forEach { (dep, lista) -> println("$dep: ${lista.map { it.nombre }}") }

    // Salario promedio por departamento
    val promedioPorDep = agrupados.mapValues { (_, lista) -> lista.map { it.salario }.average() }
    println("\n📌 Salario promedio por departamento:")
    promedioPorDep.forEach { (dep, prom) -> println("$dep: $prom") }

    // Mapa nombre → salario
    val mapaNombreSalario = empleados.associate { it.nombre to it.salario }
    println("\n📌 Mapa nombre → salario:")
    mapaNombreSalario.forEach { (nombre, salario) -> println("$nombre: $salario") }

    // Set de departamentos
    val departamentos: Set<String> = empleados.map { it.departamento }.toSet()
    println("\n📌 Conjunto de departamentos (sin duplicados): $departamentos")

    // MutableMap de edades
    val edades = mutableMapOf("Ana" to 35, "Pedro" to 40)
    edades["Sofía"] = 45
    edades["Pedro"] = 41
    edades.remove("Ana")
    println("\n📌 Ejemplo de MutableMap con edades:")
    edades.forEach { (nombre, edad) -> println("$nombre: $edad") }

    // Lista de solo nombres
    val nombres = empleados.map { it.nombre }
    println("\n📌 Lista de solo nombres:")
    println(nombres)
}
