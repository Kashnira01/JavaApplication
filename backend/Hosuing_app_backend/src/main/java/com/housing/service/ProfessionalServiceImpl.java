package com.housing.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.housing.dto.ProfessionalDTO;
import com.housing.entity.Professional;
import com.housing.exception.HousingException;
import com.housing.repository.ProfessionalRepository;

import jakarta.transaction.Transactional;

@Service(value = "professionalServiceImpl")
@Transactional
public class ProfessionalServiceImpl implements ProfessionalService {

	@Autowired
	private ProfessionalRepository professionalRepository;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public Long addProfessional(ProfessionalDTO professionalDTO) throws HousingException {
		Professional newProfessional = modelMapper.map(professionalDTO, Professional.class);
		professionalRepository.save(newProfessional);
		return newProfessional.getId();
	}

	@Override
	public ProfessionalDTO getProfessional(Long professionalId) throws HousingException {
		Optional<Professional> optional = professionalRepository.findById(professionalId);
		Professional currentProfessional = optional
				.orElseThrow(() -> new HousingException("Professional doesn't exists"));
		ProfessionalDTO currentProfessionalDTO = modelMapper.map(currentProfessional, ProfessionalDTO.class);
		return currentProfessionalDTO;
	}

	@Override
	public List<ProfessionalDTO> getAllProfessionals() throws HousingException {
		List<Professional> allProfessionals = professionalRepository.findAll();
		if (allProfessionals.isEmpty()) {
			throw new HousingException("There are no professionals");
		}
		List<ProfessionalDTO> allProfessionalDTOs = modelMapper.map(allProfessionals,
				new TypeToken<List<ProfessionalDTO>>() {
				}.getType());
		return allProfessionalDTOs;
	}

}
