package net.javaguides.springboot.service.imp;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.EmployeeRepository;
import net.javaguides.springboot.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee){
       return employeeRepository.save(employee);
   }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
    Optional<Employee> employee = employeeRepository.findById(id);
//        if (employee.isPresent()){
//        return employee.get();
//        }else{
//            throw new ResourceNotFoundException("Employee", "id", id);

//      } */
          return employeeRepository.findById(id).orElseThrow(() ->
                  new ResourceNotFoundException("Employee","Id", id));

    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {

        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "id",id));

        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());

        // save existing employee
        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }

    @Override
    public void deleteEmployee(long id) {

        // check whether id is in the DB
        employeeRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Employee", "id",id));

        employeeRepository.deleteById(id);
    }

}
