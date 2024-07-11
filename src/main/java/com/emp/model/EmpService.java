package com.emp.model;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("empService")
public class EmpService {

	@Autowired
	EmpRepository repository;

	public void addEmp(EmpVO empVO) {
		repository.save(empVO);
	}

	public void updateEmp(EmpVO empVO) {
		repository.save(empVO);
	}

	public void deleteEmp(Integer empno) {
		if (repository.existsById(empno))
			repository.deleteByEmpno(empno);
//		    repository.deleteById(empno);
	}

	public EmpVO getOneEmp(Integer empno) {
		Optional<EmpVO> optional = repository.findById(empno);
//		return optional.get();
		return optional.orElse(null);  // public T orElse(T other) : 如果值存在就回傳其值，否則回傳other的值
	}

	public List<EmpVO> getAll() {
		return repository.findAll();
	}

}
