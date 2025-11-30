package br.com.cantarutti;

import br.com.cantarutti.data.EmployeeDTO;
import br.com.cantarutti.model.Employee;
import br.com.cantarutti.repository.EmployeeRepository;
import br.com.cantarutti.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeAppApplicationTest {

    @Mock
    private EmployeeRepository repository;

    @InjectMocks
    private EmployeeService service;

    @Test
    public void findByIdTest_ReturnEmployee() {
        // given
        Employee fake = new Employee();

        String id = "550e8400-e29b-41d4-a716-446655440000";

        fake.setId(UUID.fromString(id));
        fake.setName("Alice");
        when(repository.findById(UUID.fromString(id))).thenReturn(Optional.of(fake));

        // when
        EmployeeDTO result = service.findById(UUID.fromString(id));

        // then
        assertNotNull(result);
        assertEquals("Alice", result.getName());
        verify(repository).findById(UUID.fromString(id));
    }


    @Test
    public void findById_WhenEmployeeNotFound() {
        UUID id = UUID.randomUUID();

        when(repository.findById(id)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> service.findById(id));

        verify(repository).findById(id);
    }

    @Test
    public void shouldReturnAllEmployees() {

        Employee e1 = new Employee();
        e1.setId(UUID.randomUUID());
        e1.setName("Alice");

        Employee e2 = new Employee();
        e2.setId(UUID.randomUUID());
        e2.setName("Bob");

        when(repository.findAll()).thenReturn(List.of(e1, e2));

        List<EmployeeDTO> result = service.listAll();

        assertEquals(2, result.size());
        assertEquals("Alice", result.get(0).getName());
        assertEquals("Bob", result.get(1).getName());

        verify(repository).findAll();
        System.out.printf("First employee: " + result.get(0).getName());
        System.out.println();
        System.out.printf("Last employee: " + result.get(1).getName());
    }

}
