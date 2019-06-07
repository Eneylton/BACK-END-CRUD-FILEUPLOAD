package com.ionic.br.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.ionic.br.Model.Galeria;
import com.ionic.br.Repository.GaleriaRepositories;
import com.ionic.br.Service.Exceptions.DataIntegrityException;

@Service
public class GaleriaService {

	@Autowired
	private GaleriaRepositories repos;

	public Galeria buscarPorID(Integer id) {

		Optional<Galeria> lista = repos.findById(id);

		return lista.orElse(null);
	}

	public List<Galeria> buscar() {
		return repos.findAll();
	}
	
	public Galeria insert(Galeria obj) {
		obj.setId(null);
		return repos.save(obj);
	}
	
	public Galeria update(Galeria obj) {
		Galeria newObj = buscarPorID(obj.getId());
		updateData(newObj, obj);
		return repos.save(newObj);
	}
	
	private void updateData(Galeria newObj, Galeria obj) {
		newObj.setNome(obj.getNome());
	}
	
	
	public void delete(Integer id) {
		buscarPorID(id);
		try {
			repos.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos");
		}
	}
}
