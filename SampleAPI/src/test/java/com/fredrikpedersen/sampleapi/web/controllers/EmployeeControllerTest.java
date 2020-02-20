package com.fredrikpedersen.sampleapi.web.controllers;

import com.fredrikpedersen.sampleapi.services.EmployeeService;
import com.fredrikpedersen.sampleapi.web.models.people.employee.EmployeeDTO;
import com.fredrikpedersen.sampleapi.web.util.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 20.02.2020 at 11:18
 */
class EmployeeControllerTest extends BaseControllerTest {

    private final String FIRST_NAME = "Fredrik";
    private final String LAST_NAME = "Pedersen";
    private final String DEPARTMENT = "IT";
    private final String URL = EmployeeController.BASE_URL;
    private final Long ID = 1L;

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    EmployeeController employeeController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(employeeController)
                .setControllerAdvice(new ResponseEntityExceptionHandler())
                .build();
    }

    @Test
    void getAllEmployeesTest() throws Exception {

        //given
        EmployeeDTO employee1 = new EmployeeDTO();
        employee1.setFirstName(FIRST_NAME);
        employee1.setLastName(LAST_NAME);
        employee1.setDepartment(DEPARTMENT);
        employee1.setEmployeeUrl(URL + ID);

        EmployeeDTO employee2 = new EmployeeDTO();
        employee2.setFirstName("Nikita");
        employee2.setLastName("Petrovs");
        employee2.setDepartment("Economics");
        employee2.setEmployeeUrl(URL + "2");

        List<EmployeeDTO> employees = Arrays.asList(employee1, employee2);

        when(employeeService.getAllEmployees()).thenReturn(employees);

        //when/then
        mockMvc.perform(get(URL)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.employees", hasSize(2)));
    }

    @Test
    void getEmployeeByIdTest() throws Exception {

        //given
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setFirstName(FIRST_NAME);
        employeeDTO.setEmployeeUrl(URL + ID);

        when(employeeService.getEmployeeById(anyLong())).thenReturn(employeeDTO);

        //when/then
        mockMvc.perform(get(URL + ID)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName", equalTo(FIRST_NAME)));
    }

    @Test
    void createNewEmployeeTest() throws Exception {

        //given
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setFirstName(FIRST_NAME);
        employeeDTO.setLastName(LAST_NAME);
        employeeDTO.setDepartment(DEPARTMENT);

        EmployeeDTO returnDto = new EmployeeDTO();
        returnDto.setFirstName(employeeDTO.getFirstName());
        returnDto.setLastName(employeeDTO.getLastName());
        returnDto.setDepartment(employeeDTO.getDepartment());
        returnDto.setEmployeeUrl(URL + ID);

        when(employeeService.createNewEmployee(employeeDTO)).thenReturn(returnDto);

        //when/then
        mockMvc.perform(post(URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapToJson(employeeDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.firstName", equalTo(FIRST_NAME)))
                .andExpect(jsonPath("$.employeeUrl", equalTo(URL + ID)));
    }

    @Test
    void updateEmployeeTest() throws Exception {

        //given
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setFirstName(FIRST_NAME);
        employeeDTO.setLastName(LAST_NAME);
        employeeDTO.setDepartment(DEPARTMENT);

        EmployeeDTO returnDTO = new EmployeeDTO();
        returnDTO.setFirstName(employeeDTO.getFirstName());
        returnDTO.setLastName(employeeDTO.getLastName());
        returnDTO.setDepartment(employeeDTO.getDepartment());
        returnDTO.setEmployeeUrl(URL + ID);

        when(employeeService.saveEmployeeByDTO(anyLong(), any(EmployeeDTO.class))).thenReturn(returnDTO);

        //when/then
        mockMvc.perform(put(URL + ID)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapToJson(employeeDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName", equalTo(FIRST_NAME)))
                .andExpect(jsonPath("$.lastName", equalTo(LAST_NAME)))
                .andExpect(jsonPath("$.employeeUrl", equalTo(URL + ID)));
    }

    @Test
    void patchEmployeeTest() throws Exception {

        //given
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setFirstName(FIRST_NAME);

        EmployeeDTO returnDTO = new EmployeeDTO();
        returnDTO.setFirstName(employeeDTO.getFirstName());
        returnDTO.setLastName(LAST_NAME);
        returnDTO.setEmployeeUrl(URL + ID);

        when(employeeService.patchEmployee(anyLong(), any(EmployeeDTO.class))).thenReturn(returnDTO);

        //when/then
        mockMvc.perform(patch(URL + ID)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapToJson(employeeDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName", equalTo(FIRST_NAME)))
                .andExpect(jsonPath("$.lastName", equalTo(LAST_NAME)))
                .andExpect(jsonPath("$.employeeUrl", equalTo(URL + ID)));
    }

    @Test
    void deleteEmployeeTest() throws Exception {

        mockMvc.perform(delete(URL + ID)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(employeeService).deleteEmployeeById(anyLong());
    }

    @Test
    void notFoundExceptionTest() throws Exception {

        when(employeeService.getEmployeeById(anyLong())).thenThrow(ResourceNotFoundException.class);

        mockMvc.perform(get(URL + "420")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}