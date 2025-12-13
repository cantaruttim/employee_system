//package br.com.cantarutti;
//
//import br.com.cantarutti.data.employeeDTO.EmployeeDTO;
//import br.com.cantarutti.model.employee.Employee;
//import br.com.cantarutti.repository.employee.EmployeeRepository;
//import br.com.cantarutti.service.EmployeeService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.UUID;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@RunWith(MockitoJUnitRunner.class)
//public class EmployeeAppApplicationTest {
//
//    @Mock
//    private EmployeeRepository repository;
//
//    @InjectMocks
//    private EmployeeService service;
//
//    @Test
//    public void findByIdTest_ReturnEmployee() {
//        // given
//        Employee fake = new Employee();
//
//        String id = "550e8400-e29b-41d4-a716-446655440000";
//
//        fake.setId(String.valueOf(UUID.fromString(id)));
//        fake.setName("Alice");
//        when(repository.findById(String.valueOf(UUID.fromString(id)))).thenReturn(Optional.of(fake));
//
//        // when
//        EmployeeDTO result = service.findById(String.valueOf(UUID.fromString(id)));
//
//        // then
//        assertNotNull(result);
//        assertEquals("Alice", result.getName());
//        verify(repository).findById(String.valueOf(UUID.fromString(id)));
//    }
//
//
//    @Test
//    public void findById_WhenEmployeeNotFound() {
//        UUID id = UUID.randomUUID();
//
//        when(repository.findById(String.valueOf(id))).thenReturn(Optional.empty());
//
//        assertThrows(RuntimeException.class, () -> service.findById(String.valueOf(id)));
//
//        verify(repository).findById(String.valueOf(id));
//    }
//
//    @Test
//    public void shouldReturnAllEmployees() {
//
//        Employee e1 = new Employee();
//        e1.setId(String.valueOf(UUID.randomUUID()));
//        e1.setName("Alice");
//
//        Employee e2 = new Employee();
//        e2.setId(String.valueOf(UUID.randomUUID()));
//        e2.setName("Bob");
//
//        when(repository.findAll()).thenReturn(List.of(e1, e2));
//
//        List<EmployeeDTO> result = service.listAll();
//
//        assertEquals(2, result.size());
//        assertEquals("Alice", result.get(0).getName());
//        assertEquals("Bob", result.get(1).getName());
//
//        verify(repository).findAll();
//        System.out.printf("First employee: " + result.get(0).getName());
//        System.out.println();
//        System.out.printf("Last employee: " + result.get(1).getName());
//    }
//
//    @Test
//    public void shouldUpdateLocation() {
//        UUID id = UUID.randomUUID();
//        Employee employee = new Employee();
//        employee.setId(String.valueOf(id));
//        employee.setLat(-23.55);
//        employee.setLon(-46.63);
//        employee.setName("Alice");
//        System.out.printf("Started Position");
//        System.out.printf("Employee: " + employee.getName() + "\n" + "POSITION: " + "\n" + "  Lat: " + employee.getLat() + "\n" + "  Lon: " +  employee.getLon() );
//
//        // Mock do findById
//        when(repository.findById(String.valueOf(id))).thenReturn(Optional.of(employee));
//        // Mock do save, retornando o próprio employee
//        when(repository.save(any(Employee.class))).thenAnswer(invocation -> invocation.getArgument(0));
//
//        EmployeeDTO result = service.updatedLocation(String.valueOf(id), -20.00, -35.18);
//
//        assertEquals(-20.00, result.getLat());
//        assertEquals(-35.18, result.getLon());
//
//        verify(repository).save(any(Employee.class));
//
//        System.out.printf("\nEnded Position");
//        System.out.printf("Employee: " + result.getName() + "\n" + "POSITION: " + "\n" + "  Lat: " + result.getLat() + "\n" + "  Lon: " +  result.getLon() );
//
//    }
//
//
//
//}
