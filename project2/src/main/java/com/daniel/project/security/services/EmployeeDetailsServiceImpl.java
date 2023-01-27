package com.daniel.project.security.services;

import com.daniel.project.models.Employee;
import com.daniel.project.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeDetailsServiceImpl implements UserDetailsService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String employeename) throws UsernameNotFoundException {

		Employee employee = employeeRepository.findByEmployeename(employeename)
				.orElseThrow(() -> new UsernameNotFoundException("Employee Not Found with username: " + employeename));

		return EmployeeDetailsImpl.build(employee);
	}

}
