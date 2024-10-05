//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    // Задание 1
    val employees = listOf(
        Employee("Олег", 23, 45000),
        Employee("Иван", 28, 50000),
        Employee("Ольга", 25, 40000),
        Employee("Михаил", 22, 55000),
        Employee("Анастасия", 27, 60000),
    )

    println(sortEmployee(employees,"name"))
    println(sortEmployee(employees,"age"))
    println(sortEmployee(employees,"salary"))
    println()

    // Задание 2
    val matrix = arrayListOf(
        listOf((1..9).random(),(1..9).random(),(1..9).random(),(1..9).random()),
        listOf((1..9).random(),(1..9).random(),(1..9).random(),(1..9).random()),
        listOf((1..9).random(),(1..9).random(),(1..9).random(),(1..9).random()),
    )
    val matrixSort = sortRowMatrix(matrix)
    matrixSort.forEach {
        println(it)
    }
    println()

    // Задание 3
    val matrix2 = arrayListOf(
        listOf((1..9).random(),(1..9).random(),(1..9).random(),(1..9).random()),
        listOf((1..9).random(),(1..9).random(),(1..9).random(),(1..9).random()),
        listOf((1..9).random(),(1..9).random(),(1..9).random(),(1..9).random()),
    )
    var current = 0
    val arrIndex = arrayListOf<Int>()

    for (i in matrix2.indices){
        for (j in 1..<matrix2[i].lastIndex){
            if (((matrix2[i][j-1]<matrix2[i][j])&&(matrix2[i][j+1]<matrix2[i][j]))
                ||((matrix2[i][j-1]>matrix2[i][j])&&(matrix2[i][j+1]>matrix2[i][j]))) {
                arrIndex.add(i)
                current++
            }
        }
    }
    arrIndex.distinct().forEach{
        println(matrix2[it])
    }
    println(current)
}

/**
 * @param employees Принимает список сотрудников
 * @param type Принимает тип сортировки
 * @return Отдает список сотрудников
 * */
fun sortEmployee(employees: List<Employee>, type:String):List<Employee>{
    val result: List<Employee> = when(type){
        "name"-> employees.sortedBy { it.name }
        "age"-> employees.sortedBy { it.age.toString() }
        "salary"-> employees.sortedBy { it.salary.toString() }
        else -> throw Exception("Такого типа нет")
    }
    return result
}
data class Employee(val name:String, val age:Number, val salary:Number){
    override fun toString(): String {
        return "$name ($age), Зарплата: $salary "
    }
}

fun sortRowMatrix(array:ArrayList<List<Int>>): ArrayList<List<Int>> {
    val result = ArrayList<List<Int>>()
    for (el in array){
        result.add(el.sorted())
    }
    return result
}