import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        StudentManagerImpl manager = new StudentManagerImpl();

        //Agregando Estudiantes
        manager.addStudent(new Student(1, "Diego", 22));
        manager.addStudent(new Student(2, "Mirna", 20));
        manager.addStudent(new Student(3, "Juan", 23));
        manager.addStudent(new Student(4, "Juan", 30));
        manager.addStudent(new Student(5, "Juan", 40));

        // Lista completa de Estudiantes
        System.out.println("All Students:");
        manager.getAllStudents().forEach(System.out::println);

        // Filtrar estudiantes mayores de 21
        System.out.println("\nStudiantes Mayores de 21:");
        List<Student> olderStudents = manager.getAllStudents().stream()
                .filter(s -> s.getAge() > 21)
                .collect(Collectors.toList());
        olderStudents.forEach(System.out::println);

        // Ordenar estudiantes por nombre
        System.out.println("\nEstudiantes por Nombre:");
        List<Student> sortedStudents = manager.getAllStudents().stream()
                .sorted((s1, s2) -> s1.getName().compareTo(s2.getName()))
                .collect(Collectors.toList());
        sortedStudents.forEach(System.out::println);

        // Manejo de excepciones
        try {
            manager.removeStudent(6); // Intentar eliminar un estudiante que no existe
        } catch (StudentNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
