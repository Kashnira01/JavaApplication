package com.housing.service;

import java.util.List;

import com.housing.dto.ProfessionalDTO;
import com.housing.exception.HousingException;

public interface ProfessionalService {
	
	public Long addProfessional(ProfessionalDTO professionalDTO) throws HousingException;
	
	public ProfessionalDTO getProfessional(Long professionalId) throws HousingException;
	
	public List<ProfessionalDTO> getAllProfessionals() throws HousingException;
	
}
